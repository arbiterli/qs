package com.glority.quality.metrics.cs;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;
import com.glority.quality.model.Metric;

public class CsCPDCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CsCPDCheckTask cpdCheckTask;
	
	@Before
	public void setUp() {		
		cpdCheckTask = new CsCPDCheckTask();
		metricsTask = cpdCheckTask;
		cpdCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "cpd.txt");
		super.setUp();
	}
	
	@Test
	public void testGetMeticName() {
		assertEquals(MetricName.CS_CPD.toString(), cpdCheckTask.getMeticName());		
	}

	@Test
	public void testGetMetrics() {
		assertEquals(1, cpdCheckTask.getMetrics().size());
		Metric duplication = cpdCheckTask.getMetrics().get(0);
		assertEquals("511", duplication.getNewValue());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
