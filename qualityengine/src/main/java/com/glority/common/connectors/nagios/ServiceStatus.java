/**
 * 
 */
package com.glority.common.connectors.nagios;

/**
 * status of current status
 * 
 * @author CLB
 * 
 */
public class ServiceStatus {
    private String service;
    private String attempt;
    private Status status;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    /**
     * Service Status.
     * 
     * @author li.heping
     * 
     */
    public static enum Status {
        STATUS_OK("OK"), STATUS_CRITICAL("CRITICAL"), STATUS_WARNING("WARNING"), STATUS_UNKNOWN("UNKNOWN"),
        STATUS_PENDING("PENDING");

        private String value;

        private Status(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }

        public static Status getValueOf(String str) {
            Status[] statuses = values();
            for (Status status : statuses) {
                if (status.value.equalsIgnoreCase(str)) {
                    return status;
                }
            }
            throw new IllegalArgumentException(str);
        }
    }
}
