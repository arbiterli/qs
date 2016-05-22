package com.glority.quality;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;


import com.glority.quality.Constants.FailureHandle;
import com.glority.quality.factory.FailureHandlerFactory;
import com.glority.quality.failurehandler.TaskFailureHandler;
import com.glority.quality.reportxml.QualityReport;

/**
 * The base class of glority quality engine tasks, All ant tasks in the glority
 * engine should extend from this class.
 * 
 * @author XQS
 * 
 */
public abstract class BaseTask extends Task implements IBaseTask {
    // Marks whether we need fail the task when error happens
    protected boolean failOnError;
    // Quality xml path
    protected String qualityXmlPath;
    // If the task is retied, then you need set this flag to true
    protected boolean retried;

    protected QualityReport qualityReport;

    protected boolean verbose = false;

    private String owner;
    /**
     * Used for handle the task execute failure.
     */
    private TaskFailureHandler taskFailureHandler;

    public BaseTask() {
        failOnError = false;
        retried = false;
    }

    public boolean isRetried() {
        return retried;
    }

    public void setRetried(boolean retried) {
        this.retried = retried;
    }

    public void setQualityXmlPath(String qualityXmlPath) {
        this.qualityXmlPath = qualityXmlPath;
    }

    public QualityReport getQualityReport() {
        return qualityReport;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * We allow quality xml be empty But if the quality xml is specified, it
     * must be loadable and correct.
     */
    public void loadQualityReport() {
        if (StringUtil.isEmpty(qualityXmlPath)) {
            getProject().log("Warning: quality xml is not specified.");
            qualityReport = null;
            return;
        }
        try {
            qualityReport = new QualityReport(new FileInputStream(new File(
                    qualityXmlPath)));
        } catch (Exception e) {
            getProject().log("Error: Failed to update metrics to quality xml");
            qualityReport = null;
            throw new BuildException(e);
        }
    }

    public void exportQualityXml() {
        try {
            qualityReport.writeToFile(qualityXmlPath);
        } catch (Exception e) {
            throw new BuildException("Write quality report failed", e);
        }
    }

    public boolean isFailOnError() {
        return failOnError;
    }

    public void setFailOnError(boolean failOnError) {
        this.failOnError = failOnError;
    }

    /**
     * Set the verbose flag.
     * 
     * @param verbose
     *            if true output more verbose logging
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    /**
     * Get the verbose flag.
     * 
     * @return the verbose flag
     */
    public boolean getVerbose() {
        return verbose;
    }

    /**
     * Report the failures when we encount errors. This method will call then
     * error handle engine. And return the FailureHandle to tell the reporter
     * how to handle the error.
     * 
     * The tasks should override this method
     */
    // TODO: This feature has not been finalized
    public FailureHandle reportFailure() {
        return FailureHandle.IGNORE;
    }

    /**
     * Handle the failure with given handle.
     * 
     * the task should override this method, and handle the failures correctly.
     * 
     */
    // TODO: this feature has not been finalized
    public void handleFailure(FailureHandle failureHandle) {
    }

    public TaskFailureHandler getTaskFailureHandler() {
        if (taskFailureHandler == null) {
            taskFailureHandler = FailureHandlerFactory.getInstance().getFailureHandler(getClass().getName());
        }
        return taskFailureHandler;
    }

    /**
     * The execute of the task. In most case, you should not overide this
     * function and keep you keep logic in process function.
     */
    public void execute() {
        try {
            loadQualityReport();
            process();
        } catch (Exception e) {
            BuildException buildException =  e instanceof BuildException ? (BuildException) e : new BuildException(e);
            getTaskFailureHandler().handleFailue(this, buildException);
            if (failOnError) {
                throw buildException;
            } else {
                log("Caught exception: " + e.getMessage(), Project.MSG_ERR);
            }
        }
    }
    /**
     * The main logic method of the task, finish the operations expected to be
     * done in the task.
     * 
     * Each task should override this function.
     * @throws Exception exception
     * 
     * @throws BuildException
     */
    public abstract void process() throws Exception;

}
