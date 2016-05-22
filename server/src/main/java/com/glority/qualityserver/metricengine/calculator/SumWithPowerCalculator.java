package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.metricengine.BasicItem;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * SumWithPowerCalculator.
 * 
 * @author xxd
 *
 */
public class SumWithPowerCalculator extends AbstractCalculator {

    @Override
    public String getName() {
        return "sumWithPower";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (scoreItem == null) {
            return null;
        }

        List<ExtendItem> params = scoreItem.getItemList();
        getLogger().debug("in sumWithPower method ");
        if (params != null && !params.isEmpty()) {
            getLogger().debug("params size " + params.size());
            double totalPower = 0.0;
            for (ExtendItem param : params) {
                totalPower += param.getPower();
            }
            getLogger().debug("totalPower" + totalPower);
            for (ExtendItem param : params) {
                calculateScoreItem(param, totalPower, profile, cache);

                BasicItem innerItem = param.getBasicItem();
                if (innerItem instanceof ScoreItem) {
                    param.setData(((ScoreItem) innerItem).getData());
                } else if (innerItem instanceof MetricItem) {
                    param.setData(getOneValueFromItem(innerItem, profile, cache));
                    param.setScore(0.0);
                }
            }

            double totalScore = 0.0;
            for (ExtendItem param : params) {
                totalScore += param.getRateScore();
            }

            ExtendItem result = new ExtendItem();
            result.setBasicItem(scoreItem);
            result.setScore(totalScore);
            return result;
        }

        return null;
    }
}
