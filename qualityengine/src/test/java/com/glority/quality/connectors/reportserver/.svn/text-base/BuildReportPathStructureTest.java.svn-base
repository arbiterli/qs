package com.glority.quality.connectors.reportserver;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuildReportPathStructureTest {
    private BuildReportPathStructure brps;
    private String expectedBasePath;
    private String expectedBaseFullPath;
    private String baseUrl;

    private static final String INSTALLER_FOLDER = "installer";
    private static final String DEBUG_INSTALLER_FOLDER = "debug_installer";
    private static final String REPORT_FOLDER = "buildreports";
    private static final String QUALITY_REPORT_FOLDER = "qualityreports";
    private static final String QUALITY_XML = "quality.xml";    
    
    @Before
    public void setUp() {
        baseUrl = "http://quality.glority.com:81";
        brps = new BuildReportPathStructure();
        brps.setBusinessUnit("Glority");
        brps.setProductName("QualitySystem");
        brps.setBaseURL(baseUrl);
        brps.setJenkinsBuildId("49");
        brps.setSvnRevision("24473");
        brps.setProtocol(BuildReportPathStructure.PROTOCOL_HTTP);
        
        expectedBasePath = "qsdata/Glority/build/QualitySystem/24473_49";
        expectedBaseFullPath =  baseUrl + "/" + expectedBasePath;
    }
    @Test
    public void testGetBuildPath() {
        assertEquals(expectedBasePath, brps.getBuildPath(false));
        assertEquals(expectedBaseFullPath, brps.getBuildPath(true));
    }

    @Test
    public void testGetQualityXmlPath() {
        assertEquals(expectedBasePath + "/" + QUALITY_XML, brps.getQualityXmlPath(false));
        assertEquals(expectedBaseFullPath + "/" + QUALITY_XML, brps.getQualityXmlPath(true));
    }

    @Test
    public void testGetInstallerPath() {
        assertEquals(expectedBasePath + "/" + INSTALLER_FOLDER, brps.getInstallerPath(false));
        assertEquals(expectedBaseFullPath + "/" + INSTALLER_FOLDER, brps.getInstallerPath(true));
    }

    @Test
    public void testGetDebugInstallerPath() {
        assertEquals(expectedBasePath + "/" + DEBUG_INSTALLER_FOLDER, brps.getDebugInstallerPath(false));
        assertEquals(expectedBaseFullPath + "/" + DEBUG_INSTALLER_FOLDER, brps.getDebugInstallerPath(true));
    }

    @Test
    public void testGetBuildReportPath() {
        assertEquals(expectedBasePath + "/" + REPORT_FOLDER, brps.getBuildReportPath(false));
        assertEquals(expectedBaseFullPath + "/" + REPORT_FOLDER, brps.getBuildReportPath(true));
    }

    @Test
    public void testGetQualityReportPathBoolean() {
        assertEquals(expectedBasePath + "/" + REPORT_FOLDER + "/" + QUALITY_REPORT_FOLDER, brps.getQualityReportPath(false));
        assertEquals(expectedBaseFullPath + "/" + REPORT_FOLDER + "/" + QUALITY_REPORT_FOLDER, brps.getQualityReportPath(true));
    }

    @Test
    public void testGetQualityReportPathBooleanString() {
        String metricsPath = "java-mi";
        String relativePath = REPORT_FOLDER + "/" + QUALITY_REPORT_FOLDER + "/" + metricsPath;
        assertEquals(expectedBasePath + "/" + relativePath, brps.getQualityReportPath(false, metricsPath));
        assertEquals(expectedBaseFullPath + "/" + relativePath, brps.getQualityReportPath(true, metricsPath));
        assertEquals(null, brps.getQualityReportPath(true, null));
    }
    @Test
    public void testFtpPath() {
        brps.setProtocol(BuildReportPathStructure.PROTOCOL_FTP);
        assertEquals(expectedBasePath, brps.getBuildPath(false));
        brps.setProtocol(BuildReportPathStructure.PROTOCOL_HTTP);        
    }
    @Test
    public void testLocalPath() {
        brps.setProtocol(BuildReportPathStructure.PROTOCOL_LOCAL);
        assertEquals(brps.fixedPath(expectedBasePath), brps.getBuildPath(false));
        brps.setProtocol(BuildReportPathStructure.PROTOCOL_HTTP);
    }
    @Test
    public void testFixedPath() {
        assertEquals(null, brps.fixedPath(null));
        assertEquals("aa", brps.fixedPath("aa"));
        assertEquals("a/a", brps.fixedPath("a\\a"));
        assertEquals("a/a", brps.fixedPath("a/a"));
    }
    @After
    public void tearDown() throws Exception {
    }
}
