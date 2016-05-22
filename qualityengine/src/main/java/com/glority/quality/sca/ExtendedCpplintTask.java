package com.glority.quality.sca;

import com.glority.quality.Constants.FailureHandle;
import com.glority.quality.console.output.OutputConsoleManager;
import com.glority.quality.sca.cpp.CppCpplintTask;

/**
 * Run Cpplint task.
 * 
 * @author Zhao JP
 * 
 */
public class ExtendedCpplintTask extends CppCpplintTask implements IScaBaseTask {
    private boolean verbose = false;

    @Override
    public FailureHandle reportFailure() {
        return null;
    }

    @Override
    public void handleFailure(FailureHandle failureHandle) {

    }

    @Override
    public boolean getVerbose() {
        return this.verbose;
    }

    @Override
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public void process() {
        OutputConsoleManager ocm = OutputConsoleManager.getInstance();
        ocm.disableOutput(verbose);
        super.execute();
        ocm.enableOutput(verbose);
    }

    @Override
    public void execute() {
        process();
    }
}
