package com.glority.quality.backup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildException;

import com.glority.quality.connectors.ftp.FTPCommonDownloadTask;
/**
 * base backup download task.
 * 
 * @author LYX
 * 
 */
public class BaseBackupDownloadTask extends FTPCommonDownloadTask {
    private static final Logger LOGGER = Logger.getLogger(BaseBackupDownloadTask.class);
    protected static final String LOGFILENAME = "latestBackup.log";
    private String latestBackup;
    private String version = null;

    public String getLatestBackup() {
        return latestBackup;
    }

    public void setLatestBackup(String latestBackup) {
        this.latestBackup = latestBackup;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    protected void deleteLogFile(String latestBackup) {
        File file = new File(latestBackup);
        if (file.exists()) {
            file.delete();
        }
    }

    protected void readLatestBackup(String logFilePath) {
        InputStream fin = null;
        BufferedReader reader = null;
        try {
            fin = new FileInputStream(logFilePath);
            reader = new BufferedReader(new InputStreamReader(fin));
            this.setLatestBackup(reader.readLine());
            reader.close();
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.debug(e.getMessage(), e);
            LOGGER.debug("Failed to read latestBackup.log");
            throw new BuildException(e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.debug("Failed to close InputStream");
                throw new BuildException(e.getMessage());
            }
        }
    }
}
