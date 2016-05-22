package com.glority.qualityserver.metricengine.scoreformulagenerator;

import java.util.ArrayList;

import java.util.List;

import com.glority.qualityserver.metricengine.BasicItem;
import com.glority.qualityserver.metricengine.DataItem;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricFormulaGenerator;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.web.model.MetricScoreFormula;
import com.glority.qualityserver.web.model.ScoreFormula;
import com.glority.qualityserver.web.model.SimpleMetricScoreFormula;

/**
 * The super class for Linear generator.
 * 
 * @author Chen.hong
 * 
 */
public abstract class AbstractLinearGenerator implements MetricFormulaGenerator {
    public static final String LINEAR_INC = " linear increase value ";
    public static final String LINEAR_DEC = " linear decrease value ";

    private List<MetricItem> metricItems = new ArrayList<MetricItem>();

    private String metricName;
    private double leftScore;

    private double rightScore;

    /**
     * Get left bound score.
     * 
     * @return the left bound sore
     */
    public double getLeftScore() {
        return leftScore;
    }

    /**
     * Set the left bound score.
     * 
     * @param leftScore
     *            the left bound score.
     */
    public void setLeftScore(double leftScore) {
        this.leftScore = leftScore;
    }

    /**
     * Get the right bound score.
     * 
     * @return the right bound score.
     */
    public double getRightScore() {
        return rightScore;
    }

    /**
     * set the right bound score.
     * 
     * @param rightScore
     *            the right bound score.
     */
    public void setRightScore(double rightScore) {
        this.rightScore = rightScore;
    }

    /**
     * Check if the score is for defective.
     * 
     * @return true if left bound score is large than right bound score.
     */
    protected boolean isDefect() {
        return leftScore > rightScore;
    }

    /**
     * Get the MetricItem list, it could be one or 2 instance.
     * 
     * @return list of MetricItem
     */
    public List<MetricItem> getMetricItems() {
        return metricItems;
    }

    /**
     * Add the metric item.
     * 
     * @param metricItem
     *            the MetricItem
     */
    public void addMetricItems(MetricItem metricItem) {
        this.metricItems.add(metricItem);
    }

    /**
     * Abstract method to generate formula.
     * 
     * @param id
     *            the id
     * @param itemList
     *            the ExtendItem list.
     * @return formula in string representation
     */
    public abstract MetricScoreFormula generateFormula(String id, List<ExtendItem> itemList);

    /**
     * Parse the ExtendItem list for retrieve out metric items and left bound
     * score and right bound score.
     * 
     * @param itemList
     *            the ExtendItem list.
     */
    protected void parseExtendItemList(List<ExtendItem> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            ExtendItem extendItem = itemList.get(i);

            BasicItem item = extendItem.getBasicItem();
            if (item instanceof MetricItem) {
                MetricItem metricItem = (MetricItem) item;
                if (!metricItem.getMetricName().endsWith("LINES_OF_CODE")) {
                    setMetricName(metricItem.getMetricName());
                }
            } else if (extendItem.getBasicItem() instanceof DataItem) {
                DataItem dataItem = (DataItem) item;
                if (dataItem.getId().endsWith("Left") || dataItem.getId().endsWith("ZeroScoreBound")) {
                    leftScore = Double.parseDouble(dataItem.getValue());
                } else {
                    rightScore = Double.parseDouble(dataItem.getValue());
                }
            }
        }
    }

    /**
     * Set the metric name.
     * 
     * @param metricName
     *            metric name.
     */
    protected void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    /**
     * Get the metric name.
     * 
     * @return metric name
     */
    protected String getMetricName() {
        return metricName;
    }

    /**
     * Build the formula.
     * 
     * @param id
     *            the id
     * @return the formula
     */
    protected MetricScoreFormula buildFormula(String id) {
        SimpleMetricScoreFormula formula = new SimpleMetricScoreFormula(getMetricName());
        formula.setID(id);
        formula.setIsRated(false);

        if (!isDefect()) {
            formula.addScoreFormula(new ScoreFormula(" < " + getLeftScore(), "0"));
            formula.addScoreFormula(new ScoreFormula(getLeftScore() + " <= x < " + getRightScore(), LINEAR_INC));
            formula.addScoreFormula(new ScoreFormula(" >= " + getRightScore(), "100"));
        } else {
            formula.addScoreFormula(new ScoreFormula(" < " + getRightScore(), "100"));
            formula.addScoreFormula(new ScoreFormula(getRightScore() + " <= x < " + getLeftScore(), LINEAR_DEC));
            formula.addScoreFormula(new ScoreFormula(" >= " + getLeftScore(), "0"));
        }
        return formula;

    }
}
