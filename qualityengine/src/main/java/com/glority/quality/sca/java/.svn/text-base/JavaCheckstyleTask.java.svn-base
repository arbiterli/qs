package com.glority.quality.sca.java;

import java.io.IOException;

import com.glority.quality.sca.IScaBaseTask;
import com.glority.quality.sca.ScaBaseCommandTask;

/**
 * Extended java checkstyle task.
 * 
 * @author LYX
 * 
 */
public class JavaCheckstyleTask extends ScaBaseCommandTask implements IScaBaseTask {
    private String jarPath;
    private String rulePath;
    private String srcDir;
    private String reportPath;

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getJarPath() {
        return this.jarPath;
    }

    public void setRulePath(String rulePath) {
        this.rulePath = rulePath;
    }

    public String getRulePath() {
        return this.rulePath;
    }

    public void setSrcDir(String srcDir) {
        this.srcDir = srcDir;
    }

    public String getSrcDir() {
        return this.srcDir;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getReportPath() {
        return this.reportPath;
    }

    public void process() throws IOException, InterruptedException {
        this.commandString = "java -jar " + jarPath + " -c " + rulePath + " -r " + srcDir + " -f xml " + "-o "
                + reportPath;
        super.process();
    }

}
