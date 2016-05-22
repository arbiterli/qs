package com.glority.quality.metrics.java;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JavaCheckStyleCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JavaCheckStyleCheckTask javaCheckStyleCheckTask;
	
	@Before
	public void setUp() {		
		javaCheckStyleCheckTask = new JavaCheckStyleCheckTask();
		metricsTask = javaCheckStyleCheckTask;
		javaCheckStyleCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "checkstyle_report.xml");
		System.out.println(javaCheckStyleCheckTask.getReportPath());
		super.setUp();
	}
	
	@Test
	public void testGetMetrics(){
		assertEquals(1, javaCheckStyleCheckTask.getMetrics().size());
		assertEquals("26024", javaCheckStyleCheckTask.getMetrics().get(0).getNewValue());
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
