package com.glority.quality.metrics;

import java.io.File;

import org.junit.Ignore;

import com.glority.quality.AbstractBaseTaskTest;

@Ignore
public abstract class AbstractMetricsCheckBaseTaskTest extends AbstractBaseTaskTest {
	protected String thresholdPath;
	protected MetricsCheckBaseTask metricsTask;		

	public void setUp() {	
		task = metricsTask;
		thresholdPath = TEST_OUT_PATH + File.separator + "threshold.properties";
		//metricsTask.setThresholdPath(thresholdPath);
		super.setUp();
	}

}
