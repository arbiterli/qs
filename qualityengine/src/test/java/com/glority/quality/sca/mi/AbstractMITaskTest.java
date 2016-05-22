package com.glority.quality.sca.mi;

import java.io.File;

import junit.framework.TestCase;

import org.apache.tools.ant.Project;
import org.junit.BeforeClass;


public class AbstractMITaskTest extends TestCase {
	
	protected static MITask miTask;
	protected String reportPath;
	protected File expectedFile;
	protected File generatedFile;
	protected File inputFile;
	protected String inputFilePath;
	protected String exFilePath;

	
	@BeforeClass
	protected void setUp() throws Exception {
		reportPath = "testtasks" + File.separator + "MIReports";
		exFilePath = "testtasks" + File.separator + "reports" + File.separator + "MIExpectedReport";
		inputFilePath = "testtasks" + File.separator + "testsrc";
		miTask = new MITask();
		Project p = new Project();
		miTask.setProject(p);
		super.setUp();
	}	

}
