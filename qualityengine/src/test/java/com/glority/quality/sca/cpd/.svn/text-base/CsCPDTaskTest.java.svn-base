package com.glority.quality.sca.cpd;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.glority.quality.metrics.cs.CsCPDCheckTask;

public class CsCPDTaskTest extends AbstractCPDTaskTest {
	
	@BeforeClass
	protected void setUp() throws Exception {
		super.setUp();
		
		format.setValue(format.getValues()[1]);
		cpdTask.setFormat(format);
		
		language.setValue(language.getValues()[7]);
		cpdTask.setLanguage(language);
		
		inputFilePath += "cs" + File.separator + "DataAccess4CSCPD.cs";
		set.setFile(new File(inputFilePath));
		cpdTask.addFileset(set);
		
		outputFilePath += "cs";
		new File(outputFilePath).mkdirs();
		outputFilePath += File.separator + "GeneratedCSCPDReport.txt";
		cpdTask.setOutputFile(new File(outputFilePath));

		cpdCheck = new CsCPDCheckTask();
		cpdCheck.setReportPath(outputFilePath);
		expectedDuplicaton = 5;
		
		cpdTask.execute();
	}

	@Test
	public void testJavaCpd() throws IOException{
		cpdCheck.parseReport();
		assertTrue(expectedDuplicaton == Integer.parseInt(cpdCheck.getMetrics().get(0).getNewValue()));
	}
}
