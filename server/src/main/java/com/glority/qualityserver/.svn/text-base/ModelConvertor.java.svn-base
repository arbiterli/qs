package com.glority.qualityserver;

import java.util.List;

/**
 * Model convertor. methods for convert model from engine to server.
 * 
 * @author liheping
 * 
 */
public final class ModelConvertor {
    /**
     * default constructor.
     */
    private ModelConvertor() {
    }

    /**
     * convert engine productInfo to server Product.
     * 
     * @param productInfo
     *            engine ProductInfo
     * @return server Product
     */
    public static com.glority.qualityserver.model.Product convertToSeverModel(
            com.glority.quality.model.ProductInfo productInfo) {
        com.glority.qualityserver.model.Product sProduct = new com.glority.qualityserver.model.Product();

        if (productInfo != null) {
            sProduct.setName(productInfo.getProductName());
            sProduct.setDisplayName(productInfo.getProductName());
            sProduct.setGroup(productInfo.getBusinessUnit());
            // sProduct.setSvnUrl(productInfo.getSvnUrl());
            // sProduct.setSvnRevision(productInfo.getSvnRevision());
        }

        return sProduct;
    }

    /**
     * convert engine productInfo to server Version.
     * 
     * @param productInfo
     *            engine ProductInfo
     * @return server Version
     */
    public static com.glority.qualityserver.model.Version convertToGetVersion(
            com.glority.quality.model.ProductInfo productInfo) {
        com.glority.qualityserver.model.Version version = new com.glority.qualityserver.model.Version();

        if (productInfo != null) {
            if (productInfo.getProductVersionId() != null) {
                version.setId(Long.parseLong(productInfo.getProductVersionId()));
            }

            version.setVersion(productInfo.getProductVersion());

            version.setSvnRevision(productInfo.getSvnRevision());

            version.setSvnUrl(productInfo.getSvnUrl());
        }

        return version;
    }

    /**
     * convert engine Configuration to server Configuration.
     * 
     * @param configuration
     *            engine Configuration
     * @return server Configuration
     */
    public static com.glority.qualityserver.model.Configuration convertToServerModel(
            com.glority.quality.model.Configuration configuration) {
        com.glority.qualityserver.model.Configuration sConfig = new com.glority.qualityserver.model.Configuration();

        if (configuration != null) {
            //use name field to store the id from report.
            sConfig.setName(configuration.getId());

            sConfig.setOs(configuration.getEnvironments().getOs());
            sConfig.setArch(configuration.getEnvironments().getArch());
            sConfig.setLanguage(configuration.getEnvironments().getLanguage());
            sConfig.setSoftwares(convertSoftwaresToXml(configuration.getSoftwares()));
        }
        return sConfig;
    }

    /**
     * generate server Build from engine Build and engine ProductInfo.
     * 
     * @param build
     *            engine Build
     * @param productInfo
     *            engine ProductInfo
     * @return server Build
     */
    public static com.glority.qualityserver.model.Build convertToServerModel(com.glority.quality.model.Build build,
            com.glority.quality.model.ProductInfo productInfo) {
        com.glority.qualityserver.model.Build sBuild = new com.glority.qualityserver.model.Build();

        if (build != null && productInfo != null) {
            if (build.getId() != null) {
                sBuild.setId(Long.valueOf(build.getId()).longValue());
            }
            sBuild.setJenkinsJobname(build.getJenkinsjob());
            if (build.getJenkinsbuild() != null) {
                sBuild.setJenkinsBuildId(Long.valueOf(build.getJenkinsbuild()).longValue());
            }
            sBuild.setResult(build.getResult());
            sBuild.setSvnRevision(productInfo.getSvnRevision());
            sBuild.setSvnUrl(productInfo.getSvnUrl());
        }

        return sBuild;
    }

    /**
     * convert from engine TestGroup to server TestGroup.
     * 
     * @param testGroup
     *            engine TestGroup
     * @return server TestGroup
     */
    public static com.glority.qualityserver.model.TestGroup convertToServerModel(
            com.glority.quality.model.TestGroup testGroup) {
        com.glority.qualityserver.model.TestGroup sTestGroup = new com.glority.qualityserver.model.TestGroup();

        if (testGroup != null) {
            if (testGroup.getId() != null) {
                sTestGroup.setId(Long.valueOf(testGroup.getId()).longValue());
            }
        }

        return sTestGroup;
    }

