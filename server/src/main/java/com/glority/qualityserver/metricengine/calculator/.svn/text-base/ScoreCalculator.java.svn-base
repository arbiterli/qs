package com.glority.qualityserver.metricengine.calculator;

import java.util.List;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * Used to calculate the score.
 * 
 * @author xxd
 */
public interface ScoreCalculator {
    List<Object> calculateMetric(MetricItem item, MetricEngineProfile profile, MetricEngineCache cache);

    ExtendItem calculateScore(ScoreItem item, MetricEngineProfile profile, MetricEngineCache cache);

    String getName();

    boolean existsConditionCheck(ExtendItem item, MetricEngineProfile profile, MetricEngineCache cache);
}
