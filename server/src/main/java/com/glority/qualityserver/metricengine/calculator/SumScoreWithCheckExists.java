package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.metricengine.BasicItem;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * SumScoreWithCheckExists.
 * 
 * @author Administrator
 * 
 */
public class SumScoreWithCheckExists extends AbstractCalculator {

    @Override
    public String getName() {
        return "sumScoreWithCheckExists";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (scoreItem == null) {
            return null;
        }

        List<ExtendItem> params = scoreItem.getItemList();
        if (params != null && !params.isEmpty()) {
            double totalPower = 0.0;
            for (ExtendItem param : params) {
                if (param.getExists() != null && !"".equals(param.getExists().trim())) {
                    if (!CalculatorEngine.INSTANCE.existConditionCheck(param, profile, cache)) {
                        super.getLogger().info("set param power 0 " + param.getBasicItem().getName());
                        param.setPower(0);
                    }
                }

                totalPower += param.getPower();

            }

            for (ExtendItem param : params) {
                super.calculateScoreItem(param, totalPower, profile, cache);

                BasicItem innerItem = param.getBasicItem();
                if (innerItem instanceof ScoreItem) {
                    param.setData(((ScoreItem) innerItem).getData());
                } else if (innerItem instanceof MetricItem) {
                    param.setData(getOneValueFromItem(innerItem, profile, cache));
                    param.setScore(0.0);
                }
            }

            double totalScore = 0;
            for (ExtendItem param : params) {
                totalScore += param.getRateScore();
            }

            ExtendItem result = new ExtendItem();
            result.setBasicItem(scoreItem);
            result.setScore(totalScore);

            return result;
        } else {
            super.getLogger().info("SumScoreWithCheckExists configed params is not right!");
        }

        return null;
    }
}
