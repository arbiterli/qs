package com.glority.quality.connectors.svn;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;

public class SVNCommitTaskTest extends AbstractSVNBaseTaskTest {
	private SVNCommitTask commitTask;
	private SVNRepository repository = null;
	private long beforeRevision = 0;
	private File localFile ;
	
	@SuppressWarnings("deprecation")
    @Before
	public void setUp() {
		commitTask = new SVNCommitTask();
		svnTask = commitTask;
		super.setUp();
		commitTask.setLocalPath(localPath);
		
		try { 
		     repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(commitTask.getSvnURI()));
		     ISVNAuthenticationManager authManager = new BasicAuthenticationManager(commitTask.getUsername(), commitTask.getPassword());
		     repository.setAuthenticationManager(authManager);
		     beforeRevision = repository.getLatestRevision();
		 } catch (SVNException e){
		     e.printStackTrace();
		     System.exit(1);
		 }
				
		localFile = new File(localPath + File.separator +"test.log");
	}

	@Test
	public void testProcessAddFile() throws IOException, SVNException {

		SVNCheckoutTaskTest test =  new SVNCheckoutTaskTest();
		test.setUp();
		test.testProcess();
		
		localFile.createNewFile();

		commitTask.setCommitMessage("commit for test");
	    commitTask.process();
	    
	    assertFalse(beforeRevision == repository.getLatestRevision());
	}
	
	@Test
	public void testProcessModifyFile() throws IOException, SVNException {
		BufferedWriter outobj = new BufferedWriter(new FileWriter(localFile));
        outobj.write("Modified");
        outobj.close();
        
		commitTask.setCommitMessage("commit for test");
	    commitTask.process();
	    
	    assertFalse(beforeRevision == repository.getLatestRevision());
	}
	
	@Test
	public void testProcessDeleteFile() throws IOException, SVNException {
		commitTask.svnConnect();
		commitTask.clientManager.getWCClient().doDelete(localFile, false, false);
	    commitTask.setCommitMessage("revert for test");
	    commitTask.process();
	    
	    assertFalse(beforeRevision == repository.getLatestRevision());
	}
}
