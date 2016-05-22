package com.glority.quality.metrics.java;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JavaPMDCheckTaskTest extends AbstractMetricsCheckBaseTaskTest {
	private JavaPMDCheckTask pmdCheckTask;
	
	@Before
	public void setUp() {		
		pmdCheckTask = new JavaPMDCheckTask();
		metricsTask = pmdCheckTask;
		pmdCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "pmd.xml");		
		super.setUp();
	}
	
	@Test
	public void testGetMeticName() {
      	assertEquals(MetricName.JAVA_PMD.toString(), pmdCheckTask.getMeticName());
	}

	@Test
	public void testGetMetrics() {
		assertEquals(3, pmdCheckTask.getMetrics().size());
	}

	@Test
	public void testGetMetricTotalPMDViolations() {
		assertEquals(8420, pmdCheckTask.getMetricTotalPMDViolations());
	}

	@Test
	public void testGetMetricPMDErrors() {
		assertEquals(135, pmdCheckTask.getMetricPMDErrors());
	}

	@Test
	public void testGetMetricPMDWarnings() {
		assertEquals(6901, pmdCheckTask.getMetricPMDWarnings());
	}

	@Test
	public void testGetReportPath() {
		assertEquals(TEST_SAMPLE_REPORTS + File.separator + "pmd.xml", pmdCheckTask.getReportPath());
	}

//	@Test
//	public void testGetThreshold() {
//		fail("Not yet implemented");
//	}
	
	@After
	public void tearDown() throws Exception {
	}
}
