package com.glority.qualityserver.deploylog.impl;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import com.glority.qualityserver.deploylog.DeployLog;

/**
 * Dummy DeployLog.
 * 
 */
public class DummyDeployLog implements DeployLog {

    private File file;

    /**
     * Get the File.
     * 
     * @return File.
     */
    public File getFile() {
        return file;
    }

    /**
     * Dummy.
     * 
     * @return false.
     */
    public boolean isLogRunning() {
        return false;
    }

    /**
     * Dummy.
     * 
     * @return list of string
     */
    public List<String> getRunningLog() {
        return null;
    }

    /**
     * dummy.
     */
    public void dispose() {
        if (file != null && file.exists()) {
            file.delete();
        }
    }

    /**
     * Dummy.
     * 
     * @param output
     */
    public void setPersistentOuput(File output) {
        file = output;
    }

    /**
     * Dummy.
     * 
     * @param outputStream
     */
    public void setPersistendOutput(OutputStream outputStream) {
    }

    /**
     * get unique prefix.
     * 
     * @return string
     */
    public String getUniquePrefix() {
        return null;
    }

}
