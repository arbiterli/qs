package com.glority.qualityserver.deploylog;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

/**
 * Interface for DeployLog.
 * 
 * @author liheping
 * 
 */
public interface DeployLog {
    /**
     * check whether the log is running.
     * 
     * @return log is running
     */
    boolean isLogRunning();

    /**
     * get logs from running log.
     * 
     * @return logs List<String>
     */
    List<String> getRunningLog();

    /**
     * dispose the log.
     */
    void dispose();

    /**
     * set the file to persistent the output.
     * 
     * @param output
     *            the output
     */
    void setPersistentOuput(File output);

    /**
     * set the outputStream to persistent the ouput.
     * 
     * @param outputStream
     *            OutputStream
     */
    void setPersistendOutput(OutputStream outputStream);

    /**
     * get the prefix for form the unique log file name.
     * 
     * @return string prefix
     */
    String getUniquePrefix();
}
