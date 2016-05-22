package com.glority.quality.backup;

import com.glority.common.connectors.ftp.FTPConnector;

/**
 * download backup.
 * 
 * @author LYX
 * 
 */
public class BackupDownloadTask extends BaseBackupDownloadTask {

    @Override
    public void process() {
        this.setVerbose(true);
        if (getVersion() == null || getVersion().equals("")) {
            String logRemoteFile = this.remotePath + LOGFILENAME;
            this.setRemotePath(logRemoteFile);
            super.process();
            this.readLatestBackup(this.localPath + LOGFILENAME);
            this.deleteLogFile(this.localPath + LOGFILENAME);
            this.setRemotePath(this.getLatestBackup());
        } else {
            this.setRemotePath(this.remotePath + FTPConnector.FTP_FILE_SEPERATOR + this.getVersion()
                    + FTPConnector.FTP_FILE_SEPERATOR);
        }
        super.process();
    }
}
