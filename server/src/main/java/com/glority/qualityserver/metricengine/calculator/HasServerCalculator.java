package com.glority.qualityserver.metricengine.calculator;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;

/**
 * HasServerCalculator.
 * 
 * @author Li.heping
 * 
 */
public class HasServerCalculator extends AbstractCalculator {

    @Override
    public String getName() {
        return "hasServer";
    }

    @Override
    public boolean existsConditionCheck(ExtendItem item, MetricEngineProfile profile, MetricEngineCache cache) {
        return cache.hasProductionServer();
    }

}
