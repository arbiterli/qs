package com.glority.qualityserver.metricengine.calculator;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * LinearScoreWithFullScoreForNoDataCalculator.
 * 
 * @author xxd
 *
 */
public class LinearScoreWithFullScoreForNoDataCalculator extends AbstractLinearScoreCalculator {

    @Override
    public String getName() {
        return "linearScoreWithFullScoreForNoData";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        getLogger().debug("in linearScore method ");
        if (scoreItem == null) {
            return null;
        }

        ExtendItem dataItem = scoreItem.getItemList().get(0);

        setItemLink(scoreItem, dataItem.getBasicItem());
        scoreItem.setUnit(dataItem.getBasicItem().getUnit());

        String calDataStr = getOneValueFromItem(dataItem, profile, cache);
        getLogger().debug("calDataStr :" + calDataStr);

        ExtendItem result = new ExtendItem();
        result.setBasicItem(scoreItem);
        if (calDataStr == null) {
            scoreItem.setData(Constants.NO_DATA);
            result.setData(Constants.NO_DATA);
            result.setScore(FULL_SCORE);
            return result;
        } else {
            return linearScore(scoreItem, profile, cache);

        }
    }
}
