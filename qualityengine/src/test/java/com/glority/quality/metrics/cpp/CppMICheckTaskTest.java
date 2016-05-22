package com.glority.quality.metrics.cpp;

import com.glority.quality.Constants.Language;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class CppMICheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CppMICheckTask cppMICheckTask;
	
	@Before
	public void setUp() {
		cppMICheckTask = new CppMICheckTask();
		metricsTask = cppMICheckTask;
		cppMICheckTask.setReportPath(TEST_SAMPLE_REPORTS);
		super.setUp();
	}
	
	@Test
	public void testGetLanguageName(){
		assertEquals(Language.CPP.toString(), cppMICheckTask.getLanguageName());
	}
}
