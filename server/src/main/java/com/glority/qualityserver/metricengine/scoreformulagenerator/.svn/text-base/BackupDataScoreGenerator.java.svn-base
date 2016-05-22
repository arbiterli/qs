package com.glority.qualityserver.metricengine.scoreformulagenerator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.web.model.MetricScoreFormula;

/**
 * Used for generate formula for backup score type.
 * 
 * @author Chen.hong
 * 
 */
public class BackupDataScoreGenerator extends AbstractLinearGenerator {

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
        parseExtendItemList(itemList);
        return buildFormula(id);
    }
}
