package com.glority.common.connectors.ftp;

/**
 * the logger to log the info in the ftp connector working.
 * 
 * @author li.heping
 * 
 */
public interface FTPLogger {
    /**
     * init the log for specified operation;
     * 
     * @param operation
     */
    void initLogger(FTPOperation operation);

    /**
     * mark the file.
     * 
     * @param fileName
     */
    void mark(String fileName);

    /**
     * final call.
     */
    void finalCall();

    /**
     * log the error. this the logger interface for other logger.
     * 
     * @param error
     * @param e
     */
    void error(String error);

    /**
     * log the warn. this the logger interface for other logger.
     * 
     * @param error
     * @param e
     */
    void warn(String warn);
}
