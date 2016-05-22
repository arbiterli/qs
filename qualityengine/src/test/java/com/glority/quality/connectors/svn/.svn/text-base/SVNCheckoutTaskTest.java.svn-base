package com.glority.quality.connectors.svn;


import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class SVNCheckoutTaskTest extends AbstractSVNBaseTaskTest {
	private SVNCheckoutTask svnCheckoutTask;
	
	@Before
	public void setUp() {
		svnCheckoutTask = new SVNCheckoutTask();
		svnTask = svnCheckoutTask;
		super.setUp();
	}

	@Test
	public void testCheckParametersWithException() {
		Exception exception = null;;
		try{
			svnCheckoutTask.checkParameters();
		}catch (Exception e) {
			exception = e;
		}
		assertNotNull(exception);
		assertEquals("Local path cann't be null.", exception.getMessage());
	}
	
	@Test
	public void testCheckParameters() {
		Exception exception = null;;
		try{
			svnCheckoutTask.setLocalPath(localPath);
			svnCheckoutTask.checkParameters();
		}catch (Exception e) {
			exception = e;
		}
		assertNull(exception);
	}

	@Test
	public void testProcess() {
		
		File localFile = new File(localPath);
		removeDirectory(localFile);
		assertFalse(localFile.exists());
		
		svnCheckoutTask.setLocalPath(localPath);
		svnCheckoutTask.process();	
		assertTrue(localFile.exists());
		assertTrue(new File(localPath + File.separator + ".svn").exists());
	}

}
