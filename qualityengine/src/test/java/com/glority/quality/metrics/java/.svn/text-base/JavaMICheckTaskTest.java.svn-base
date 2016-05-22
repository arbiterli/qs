package com.glority.quality.metrics.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.Language;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JavaMICheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JavaMICheckTask javaMICheckTask;
	
	@Before
	public void setUp() {		
		javaMICheckTask = new JavaMICheckTask();
		metricsTask = javaMICheckTask;
		javaMICheckTask.setReportPath(TEST_SAMPLE_REPORTS);
		super.setUp();
	}
	
	@Test
	public void testGetLanguageName() {
		assertEquals(Language.JAVA.toString(), javaMICheckTask.getLanguageName());		
	}
	
	@Test
	public void testGetMetrics(){
		assertEquals(4, javaMICheckTask.getMetrics().size());
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
}
