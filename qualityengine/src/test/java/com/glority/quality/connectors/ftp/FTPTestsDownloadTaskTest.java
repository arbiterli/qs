package com.glority.quality.connectors.ftp;

import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tools.ant.Project;
import org.junit.Before;
import org.junit.Test;

/**
 * Add junit test for functionality of download test result from ftp.
 * 
 * @author Chen.hong
 *
 */
public class FTPTestsDownloadTaskTest {
    private static final String TEST_DIR = "c:\\test_dir";

    private static final String PROPERTY_FILE = "C:\\path_types.properties";
    private FTPTestsDownloadTask task;

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
    }

    @Test
    public void downloadFileTest() {
        task = new FTPTestsDownloadTask();
        task.setFolderType("qualityxml");
        task.setLocalPath(TEST_DIR);
        task.setServer("quality.glority.com");
        task.setJenkinsBuild("latest");
        task.setPassword("qsdata");
        task.setUsername("qsdata");
        task.setBusinessUnit("winzip");
        task.setProductName("Courier45");
        task.setPathDefFile(PROPERTY_FILE);
        task.setSuiteNum("121212");
        task.setTestNum("111111");
        task.setProject(new Project());
        task.process();

        // validate if the Quality.xml file is downloaded.
        File file = new File(TEST_DIR + File.separator + "quality.xml");
        assertTrue(file.exists());
    }
}
