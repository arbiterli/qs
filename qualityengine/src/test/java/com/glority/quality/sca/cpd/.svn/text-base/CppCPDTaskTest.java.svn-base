package com.glority.quality.sca.cpd;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.glority.quality.metrics.cpp.CppCPDCheckTask;

public class CppCPDTaskTest extends AbstractCPDTaskTest {
	
	@BeforeClass
	protected void setUp() throws Exception {
		super.setUp();
		
		format.setValue(format.getValues()[1]);
		cpdTask.setFormat(format);
		
		language.setValue(language.getValues()[2]);
		cpdTask.setLanguage(language);
		
		inputFilePath += "cpp" + File.separator + "TestForCppCPD.cpp";
		set.setFile(new File(inputFilePath));
		cpdTask.addFileset(set);
		
		outputFilePath += "cpp";
		new File(outputFilePath).mkdirs();
		outputFilePath += File.separator + "GeneratedCppCPDReport.txt";
		cpdTask.setOutputFile(new File(outputFilePath));
		
		cpdCheck = new CppCPDCheckTask();
		cpdCheck.setReportPath(outputFilePath);
		expectedDuplicaton = 2;
		
		cpdTask.execute();
	}

	@Test
	public void testJavaCpd() throws IOException{
		cpdCheck.parseReport();
		assertTrue(expectedDuplicaton == Integer.parseInt(cpdCheck.getMetrics().get(0).getNewValue()));
	}
}
