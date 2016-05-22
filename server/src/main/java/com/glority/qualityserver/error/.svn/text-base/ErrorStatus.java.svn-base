package com.glority.qualityserver.error;

/**
 * this enum contains all the error status.
 * 
 * @author liheping
 * 
 */
public enum ErrorStatus {
    INVALID("invalid"), NEW("new"), FIXED("fixed"), REOPEN("reopen"), IGNORED("ignored");

    private String value;

    private ErrorStatus(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public static ErrorStatus getValueOf(String value) {
        ErrorStatus[] statuses = ErrorStatus.values();
        for (ErrorStatus status : statuses) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }

        return INVALID;
    }
}
