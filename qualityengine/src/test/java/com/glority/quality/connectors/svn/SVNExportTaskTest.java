package com.glority.quality.connectors.svn;


import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class SVNExportTaskTest extends AbstractSVNBaseTaskTest {
	private SVNExportTask svnExportTask; 
	
	@Before
	public void setUp() {
		svnExportTask = new SVNExportTask();
		svnTask = svnExportTask;
		super.setUp();
	}

	@Test
	public void testProcess() {
		File localFile = new File(localPath);
		removeDirectory(localFile);
		assertFalse(localFile.exists());
		
		svnExportTask.setDestPath(localPath);
		svnExportTask.process();	
		assertTrue(localFile.exists());
		assertFalse(new File(localPath + File.separator + ".svn").exists());
	}

}
