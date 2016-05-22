package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * FullScoreWithNoRecordCalculator.
 * 
 * @author Administrator
 * 
 */
public class FullScoreWithSpecifiedStatusCalculator extends AbstractCalculator {

    private final int paramSize = 3;

    @Override
    public String getName() {
        return "fullScoreWithSpecifiedStatus";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (scoreItem != null) {
            List<ExtendItem> params = scoreItem.getItemList();
            if (params != null && params.size() == this.paramSize) {
                ExtendItem result = new ExtendItem();
                result.setBasicItem(scoreItem);

                ExtendItem calculateParam = params.get(0);
                //scoreItem.setUnit(calculateParam.getBasicItem().getUnit());
                String value = super.getOneValueFromItem(calculateParam, profile, cache);

                ExtendItem fullScoreStatusParam = params.get(1);
                String fullScoreStatus = super.getOneValueFromItem(fullScoreStatusParam, profile, cache);

                ExtendItem zeroScoreStatusParam = params.get(2);
                String zerorScoreStatus = super.getOneValueFromItem(zeroScoreStatusParam, profile, cache);

                if (fullScoreStatus != null && fullScoreStatus.equalsIgnoreCase(value)) {
                    scoreItem.setData(fullScoreStatus);
                    result.setData(fullScoreStatus);
                    result.setScore(FULL_SCORE);
                } else {
                    scoreItem.setData(zerorScoreStatus);
                    result.setData(zerorScoreStatus);
                    result.setScore(0);
                }

                return result;
            } else {
                super.getLogger().error("fullScoreWithSpecifiedStatus config with wrong params");
            }
        }
        return null;
    }
}
