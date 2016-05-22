package com.glority.quality.sca.cpp;

import java.io.IOException;

import com.glority.quality.sca.IScaBaseTask;
import com.glority.quality.sca.ScaBaseCommandTask;

/**
 * Extended cpp PClint task.
 * 
 * @author LYX
 * 
 */
public class CppPClintTask extends ScaBaseCommandTask implements IScaBaseTask {
    private String batPath;

    public void setBatPath(String batPath) {
        this.batPath = batPath;
    }

    public String getBatPath() {
        return this.batPath;
    }

    public void process() throws IOException, InterruptedException {
        this.commandString = batPath;
        super.process();
    }
}
