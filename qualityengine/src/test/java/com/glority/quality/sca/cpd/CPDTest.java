package com.glority.quality.sca.cpd;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.glority.quality.model.TestCase;

public class CPDTest extends TestCase {
	private String[] args;

	@Test
	public void testCpdPositive() throws IOException, ReportException{
		String fileDir = "testtasks" + File.separator + "testsrc" + File.separator + "java";
		args = new String[]{"--language", "java", "--format", "vs", "--encoding", "UTF-8", "--minimum-tokens", "3", "--skip-duplicate-files", "--files", fileDir};
		CPDConfiguration cpdConfig = new CPDConfiguration(args);
        CPD cpd = new CPD(cpdConfig);
        for (int position = 0; position < args.length; position++) {
            if (args[position].equals("--files")) {
                cpd.addRecursively(args[position + 1]);
            }
        }
        cpd.go(false);
        assertNotNull(cpdConfig.renderer().render(cpd.getMatches(),new File("testCPD.txt")));
	}
	
	@Test
	public void testCpdNegative(){
		args = new String[]{};
        if (args.length == 0) {
            CPD.showUsage();
        }
	}
}
