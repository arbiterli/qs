package com.glority.quality.reportxml;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

public class QualityReportBuildTaskTest extends AbstractBaseTaskTest{
	private QualityReportBuildTask buildTask;
	
	@Before
	public void setUp(){
		buildTask = new QualityReportBuildTask();
	}
	
	@Test
	public void testProcess(){
		buildTask.setJenkinsJobName("name");
		buildTask.setJenkinsBuildId("id");
		buildTask.setQualityXmlPath("testtasks" + File.separator + "reports" + File.separator + "quality.xml");
		buildTask.loadQualityReport();
		buildTask.process();
		assertEquals("name", buildTask.getQualityReport().getBuildTestInfo().getBuild().getJenkinsjob());
		assertEquals("id", buildTask.getQualityReport().getBuildTestInfo().getBuild().getJenkinsbuild());
	}
	
}
