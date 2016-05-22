package com.glority.common.connectors.ftp;

/**
 * the ftp operation enumeration.
 * 
 * @author zm.
 * 
 */
public enum FTPOperation {

    DOWNLOAD("Download"), UPLOAD("Upload");

    private String value;

    private FTPOperation(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}
