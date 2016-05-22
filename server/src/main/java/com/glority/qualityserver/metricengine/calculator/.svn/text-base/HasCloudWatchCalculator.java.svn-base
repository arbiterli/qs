package com.glority.qualityserver.metricengine.calculator;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;

/**
 * HasCloudWatchCalculator.
 * 
 * @author liheping
 * 
 */
public class HasCloudWatchCalculator extends AbstractCalculator {
    @Override
    public String getName() {
        return "hasCloudWatch";
    }

    @Override
    public boolean existsConditionCheck(ExtendItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return cache.checkCloudWatch(profile.getProductId(), profile.getPhase());
    }
}
