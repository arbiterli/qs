package com.glority.quality.metrics.java;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JavaEmmaCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JavaEmmaCheckTask javaEmmaCheckTask;
	
	@Before
	public void setUp() {		
		javaEmmaCheckTask = new JavaEmmaCheckTask();
		metricsTask = javaEmmaCheckTask;
		javaEmmaCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "emma.xml");	
		super.setUp();
	}
	
	@Test
	public void testJavaGetMetrise(){
		assertEquals(4, javaEmmaCheckTask.getMetrics().size());
	}
}
