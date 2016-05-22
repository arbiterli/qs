package com.glority.quality.failurehandler.impl;

import org.apache.tools.ant.BuildException;

import com.glority.quality.BaseTask;

/**
 * RetryFailureHandler.
 * 
 * @author
 * 
 */
public class RetryFailureHandler extends BaseFailureHandler {

    public void handleFailue(BaseTask task, BuildException buildException) {
        reportFailureMessage(task, buildException);

        try {
            task.execute();
        } catch (BuildException e) {
            reportFailureMessage(task, e);
        }
    }

}
