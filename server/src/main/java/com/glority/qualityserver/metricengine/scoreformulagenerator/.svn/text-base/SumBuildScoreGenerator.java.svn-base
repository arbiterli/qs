package com.glority.qualityserver.metricengine.scoreformulagenerator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.web.model.ComplexMetricScoreFormula;
import com.glority.qualityserver.web.model.MetricScoreFormula;

/**
 * Sum Build Score is complex build score, it is product related score, the
 * score formula depends on the languages used in the product.
 * <p>
 * For example, if product only has Java language. Then the score is calculated
 * by Java Build Score multiple 70% + testCompleteScore multiple 30%.
 * </p>
 * 
 * <p>
 * But if a product has both Java language and CS language, then the score
 * formula is adapter to (Java Build Score + CS build score) multiple 70% +
 * testCompleteScore multiple 30%.
 * </p>
 * 
 * <p>
 * Because the actual formula is product based, and during parse the metric
 * engine file, the product id is not available, all sub score item will be
 * collected, and a flag of product based will be set to this formula in order
 * to adjust to the actual formula while calling from web-service.
 * </p>
 * 
 * @author Chenhong
 * 
 */
public class SumBuildScoreGenerator extends SumWithPowerScoreGenerator {

    /**
     * Generate the formula for product based metric score: Build Score with
     * score id, and list of items.
     */
    public MetricScoreFormula generateFormula(String id, List<ExtendItem> itemList) {
        ComplexMetricScoreFormula sumBuildScore = (ComplexMetricScoreFormula) super.generateFormula(id, itemList);
        sumBuildScore.setProductBased(true);

        return sumBuildScore;
    }

}
