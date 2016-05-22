package com.glority.qualityserver.exception;
/**
 * Permission Denied Exception class.
 */
public class PermissionDeniedException extends RuntimeException {

    private static final long serialVersionUID = -6202196950573148888L;

    public PermissionDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PermissionDeniedException(String message) {
        super(message);
    }

}
