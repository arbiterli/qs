package com.glority.quality.metrics.cs;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class CSStylecopCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CSStylecopCheckTask csStylecopCheckTask;
	
	@Before
	public void setUp() {
		csStylecopCheckTask = new CSStylecopCheckTask();
		metricsTask = csStylecopCheckTask;
		csStylecopCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "stylecop-report.xml");
		super.setUp();
	}

	@Test
	public void testGetMetrics() {
		assertEquals(1, csStylecopCheckTask.getMetrics().size());
		assertEquals("383", csStylecopCheckTask.getMetrics().get(0).getNewValue());
	}

}
