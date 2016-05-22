package com.glority.quality.connectors.ftp;

import org.apache.commons.logging.Log;

import com.glority.common.connectors.ftp.FTPLogger;
import com.glority.common.connectors.ftp.FTPOperation;

/**
 * to show log of a ftp task, a passive observer.
 * 
 * @author zm.
 * 
 */
public class FTPLog implements FTPLogger {
    private int counter;

    private boolean verbose;
    private Log log;

    private FTPOperation operation;

    private static final String TOTAL_SINGLE_DOWNLOAD_STR = "Total download %d file.";

    private static final String TOTAL_MULTI_DOWNLOAD_STR = "Total download %d files.";

    private static final String TOTAL_SINGLE_UPLOAD_STR = "Total upload %d file.";

    private static final String TOTAL_MULTI_UPLOAD_STR = "Total upload %d files.";

    public FTPLog(FTPBaseTask ftpTask, Log log) {
        counter = 0;
        this.log = log;
        this.verbose = ftpTask.getVerbose();
    }

    @Override
    public void initLogger(FTPOperation operation) {
        this.operation = operation;

    }

    public void mark(String fileName) {
        counter++;
        if (verbose) {
            printCounterInfo(false, fileName);
        }
    }

    public void finalCall() {
        printCounterInfo(true, null);
    }

    private void printCounterInfo(boolean isFinal, String fileName) {
        if (isFinal) {
            finalPrint();
        } else {
            singlePrint(fileName);
        }
    }

    public void error(String error, Throwable e) {
        log.error(error, e);
    }

    public void error(String error) {
        log.error(error);
    }

    public void warn(String warn) {
        log.warn(warn);
    }

    private void finalPrint() {
        if (counter > 1) {
            if (operation.equals(FTPOperation.DOWNLOAD)) {
                log.info(String.format(TOTAL_MULTI_DOWNLOAD_STR, counter));
            }

            if (operation.equals(FTPOperation.UPLOAD)) {
                log.info(String.format(TOTAL_MULTI_UPLOAD_STR, counter));
            }
        } else {
            if (operation.equals(FTPOperation.DOWNLOAD)) {
                log.info(String.format(TOTAL_SINGLE_DOWNLOAD_STR, counter));
            }

            if (operation.equals(FTPOperation.UPLOAD)) {
                log.info(String.format(TOTAL_SINGLE_UPLOAD_STR, counter));
            }
        }
    }

    private void singlePrint(String fileName) {
        log.info(operation.toString() + " " + fileName);
    }

}
