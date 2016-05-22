package com.glority.quality.sca;

import com.glority.quality.Constants.FailureHandle;
import com.glority.quality.console.output.OutputConsoleManager;
import com.glority.quality.sca.mi.MITask;

/**
 * ExtendedMITask.
 * 
 * @author
 * 
 */
public class ExtendedMITask extends MITask implements IScaBaseTask {
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
