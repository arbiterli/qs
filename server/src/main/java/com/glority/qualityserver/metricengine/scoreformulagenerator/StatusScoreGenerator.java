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
 * Generator for constant type.
 * 
 */
public class StatusScoreGenerator implements MetricFormulaGenerator {

    private MetricItem metricItem;

    private List<DataItem> dataItemList = new ArrayList<DataItem>();

    /**
     * Generate the MetricScoreFormula with given id and list of ExtendItem.
     * 
     * @param id
     *            the id
     * @param itemList
     *            the ExtendItem list
     * @return MetricScoreFormula the formula
     */
    public MetricScoreFormula generateFormula(String id, List<ExtendItem> itemList) {
        parseExtendItems(itemList);

        if (metricItem == null) {
            throw new IllegalArgumentException("The parameter itemList should contain MetricItem.");
        }

        return buildFormula(id);
    }

    /**
     * Build the formula with id.
     * 
     * @param id
     *            the id
     * @return MetricScoreFormula instance
     */
    private MetricScoreFormula buildFormula(String id) {
        SimpleMetricScoreFormula formula = new SimpleMetricScoreFormula(metricItem.getMetricName());
        formula.setID(id);
        for (DataItem dataItem : dataItemList) {
            formula.addScoreFormula(new ScoreFormula(dataItem.getValue(), String.valueOf(dataItem.getGetScore())));
        }
        return formula;
    }

    /**
     * parse the item list for DataItem.
     * 
     * @param itemList
     *            item list
     */
    private void parseExtendItems(List<ExtendItem> itemList) {
        if (itemList == null || itemList.isEmpty()) {
            throw new IllegalArgumentException("The ExtendItem list should  not be empty or null.");
        }
        for (int i = 0; i < itemList.size(); i++) {
            ExtendItem extendItem = itemList.get(i);

            BasicItem item = extendItem.getBasicItem();
            if (item instanceof MetricItem) {
                metricItem = (MetricItem) item;
            } else if (extendItem.getBasicItem() instanceof DataItem) {
                dataItemList.add((DataItem) extendItem.getBasicItem());
            }
        }
    }

}
