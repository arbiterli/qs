package com.glority.quality.model;

/**
 * CurrentStatus.
 * 
 * @author CLB
 * 
 */
public class CurrentStatus {
    private String service;
    private String status;
    private String attempt;

    public static final String STATUS_OK = "OK";
    public static final String STATUS_CRITICAL = "CRITICAL";
    public static final String STATUS_WARNING = "WARNING";
    public static final String STATUS_UNKNOWN = "UNKNOWN";
    public static final String STATUS_PENDING = "PENDING";

    /**
     * get service.
     * 
     * @return the service to get.
     */
    public String getService() {
        return service;
    }

    /**
     * set service.
     * 
     * @param service
     *            the service to set.
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * get status.
     * 
     * @return status the status to get.
     */
    public String getStatus() {
        return status;
    }

    /**
     * set status.
     * 
     * @param status
     *            the status to set.
     */
    public void setStatus(String status) {
        if (status.equalsIgnoreCase(STATUS_OK)) {
            this.status = STATUS_OK;
        } else if (status.equalsIgnoreCase(STATUS_CRITICAL)) {
            this.status = STATUS_CRITICAL;
        } else if (status.equalsIgnoreCase(STATUS_WARNING)) {
            this.status = STATUS_WARNING;
        } else if (status.equalsIgnoreCase(STATUS_UNKNOWN)) {
            this.status = STATUS_UNKNOWN;
        } else {
            this.status = STATUS_PENDING;
        }
    }

    /**
     * get attempt.
     * 
     * @return the attempt to get.
     */
    public String getAttempt() {
        return attempt;
    }

    /**
     * set attempt.
     * 
     * @param attempt
     *            the attempt to set.
     */
    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    @Override
    public String toString() {
        return "CurrentStatus [service=" + service + ", status=" + status + ", attempt=" + attempt + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attempt == null) ? 0 : attempt.hashCode());
        result = prime * result + ((service == null) ? 0 : service.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CurrentStatus other = (CurrentStatus) obj;
        if (attempt == null) {
            {
                if (other.attempt != null) {
                    return false;
                }
            }
        } else if (!attempt.equals(other.attempt)) {
            return false;
        }
        if (service == null) {
            {
                if (other.service != null) {
                    return false;
                }
            }
        } else if (!service.equals(other.service)) {
            return false;
        }
        if (status == null) {
            {
                if (other.status != null) {
                    return false;
                }
            }
        } else if (!status.equals(other.status)) {
            return false;
        }
        return true;
    }

}