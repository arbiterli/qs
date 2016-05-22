package com.glority.quality.connectors.ftp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimeZone;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.tools.ant.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FTPCommonUploadTaskTest {

    private static final String SERVER = "quality.glority.com";
    private static final String REMOTE_PATH = "qsdata/junit_test";
    private static final String USERNAME = "qsdata";
    private static final String PASSWORD = "qsdata";
    private static final int PORT = 21;
    private static final String TEST_DIR = "junit_test_upload";

    private static final String LOCAL_PATH = "testtasks" + File.separator + TEST_DIR;

    @Before
    public void setUp() throws IOException {
        // create a directory.
        File file = new File(LOCAL_PATH);
        if (!file.exists()) {
            file.mkdir();
        }

        // append a text file to the directory.
        File subFile = new File(file.getAbsoluteFile() + File.separator + "junittest.txt");
        if (!subFile.exists()) {
            subFile.createNewFile();
        }

        FileWriter writer = new FileWriter(subFile);
        writer.write("testing only\n");
        writer.flush();
        writer.close();
    }

    /**
     * Get the FTPClient for testing.
     * 
     * @return
     * @throws Exception
     *             to junit
     */
    private FTPClient getFTPClient() throws Exception {
        FTPClientConfig config = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
        config.setServerTimeZoneId(TimeZone.getDefault().getID());
        FTPClient ftpClient = new FTPClient();

        ftpClient.connect(SERVER, PORT);
        ftpClient.login(USERNAME, PASSWORD);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

        return ftpClient;
    }

    @After
    public void tearDown() throws Exception {
        FTPClient ftpClient = getFTPClient();

        ftpClient.changeWorkingDirectory("/");
        ftpClient.changeWorkingDirectory(REMOTE_PATH);
        ftpClient.changeWorkingDirectory(TEST_DIR);

        FTPFile[] testFiles = ftpClient.listFiles();
        for (int i = 0; i < testFiles.length; i++) {
            if (testFiles[i].isFile()) {
                ftpClient.deleteFile(testFiles[i].getName());
            }
        }
        ftpClient.disconnect();
    }

    @Test
    public void testProcess() throws Exception {
        FTPCommonUploadTask task = new FTPCommonUploadTask();

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

        checkFileUploaded();
    }

    private void checkFileUploaded() throws Exception {
        FTPClient ftpClient = getFTPClient();

        ftpClient.changeWorkingDirectory("/" + REMOTE_PATH + "/" + TEST_DIR);
        FTPFile[] files = ftpClient.listFiles();

        assertEquals("Equal to 1.", 1, files.length);

        assertEquals("junittest.txt", files[0].getName());

    }
}
