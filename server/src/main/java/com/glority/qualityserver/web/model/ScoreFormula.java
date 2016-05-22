package com.glority.qualityserver.web.model;

/**
 * Represents the piece of score formula with range and value. Take MI as
 * example, the range of MI > 130, the score value is 100.
 * 
 */
public class ScoreFormula {
    private String range;
    private String value;

    /**
     * Create the ScoreFormula with range and value.
     * 
     * @param range
     *            the range.
     * @param value
     *            the value
     */
    public ScoreFormula(String range, String value) {
        this.range = range;
        this.value = value;
    }

    /**
     * Get the range.
     * 
     * @return range.
     */
    public String getRange() {
        return range;
    }

    /**
     * Set the range.
     * 
     * @param range
     *            the range to set.
     */
    public void setRange(String range) {
        this.range = range;
    }

    /**
     * Get the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Set the value.
     * 
     * @param value
     *            the value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
