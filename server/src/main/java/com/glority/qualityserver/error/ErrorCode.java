package com.glority.qualityserver.error;

/**
 * this enum contains the error code for all errors.
 * 
 * @author liheping
 * 
 */
public enum ErrorCode {
    INVALID(0), SERVER_CHECK(1), SERVER_MONITORING(2);

    private int value;

    private ErrorCode(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public int getValue() {
        return this.value;
    }

    public static ErrorCode getValueOf(int value) {
        ErrorCode[] codes = ErrorCode.values();
        for (ErrorCode code : codes) {
            if (code.value == value) {
                return code;
            }
        }

        return INVALID;
    }
}
