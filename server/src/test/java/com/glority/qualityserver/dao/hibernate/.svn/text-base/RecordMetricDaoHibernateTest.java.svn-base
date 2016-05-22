package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class RecordMetricDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private RecordMetricDaoHibernate recordMetric;

    @Test
    public void testGetLatestSampleMetrics() {
        assertEquals(0, recordMetric.getLatestSampleMetrics(0, "RUN_QUALITY").size());
        assertEquals(1, recordMetric.getLatestSampleMetrics(3, "RUN_QUALITY").size());
    }
}
