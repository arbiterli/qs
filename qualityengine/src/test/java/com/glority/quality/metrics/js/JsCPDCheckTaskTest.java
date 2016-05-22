package com.glority.quality.metrics.js;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;
import com.glority.quality.model.Metric;

public class JsCPDCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JsCPDCheckTask jsCPDCheckTask;
	
	@Before
	public void setUp() {		
		jsCPDCheckTask = new JsCPDCheckTask();
		metricsTask = jsCPDCheckTask;
		jsCPDCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "cpd.txt");
		super.setUp();
	}
	
	@Test
	public void testGetMeticName() {
		assertEquals(MetricName.JS_CPD.toString(), jsCPDCheckTask.getMeticName());		
	}

	@Test
	public void testGetMetrics() {
		Metric duplication = jsCPDCheckTask.getMetrics().get(0);
		assertEquals(1, jsCPDCheckTask.getMetrics().size());
		assertEquals("511", duplication.getNewValue());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
