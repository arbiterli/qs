package com.glority.quality.sca.js;



import com.glority.quality.Constants.FailureHandle;
import com.glority.quality.console.output.OutputConsoleManager;
import com.glority.quality.sca.IScaBaseTask;
import com.googlecode.jslint4java.ant.JSLintTask;

/**
 * Extended jslint task.
 * 
 * @author LYX
 * 
 */
public class JSJslintTask extends JSLintTask implements IScaBaseTask {
    private boolean verbose = false;

    public void handleFailure(FailureHandle failureHandle) {

    }

    public FailureHandle reportFailure() {
        return null;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public boolean getVerbose() {
        return this.verbose;
    }
    // ant -lib <OutputManager.path> -logger com.glority.quality.console.output.OutputAntManager
    public void process() {
        OutputConsoleManager log = (OutputConsoleManager) getProject().getBuildListeners().get(0);
        log.disableOutput(verbose);
        //TODO:need to change defaultlogger to OutputConsoleManager.
        //super.execute();
        log.enableOutput(verbose);
    }

    public void execute() {
        process();
    }

}
