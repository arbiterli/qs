package com.glority.qualityserver;

/**
 * supported protocol for link to server.
 * 
 * @author liheping
 * 
 */
public enum DeployProtocol {
    SSH("ssh"), INVALID("invalid");

    private String value;

    /**
     * constructor.
     * 
     * @param value
     *            the protocol string
     */
    private DeployProtocol(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * get DeployProtocol Enum by protocol string value.
     * 
     * @param protocol
     *            protocol string value
     * @return DeployProtocol Enum, if not exists, return INVALID.
     */
    public static DeployProtocol getDeployProtocol(String protocol) {
        if ("ssh".equalsIgnoreCase(protocol)) {
            return SSH;
        } else {
            return INVALID;
        }
    }
}
