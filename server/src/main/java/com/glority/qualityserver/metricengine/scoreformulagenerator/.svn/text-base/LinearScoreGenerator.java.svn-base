package com.glority.qualityserver.metricengine.scoreformulagenerator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.web.model.MetricScoreFormula;

/**
 * Generate the linear score formula.
 * 
 * @author Chen.hong
 * 
 */
public class LinearScoreGenerator extends AbstractLinearGenerator {

    private static final int LINEAR_SCORE_ITEM_LEN = 3;

    /**
     * Generate the formula with list of ExtendItem.
     * 
     * @param id
     *            the id
     * @param itemList
     *            the ExtendItem list
     * @return String the formula
     */
    public MetricScoreFormula generateFormula(String id, List<ExtendItem> itemList) {
        if (itemList == null || itemList.size() != LINEAR_SCORE_ITEM_LEN) {
            throw new IllegalArgumentException(
                    "The linear score item should have one metric item , left data item and right data item");
        }

        parseExtendItemList(itemList);

        return buildFormula(id);
    }
}
