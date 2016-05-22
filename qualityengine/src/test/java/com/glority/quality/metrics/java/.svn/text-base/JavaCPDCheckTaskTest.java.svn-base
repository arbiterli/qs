package com.glority.quality.metrics.java;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;
import com.glority.quality.model.Metric;

public class JavaCPDCheckTaskTest extends AbstractMetricsCheckBaseTaskTest {
    private JavaCPDCheckTask javaCPDCheckTask;
	
	@Before
	public void setUp() {		
		javaCPDCheckTask = new JavaCPDCheckTask();
		metricsTask = javaCPDCheckTask;
		javaCPDCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "cpd.txt");
		super.setUp();
	}
	
	@Test
	public void testGetMeticName() {
		assertEquals(MetricName.JAVA_CPD.toString(), javaCPDCheckTask.getMeticName());	    
	}

	@Test
	public void testGetMetrics() {
		assertEquals(1, javaCPDCheckTask.getMetrics().size());
		Metric duplication = javaCPDCheckTask.getMetrics().get(0);
		assertEquals("511", duplication.getNewValue());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
