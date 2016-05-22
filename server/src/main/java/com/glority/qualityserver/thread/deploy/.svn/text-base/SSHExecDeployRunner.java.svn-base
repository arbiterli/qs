package com.glority.qualityserver.thread.deploy;

import com.glority.quality.connectors.ssh.SSHExec;

/**
 * SSH Exec Deploy runner.
 * 
 * @author liheping
 * 
 */
public class SSHExecDeployRunner extends DeployRunner {

    private SSHExec se;

    public SSHExecDeployRunner(SSHExec se) {
        this.se = se;
    }

    @Override
    protected void deploy() {
        this.se.execute();
        // wait for the execute to finish
        boolean flag = true;
        while (this.se.getExitCode() == -1) {
            flag = !flag;
        }
    }

    @Override
    protected boolean isDeploySuccessful() {

        return this.se.getExitCode() == 0;
    }

}