    /**
     * convert from engine Test to server Test.
     * 
     * @param test
     *            engine Test
     * @return server Test
     */
    public static com.glority.qualityserver.model.Test convertToServerModel(com.glority.quality.model.Test test) {
        com.glority.qualityserver.model.Test sTest = new com.glority.qualityserver.model.Test();

        if (test != null) {
            if (test.getConfigurationId() != null) {
                sTest.setConfigurationId(Long.valueOf(test.getConfigurationId()).longValue());
            }
            if (test.getId() != null) {
                sTest.setId(Long.valueOf(test.getId()).longValue());
            }
            sTest.setJenkinsJobname(test.getJenkinsjob());
            if (test.getJenkinsbuild() != null) {
                sTest.setJenkinsBuildid(Long.valueOf(test.getJenkinsbuild()).longValue());
            }
            sTest.setResult(test.getResult());
        }

        return sTest;
    }

    /**
     * convert from engine testSuite to server TestSuite.
     * 
     * @param testSuite
     *            engine TestSuite
     * @return server TestSuite
     */
    public static com.glority.qualityserver.model.TestSuite convertToServerModel(
            com.glority.quality.model.TestSuite testSuite) {
        com.glority.qualityserver.model.TestSuite sTestSuite = new com.glority.qualityserver.model.TestSuite();

        if (testSuite != null) {
            if (testSuite.getConfigurationId() != null) {
                sTestSuite.setConfigurationId(Long.valueOf(testSuite.getConfigurationId()).longValue());
            }
            if (testSuite.getTestId() != null) {
                sTestSuite.setTestId(Long.valueOf(testSuite.getTestId()).longValue());
            }
            sTestSuite.setType(testSuite.getType());
        }

        return sTestSuite;
    }

    /**
     * convert from engine TestCase to server TestCase.
     * 
     * @param testCase
     *            engine TestCase
     * @return server TestCase
     */
    public static com.glority.qualityserver.model.TestCase convertToServerModel(
            com.glority.quality.model.TestCase testCase) {
        com.glority.qualityserver.model.TestCase sTestCase = new com.glority.qualityserver.model.TestCase();

        if (testCase != null) {
            sTestCase.setName(testCase.getName());
            if (testCase.getTime() != null) {
                sTestCase.setTime(new Float(testCase.getTime()).floatValue());
            }
            sTestCase.setResult(testCase.getResult());
            sTestCase.setSvnUrl(testCase.getSvnUrl());
            sTestCase.setSvnRevision(testCase.getSvnRevision());
        }

        return sTestCase;
    }

    /**
     * convert from engine Metric to server BuildMetric.
     * 
     * @param metric
     *            engine Metric
     * @return server BuildMetric
     */
    public static com.glority.qualityserver.model.BuildMetric convertToServerModel(
            com.glority.quality.model.Metric metric) {
        com.glority.qualityserver.model.BuildMetric sMetric = new com.glority.qualityserver.model.BuildMetric();

        if (metric != null) {
            sMetric.setResult(metric.getResult().toString());
            sMetric.setType(metric.getType().toString());
            sMetric.setName(metric.getName());
            sMetric.setFailureCount(Long.valueOf(metric.getFaileCount()).longValue());

            sMetric.setNewValue(metric.getNewValue());
            sMetric.setOldValue(metric.getOldValue());
        }

        return sMetric;
    }

    /**
     * get server Failure from engine Metric.
     * 
     * @param metric
     *            engine Metric
     * @return server Failure
     */
    public static com.glority.qualityserver.model.Failure convertToGetFailure(com.glority.quality.model.Metric metric) {
        com.glority.qualityserver.model.Failure failure = new com.glority.qualityserver.model.Failure();

        if (metric != null) {
            failure.setDetail(metric.getFailure());
        }

        return failure;
    }

    /**
     * convertSoftwares to XML String.
     * 
     * @param softwareList
     *            softwares
     * @return XML string
     */
    private static String convertSoftwaresToXml(List<String> softwareList) {
        StringBuilder xmlContent = new StringBuilder("<softwares>");

        for (String software : softwareList) {
            xmlContent.append("<software>").append(software).append("</software>");
        }

        xmlContent.append("</softwares");

        return xmlContent.toString();
    }
}
