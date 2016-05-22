package com.glority.qualityserver.deploylog.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.glority.quality.connectors.ssh.SSHExec;
import com.glority.qualityserver.deploylog.DeployLog;

/**
 * SSH Exec deploy Log implementation.
 * 
 * @author liheping
 * 
 */
public class SSHExecLog implements DeployLog {

    private SSHExec se;
    private long serverId;

    public SSHExecLog(SSHExec se, long serverId) {
        this.se = se;
        this.serverId = serverId;
    }

    public void dispose() {
        // TODO Auto-generated method stub

    }

    public boolean isLogRunning() {
        if (this.se == null) {
            return false;
        } else {
            return this.se.getExitCode() == -1;
        }
    }

    public List<String> getRunningLog() {
        List<String> result = new ArrayList<String>();

        if (this.se != null) {
            ByteArrayOutputStream execLogOut = (ByteArrayOutputStream) this.se.getOutStream();

            ByteArrayInputStream execInput = new ByteArrayInputStream(execLogOut.toByteArray());
            InputStreamReader inputStreamReader = new InputStreamReader(execInput);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            try {
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    result.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return result;
    }

    public void setPersistentOuput(File output) {
        if (output != null) {
            this.se.setOutput(output);
        }
    }

    public void setPersistendOutput(OutputStream outputStream) {
        // TODO Auto-generated method stub

    }

    /**
     * since at one time, only one server can be deploying. so the can get the unique name.
     */
    @Override
    public String getUniquePrefix() {
        return Long.toString(serverId);
    }
}
