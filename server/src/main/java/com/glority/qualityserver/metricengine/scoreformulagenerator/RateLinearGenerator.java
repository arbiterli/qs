package com.glority.qualityserver.metricengine.scoreformulagenerator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.web.model.MetricScoreFormula;
import com.glority.qualityserver.web.model.SimpleMetricScoreFormula;

/**
 * Build Rate linear formula.
 * 
 * @author Chen.hong
 * 
 */
public class RateLinearGenerator extends AbstractLinearGenerator {

    /**
     * Generate the formula with list of ExtendItem.
     * 
     * @param id
     *            the id used for retrieve the sub item.
     * @param itemList
     *            the ExtendItem list
     * @return String the formula
     */
    public MetricScoreFormula generateFormula(String id, List<ExtendItem> itemList) {
        parseExtendItemList(itemList);

        SimpleMetricScoreFormula metricScoreFormula = (SimpleMetricScoreFormula) buildFormula(id);
        metricScoreFormula.setIsRated(true);
        metricScoreFormula.setRateFormula(getMetricName() + " per 1000 line ");
        return metricScoreFormula;
    }
}
