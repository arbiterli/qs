package com.glority.qualityserver.thread.deploy;

/**
 * DeployThread, this class is used to start a thread to deploy.
 * 
 * @author liheping
 * 
 */
public class DeployThread extends Thread {
    private DeployRunner runner;

    public DeployThread(DeployRunner runner) {
        this.runner = runner;
    }

    public void run() {
        runner.deployRun();
    }
}
