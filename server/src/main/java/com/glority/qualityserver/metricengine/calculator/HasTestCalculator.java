package com.glority.qualityserver.metricengine.calculator;

import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;

/**
 * Calculator for check if current build has test.
 * @author Zhao JP
 *
 */
public class HasTestCalculator extends AbstractCalculator {

    @Override
    public String getName() {
        return "hasTest";
    }

    @Override
    public boolean existsConditionCheck(ExtendItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return cache.checkHasTest(profile.getBuildId());
    }

}
