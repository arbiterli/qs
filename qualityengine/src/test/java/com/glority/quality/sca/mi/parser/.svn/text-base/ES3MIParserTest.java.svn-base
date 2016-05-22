package com.glority.quality.sca.mi.parser;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;
import org.apache.tools.ant.types.FileSet;
import org.junit.BeforeClass;
import org.junit.Test;

import com.glority.quality.sca.CompareFileUtil;
import com.glority.quality.sca.mi.AbstractMITaskTest;

public class ES3MIParserTest extends AbstractMITaskTest {
	
	@BeforeClass
	protected void setUp() throws Exception {
		super.setUp();
		
		exFilePath = exFilePath + File.separator + "js" + File.separator + "ExpectedJsMi.xml";
		expectedFile = new File(exFilePath);
		reportPath = reportPath + File.separator + "js";
		new File(reportPath).mkdirs();		
		
		FileSet set = new FileSet();
		inputFile = new File(inputFilePath + File.separator + "js" + File.separator + "Test4JsMi.js");
		set.setFile(inputFile);
		
		miTask.addFileset(set);
		miTask.setLanguage("js");
		miTask.setReportPath(reportPath);
		miTask.execute();
		
		generatedFile = new File(reportPath + File.separator + "mi.xml");
	}
	
	@Test
	public void testParseJava() throws RecognitionException, IOException{
		assertTrue(CompareFileUtil.compareReports(expectedFile, generatedFile));
	}
}
