package com.glority.quality.metrics.js;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.Language;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class JSMICheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private JSMICheckTask jsMICheckTask;
	
	@Before
	public void setUp() {
		jsMICheckTask = new JSMICheckTask();
		metricsTask = jsMICheckTask;
		jsMICheckTask.setReportPath(TEST_SAMPLE_REPORTS);
		super.setUp();
	}
	
	@Test
	public void testGetLanguageName(){
		assertEquals(Language.JS.toString(), jsMICheckTask.getLanguageName());
	}
}
