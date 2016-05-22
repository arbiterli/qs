package com.glority.quality.reportxml;

import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.StringUtil;
import com.glority.quality.exception.IllegalDataException;
import com.glority.quality.exception.InitException;
import com.glority.quality.model.Build;
import com.glority.quality.model.BuildTestInfo;
import com.glority.quality.model.Configuration;
import com.glority.quality.model.Environments;
import com.glority.quality.model.Metric;
import com.glority.quality.model.ProductInfo;
import com.glority.quality.model.Test;
import com.glority.quality.model.TestCase;
import com.glority.quality.model.TestGroup;
import com.glority.quality.model.TestSuite;

/**
 * Quality report.
 * 
 * @author liheping
 * 
 */
public class QualityReport {
    public static final String ID = "id";

    public static final String GUALITY_REPORT = "qaulityreport";

    public static final String PRODUCT_INFO = "productinfo";
    public static final String BUSINESS_UNIT = "businessunit";
    public static final String PRODUCT_NAME = "productname";
    public static final String PRODUCT_VERSION = "productversion";
    public static final String SVN_URL_TAG = "svnurl";
    public static final String SVN_REVISION_TAG = "svnrevision";

    public static final String BUILD_TEST_INFO = "buildtestinfo";
    public static final String CERTIFICATION = "certification";
    public static final String TIMESTAMP = "timestamp";
    public static final String BUILD = "build";
    public static final String JENKINS_JOB = "jenkinsjob";
    public static final String JENKINS_BUILD = "jenkinsbuild";
    public static final String TEST_GROUP = "testgroup";
    public static final String TEST = "test";
    public static final String CONFIGURATION_ID = "configurationid";

    public static final String CONFIGURATIONS = "configurations";
    public static final String CONFIGURATION = "configuration";
    public static final String ENVIRONMENTS = "environments";
    public static final String OS = "os";
    public static final String ARCH = "arch";
    public static final String LANGUAGE = "language";
    public static final String SOFTWARES = "softwares";
    public static final String SOFTWARE = "software";

    public static final String TESTS = "tests";
    public static final String TEST_SUITE = "testsuite";
    public static final String TYPE = "type";
    public static final String TEST_ID = "testid";
    public static final String TEST_CASE = "testcase";
    public static final String NAME = "name";
    public static final String TIME = "time";
    public static final String RESULT = "result";
    public static final String SVN_URL_ATTR = "svn_url";
    public static final String SVN_REVISION_ATTR = "svn_revision";

    public static final String GUALITY_METRICS = "gualitymetrics";
    public static final String METRIC = "metric";
    public static final String FAILURE_COUNT = "failurecount";
    public static final String NEW = "new";
    public static final String OLD = "old";
    public static final String FAILURE = "failure";

    private final float percentRate = 100;
    private ProductInfo productInfo;
    private BuildTestInfo buildTestInfo;
    private List<Configuration> configurations;
    private List<TestSuite> tests;
    private List<Metric> gualityMetrics;

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public BuildTestInfo getBuildTestInfo() {
        return buildTestInfo;
    }

    public void setBuildTestInfo(BuildTestInfo buildTestInfo) {
        this.buildTestInfo = buildTestInfo;
    }

