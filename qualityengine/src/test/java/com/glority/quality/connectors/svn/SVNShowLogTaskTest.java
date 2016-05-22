package com.glority.quality.connectors.svn;


import org.junit.Before;
import org.junit.Test;

public class SVNShowLogTaskTest extends AbstractSVNBaseTaskTest {
	private SVNShowLogTask svnShowLogTask;
	
	@Before
	public void setUp() {
		svnShowLogTask = new SVNShowLogTask();
		svnTask = svnShowLogTask;
		super.setUp();
	}

	@Test
	public void testProcess() {
		
	}


}
