package com.glority.quality.reportxml;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;
import com.glority.quality.sca.CompareFileUtil;

public class QualityReportInitialTaskTest extends AbstractBaseTaskTest{
	private QualityReportInitialTask initialTask;
	
	@Before
	public void setUp(){
		initialTask = new QualityReportInitialTask();
	}
	
	@Test
	public void testProcess() throws Exception{
		initialTask.setQualityXmlPath("testtasks" + File.separator + "reports" + File.separator + "InitialQuality.xml");
		initialTask.setBusinessUnit("businessUnit");
		initialTask.setProductName("productName");
		initialTask.setProductVersion("productVersion");
		initialTask.setSvnUrl("svnUrl");
		initialTask.setSvnRevision("svnRevision");
		initialTask.process();
		File inputFile = new File("testtasks" + File.separator + "reports" + File.separator + "InitialQuality.xml");
		File expectedFile = new File("testtasks" + File.separator + "reports" + File.separator + "ExpectedQualityReport" + File.separator + "InitialQuality.xml");
		assertEquals(true, CompareFileUtil.compareReports(expectedFile, inputFile));
	}
	
}
