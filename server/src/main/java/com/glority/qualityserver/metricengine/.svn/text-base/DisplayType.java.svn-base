package com.glority.qualityserver.metricengine;

/**
 * display type for metric engine config.
 * 
 * @author liheping
 * 
 */
public enum DisplayType {
    DISPLAY("display"), AUTO("auto"), NONE("none");

    private String value;

    private DisplayType(String value) {
        this.value = value;
    }

    public static DisplayType getValueOf(String value) {
        DisplayType[] types = values();
        for (DisplayType type : types) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return NONE;
    }
}
