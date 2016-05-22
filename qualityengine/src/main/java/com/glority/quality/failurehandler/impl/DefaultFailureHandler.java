package com.glority.quality.failurehandler.impl;

import org.apache.tools.ant.BuildException;


import com.glority.quality.BaseTask;

/**
 * A default TaskFailureHandler implementation. It implements the IGNORE mode of exception handle.
 * 
 * <P>
 * The failure details will be reported.
 * </P>
 */
public class DefaultFailureHandler extends BaseFailureHandler {

    public void handleFailue(BaseTask task, BuildException buildException) {
        reportFailureMessage(task, buildException);
    }
}
