package com.glority.quality;

import com.glority.quality.Constants.FailureHandle;

/**
 * The APIs that quality engine tasks need implement.
 * 
 * @author XQS
 * 
 */
public interface IBaseTask {
    /**
     * 
     * Report the failure out when errors happens in the task It will return an
     * failure handle base on the predefined logic.
     * 
     * @return
     */
    FailureHandle reportFailure();

    /**
     * Handle the failure base on the given failure Handle.
     * 
     * @param failureHandle
     */
    void handleFailure(FailureHandle failureHandle);

    /**
     * get the verbose to decide whether print log on the console.
     * 
     * @return
     */
    boolean getVerbose();

    /**
     * set the verbose.
     * 
     * @param verbose
     */
    void setVerbose(boolean verbose);

    /**
     * entry function.
     * @throws Exception
     */
    void process() throws Exception;

}
