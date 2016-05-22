package com.glority.quality.metrics.java;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.TestFramework;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JavaJunitCheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JavaJunitCheckTask javaJunitCheckTask;
	
	@Before
	public void setUp() {		
		javaJunitCheckTask = new JavaJunitCheckTask();
		metricsTask = javaJunitCheckTask;
		javaJunitCheckTask.setReportPath(TEST_SAMPLE_REPORTS + File.separator + "junit.xml");
		super.setUp();
	}
	
	@Test
	public void testGetLanguageName() {
		assertEquals(TestFramework.TEST_FRAMEWORK_JUNIT.toString(), javaJunitCheckTask.getTestFrameworkName());
	}
	
	@After
	public void tearDown() throws Exception {
	}
}
