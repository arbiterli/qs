package com.glority.quality.backup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ftp.FTPConnector;
import com.glority.quality.connectors.ftp.FTPCommonUploadTask;

/**
 * upload backup.
 * 
 * @author LYX
 * 
 */
public class BackupUploadTask extends FTPCommonUploadTask {
    private static final Logger LOGGER = Logger.getLogger(BackupUploadTask.class);
    private static final String LOGFILENAME = "latestBackup.log";

    private String getTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        sdf.applyPattern("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    private void createLogFile(String latestBackup) {
        OutputStream os = null;
        try {
            String logFile = this.localPath + FTPConnector.FTP_FILE_SEPERATOR + LOGFILENAME;
            os = new FileOutputStream(logFile);
            os.write(latestBackup.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to write latestBackup.log");
            throw new BuildException(e.getMessage());
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.debug("Failed to close OutputStream");
                throw new BuildException(e.getMessage());
            }
        }
    }

    private void deleteLogFile(String latestBackup) {
        File file = new File(latestBackup);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public void process() {
        String logRemoteDir = this.remotePath + FTPConnector.FTP_FILE_SEPERATOR;
        String newRemoteDir = this.remotePath + (new File(localPath)).getName() + "_" + getTimeStr()
                + FTPConnector.FTP_FILE_SEPERATOR;
        this.setRemotePath(newRemoteDir);
        this.setFailOnError(false);
        this.setVerbose(true);
        super.process();
        createLogFile(newRemoteDir);
        this.setLocalPath(this.localPath + FTPConnector.FTP_FILE_SEPERATOR + LOGFILENAME);
        this.setRemotePath(logRemoteDir);
        super.process();
        this.deleteLogFile(this.localPath);
    }
}
