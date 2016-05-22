package com.glority.quality.console.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DefaultLogger;

/**
 * This is the output console manager class that allow you disable or enable
 * output strings to system.out.
 * 
 * @author XQS
 */
public final class OutputConsoleManager extends DefaultLogger {
    private static final OutputConsoleManager INSTANCE = new OutputConsoleManager();
    private PrintStream systemOut = System.out;
    private PrintStream systemErr = System.err;

    private OutputConsoleManager() {
        systemOut = System.out;
        systemErr = System.err;
    }

    /**
     * Return a OutputConsoleManager singleton instance.
     * 
     * @return
     */
    public static OutputConsoleManager getInstance() {
        return INSTANCE;
    }

    /**
     * Disable output console to avoid print too many useless logs. if the
     * verbose is turned on, then do nothing
     */
    public synchronized void disableOutput(boolean verbose) {
        if (verbose) {
            return;
        }
        try {
            System.setOut(getDummyConsole());
            System.setErr(getDummyConsole());
        } catch (Exception e) {
            System.setOut(systemOut);
            System.setErr(systemErr);
            throw new BuildException(e.getMessage());
        }
    }

    /**
     * Enable the system console back.
     */
    public synchronized void enableOutput(boolean verbose) {
        if (!verbose) {
            System.setOut(systemOut);
            System.setErr(systemErr);
        }
    }

    public void setOutput(PrintStream out) {
        this.out = out;
    }

    public void setErrorOutput(PrintStream err) {
        this.err = err;
    }

    private PrintStream getDummyConsole() {
        return new PrintStream(new OutputStream() {
            public void write(int b) throws IOException {
                // Do nothing
            }
        });
    }
}