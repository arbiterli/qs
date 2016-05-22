package com.glority.quality.connectors.ftp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tools.ant.Project;
import org.junit.Before;
import org.junit.Test;

public class FTPTestsUploadTaskTest {

    private static final String CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "<qaulityreport><productinfo><businessunit>winzip</businessunit><productname>Courier45</productname>"
            + "<productversion>4.5</productversion>"
            + "<svnurl>http://10.0.0.158/svn/Development/Products/Courier45</svnurl><svnrevision>22139</svnrevision></productinfo>"
            + "<buildtestinfo><certification></certification><timestamp></timestamp><build jenkinsjob=\"121212\" jenkinsbuild=\"111111\"/>"
            + "<testgroup><test jenkinsjob=\"Courier45_Build\" jenkinsbuild=\"357\"/></testgroup></buildtestinfo><configurations>"
            + "<configuration>"
            + "<environments><os>-Dtestinfo.configuration.lang</os><arch></arch><language></language></environments><softwares>"
            + "<software>explorer</software></softwares></configuration></configurations><gualitymetrics>"
            + "<metric name=\"CPP_MI_WITH_COMMENT\" result=\"invalidthreshold\" new=\"107.236435\" type=\"MI\"/>"
            + "<metric name=\"CPP_MI\" result=\"nocheck\" new=\"79.34516\" type=\"MI\"/>"
            + "<metric name=\"CPP_LINES_OF_CODE\" result=\"nocheck\" new=\"554787.0\" type=\"CODEBASEINFO\"/>"
            + "<metric name=\"CPP_LINES_OF_COMMENT\" result=\"nocheck\" new=\"94778.0\" type=\"CODEBASEINFO\"/>"
            + "<metric name=\"CS_MI_WITH_COMMENT\" result=\"invalidthreshold\" new=\"105.57279\" type=\"MI\"/>"
            + "<metric name=\"CS_MI\" result=\"nocheck\" new=\"84.44295\" type=\"MI\"/>"
            + "<metric name=\"CS_LINES_OF_CODE\" result=\"nocheck\" new=\"23412.0\" type=\"CODEBASEINFO\"/>"
            + "<metric name=\"CS_LINES_OF_COMMENT\" result=\"nocheck\" new=\"2017.0\" type=\"CODEBASEINFO\"/>"
            + "<metric name=\"TESTCOMPLETE_TEST_TOTAL_COUNT\" result=\"nocheck\" new=\"21.0\" type=\"TEST_SUMMARY\"/>"
            + "<metric name=\"TESTCOMPLETE_TEST_PASSED_COUNT\" result=\"nocheck\" new=\"1.0\" type=\"TEST_SUMMARY\"/>"
            + "<metric name=\"TESTCOMPLETE_TEST_SUCCESS_RATE\" result=\"nocheck\" new=\"0.04761905\" type=\"TEST_SUMMARY\"/>"
            + "<metric name=\"TESTCOMPLETE_TEST_FAILED_COUNT\" result=\"invalidthreshold\" new=\"20.0\" type=\"TEST_SUMMARY\"/>"
            + "</gualitymetrics>"
            + "<tests><testsuite type=\"TESTCOMPLETE\"><testcase name=\"308\" result=\"fail\"/>"
            + "<testcase name=\"83\" result=\"fail\"/><testcase name=\"84\" result=\"fail\"/><testcase name=\"85\" result=\"fail\"/>"
            + "<testcase name=\"86\" result=\"fail\"/><testcase name=\"87\" result=\"fail\"/><testcase name=\"88\" result=\"fail\"/>"
            + "<testcase name=\"89\" result=\"fail\"/><testcase name=\"90\" result=\"fail\"/><testcase name=\"91\" result=\"fail\"/>"
            + "<testcase name=\"reportgenerator\" result=\"success\"/><testcase name=\"92\" result=\"fail\"/>"
            + "<testcase name=\"93\" result=\"fail\"/><testcase name=\"239\" result=\"fail\"/>"
            + "<testcase name=\"94\" result=\"fail\"/><testcase name=\"512\" result=\"fail\"/><testcase name=\"97\" result=\"fail\"/>"
            + "<testcase name=\"98\" result=\"fail\"/><testcase name=\"99\" result=\"fail\"/><testcase name=\"514\" result=\"fail\"/>"
            + "<testcase name=\"513\" result=\"fail\"/></testsuite></tests></qaulityreport>";

    private static final String TEST_DIR = "c:\\test_dir";
    private static final String LOCAL_FILE = TEST_DIR + File.separator + "quality.xml";


    private static final String PROPERTY_FILE = "C:\\path_types.properties";
    private FTPTestsUploadTask task;

    @Before
    public void setUp() throws IOException {
        File file = new File(TEST_DIR);
        if (!file.exists()) {
            file.mkdir();
        }

        File propertyFile = new File(PROPERTY_FILE);
        if (!propertyFile.exists()) {
            propertyFile.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(propertyFile));
        writer.append("all=\n");
        writer.append("root=\n");
        writer.append("installer=installer/\n");
        writer.append("debuginstaller=debug_installer/\n");
        writer.append("tests=tests/\n");
        writer.append("buildreports=buildreports/\n");
        writer.append("testreport=testreport/\n");
        writer.append("log=log/\n");
        writer.append("qualityxml=quality.xml\n");
        writer.flush();
        writer.close();
        
        File localFile = new File(LOCAL_FILE);
        if (!localFile.exists()) {
            localFile.createNewFile();
        }

        writer = new BufferedWriter(new FileWriter(localFile));
        writer.write(CONTENT);
        writer.write("\n");
        writer.flush();
        writer.close();
    }

    @Test
    public void uploadFileTest() {
        task = new FTPTestsUploadTask();
        task.setFolderType("qualityxml");
        task.setLocalPath(LOCAL_FILE);
        task.setServer("quality.glority.com");
        task.setJenkinsBuild("357");
        task.setPassword("qsdata");
        task.setUsername("qsdata");
        task.setBusinessUnit("winzip");
        task.setProductName("Courier45");
        task.setPathDefFile(PROPERTY_FILE);
        task.setSuiteNum("121212");
        task.setTestNum("111111");
        task.setProject(new Project());
        task.process();
    }
}
