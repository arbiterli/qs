package com.glority.quality.sca.cpd;

import java.io.File;

import junit.framework.TestCase;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.FileSet;
import org.junit.BeforeClass;

import com.glority.quality.metrics.CPDCheckBaseTask;
import com.glority.quality.sca.cpd.CPDTask.FormatAttribute;
import com.glority.quality.sca.cpd.CPDTask.LanguageAttribute;

public class AbstractCPDTaskTest extends TestCase {
	
	//public static final int TOTAL_DUPLICATION_INDEX = 1;  
	protected CPDTask cpdTask;
	protected LanguageAttribute language;
	protected FormatAttribute format;
	protected FileSet set;
	protected String outputFilePath;
	protected String inputFilePath;
	protected int expectedDuplicaton;
	protected CPDCheckBaseTask cpdCheck;

	@BeforeClass
	protected void setUp() throws Exception {
		
		super.setUp();
		cpdTask = new CPDTask();
		cpdTask.setMinimumTokenCount(5);
		cpdTask.setIgnoreLiterals(true);
		cpdTask.setIgnoreIdentifiers(true);
		cpdTask.setEncoding("UTF-8");
		cpdTask.setProject(new Project());
		
		format = new FormatAttribute();		
		language = new LanguageAttribute();		
		set = new FileSet();
		outputFilePath = "testtasks" + File.separator + "CPDReports" + File.separator;
		inputFilePath = "testtasks" + File.separator + "testsrc" + File.separator;
	}
	
}
