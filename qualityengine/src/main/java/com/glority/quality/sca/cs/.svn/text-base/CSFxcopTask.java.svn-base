package com.glority.quality.sca.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.glority.quality.BaseTask;
import com.glority.quality.sca.IScaBaseTask;

/**
 * Extended cs fxcop task.
 * 
 * @author LYX
 * 
 */
public class CSFxcopTask extends BaseTask implements IScaBaseTask {
    private String fxcopPath;
    private String srcDir;
    private String reportPath;

    public void setFxcopPath(String fxcopPath) {
        this.fxcopPath = fxcopPath;
    }

    public String getFxcopPath() {
        return this.fxcopPath;
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
        String command = fxcopPath + " /outxsl=none /f:" + srcDir + "/*.dll /f:" + srcDir
                         + "/*.exe /o:" + reportPath;
        String temp;
        Process proc = Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }
        proc.waitFor();
    }
}
