package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * calculate the score for score item, the power for each param is based on the
 * lines of code.
 * 
 * @author xxd
 * 
 */
public class SumScoreWithDynamicPower extends AbstractCalculator {

    @Override
    public String getName() {
        return "sumScoreWithDynamicPower";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (scoreItem == null) {
            return null;
        }

        List<ExtendItem> params = scoreItem.getItemList();
        getLogger().debug("in sumWithLOCPower method ");
        if (params != null && !params.isEmpty()) {
            // set build score power and calculate build score total power
            double totalPower = 0.0;
            for (int i = 0; i < params.size(); i += 2) {
                String powerStr = getOneValueFromItem(params.get(i), profile, cache);
                if (powerStr == null) {
                    if (i + 1 < params.size()) {
                        params.get(i + 1).setPower(0);
                    }
                } else {
                    // if power is not specified, based on the exist item
                    // calculate power.
                    if (params.get(i + 1).getPower() <= 0.0) {
                        try {
                            double power = Double.parseDouble(powerStr);
                            if (i + 1 < params.size()) {
                                params.get(i + 1).setPower(power);
                                params.get(i + 1).getBasicItem().setUnit(params.get(i).getBasicItem().getUnit());
                                totalPower += power;
                            }
                        } catch (Exception e) {
                            if (i + 1 < params.size()) {
                                params.get(i + 1).setPower(0);
                            }
                        }
                    } else {
                        totalPower += params.get(i + 1).getPower();
                    }
                }
            }

            // calculate each item score and set related data to item.
            for (int i = 1; i < params.size(); i += 2) {
                ExtendItem param = params.get(i);
                if (param.getPower() != 0) {
                    calculateScoreItem(param, totalPower, profile, cache);
                    param.setData(inf.format(param.getPower()));
                }
            }
            // calculate final score
            double totalScore = 0.0;
            for (int i = 1; i < params.size(); i += 2) {
                ExtendItem param = params.get(i);
                if (param.getPower() != 0) {
                    totalScore += param.getRateScore();
                }
            }

            ExtendItem result = new ExtendItem();
            result.setBasicItem(scoreItem);
            result.setScore(totalScore);
            return result;
        }

        return null;
    }

}
