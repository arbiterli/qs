package com.glority.quality.backup;

/**
 * check the latest upload time.
 * 
 * @author LYX
 * 
 */
public class BackupLatestVersionCheckTask extends BaseBackupDownloadTask {
    private static final int TIME_STAMP_START = 15;
    private static final int TIME_STAMP_END = 1;
    private static final int YEAR = 4;
    private static final int MONTH = 6;
    private static final int DAY = 8;
    private static final int HOUR = 10;
    private static final int MINUTE = 12;
    private static final int SECOND = 14;
    private int insertNum = 0;

    private String changeFormat(String timeNum) {
        StringBuffer time = new StringBuffer(timeNum);
        time.insert(YEAR + insertNum, "-");
        insertNum++;
        time.insert(MONTH + insertNum, "-");
        insertNum++;
        time.insert(DAY + insertNum, ",");
        insertNum++;
        time.insert(HOUR + insertNum, ":");
        insertNum++;
        time.insert(MINUTE + insertNum, ":");
        insertNum++;
        time.insert(SECOND + insertNum, ".");
        return time.toString();
    }

    @Override
    public void process() {
        String logRemoteFile = this.remotePath + LOGFILENAME;
        this.setRemotePath(logRemoteFile);
        super.process();
        readLatestBackup(this.localPath + LOGFILENAME);
        deleteLogFile(this.localPath + LOGFILENAME);
        String origin = getLatestBackup();
        String timeNum = origin.substring(origin.length() - TIME_STAMP_START
                , origin.length() - TIME_STAMP_END);
        System.out.println(changeFormat(timeNum));
    }
}
