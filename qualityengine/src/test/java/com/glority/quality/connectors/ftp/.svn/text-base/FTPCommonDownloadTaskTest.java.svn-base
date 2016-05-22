package com.glority.quality.connectors.ftp;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.tools.ant.Project;
import org.junit.Before;
import org.junit.Test;

public class FTPCommonDownloadTaskTest {
    private static final String SERVER = "quality.glority.com";
    private static final String REMOTE_PATH = "/qsdata/junit_test/download_test";
    private static final String USERNAME = "qsdata";
    private static final String PASSWORD = "qsdata";
    private static final String TEST_DIR = "junit_test";

    private static final String LOCAL_PATH = "testtasks" + File.separator + TEST_DIR;

    @Before
    public void setUp() {
        File file = new File(LOCAL_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    @Test
    public void testProcess() {
        FTPCommonDownloadTask task = new FTPCommonDownloadTask();

        task.setUsername(USERNAME);
        task.setPassword(PASSWORD);
        task.setDescription("upload test file");
        task.setLocalPath(LOCAL_PATH);

        task.setRemotePath(REMOTE_PATH);
        task.setServer(SERVER);
        task.setPassword(USERNAME);
        task.setUsername(PASSWORD);
        task.setProject(new Project());
        task.process();

        File file = new File(LOCAL_PATH + File.separator + "download_test");
        assertEquals(3, file.listFiles().length);
    }

}
