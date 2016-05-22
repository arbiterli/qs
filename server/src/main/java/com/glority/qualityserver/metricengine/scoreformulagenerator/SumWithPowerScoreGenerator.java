package com.glority.qualityserver.metricengine.scoreformulagenerator;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricFormulaGenerator;
import com.glority.qualityserver.metricengine.ScoreItem;
import com.glority.qualityserver.web.model.ComplexMetricScoreFormula;
import com.glority.qualityserver.web.model.MetricScoreFormula;

/**
 * 
 * Generate the formula for SumWithPower type.
 */
public class SumWithPowerScoreGenerator implements MetricFormulaGenerator {

    private static Log log = LogFactory.getLog(SumWithPowerScoreGenerator.class.getName());
    /**
     * Generate the formula.
     * 
     * @param id the id.
     * @param itemList
     *            the itemList
     * @return MetricScoreFormula formula generated
     */
    public MetricScoreFormula generateFormula(String id, List<ExtendItem> itemList) {
        ComplexMetricScoreFormula formula = new ComplexMetricScoreFormula("multiple build score");
        formula.setComplexMetricScore(true);
        formula.setID(id);

        for (ExtendItem item : itemList) {
            if (!(item.getBasicItem() instanceof ScoreItem)) {
                continue;
            }
            ScoreItem scoreItem = (ScoreItem) item.getBasicItem();
            MetricScoreFormula metricScoreFormula = (MetricScoreFormula) scoreItem.getFormula();
            if (metricScoreFormula != null) {
                formula.addMetricScoreFormula(metricScoreFormula);
                formula.addPower(metricScoreFormula.getID(), String.valueOf(item.getPower()));
            }
            if (metricScoreFormula == null) {
                log.warn("The score formula for " + scoreItem.getId() + " is not properly generated.");
            }
        }
        return formula;
    }

}
