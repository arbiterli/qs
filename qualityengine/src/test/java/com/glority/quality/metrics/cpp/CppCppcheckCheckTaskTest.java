package com.glority.quality.metrics.cpp;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;
import com.glority.quality.model.Metric;

public class CppCppcheckCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CppCppcheckCheckTask cppCppcheckCheckTask;
	
	@Before
	public void setUp() {
		cppCppcheckCheckTask = new CppCppcheckCheckTask();
		metricsTask = cppCppcheckCheckTask;
		cppCppcheckCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "cppcheck-report.xml");
		super.setUp();
	}
	
	@Test
	public void testGetMetrics(){
		List<Metric> metric = cppCppcheckCheckTask.getMetrics();
		assertEquals(1, metric.size());
		assertEquals("4", metric.get(0).getNewValue());
	}
}
