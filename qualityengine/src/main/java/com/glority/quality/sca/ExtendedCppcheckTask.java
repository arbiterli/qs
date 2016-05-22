package com.glority.quality.sca;

import com.glority.quality.Constants.FailureHandle;
import com.glority.quality.console.output.OutputConsoleManager;
import com.glority.quality.sca.cpp.CppCppcheckTask;

/**
 * Run cppCheck task.
 * 
 * @author Zhao JP
 * 
 */
public class ExtendedCppcheckTask extends CppCppcheckTask implements IScaBaseTask {
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
    public void process() throws Exception {
        OutputConsoleManager ocm = OutputConsoleManager.getInstance();
        ocm.disableOutput(verbose);
        super.execute();
        ocm.enableOutput(verbose);
    }

    @Override
    public void execute() {
        try {
            process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
