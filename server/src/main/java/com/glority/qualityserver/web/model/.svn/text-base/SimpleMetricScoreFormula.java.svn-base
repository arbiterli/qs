package com.glority.qualityserver.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Used for represents the MetricScoreFormula for simple type, such as
 * linearScore, per1000RateLinearScore.
 * 
 * @author Chenhong
 * 
 */
public class SimpleMetricScoreFormula extends MetricScoreFormula {

    private boolean rated;

    private String rateFormula;

    private List<ScoreFormula> scoreFormulas = new ArrayList<ScoreFormula>();

    /**
     * Create SimpleMetricScoreFormula with metric name.
     * 
     * @param metricName
     *            metric name
     */
    public SimpleMetricScoreFormula(String metricName) {
        super(metricName);
    }

    /**
     * Add ScoreFormula.
     * 
     * @param scoreFormula
     *            score formula
     */
    public void addScoreFormula(ScoreFormula scoreFormula) {
        if (scoreFormula == null) {
            throw new IllegalArgumentException("The parameter scoreFormula should not be null.");
        }
        this.scoreFormulas.add(scoreFormula);
    }

    /**
     * Get all ScoreFormula.
     * 
     * @return list of ScoreFormula
     */
    public List<ScoreFormula> getScoreFormulas() {
        return new ArrayList<ScoreFormula>(scoreFormulas);
    }

    /**
     * set if the score is rated or not.
     * 
     * @param isRated
     *            rated or not
     */
    public void setIsRated(boolean isRated) {
        this.rated = isRated;
    }

    /**
     * Set the rate formula. For example, per 1000 rate.
     * 
     * @param rateFormula
     *            rate formula.
     */
    public void setRateFormula(String rateFormula) {
        this.rateFormula = rateFormula;
    }

    /**
     * Get the rate formula.
     * 
     * @return rate formula
     */
    public String getRateFormula() {
        return this.rateFormula;
    }

    /**
     * Check for is rated.
     * 
     * @return isRated
     */
    public boolean isRated() {
        return this.rated;
    }
}
