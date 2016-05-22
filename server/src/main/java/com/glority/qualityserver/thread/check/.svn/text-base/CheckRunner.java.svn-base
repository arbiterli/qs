package com.glority.qualityserver.thread.check;

import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.SchedulerService;

/**
 * Abstract class for server change check runner.
 * 
 * @author liheping
 * 
 */
public abstract class CheckRunner {
    protected SchedulerService schedulerService;
    protected Server server;

    public void checkRun() {
        String result = this.check();

        if (result != null) {
            this.schedulerService.saveChange(result, this.server);
        }
    }

    /**
     * do check, and return the result.
     * 
     * @return
     */
    protected abstract String check();

}
