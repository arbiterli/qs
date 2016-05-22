package com.glority.quality.metrics.cs;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.Constants.Language;
import com.glority.quality.metrics.AbstractMetricsCheckBaseTaskTest;

public class CSMICheckTaskTest extends AbstractMetricsCheckBaseTaskTest{
	private CSMICheckTask csMICheckTask;
	
	@Before
	public void setUp() {
		csMICheckTask = new CSMICheckTask();
		metricsTask = csMICheckTask;
		csMICheckTask.setReportPath(TEST_SAMPLE_REPORTS);
		super.setUp();
	}

	@Test
	public void testGetLanguageName() {
		assertEquals(Language.CS.toString(), csMICheckTask.getLanguageName());
	}
	

}
