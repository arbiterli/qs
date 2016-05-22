package com.glority.quality.sca.cpd;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.glority.quality.metrics.java.JavaCPDCheckTask;

public class JavaCPDTaskTest extends AbstractCPDTaskTest {

	@BeforeClass
	protected void setUp() throws Exception {
		super.setUp();
		
		format.setValue(format.getValues()[1]);
		cpdTask.setFormat(format);
		
		language.setValue(language.getValues()[0]);
		cpdTask.setLanguage(language);
		
		inputFilePath += "java" + File.separator + "DateCompare4JavaCPD.java.test";
		set.setFile(new File(inputFilePath));
		cpdTask.addFileset(set);
		
		outputFilePath += "java";
		new File(outputFilePath).mkdirs();
		outputFilePath += File.separator + "GeneratedJavaCPDReport.txt";
		cpdTask.setOutputFile(new File(outputFilePath));

		cpdCheck = new JavaCPDCheckTask();
		cpdCheck.setReportPath(outputFilePath);
		expectedDuplicaton = 6;
		
		cpdTask.execute();
		
	}

	@Test
	public void testJavaCpd() throws IOException{
		cpdCheck.parseReport();
		assertTrue(expectedDuplicaton == Integer.parseInt(cpdCheck.getMetrics().get(0).getNewValue()));
	}
}
