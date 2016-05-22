package com.glority.quality.metrics.js;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JsPMDCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JsPMDCheckTask jsPMDCheckTask;
	
	@Before
	public void setUp() {		
		jsPMDCheckTask = new JsPMDCheckTask();
		metricsTask = jsPMDCheckTask;
		jsPMDCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "pmd.xml");		
		super.setUp();
	}
	
	@Test
	public void testGetMeticName() {
	  	assertEquals(MetricName.JS_PMD.toString(), jsPMDCheckTask.getMeticName());
	}

	@Test
	public void testGetMetrics() {
		assertEquals(3, jsPMDCheckTask.getMetrics().size());
	}

	@Test
	public void testGetMetricTotalPMDViolations() {
		assertEquals(8420, jsPMDCheckTask.getMetricTotalPMDViolations());
	}

	@Test
	public void testGetMetricPMDErrors() {
		assertEquals(135, jsPMDCheckTask.getMetricPMDErrors());
	}

	@Test
	public void testGetMetricPMDWarnings() {
		assertEquals(6901, jsPMDCheckTask.getMetricPMDWarnings());
	}

	@Test
	public void testGetReportPath() {
		assertEquals(TEST_SAMPLE_REPORTS + File.separator + "pmd.xml", jsPMDCheckTask.getReportPath());
	}

	
	@After
	public void tearDown() throws Exception {
	}
}
