package com.glority.qualityserver.service.impl;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.ftp.FTPConnector;
import com.glority.quality.model.BuildTestInfo;
import com.glority.quality.model.ProductInfo;
import com.glority.quality.reportxml.QualityReport;
import com.glority.qualityserver.ModelConvertor;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.ServerErrorCollector;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.service.QualityReportService;

/**
 * QualityReportService implementation.
 * 
 * @author liheping
 * 
 */
@Service("qualityReportService")
public class QualityReportServiceImpl extends DBBaseService implements QualityReportService {
    public static final String REPORT_SERVER_IP = "reportServerIP";
    public static final String REPORT_SERVER_USERNAME = "reportServerUsername";
    public static final String REPORT_SERVER_PASSWORD = "reportServerPassword";
    public static final String REPORT_SERVER_PORT = "reportServerPort";

    private static final String DATA_BASE = "/qsdata";
    private static final String BUILD = "/build";
    private static final String REPORT_NAME = "quality.xml";
    private static final Logger LOGGER = Logger.getLogger(QualityReportServiceImpl.class);

    @Autowired
    private ProductManager productManager;

    private String reportServer;
    private String username;
    private String password;
    private int port;
    private boolean portIsSetted;

    @PostConstruct
    public void initConnector() {
        this.reportServer = ServerSettings.getInstance().getSetting(REPORT_SERVER_IP);
        this.username = ServerSettings.getInstance().getSetting(REPORT_SERVER_USERNAME);
        this.password = ServerSettings.getInstance().getSetting(REPORT_SERVER_PASSWORD);

        if (StringUtils.isEmpty(reportServer) || StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            ServerErrorCollector.getInstance().collectError(
                    "Report ftp is not rightly configed. One or more property is empty : server, username, password.",
                    "Init ftp connector error.");
            return;
        }
        String reportServerPort = ServerSettings.getInstance().getSetting(REPORT_SERVER_PORT);
        if (StringUtils.isEmpty(reportServerPort)) {
            this.portIsSetted = false;
        } else {
            try {
                this.port = Integer.valueOf(reportServerPort);
                this.portIsSetted = true;
            } catch (Exception e) {
                ServerErrorCollector.getInstance().collectError(
                        "Report ftp is not rightly configed. port is configed rightly.", "Init ftp connector error.");
                return;
            }
        }
    }

    private FTPConnector getFTPConnector() {
        if (portIsSetted) {
            return new FTPConnector(this.reportServer, this.port, this.username, this.password);
        } else {
            return new FTPConnector(this.reportServer, this.username, this.password);
        }
    }

    public QualityReport retrieveQualityReport(String newReportPath) throws Exception {
        FTPConnector connector = this.getFTPConnector();
        try {
            connector.initFtpEnv();
            InputStream reportInputStream = connector.retrieveFileStream(newReportPath);
            return this.parseQualityReport(reportInputStream);
        } catch (Exception e) {
            throw e;
        } finally {
            connector.clearEnv();
        }
    }

    public void validateReport(Product product, String reportPath, QualityReport report) {
        if (!product.getName().equals(report.getProductInfo().getProductName())) {
            throw new IllegalArgumentException("product name : " + report.getProductInfo().getProductName());
        }

        String jenkinsBuildNumber = reportPath.split("_")[1].split(FTPConnector.FTP_FILE_SEPERATOR)[0];
        if (!jenkinsBuildNumber.equals(report.getBuildTestInfo().getBuild().getJenkinsbuild())) {
            throw new IllegalArgumentException("jenkins build number in report path not much that in report. path "
                    + reportPath);
        }
    }

