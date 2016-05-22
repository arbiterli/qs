package com.glority.qualityserver.error.erroranalyser;

/**
 * Server change check error analyser.
 * 
 * @author liheping
 * 
 */
public class ServerCheckAnalyser implements ErrorAnalyser {
    private final String connectionRefuse = "Connection refused";

    public String analyse(String detail) {
        if (detail != null) {
            if (detail.contains(connectionRefuse)) {
                return CAUSED_BY_QUALITY_SYSTEM;
            }
        }

        return CAUSED_BY_PRODUCT;
    }

}
