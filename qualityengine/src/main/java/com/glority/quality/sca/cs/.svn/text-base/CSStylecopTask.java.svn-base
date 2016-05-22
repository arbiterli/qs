package com.glority.quality.sca.cs;

import java.io.IOException;

import com.glority.quality.sca.IScaBaseTask;
import com.glority.quality.sca.ScaBaseCommandTask;

/**
 * Extended cs stylecop task.
 * 
 * @author LYX
 * 
 */
public class CSStylecopTask extends ScaBaseCommandTask implements IScaBaseTask {
    private String msbuildPath;
    private String stylecopPath;
    private String srcDir;
    private String reportDir;

    public void setMsbuildPath(String msbuildPath) {
        this.msbuildPath = msbuildPath;
    }

    public String getMsbuildPath() {
        return this.msbuildPath;
    }

    public void setStylecopPath(String stylecopPath) {
        this.stylecopPath = stylecopPath;
    }

    public String getStylecopPath() {
        return this.stylecopPath;
    }

    public void setSrcDir(String srcDir) {
        this.srcDir = srcDir;
    }

    public String getSrcDir() {
        return this.srcDir;
    }

    public void setReportDir(String reportDir) {
        this.reportDir = reportDir;
    }

    public String getReportDir() {
        return this.reportDir;
    }

    public void process() throws IOException, InterruptedException {
        this.commandString = msbuildPath + " " + stylecopPath + " /p:srcdir=" + srcDir + ";outdir="
                         + reportDir;
        super.process();
    }
}