    @Transactional
    public Map<Product, List<String>> getNewReportFTPPaths() {
        Map<Product, List<String>> productNewReportsMap = new HashMap<Product, List<String>>();

        List<Product> productList = this.productManager.getAutoScanNewReportProducts();

        for (Product product : productList) {
            try {
                String reportsBasePath = this.getProductFtpQRBasePath(product);
                List<String> reportFolderNameList = this.getFTPConnector().getSpecifiedFolderContentNames(
                        reportsBasePath);

                Set<String> newReportFolderNameSet = new HashSet<String>(reportFolderNameList);
                Set<String> existsBuildFolderNameSet = this.getExistBuildFtpFolderNames(product);

                newReportFolderNameSet.removeAll(existsBuildFolderNameSet);

                List<String> newPaths = new ArrayList<String>();
                Set<String> sortedSet = new TreeSet<String>(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        int jenkinsBuildNumber1 = Integer.valueOf(((String) o1).split("_")[1]);
                        int jenkinsBuildNumber2 = Integer.valueOf(((String) o2).split("_")[1]);
                        return jenkinsBuildNumber1 - jenkinsBuildNumber2;
                    }
                });
                sortedSet.addAll(newReportFolderNameSet);
                for (String folderName : sortedSet) {
                    newPaths.add(this.getProductFtpQRPath(reportsBasePath, folderName));
                }

                if (!newPaths.isEmpty()) {
                    productNewReportsMap.put(product, newPaths);
                }
            } catch (ConnectorException e) {
                ServerErrorCollector.getInstance().collectorError(e,
                        "In get new quality report for product " + product.getName());
                LOGGER.error(e.getMessage(), e);
            }
        }
        return productNewReportsMap;
    }

    private Set<String> getExistBuildFtpFolderNames(Product product) {
        Set<String> result = new HashSet<String>();
        Set<Build> builds = product.getBuildses();
        for (Build build : builds) {
            result.add((build.getSvnRevision() + "_" + build.getJenkinsBuildId()).trim());
        }
        return result;
    }

    private String getProductFtpQRPath(String basePath, String folder) {
        return new StringBuilder(basePath).append(FTPConnector.FTP_FILE_SEPERATOR).append(folder)
                .append(FTPConnector.FTP_FILE_SEPERATOR).append(REPORT_NAME).toString();
    }

    /**
     * base the input to generate the quality report data path.
     * 
     * @param product
     * @return
     */
    private String getProductFtpQRBasePath(Product product) {
        StringBuilder path = new StringBuilder(DATA_BASE).append(FTPConnector.FTP_FILE_SEPERATOR)
                .append(product.getFtpReportScope()).append(BUILD).append(FTPConnector.FTP_FILE_SEPERATOR)
                .append(product.getName());
        return path.toString().trim();
    }

    public QualityReport parseQualityReport(String reportString) throws Exception {
        QualityReport report = QualityReport.parseGualityReportXml(reportString);
        return report;
    }

    public QualityReport parseQualityReport(InputStream inputStream) throws Exception {
        QualityReport report = QualityReport.parseGualityReportXml(inputStream);
        return report;
    }

    public String generateQualityReport(QualityReport report) throws Exception {

        return report.toXml();
    }

    /**
     * since some data in the xml is not finally decided. so this method is just
     * for let the system work.
     * 
     * no Version info is provided, so I new a one.
     * 
     * it needs to be rewrite
     */

    @Transactional(propagation = Propagation.NESTED)
    public void saveQualityReport(QualityReport report) {
        // get all the info from the report.
        ProductInfo prodInfo = report.getProductInfo();
        BuildTestInfo buildTestInfo = report.getBuildTestInfo();
        List<com.glority.quality.model.Configuration> configurationList = report.getConfigurations();
        List<com.glority.quality.model.TestSuite> testSuiteList = report.getTests();
        List<com.glority.quality.model.Metric> metricList = report.getGualityMetrics();

        java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
        // save product
        com.glority.qualityserver.model.Product pProduct = saveProduct(prodInfo, now);
        // save version
        com.glority.qualityserver.model.Version pVersion = saveVersion(prodInfo, pProduct.getId(), now);

        // use a map to keep the id map. to keep the relation in the xml report.

        Map<String, Long> configIdMap = new HashMap<String, Long>();

        if (configurationList != null) {
            for (com.glority.quality.model.Configuration config : configurationList) {
                com.glority.qualityserver.model.Configuration sConfig = ModelConvertor.convertToServerModel(config);

                sConfig.setCreatedAt(now);
                sConfig.setProducts(pProduct);
                sConfig.setVersion(pVersion);

                com.glority.qualityserver.model.Configuration pConfig = super.configurationManager.save(sConfig);
                configIdMap.put(config.getId(), pConfig.getId());
            }
        }

        // no build test info, return.
        if (buildTestInfo == null || buildTestInfo.getBuild() == null) {
            return;
        }

        // save build
        com.glority.qualityserver.model.Build pbuild = saveBuild(buildTestInfo, prodInfo, now, pProduct, pVersion);

        // save test group and test
        // testIdMap to keep the change of test id.
        Map<Long, Long> testIdMap = new HashMap<Long, Long>();

        if (buildTestInfo.getTestgroup() != null) {
            com.glority.quality.model.TestGroup testGroup = buildTestInfo.getTestgroup();
            com.glority.qualityserver.model.TestGroup sTestGroup = ModelConvertor.convertToServerModel(testGroup);

            sTestGroup.setCreatedAt(now);
            sTestGroup.setBuilds(pbuild);
            sTestGroup.setProductId(pProduct.getId());

            com.glority.qualityserver.model.TestGroup pTestGroup;
            if (buildTestInfo.getTestgroup().getId() == null) {
                pTestGroup = super.testGroupManager.save(sTestGroup);
            } else {
                pTestGroup = super.testGroupManager.get(sTestGroup.getId());

                if (pTestGroup == null) {
                    pTestGroup = super.testGroupManager.save(sTestGroup);
                }
            }

            if (testGroup.getTests() != null) {
                for (com.glority.quality.model.Test test : testGroup.getTests()) {
                    com.glority.qualityserver.model.Test sTest = ModelConvertor.convertToServerModel(test);

                    sTest.setBuildId(pbuild.getId());
                    if (configIdMap.get(sTest.getConfigurationId()) != null) {
                        sTest.setConfigurationId(configIdMap.get(sTest.getConfigurationId()));
                    }
                    sTest.setTestgroup(pTestGroup);

                    com.glority.qualityserver.model.Test pTest;
                    if (test.getId() == null) {
                        pTest = super.testManager.save(sTest);
                    } else {
                        pTest = super.testManager.get(sTest.getId());
                        if (pTest == null) {
                            pTest = super.testManager.save(sTest);
                        }
                    }

                    testIdMap.put(sTest.getId(), pTest.getId());
                }
            }

        }

        // save test suite
        if (testSuiteList != null) {
            for (com.glority.quality.model.TestSuite testSuite : testSuiteList) {
                com.glority.qualityserver.model.TestSuite sTestSuite = ModelConvertor.convertToServerModel(testSuite);

                sTestSuite.setBuilds(pbuild);
                if (configIdMap.get(sTestSuite.getId()) != null) {
                    sTestSuite.setConfigurationId(configIdMap.get(sTestSuite.getId()));
                }
                sTestSuite.setCreatedAt(now);
                if (testIdMap.get(sTestSuite.getTestId()) != null) {
                    sTestSuite.setTestId(testIdMap.get(sTestSuite.getTestId()));
                }

                com.glority.qualityserver.model.TestSuite pTestSuite = super.testSuiteManger.save(sTestSuite);

                if (testSuite.getTestCases() != null) {
                    List<com.glority.qualityserver.model.TestCase> testcases =
                        new ArrayList<com.glority.qualityserver.model.TestCase>();
                    for (com.glority.quality.model.TestCase testCase : testSuite.getTestCases()) {
                        com.glority.qualityserver.model.TestCase sTestCase = ModelConvertor
                                .convertToServerModel(testCase);

                        sTestCase.setCreatedAt(now);
                        sTestCase.setTestsuite(pTestSuite);
                        testcases.add(sTestCase);
                        // super.testCaseManager.save(sTestCase);
                    }
                    super.testCaseManager.saveOrUpdateAll(testcases);
                }
            }
        }

        // save metric List<com.glority.quality.model.Metric> metricList
        if (metricList != null) {
            for (com.glority.quality.model.Metric metric : metricList) {
                com.glority.qualityserver.model.BuildMetric sMetric = ModelConvertor.convertToServerModel(metric);

                sMetric.setBuilds(pbuild);
                sMetric.setCreatedAt(now);
                sMetric.setProdutId(pProduct.getId());

                com.glority.qualityserver.model.BuildMetric pMetric = super.metricManager.save(sMetric);

                if (metric.getFailure() != null) {
                    com.glority.qualityserver.model.Failure sFailure = ModelConvertor.convertToGetFailure(metric);

                    sFailure.setCreatedAt(now);
                    sFailure.setMetrics(pMetric);

                    super.failureManager.save(sFailure);
                }
            }
        }
    }

    private com.glority.qualityserver.model.Build saveBuild(com.glority.quality.model.BuildTestInfo buildTestInfo,
            com.glority.quality.model.ProductInfo productInfo, Timestamp now,
            com.glority.qualityserver.model.Product pProduct, com.glority.qualityserver.model.Version pVersion) {
        // go on to save other part.

        // convert build and save build
        if (buildTestInfo.getBuild() != null) {
            com.glority.qualityserver.model.Build build = ModelConvertor.convertToServerModel(buildTestInfo.getBuild(),
                    productInfo);
            build.setCreatedAt(now);
            build.setProduct(pProduct);
            build.setVersion(pVersion);

            com.glority.qualityserver.model.Build pbuild;

            if (buildTestInfo.getBuild().getId() == null) {
                pbuild = super.buildManager.getBuild(pVersion.getId(), build.getJenkinsJobname(),
                        build.getJenkinsBuildId());
                if (pbuild == null) {
                    pbuild = super.buildManager.save(build);
                }
            } else {
                if (!super.buildManager.exists(build.getId())) {
                    pbuild = super.buildManager.save(build);
                } else {
                    pbuild = super.buildManager.get(build.getId());
                }
            }
            return pbuild;
        }
        return null;
    }

    private com.glority.qualityserver.model.Product saveProduct(com.glority.quality.model.ProductInfo prodInfo,
            Timestamp now) {

        com.glority.qualityserver.model.Product product = ModelConvertor.convertToSeverModel(prodInfo);
        product.setCreatedAt(now);
        product.setDiscarded(false);
        com.glority.qualityserver.model.Product pProduct;

        pProduct = super.productManager.getProduct(product.getName());
        if (pProduct == null) {
            pProduct = super.productManager.save(product);
        }
        createPhaseAndSave(pProduct.getId());

        return pProduct;
    }

    private com.glority.qualityserver.model.Version saveVersion(com.glority.quality.model.ProductInfo prodInfo,
            long productId, Timestamp now) {

        com.glority.qualityserver.model.Version version = ModelConvertor.convertToGetVersion(prodInfo);

        com.glority.qualityserver.model.Version pVersion;

        pVersion = super.versionManager.getVersion(version.getVersion(), productId);
        if (pVersion == null) {
            version.setProductId(Long.valueOf(productId));

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);

            calendar.add(Calendar.MONDAY, -1);

            Timestamp startTime = new Timestamp(calendar.getTime().getTime());

            calendar.add(Calendar.MONDAY, 2);

            Timestamp endTime = new Timestamp(calendar.getTime().getTime());

            version.setStageStartTime(startTime);
            version.setStageEndTime(endTime);

            version.setDevStartTime(startTime);
            version.setDevEndTime(endTime);

            version.setTestStartTime(startTime);
            version.setTestEndTime(endTime);

            version.setProductionStartTime(startTime);
            version.setProductionEndTime(endTime);

            pVersion = super.versionManager.save(version);
        }

        return pVersion;
    }

    private void createPhaseAndSave(long productId) {
        createPhaseAndSave(productId, ProductStage.DEV);
        createPhaseAndSave(productId, ProductStage.TEST);
        createPhaseAndSave(productId, ProductStage.STAGE);
        createPhaseAndSave(productId, ProductStage.PROD);
    }

    private com.glority.qualityserver.model.Phase createPhaseAndSave(long productId, ProductStage stage) {
        com.glority.qualityserver.model.Phase phase = super.phaseManager.getPhase(productId, stage);
        if (phase != null) {
            return phase;
        }

        phase = new com.glority.qualityserver.model.Phase();
        phase.setProductId(productId);
        phase.setType(stage.toString());
        return super.phaseManager.save(phase);

    }
}
