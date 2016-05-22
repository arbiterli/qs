package com.glority.qualityserver.manager.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class BuildMetricManagerImplTest extends AbstractBaseTest {

    @Autowired
    private BuildMetricManagerImpl metricManager;

    @Test
    public void testGetMetricsForScoreCalculate() {
        assertEquals(17, metricManager.getMetricsForScoreCalculate(3).size());
    }

    @Test
    public void testGetScoreMetricTypeList() {
        assertEquals(17, metricManager.getBuildMetrics(3).size());
    }
}
