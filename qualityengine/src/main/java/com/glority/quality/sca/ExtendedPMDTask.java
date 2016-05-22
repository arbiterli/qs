package com.glority.quality.sca;

import net.sourceforge.pmd.ant.PMDTask;

import com.glority.quality.Constants.FailureHandle;
import com.glority.quality.console.output.OutputConsoleManager;

/**
 * Extended PMD task the meet quality engine task standard.
 * 
 * @author XQS
 * 
 */
public class ExtendedPMDTask extends PMDTask implements IScaBaseTask {
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

    public void execute() {
        process();
    }
}
