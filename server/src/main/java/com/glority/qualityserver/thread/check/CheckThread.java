package com.glority.qualityserver.thread.check;

/**
 * Check Thread. this class start the thread for server change check.
 * 
 * @author liheping
 * 
 */
public class CheckThread extends Thread {
    private CheckRunner checkRunner;

    public CheckThread(CheckRunner checkRunner) {
        this.checkRunner = checkRunner;
    }

    public void run() {
        if (this.checkRunner != null) {
            this.checkRunner.checkRun();
        }
    }
}
