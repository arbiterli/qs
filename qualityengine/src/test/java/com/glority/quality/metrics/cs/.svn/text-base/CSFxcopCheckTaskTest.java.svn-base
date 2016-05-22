package com.glority.quality.metrics.cs;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;
import com.glority.quality.model.Metric;

public class CSFxcopCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CSFxcopCheckTask csFxcopCheckTask;
	
	@Before
	public void setUp() {
		csFxcopCheckTask = new CSFxcopCheckTask();
		metricsTask = csFxcopCheckTask;
		csFxcopCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "fxcop-report.xml");
		super.setUp();
	}

	@Test
	public void testGetMetrics() {
		assertEquals(1, csFxcopCheckTask.getMetrics().size());
		Metric duplication = csFxcopCheckTask.getMetrics().get(0);
		assertEquals("860", duplication.getNewValue());
	}
	
}
