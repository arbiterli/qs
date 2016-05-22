package com.glority.qualityserver.metricengine.calculator;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;

/**
 * HasNagiosWatchCalculator.
 * 
 * @author liheping
 * 
 */
public class HasNagiosWatchCalculator extends AbstractCalculator {

    @Override
    public String getName() {
        return "hasNagiosWatch";
    }

    @Override
    public boolean existsConditionCheck(ExtendItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return cache.checkNagiosWatch(profile.getProductId(), profile.getPhase());
    }
}
