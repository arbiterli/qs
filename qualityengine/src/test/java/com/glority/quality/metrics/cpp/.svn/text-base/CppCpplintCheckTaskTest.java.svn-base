package com.glority.quality.metrics.cpp;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;
import com.glority.quality.model.Metric;

public class CppCpplintCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CppCpplintCheckTask cppCpplintCheckTask;
	
	@Before
	public void setUp() {
		cppCpplintCheckTask = new CppCpplintCheckTask();
		metricsTask = cppCpplintCheckTask;
		cppCpplintCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "cpplint-report.txt");
		super.setUp();
	}
	
	@Test
	public void testGetMetrics(){
		List<Metric> metric = cppCpplintCheckTask.getMetrics();
		assertEquals(1, metric.size());
		assertEquals("514", metric.get(0).getNewValue());
	}
}
