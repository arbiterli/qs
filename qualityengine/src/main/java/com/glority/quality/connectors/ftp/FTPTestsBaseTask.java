package com.glority.quality.connectors.ftp;

import com.glority.common.connectors.ftp.FTPConnector;

/**
 * to do operation under tests directory.
 * 
 * @author zm.
 * 
 */
public abstract class FTPTestsBaseTask extends FTPTPBaseTask {

    protected String suiteNum;
    protected String testNum;
    protected static final String TESTS = "tests";

    public FTPTestsBaseTask() {
        super();
    }

    public void setSuiteNum(String suiteNum) {
        this.suiteNum = suiteNum;
    }

    public void setTestNum(String testNum) {
        this.testNum = testNum;
    }

    @Override
    protected void initParameters() {
        super.initParameters();
        if (this.suiteNum == null) {
            this.suiteNum = "1";
            log.warn("Warning: you'd better input suite number, default '1'");
        }
        if (this.testNum == null) {
            this.testNum = "1";
            log.warn("Warning: you'd better input test number, default '1'");
        }
    }

    @Override
    protected void prepareRemoteEnv() {

        String pathPrefix = HOME_PATH + FTPConnector.FTP_FILE_SEPERATOR + businessUnit
                + FTPConnector.FTP_FILE_SEPERATOR + BUILD + FTPConnector.FTP_FILE_SEPERATOR + productName;
        remotePath = getRemoteFolderPath(pathPrefix);

    }
}
