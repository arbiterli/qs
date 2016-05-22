package com.glority.qualityserver.web.model;

/**
 * Represents the Metric score formula, including, metric name, id, power and
 * flag to indicate if it is a complex metric score, such as java build score
 * which is a mixed of javaMIScore, javaDuplicationScore...
 * 
 * <p>
 * Note, id is used for retrieve the sub score information. UI could use the id
 * to retrieve the score formula by passing id.
 * </p>
 * 
 * @author Chenhong
 * 
 */
public class MetricScoreFormula {

    private String id;

    private String metricName;

    private boolean isComplexMetricScore;

    private double power;

    /**
     * Represents the flag if the metric score is product based. For example, Build score includes Java Build Score,
     * CS build score and test complete score. But if a product is a pure Java Product, then the CS build score power
     * should be removed.
     */
    private boolean isProductBased;

    /**
     * Create the MetricScoreFormula.
     * 
     * @param metricName
     *            metric name
     */
    public MetricScoreFormula(String metricName) {
        this.metricName = metricName;
    }

    /**
     * Get the metric name.
     * 
     * @return metric name
     */
    public String getMetricName() {
        return this.metricName;
    }

    /**
     * Set if it is a complex metric score.
     * 
     * @param complexMetricScore
     *            boolean value.
     */
    public void setComplexMetricScore(boolean complexMetricScore) {
        this.isComplexMetricScore = complexMetricScore;
    }

    /**
     * Check if it is complex metric score.
     * 
     * @return boolean value
     */
    public boolean isComplexMetricScore() {
        return this.isComplexMetricScore;
    }

    /**
     * Get the power.
     * 
     * @return the power.
     */
    public double getPower() {
        return this.power;
    }

    /**
     * Set the power.
     * 
     * @param power
     *            power
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * set the id.
     * 
     * @param id
     *            the id
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * get the id.
     * 
     * @return the id
     */
    public String getID() {
        return this.id;
    }

    public boolean isProductBased() {
        return isProductBased;
    }

    public void setProductBased(boolean isProductBased) {
        this.isProductBased = isProductBased;
    }
}
