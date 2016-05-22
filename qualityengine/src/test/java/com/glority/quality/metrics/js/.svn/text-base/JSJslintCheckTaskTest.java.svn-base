package com.glority.quality.metrics.js;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JSJslintCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JSJslintCheckTask jsJslintCheckTask;
	
	@Before
	public void setUp() {
		jsJslintCheckTask = new JSJslintCheckTask();
		metricsTask = jsJslintCheckTask;
		jsJslintCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "stylecop-report.xml");
		super.setUp();
	}

	@Test
	public void testGetMetrics() {
		assertEquals(1, jsJslintCheckTask.getMetrics().size());
		assertEquals("0", jsJslintCheckTask.getMetrics().get(0).getNewValue());
	}
}
