package com.glority.qualityserver.metricengine.calculator;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * LinearScoreCalculator.
 * 
 * @author xxd
 *
 */
public class LinearScoreCalculator extends AbstractLinearScoreCalculator {

    @Override
    public String getName() {
        return "linearScore";
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return super.linearScore(scoreItem, profile, cache);
    }
}
