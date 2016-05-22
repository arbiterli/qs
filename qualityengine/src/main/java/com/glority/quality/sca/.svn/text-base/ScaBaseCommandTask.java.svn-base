package com.glority.quality.sca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.glority.quality.BaseTask;
import com.glority.quality.console.output.OutputConsoleManager;

/**
 * tasks run by command line should extends this.
 * 
 * @author LYX
 * 
 */
public class ScaBaseCommandTask extends BaseTask implements IScaBaseTask {
    protected String commandString;

    public void process() throws IOException, InterruptedException {
        OutputConsoleManager ocm = OutputConsoleManager.getInstance();
        ocm.disableOutput(verbose);
        String temp;
        Process proc = Runtime.getRuntime().exec(commandString);
        BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }
        proc.waitFor();
        ocm.enableOutput(verbose);
    }
}
