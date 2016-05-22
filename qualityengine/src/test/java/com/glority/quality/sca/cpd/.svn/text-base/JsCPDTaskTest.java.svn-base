package com.glority.quality.sca.cpd;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.glority.quality.metrics.js.JsCPDCheckTask;

public class JsCPDTaskTest extends AbstractCPDTaskTest {
	
	@BeforeClass
	protected void setUp() throws Exception {
		super.setUp();
		
		format.setValue(format.getValues()[1]);
		cpdTask.setFormat(format);
		
		language.setValue(language.getValues()[9]);
		cpdTask.setLanguage(language);
		
		inputFilePath += "js" + File.separator + "Test4JsCPD.js";
		set.setFile(new File(inputFilePath));
		cpdTask.addFileset(set);
		
		outputFilePath += "js";
		new File(outputFilePath).mkdirs();
		outputFilePath += File.separator + "GeneratedJsCPDReport.txt";
		cpdTask.setOutputFile(new File(outputFilePath));

		cpdCheck = new JsCPDCheckTask();
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
