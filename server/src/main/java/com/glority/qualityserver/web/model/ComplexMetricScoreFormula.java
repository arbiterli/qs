package com.glority.qualityserver.web.model;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glority.quality.StringUtil;

/**
 * Used for represents the complex metric score formula such as JAVA BUILD
 * SCORE. Please take metricEngine.xml for reference.
 * 
 * @author Chenhong
 * 
 */
public class ComplexMetricScoreFormula extends MetricScoreFormula {

    private List<MetricScoreFormula> metricScoreFormulaList = new ArrayList<MetricScoreFormula>();


    /**
     * Used for hold the power mapping for one metric score. Use extra memory
     * for power is because one metric score might have different weight for 2
     * complex metric score.
     */
    private Map<String, String> powerMap = new HashMap<String, String>();

    /**
     * Create the ComplexMetricScoreFormula with metric name.
     * 
     * @param metricName
     *            the metric name.
     */
    public ComplexMetricScoreFormula(String metricName) {
        super(metricName);
    }

    /**
     * Add the metric name and power.
     * 
     * @param metricName
     *            the metric name
     * @param power
     *            the power
     */
    public void addPower(String metricName, String power) {
        if (StringUtil.isEmpty(metricName) || StringUtil.isEmpty(power)) {
            throw new IllegalArgumentException("The metric name or power should not be null or empty.");
        }
        this.powerMap.put(metricName, power);
    }
    /**
     * Add the sub metric score formula.
     * 
     * @param metricScoreFormula
     *            sub score formula
     */
    public void addMetricScoreFormula(MetricScoreFormula metricScoreFormula) {
        if (metricScoreFormula == null) {
            throw new IllegalArgumentException("The param metricScoreFormula should not be null.");
        }
        metricScoreFormulaList.add(metricScoreFormula);
    }

    /**
     * get the MetricScoreFormula.
     * 
     * @return list of metric score formula
     */
    public List<MetricScoreFormula> getScoreFormulaList() {
        return new ArrayList<MetricScoreFormula>(this.metricScoreFormulaList);
    }

    /**
     * Get the powerMap.
     * 
     * @return the power map.
     */
    public Map<String, String> getPowerMap() {
        return new HashMap<String, String>(powerMap);
    }

    public void setPowerMap(Map<String, String> powerMap) {
        this.powerMap = new HashMap<String, String>(powerMap);
    }

    public void setMetricScoreFormulaList(List<MetricScoreFormula> metricScoreFormulaList) {
        if (metricScoreFormulaList == null) {
            throw new IllegalArgumentException("The parameter metricScoreFormulaList should not be null.");
        }
        this.metricScoreFormulaList = new ArrayList<MetricScoreFormula>(metricScoreFormulaList);
    }

    /**
     * Remove the sub metric score formula with given metric name. Only product base score could remove
     * sub metric formula dynamically.
     * @param metricName the sub metric name to remove
     */
    public void removeSubMetricScoreFormula(String metricName) {
        if (!isProductBased()) {
            throw new IllegalStateException("Operation not supported for non-product-based Score.");
        }

        for (MetricScoreFormula subMetricScoreFormula :  this.metricScoreFormulaList) {
            if (subMetricScoreFormula.getID().equals(metricName)) {
                this.metricScoreFormulaList.remove(subMetricScoreFormula);
                break;
            }
        }
     }
}