    public List<Configuration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }

    public List<TestSuite> getTests() {
        return tests;
    }

    public void setTests(List<TestSuite> tests) {
        this.tests = tests;
    }

    public List<Metric> getGualityMetrics() {
        return gualityMetrics;
    }

    public void setGualityMetrics(List<Metric> gualityMetrics) {
        this.gualityMetrics = gualityMetrics;
    }

    public void addConfiguration(Configuration cfg) {
        if (this.configurations == null) {
            this.configurations = new ArrayList<Configuration>();
        }
        this.configurations.add(cfg);
    }

    /**
     * Construct.
     * 
     * @param xmlContent
     */
    public QualityReport() {
        this.productInfo = new ProductInfo();
        this.buildTestInfo = new BuildTestInfo();
    }

    public QualityReport(String xmlContent) throws Exception {
        QualityReport report = QualityReport.parseGualityReportXml(xmlContent);

        this.productInfo = report.productInfo;
        this.buildTestInfo = report.buildTestInfo;
        this.configurations = report.configurations;
        this.tests = report.tests;
        this.gualityMetrics = report.gualityMetrics;
    }

    public QualityReport(InputStream inputStream) throws Exception {
        QualityReport report = QualityReport.parseGualityReportXml(inputStream);

        this.productInfo = report.productInfo;
        this.buildTestInfo = report.buildTestInfo;
        this.configurations = report.configurations;
        this.tests = report.tests;
        this.gualityMetrics = report.gualityMetrics;
    }

    /* Start Quality system operations */
    /**
     * Initial the quality process. This will be called when the quality process. is started It will initialize the
     * quality xml
     * 
     */
    public void initialQualityProcess(String businessUnit, String productName, String version, String svnUrl,
            String svnRevision) {
        if (StringUtil.isEmpty(businessUnit) || StringUtil.isEmpty(productName) || StringUtil.isEmpty(version)
                || StringUtil.isEmpty(svnUrl) || StringUtil.isEmpty(svnRevision)) {
            throw new InitException("Intial input can't be empty");
        }
        this.productInfo.setBusinessUnit(businessUnit);
        this.productInfo.setProductName(productName);
        this.productInfo.setProductVersion(version);
        this.productInfo.setSvnUrl(svnUrl);
        this.productInfo.setSvnRevision(svnRevision);
    }

    /**
     * Update the build id to the quality xml. this will be called from build controller when the build is fired
     * 
     * @param buildId
     */
    public void updateBuildId(String buildId) {
        this.buildTestInfo.getBuild().setId(buildId);
    }

    /**
     * Update the build jenkins jobName and jenkins build id it will be updated when the jenkins build is launched.
     * 
     * @param jenkinsJobName
     * @param jenkinsBuildId
     * @throws Exception
     */
    public void addJenkinsBuildInfo(String jenkinsJobName, String jenkinsBuildId) {
        if (StringUtil.isEmpty(jenkinsJobName) || StringUtil.isEmpty(jenkinsBuildId)) {
            throw new IllegalDataException("Jenkins job info is incorrect");
        }
        if (this.buildTestInfo.getBuild() == null) {
            this.buildTestInfo.setBuild(new Build());
        }
        this.buildTestInfo.getBuild().setJenkinsjob(jenkinsJobName);
        this.buildTestInfo.getBuild().setJenkinsbuild(jenkinsBuildId);
    }

    /**
     * Update the jenkins jobname and jenkins Build id for the test job It will be called when the jenkins test is
     * launched.
     * 
     * @param jenkinsJobName
     * @param jenkinsBuildId
     * @throws Exception
     */
    public void addJenkinsTestInfo(String testID, String jenkinsJobName, String jenkinsBuildId) {
        if (StringUtil.isEmpty(jenkinsJobName) || StringUtil.isEmpty(jenkinsBuildId)) {
            throw new IllegalDataException("Jenkins job info is incorrect");
        }
        Test t = getTestJob(testID, jenkinsJobName, jenkinsBuildId);
        Test firstTest = getFirstTestJob();

        if (t == null && StringUtil.isEmpty(testID)) {
            // If the testID is empty, and the given jenkinsjobName and build
            // not found
            // Test it want to update the first test
            t = firstTest;
        }

        if (t == null) {
            addNewTestJob(testID, jenkinsJobName, jenkinsBuildId);
        } else {
            if (!StringUtil.isEmpty(testID)) {
                // Skip the update the test ID is the input ID is null
                t.setId(testID);
            }
            t.setJenkinsjob(jenkinsJobName);
            t.setJenkinsbuild(jenkinsBuildId);
        }
    }

    // add extern configurations
    public void addConfigurations(List<Configuration> addConfigurations) {
        Set<Configuration> set = new HashSet<Configuration>(this.configurations);
        set.addAll(addConfigurations);
        this.configurations.clear();
        this.configurations.addAll(set);
    }

    public void addTests(List<TestSuite> addTests) {
        Set<TestSuite> set = new HashSet<TestSuite>(this.tests);
        set.addAll(addTests);
        this.tests.clear();
        this.tests.addAll(set);
    }

    /**
     * 
     * Update the test result from a test report to quality.xml This will be called when are parse the testing reports.
     * 
     * @param testingFramework
     * @param metricsList
     */
    public void updateTestResult(String testingFramework, List<Metric> metricsList) {
        TestSuite ts = getFirstTestSuite(testingFramework);
        for (int i = 0; i < metricsList.size(); i++) {
            Metric m = (Metric) metricsList.get(i);
            TestCase tc = findTestCase(ts, m.getName());
            if (StringUtil.isEmpty(m.getName())) {
                // Skip if the test name is empty
                continue;
            }
            if (tc == null) {
                tc = new TestCase();
                tc.setName(m.getName());
                ts.getTestCases().add(tc);
            }
            tc.setResult(m.getResult().toString());
            tc.setTime(m.getTime());
        }
    }

    public void addMetrics(List<Metric> addMetrics) {
        if (this.gualityMetrics == null) {
            this.gualityMetrics = new ArrayList<Metric>();
        }
        for (int i = 0; i < addMetrics.size(); i++) {
            Metric m = (Metric) addMetrics.get(i);
            addMetric(m);
        }
    }

    public void merge(QualityReport sourceReport) throws Exception {
        QualityReport.merge(this, sourceReport);
    }

    /* End quality system operations */
    public String toXml() throws Exception {
        return QualityReport.translateReportToXml(this);
    }

    public void writeToFile(String fileName) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(toXml());
        writer.close();
    }

    /**
     * find the metric by name.
     * 
     * @param name
     * @return
     */
    public Metric getMetric(String name) {
        if (this.gualityMetrics == null || name == null) {
            return null;
        }
        for (int i = 0; i < this.gualityMetrics.size(); i++) {
            Metric m = gualityMetrics.get(i);
            if (name.equals(m.getName())) {
                return m;
            }
        }
        return null;
    }

    /**
     * Add the metric.
     * 
     * @param m
     */
    private void addMetric(Metric m) {
        Metric em = getMetric(m.getName());
        if (em != null) {
            this.gualityMetrics.remove(em);
        }
        this.gualityMetrics.add(m);
    }

    private void addNewTestJob(String testID, String jenkinsJobName, String jenkinsBuildId) {
        if (this.buildTestInfo.getTestgroup() == null) {
            this.buildTestInfo.setTestgroup(new TestGroup());
            List<Test> tests = new ArrayList<Test>();
            Test t = new Test();
            t.setId(testID);
            t.setJenkinsjob(jenkinsJobName);
            t.setJenkinsbuild(jenkinsBuildId);
            tests.add(t);
            this.buildTestInfo.getTestgroup().setTests(tests);
        }
    }

    private Test getFirstTestJob() {
        if (this.buildTestInfo.getTestgroup() == null) {
            return null;
        }
        List<Test> tests = this.buildTestInfo.getTestgroup().getTests();
        if (tests == null || tests.size() == 0) {
            return null;
        }
        return tests.get(0);
    }

    private Test getTestJob(String testID, String jenkinsJobName, String jenkinsBuildId) {
        if (this.buildTestInfo.getTestgroup() == null) {
            return null;
        }
        List<Test> tests = this.buildTestInfo.getTestgroup().getTests();
        if (tests == null) {
            return null;
        }
        for (Test test : tests) {
            // Treat the test the same if the id is the same
            if (StringUtil.isTwoStringEqual(test.getId(), testID)) {
                return test;
            }
            // Also treat the test the same if the jenkinsjob name and build id
            // is the same
            if (StringUtil.isTwoStringEqual(test.getJenkinsjob(), jenkinsJobName)
                    && StringUtil.isTwoStringEqual(test.getJenkinsbuild(), jenkinsBuildId)) {
                return test;
            }
        }
        return null;
    }

    private TestCase findTestCase(TestSuite ts, String name) {
        if (ts == null || ts.getTestCases() == null || StringUtil.isEmpty(name)) {
            return null;
        }
        for (TestCase tc : ts.getTestCases()) {
            if (name.equals(tc.getName())) {
                return tc;
            }
        }
        return null;
    }

    /**
     * Create the test suite if it does not exist.
     * 
     * @param name
     * @return
     */
    private TestSuite getFirstTestSuite(String type) {
        if (this.tests == null) {
            this.tests = new ArrayList<TestSuite>();
        }
        TestSuite ts = findFirstTestSuite(type);
        if (ts == null) {
            ts = new TestSuite();
            ts.setType(type);
            if (getFirstTestJob() != null) {
                ts.setTestId(getFirstTestJob().getId());
                ts.setConfigurationId(getFirstTestJob().getConfigurationId());
            }
            tests.add(ts);
        }
        if (ts.getTestCases() == null) {
            ts.setTestCases(new ArrayList<TestCase>());
        }
        return ts;
    }

    private TestSuite findFirstTestSuite(String type) {
        if (this.tests == null || StringUtil.isEmpty(type)) {
            return null;
        } else {
            for (TestSuite ts : tests) {
                if (type.equals(ts.getType())) {
                    return ts;
                }
            }
            return null;
        }
    }

    private Metric getTestSummaryMetric(String name) {
        Metric m = getMetric(name);
        if (m == null) {
            m = new Metric();
            m.setName(name);
            m.setType(MetricType.METRIC_TYPE_TEST_SUMMARY);
            m.setResult(MetricResult.METRIC_NOCHECK);
        }

        return m;
    }

    public void updateTestSummary(String type, MetricResult testResult) {
        if (StringUtil.isEmpty(type)) {
            // Do nothing if the name is invalid
            return;
        }
        List<TestSuite> testSuites = getTestsuites(type);
        float totalTest = 0, totalPassed = 0, totalFailed = 0;
        for (TestSuite ts : testSuites) {
            if (ts.getTestCases() == null) {
                continue;
            }
            for (TestCase t : ts.getTestCases()) {
                totalTest++;
                if (MetricResult.METRIC_SUCCESS.toString().equals(t.getResult())) {
                    totalPassed++;
                } else {
                    totalFailed++;
                }
            }
        }
        if (totalTest == 0) {
            return;
        }
        List<Metric> mList = new ArrayList<Metric>();
        Metric tm = getTestSummaryMetric(type + "_" + MetricName.TEST_TOTAL_COUNT);
        tm.setNewValue(totalTest);
        mList.add(tm);

        Metric pm = getTestSummaryMetric(type + "_" + MetricName.TEST_PASSED_COUNT);
        pm.setNewValue(totalPassed);
        mList.add(pm);

        Metric sm = getTestSummaryMetric(type + "_" + MetricName.TEST_SUCCESS_RATE);
        // change the data to percent to meet the other data format in report.
        sm.setNewValue((totalPassed / totalTest) * this.percentRate);
        mList.add(sm);

        Metric fm = getTestSummaryMetric(type + "_" + MetricName.TEST_FAILED_COUNT);
        fm.setNewValue(totalFailed);

        if (fm.getResult() == MetricResult.METRIC_NOCHECK || fm.getResult() == MetricResult.METRIC_SUCCESS) {
            fm.setResult(testResult);
        }
        mList.add(fm);

        addMetrics(mList);
    }

    /**
     * Return all the test suites with given type.
     * 
     * @param type
     * @return
     */
    public List<TestSuite> getTestsuites(String type) {
        List<TestSuite> ts = new ArrayList<TestSuite>();
        if (!StringUtil.isEmpty(type)) {
            for (TestSuite t : tests) {
                if (type.equals(t.getType())) {
                    ts.add(t);
                }
            }
        }
        return ts;
    }

    /**
     * Parse guality report xml to GualityReportXml Object.
     * 
     * @param xmlContent
     * @return
     * @throws Exception
     */
    public static QualityReport parseGualityReportXml(String xmlContent) throws Exception {
        Document doc = DocumentHelper.parseText(xmlContent);

        return parseGualityReportXml(doc);
    }

    public static QualityReport parseGualityReportXml(InputStream inputStream) throws Exception {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(inputStream);

        return parseGualityReportXml(doc);
    }

    /**
     * Translate GualityReportXml object to xml string.
     * 
     * @param gualityReport
     * @return
     * @throws Exception
     */
    public static String translateReportToXml(QualityReport gualityReport) {
        if (gualityReport == null) {
            throw new IllegalDataException("can not translate null to string");
        }

        Document doc = DocumentHelper.createDocument();

        Element rootElt = doc.addElement(QualityReport.GUALITY_REPORT);

        if (gualityReport.getProductInfo() != null) {

            QualityReport.addProductInfoNodeToElement(gualityReport.getProductInfo(), rootElt);
        }

        if (gualityReport.getBuildTestInfo() != null) {
            QualityReport.addBuildTestInfoNodeToElement(gualityReport.getBuildTestInfo(), rootElt);
        }

        if (gualityReport.getConfigurations() != null) {
            QualityReport.addConfigurationsNodeToElement(gualityReport.getConfigurations(), rootElt);
        }

        if (gualityReport.getGualityMetrics() != null) {
            QualityReport.addGualityMetricsNodeToElement(gualityReport.getGualityMetrics(), rootElt);
        }

        if (gualityReport.getTests() != null) {
            QualityReport.addTestsNodeToElement(gualityReport.getTests(), rootElt);
        }

        return doc.asXML();
    }

    public static void merge(QualityReport targetReport, QualityReport sourceReport) {

        if (!QualityReport.isTheTwoReportFromTheSameBuild(sourceReport, sourceReport)) {
            throw new IllegalDataException("the two report are not from the same build, can not merge");
        }

        targetReport.addConfigurations(sourceReport.getConfigurations());
        targetReport.addTests(sourceReport.getTests());
        targetReport.addMetrics(sourceReport.getGualityMetrics());
    }

    public static boolean isTheTwoReportFromTheSameBuild(QualityReport r1, QualityReport r2) {
        // this part is just compared some fields in the productionInfo and
        // buildtestInfo.
        if (r1 == null || r2 == null) {
            if (isOnlyOneObjNull(r1, r2)) {
                return false;
            }
        } else { // both the report not null;
            if (r1.productInfo == null || r2.productInfo == null) {
                if (isOnlyOneObjNull(r1.productInfo, r2.productInfo)) {
                    return false;
                }
            } else { // both the productInfo not null;
                if (!isTheTwoStringEqual(r1.productInfo.getBusinessUnit(), r2.productInfo.getBusinessUnit())) {
                    return false;
                }
                if (!isTheTwoStringEqual(r1.productInfo.getProductName(), r2.productInfo.getProductName())) {
                    return false;
                }

                if (!isTheTwoStringEqual(r2.productInfo.getProductVersion(), r2.productInfo.getProductVersion())) {
                    return false;
                }
            }

            if (r1.buildTestInfo == null || r2.buildTestInfo == null) {
                if (isOnlyOneObjNull(r1.buildTestInfo, r2.buildTestInfo)) {
                    return false;
                }
            } else { // both the buildTestInfo not null;
                if (r1.buildTestInfo.getBuild() == null || r2.buildTestInfo.getBuild() == null) {
                    if (isOnlyOneObjNull(r1.buildTestInfo.getBuild(), r2.buildTestInfo.getBuild())) {
                        return false;
                    }
                } else { // both the build not null;
                    if (!isTheTwoStringEqual(r1.buildTestInfo.getBuild().getId(),
                            r2.buildTestInfo.getBuild().getId())) {
                        return false;
                    }
                }

                if (r1.buildTestInfo.getTestgroup() == null || r2.buildTestInfo.getTestgroup() == null) {
                    if (isOnlyOneObjNull(r1.buildTestInfo.getTestgroup(), r2.buildTestInfo.getTestgroup())) {
                        return false;
                    } else {
                        if (!isTheTwoStringEqual(r1.buildTestInfo.getTestgroup().getId(), r2.buildTestInfo
                                .getTestgroup().getId())) {
                            return false;
                        }
                    }
                }
            }
        }

        // above implemtation may be replaced by the following part;
        // if (r1 == null) {
        // return r2 == null;
        // }
        //
        // if (r1.productInfo == null) {
        // if (r2.productInfo != null) {
        // return false;
        // }
        // } else {
        // if (!r1.productInfo.equals(r2.productInfo)) {
        // return false;
        // }
        // }
        //
        // if (r1.buildTestInfo == null) {
        // if (r2.buildTestInfo != null) {
        // return false;
        // }
        // } else {
        // if (!r1.buildTestInfo.equals(r1.buildTestInfo)) {
        // return false;
        // }
        // }
        return true;
    }

    private static QualityReport parseGualityReportXml(Document doc) {
        Element rootElt = doc.getRootElement();
        if (rootElt == null || !QualityReport.GUALITY_REPORT.equals(rootElt.getName())) {
            throw new IllegalDataException("Xml do not have a root element or root element is not "
                    + QualityReport.GUALITY_REPORT);
        }

        QualityReport report = new QualityReport();

        Element prodInfoElt = rootElt.element(QualityReport.PRODUCT_INFO);
        if (prodInfoElt != null) {
            ProductInfo prodInfo = QualityReport.parseProductInfo(prodInfoElt);
            report.setProductInfo(prodInfo);
        }

        Element buildtestInfoElt = rootElt.element(QualityReport.BUILD_TEST_INFO);
        if (buildtestInfoElt != null) {
            BuildTestInfo buildtestInfo = QualityReport.parseBuildTestInfo(buildtestInfoElt);
            report.setBuildTestInfo(buildtestInfo);
        }

        Element configsElt = rootElt.element(QualityReport.CONFIGURATIONS);
        if (configsElt != null) {
            List<Configuration> configs = QualityReport.parseConfigurations(configsElt);
            report.setConfigurations(configs);
        }

        Element testsElt = rootElt.element(QualityReport.TESTS);
        if (testsElt != null) {
            List<TestSuite> testSuites = QualityReport.parseTests(testsElt);
            report.setTests(testSuites);
        }

        Element gualityMetricsElt = rootElt.element(QualityReport.GUALITY_METRICS);
        if (gualityMetricsElt != null) {
            List<Metric> metrics = QualityReport.parseGualityMetrics(gualityMetricsElt);
            report.setGualityMetrics(metrics);
        }

        return report;
    }

    private static boolean isOnlyOneObjNull(Object obj1, Object obj2) {
        if ((obj1 == null && obj2 != null) || (obj1 != null && obj2 == null)) {
            return true;
        }

        return false;
    }

    private static boolean isTheTwoStringEqual(String s1, String s2) {
        if (s1 == null) {
            return s2 == null ? true : false;
        } else {
            return s1.equalsIgnoreCase(s2);
        }
    }

    // Parse productInfo node in guaility.xml
    private static ProductInfo parseProductInfo(Element prodInfoElt) {
        ProductInfo prodInfo = new ProductInfo();

        Element buElt = prodInfoElt.element(QualityReport.BUSINESS_UNIT);
        if (buElt != null) {
            String businessUnit = buElt.getText();
            prodInfo.setBusinessUnit(businessUnit);
        }

        Element prodNameElt = prodInfoElt.element(QualityReport.PRODUCT_NAME);
        if (prodNameElt != null) {
            String prodName = prodNameElt.getText();
            prodInfo.setProductName(prodName);
        }

        Element prodVersionElt = prodInfoElt.element(QualityReport.PRODUCT_VERSION);
        if (prodVersionElt != null) {
            String prodVersion = prodVersionElt.getText();
            prodInfo.setProductVersion(prodVersion);

            Attribute idAttr = prodVersionElt.attribute(QualityReport.ID);
            if (idAttr != null) {
                String idStr = idAttr.getText();
                prodInfo.setProductVersionId(idStr);
            }
        }

        Element svnUrlElt = prodInfoElt.element(QualityReport.SVN_URL_TAG);
        if (svnUrlElt != null) {
            String svnUrl = svnUrlElt.getText();
            prodInfo.setSvnUrl(svnUrl);
        }

        Element svnRevisionElt = prodInfoElt.element(QualityReport.SVN_REVISION_TAG);
        if (svnRevisionElt != null) {
            String svnRevision = svnRevisionElt.getText();
            prodInfo.setSvnRevision(svnRevision);
        }

        return prodInfo;
    }

    // Parse buildtestinfo node in guality.xml
    private static BuildTestInfo parseBuildTestInfo(Element buildtestInfoElt) {
        BuildTestInfo buildtestInfo = new BuildTestInfo();

        Element certificationElt = buildtestInfoElt.element(QualityReport.CERTIFICATION);
        if (certificationElt != null) {
            String certification = certificationElt.getText();
            buildtestInfo.setCertification(certification);
        }

        Element timestampElt = buildtestInfoElt.element(QualityReport.TIMESTAMP);
        if (timestampElt != null) {
            String timestamp = timestampElt.getText();
            buildtestInfo.setTimestamp(timestamp);
        }

        Element buildElt = buildtestInfoElt.element(QualityReport.BUILD);
        if (buildElt != null) {
            Build build = QualityReport.parseBuild(buildElt);
            buildtestInfo.setBuild(build);
        }

        Element testGroupElt = buildtestInfoElt.element(QualityReport.TEST_GROUP);
        if (testGroupElt != null) {
            TestGroup testGroup = QualityReport.parseTestGroup(testGroupElt);
            buildtestInfo.setTestgroup(testGroup);
        }

        return buildtestInfo;
    }

    // Parse build node in guality.xml
    private static Build parseBuild(Element buildElt) {
        Build build = new Build();

        Attribute idAttr = buildElt.attribute(QualityReport.ID);
        if (idAttr != null) {
            String id = idAttr.getText();
            build.setId(id);
        }

        Attribute jenkinsJobAttr = buildElt.attribute(QualityReport.JENKINS_JOB);
        if (jenkinsJobAttr != null) {
            String jenkinsJob = jenkinsJobAttr.getText();
            build.setJenkinsjob(jenkinsJob);
        }

        Attribute jenkinsBuildAttr = buildElt.attribute(QualityReport.JENKINS_BUILD);
        if (jenkinsBuildAttr != null) {
            String jenkinsBuild = jenkinsBuildAttr.getText();
            build.setJenkinsbuild(jenkinsBuild);
        }

        Attribute resultAttr = buildElt.attribute(QualityReport.RESULT);
        if (resultAttr != null) {
            String result = resultAttr.getText();
            build.setResult(result);
        }

        return build;
    }

    // Parse testgroup node in guality.xml
    @SuppressWarnings("unchecked")
    private static TestGroup parseTestGroup(Element testGroupElt) {
        TestGroup testGroup = new TestGroup();

        Attribute idAttr = testGroupElt.attribute(QualityReport.ID);
        if (idAttr != null) {
            String id = idAttr.getText();
            testGroup.setId(id);
        }

        List<Element> testEltList = testGroupElt.elements(QualityReport.TEST);
        if (testEltList != null) {
            List<Test> tests = new ArrayList<Test>();

            for (Element testElt : testEltList) {
                Test test = QualityReport.parseTest(testElt);
                tests.add(test);
            }

            testGroup.setTests(tests);
        }

        return testGroup;
    }

    // Parse test node in guality.xml
    private static Test parseTest(Element testElt) {
        Test test = new Test();

        Attribute idAttr = testElt.attribute(QualityReport.ID);
        if (idAttr != null) {
            String id = idAttr.getText();
            test.setId(id);
        }

        Attribute configIdAttr = testElt.attribute(QualityReport.CONFIGURATION_ID);
        if (configIdAttr != null) {
            String configId = configIdAttr.getText();
            test.setConfigurationId(configId);
        }

        Attribute jenkinsJobAttr = testElt.attribute(QualityReport.JENKINS_JOB);
        if (jenkinsJobAttr != null) {
            String jenkinsJob = jenkinsJobAttr.getText();
            test.setJenkinsjob(jenkinsJob);
        }

        Attribute jenkinsBuildAttr = testElt.attribute(QualityReport.JENKINS_BUILD);
        if (jenkinsBuildAttr != null) {
            String jenkinsBuild = jenkinsBuildAttr.getText();
            test.setJenkinsbuild(jenkinsBuild);
        }

        Attribute resultAttr = testElt.attribute(QualityReport.RESULT);
        if (resultAttr != null) {
            String result = resultAttr.getText();
            test.setResult(result);
        }

        return test;
    }

    // Parse configurations node in guality.xml
    @SuppressWarnings("unchecked")
    private static List<Configuration> parseConfigurations(Element configsElt) {
        List<Configuration> configs = new ArrayList<Configuration>();

        List<Element> configEltList = configsElt.elements(QualityReport.CONFIGURATION);
        if (configEltList != null) {
            for (Element configElt : configEltList) {
                Configuration config = QualityReport.parseConfiguration(configElt);
                configs.add(config);
            }
        }

        return configs;
    }

    // Parse configuration node in guality.xml
    @SuppressWarnings("unchecked")
    private static Configuration parseConfiguration(Element configElt) {
        Configuration config = new Configuration();

        Attribute idAttr = configElt.attribute(QualityReport.ID);
        if (idAttr != null) {
            config.setId(idAttr.getText());
        }

        Element environmentsElt = configElt.element(QualityReport.ENVIRONMENTS);
        if (environmentsElt != null) {
            Environments environments = new Environments();

            Element osElt = environmentsElt.element(QualityReport.OS);
            if (osElt != null) {
                String os = osElt.getText();
                environments.setOs(os);
            }

            Element archElt = environmentsElt.element(QualityReport.ARCH);
            if (archElt != null) {
                String arch = archElt.getText();
                environments.setArch(arch);
            }

            Element languageElt = environmentsElt.element(QualityReport.LANGUAGE);
            if (languageElt != null) {
                String language = languageElt.getText();
                environments.setLanguage(language);
            }

            config.setEnvironments(environments);
        }

        Element softwaresElt = configElt.element(QualityReport.SOFTWARES);
        if (softwaresElt != null) {
            List<String> softwares = new ArrayList<String>();

            List<Element> softwareEltList = softwaresElt.elements(QualityReport.SOFTWARE);
            if (softwareEltList != null) {
                for (Element softwareElt : softwareEltList) {
                    String software = softwareElt.getText();
                    softwares.add(software);
                }
            }

            config.setSoftwares(softwares);
        }

        return config;
    }

    // Parse tests node in guality.xml
    @SuppressWarnings("unchecked")
    private static List<TestSuite> parseTests(Element testsElt) {
        List<TestSuite> testSuites = new ArrayList<TestSuite>();

        List<Element> testSuiteEltList = testsElt.elements(QualityReport.TEST_SUITE);
        if (testSuiteEltList != null) {
            for (Element testSuiteElt : testSuiteEltList) {
                TestSuite testSuite = QualityReport.parseTestSuite(testSuiteElt);
                testSuites.add(testSuite);
            }
        }

        return testSuites;
    }

    @SuppressWarnings("unchecked")
    private static TestSuite parseTestSuite(Element testSuiteElt) {
        TestSuite testSuite = new TestSuite();

        Attribute typeAttr = testSuiteElt.attribute(QualityReport.TYPE);
        if (typeAttr != null) {
            String type = typeAttr.getText();
            testSuite.setType(type);
        }

        Attribute configurationIdAttr = testSuiteElt.attribute(QualityReport.CONFIGURATION_ID);
        if (configurationIdAttr != null) {
            String configurationId = configurationIdAttr.getText();
            testSuite.setConfigurationId(configurationId);
        }

        Attribute testIdAttr = testSuiteElt.attribute(QualityReport.TEST_ID);
        if (testIdAttr != null) {
            String testId = testIdAttr.getText();
            testSuite.setTestId(testId);
        }

        List<Element> testCaseEltList = testSuiteElt.elements(QualityReport.TEST_CASE);
        if (testCaseEltList != null) {
            List<TestCase> testCases = new ArrayList<TestCase>();

            for (Element testCaseElt : testCaseEltList) {
                TestCase testCase = QualityReport.parseTestCase(testCaseElt);
                testCases.add(testCase);
            }

            testSuite.setTestCases(testCases);
        }

        return testSuite;
    }

    // Parse testcase node in guality.xml
    private static TestCase parseTestCase(Element testCaseElt) {
        TestCase testCase = new TestCase();

        Attribute nameAttr = testCaseElt.attribute(QualityReport.NAME);
        if (nameAttr != null) {
            String name = nameAttr.getText();
            testCase.setName(name);
        }

        Attribute timeAttr = testCaseElt.attribute(QualityReport.TIME);
        if (timeAttr != null) {
            String time = timeAttr.getText();
            testCase.setTime(time);
        }

        Attribute resultAttr = testCaseElt.attribute(QualityReport.RESULT);
        if (resultAttr != null) {
            String result = resultAttr.getText();
            testCase.setResult(result);
        }

        Attribute svnUrlAttr = testCaseElt.attribute(QualityReport.SVN_URL_ATTR);
        if (svnUrlAttr != null) {
            String svnUrl = svnUrlAttr.getText();
            testCase.setSvnUrl(svnUrl);
        }

        Attribute svnUrlRevision = testCaseElt.attribute(QualityReport.SVN_REVISION_ATTR);
        if (svnUrlAttr != null) {
            String svnRevision = svnUrlRevision.getText();
            testCase.setSvnRevision(svnRevision);
        }

        return testCase;
    }

    // Parse gualitymetrics node in guality.xml
    @SuppressWarnings("unchecked")
    private static List<Metric> parseGualityMetrics(Element gualityMetricsElt) {
        List<Metric> metrics = new ArrayList<Metric>();

        List<Element> metricEltList = gualityMetricsElt.elements(QualityReport.METRIC);
        if (metricEltList != null) {
            for (Element metricElt : metricEltList) {
                Metric metric = QualityReport.parseMetric(metricElt);
                metrics.add(metric);
            }
        }

        return metrics;
    }

    // Parse metric node in guality.xml
    private static Metric parseMetric(Element metricElt) {
        Metric metric = new Metric();

        Attribute resultAttr = metricElt.attribute(QualityReport.RESULT);
        if (resultAttr != null) {
            String result = resultAttr.getText();
            MetricResult mResult = MetricResult.getValueOf(result);
            metric.setResult(mResult);
        }

        Attribute nameAttr = metricElt.attribute(QualityReport.NAME);
        if (nameAttr != null) {
            String name = nameAttr.getText();
            metric.setName(name);
        }

        Attribute failureCntAttr = metricElt.attribute(QualityReport.FAILURE_COUNT);
        if (failureCntAttr != null) {
            String failureCntestr = failureCntAttr.getText();
            int failureCnt = Integer.valueOf(failureCntestr).intValue();
            metric.setFaileCount(failureCnt);
        }

        Attribute newAttr = metricElt.attribute(QualityReport.NEW);
        if (newAttr != null) {
            String newStr = newAttr.getText();
            metric.setNewValue(newStr);
        }

        Attribute oldAttr = metricElt.attribute(QualityReport.OLD);
        if (oldAttr != null) {
            String oldStr = oldAttr.getText();
            metric.setOldValue(oldStr);
        }
        Attribute typeAttr = metricElt.attribute(QualityReport.TYPE);
        if (typeAttr != null) {
            String typeStr = typeAttr.getText();
            metric.setType(MetricType.getValueOf(typeStr));
        }
        Attribute timeAttr = metricElt.attribute(QualityReport.TIME);
        if (timeAttr != null) {
            String timeStr = timeAttr.getText();
            metric.setTime(timeStr);
        }

        Element failureElt = metricElt.element(QualityReport.FAILURE);
        if (failureElt != null) {
            String failure = failureElt.getText();
            metric.setFailure(failure);
        }

        return metric;
    }

    private static void addProductInfoNodeToElement(ProductInfo prodInfo, Element rootElt) {
        Element prodInfoElt = rootElt.addElement(QualityReport.PRODUCT_INFO);

        Element buElt = prodInfoElt.addElement(QualityReport.BUSINESS_UNIT);
        if (prodInfo.getBusinessUnit() != null) {
            buElt.setText(prodInfo.getBusinessUnit());
        }

        Element prodNameElt = prodInfoElt.addElement(QualityReport.PRODUCT_NAME);
        if (prodInfo.getProductName() != null) {
            prodNameElt.setText(prodInfo.getProductName());
        }

        Element prodVersionElt = prodInfoElt.addElement(QualityReport.PRODUCT_VERSION);
        if (prodInfo.getProductVersion() != null) {
            prodVersionElt.setText(prodInfo.getProductVersion());

            if (prodInfo.getProductVersionId() != null) {
                prodVersionElt.addAttribute(QualityReport.ID, prodInfo.getProductVersionId());
            }
        }

        Element svnUrlElt = prodInfoElt.addElement(QualityReport.SVN_URL_TAG);
        if (prodInfo.getSvnUrl() != null) {
            svnUrlElt.setText(prodInfo.getSvnUrl());
        }

        Element svnRevisionElt = prodInfoElt.addElement(QualityReport.SVN_REVISION_TAG);
        if (prodInfo.getSvnRevision() != null) {
            svnRevisionElt.setText(prodInfo.getSvnRevision());
        }
    }

    private static void addBuildTestInfoNodeToElement(BuildTestInfo buildtestInfo, Element rootElt) {
        Element buildtestInfoElt = rootElt.addElement(QualityReport.BUILD_TEST_INFO);

        Element certificationElt = buildtestInfoElt.addElement(QualityReport.CERTIFICATION);
        if (buildtestInfo.getCertification() != null) {
            certificationElt.setText(buildtestInfo.getCertification());
        }

        Element timestampElt = buildtestInfoElt.addElement(QualityReport.TIMESTAMP);
        if (buildtestInfo.getTimestamp() != null) {
            timestampElt.setText(buildtestInfo.getTimestamp());
        }

        if (buildtestInfo.getBuild() != null) {
            QualityReport.addBuildNodeToElement(buildtestInfo.getBuild(), buildtestInfoElt);
        }

        if (buildtestInfo.getTestgroup() != null) {
            QualityReport.addTestGroupNodeToElement(buildtestInfo.getTestgroup(), buildtestInfoElt);
        }
    }

    private static void addBuildNodeToElement(Build build, Element buildtestInfoElt) {
        Element buildElt = buildtestInfoElt.addElement(QualityReport.BUILD);

        buildElt.addAttribute(QualityReport.ID, build.getId());

        buildElt.addAttribute(QualityReport.JENKINS_JOB, build.getJenkinsjob());

        buildElt.addAttribute(QualityReport.JENKINS_BUILD, build.getJenkinsbuild());
        buildElt.addAttribute(QualityReport.RESULT, build.getResult());
    }

    private static void addTestGroupNodeToElement(TestGroup testGroup, Element buildtestInfoElt) {
        Element testGroupElt = buildtestInfoElt.addElement(QualityReport.TEST_GROUP);

        testGroupElt.addAttribute(QualityReport.ID, testGroup.getId());

        if (testGroup.getTests() != null) {
            for (Test test : testGroup.getTests()) {
                QualityReport.addTestNodeToElement(test, testGroupElt);
            }
        }
    }

    private static void addTestNodeToElement(Test test, Element testGroupElt) {
        Element testElt = testGroupElt.addElement(QualityReport.TEST);

        testElt.addAttribute(QualityReport.ID, test.getId());

        testElt.addAttribute(QualityReport.CONFIGURATION_ID, test.getConfigurationId());

        testElt.addAttribute(QualityReport.JENKINS_JOB, test.getJenkinsjob());

        testElt.addAttribute(QualityReport.JENKINS_BUILD, test.getJenkinsbuild());

        testElt.addAttribute(QualityReport.RESULT, test.getResult());
    }

    private static void addConfigurationsNodeToElement(List<Configuration> configs, Element rootElt) {
        Element configsElt = rootElt.addElement(QualityReport.CONFIGURATIONS);

        for (Configuration config : configs) {
            QualityReport.addConfigurationNodeToElement(config, configsElt);
        }
    }

    private static void addConfigurationNodeToElement(Configuration config, Element configsElt) {
        Element configElt = configsElt.addElement(QualityReport.CONFIGURATION);

        configElt.addAttribute(QualityReport.ID, config.getId());

        if (config.getEnvironments() != null) {
            Element environmentsElt = configElt.addElement(QualityReport.ENVIRONMENTS);

            Element osElt = environmentsElt.addElement(QualityReport.OS);
            if (config.getEnvironments().getOs() != null) {
                osElt.setText(config.getEnvironments().getOs());
            }

            Element archElt = environmentsElt.addElement(QualityReport.ARCH);
            if (config.getEnvironments().getArch() != null) {
                archElt.setText(config.getEnvironments().getArch());
            }

            Element languageElt = environmentsElt.addElement(QualityReport.LANGUAGE);
            if (config.getEnvironments().getLanguage() != null) {
                languageElt.setText(config.getEnvironments().getLanguage());
            }
        }

        if (config.getSoftwares() != null) {
            Element softwaresElt = configElt.addElement(QualityReport.SOFTWARES);

            for (String software : config.getSoftwares()) {
                Element softwareElt = softwaresElt.addElement(QualityReport.SOFTWARE);
                softwareElt.setText(software);
            }
        }
    }

    private static void addTestsNodeToElement(List<TestSuite> tests, Element rootElt) {
        Element testsElt = rootElt.addElement(QualityReport.TESTS);

        for (TestSuite testSuite : tests) {
            QualityReport.addTestSuiteNodeToElement(testSuite, testsElt);
        }
    }

    private static void addTestSuiteNodeToElement(TestSuite testSuite, Element testsElt) {
        Element testSuiteElt = testsElt.addElement(QualityReport.TEST_SUITE);

        testSuiteElt.addAttribute(QualityReport.TYPE, testSuite.getType());

        testSuiteElt.addAttribute(QualityReport.TEST_ID, testSuite.getTestId());

        testSuiteElt.addAttribute(QualityReport.CONFIGURATION_ID, testSuite.getConfigurationId());

        if (testSuite.getTestCases() != null) {
            for (TestCase testCase : testSuite.getTestCases()) {
                QualityReport.addTestCaseNodeToElement(testCase, testSuiteElt);
            }
        }
    }

    private static void addTestCaseNodeToElement(TestCase testCase, Element testSuiteElt) {
        Element testCaseElt = testSuiteElt.addElement(QualityReport.TEST_CASE);

        testCaseElt.addAttribute(QualityReport.NAME, testCase.getName());

        testCaseElt.addAttribute(QualityReport.TIME, testCase.getTime());

        testCaseElt.addAttribute(QualityReport.RESULT, testCase.getResult());

        testCaseElt.addAttribute(QualityReport.SVN_URL_ATTR, testCase.getSvnUrl());

        testCaseElt.addAttribute(QualityReport.SVN_REVISION_ATTR, testCase.getSvnRevision());
    }

    private static void addGualityMetricsNodeToElement(List<Metric> gualityMetrics, Element rootElt) {
        Element gualityMetricsElt = rootElt.addElement(QualityReport.GUALITY_METRICS);

        for (Metric metric : gualityMetrics) {
            QualityReport.addMetricNodeToElement(metric, gualityMetricsElt);
        }
    }

    private static void addMetricNodeToElement(Metric metric, Element gualityMetricsElt) {
        Element metricElt = gualityMetricsElt.addElement(QualityReport.METRIC);

        metricElt.addAttribute(QualityReport.NAME, metric.getName());

        metricElt.addAttribute(QualityReport.RESULT, metric.getResult().toString());
        if (metric.getFaileCount() > 0) {
            metricElt.addAttribute(QualityReport.FAILURE_COUNT, Integer.toString(metric.getFaileCount()));
        }
        metricElt.addAttribute(QualityReport.NEW, metric.getNewValue());

        metricElt.addAttribute(QualityReport.OLD, metric.getOldValue());
        if (metric.getType() != null) {
            metricElt.addAttribute(QualityReport.TYPE, metric.getType().toString());
        }
        if (!StringUtil.isEmpty(metric.getTime())) {
            metricElt.addAttribute(QualityReport.TIME, metric.getTime());
        }
        if (metric.getFailure() != null) {
            Element failureElt = metricElt.addElement(QualityReport.FAILURE);
            failureElt.setText(metric.getFailure());
        }
    }
}
