package com.glority.quality.reportxml;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

public class QualityReportTestTaskTest extends AbstractBaseTaskTest{
	private QualityReportTestTask testTask;
	
	@Before
	public void setUp(){
		testTask = new QualityReportTestTask();
	}
	
	@Test
	public void testProcess(){
		testTask.setJenkinsJobName("name");
		testTask.setJenkinsBuildId("id");
		testTask.setQualityXmlPath("testtasks" + File.separator + "reports" + File.separator + "quality.xml");
		testTask.loadQualityReport();
		testTask.process();
		assertEquals("name", testTask.getQualityReport().getBuildTestInfo().getBuild().getJenkinsjob());
		assertEquals("id", testTask.getQualityReport().getBuildTestInfo().getBuild().getJenkinsbuild());
	}
	
}
