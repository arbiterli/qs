package com.glority.quality.connectors.svn;


import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.BasicAuthenticationManager;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNStatus;

public class SVNUpdateTaskTest extends AbstractSVNBaseTaskTest {
	private SVNUpdateTask svnUpdateTask;
	private SVNRepository repository = null;
	
	@SuppressWarnings("deprecation")
    @Before
	public void setUp() {
		svnUpdateTask = new SVNUpdateTask();
		svnTask = svnUpdateTask;
		super.setUp();
		
		try { 
		     repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(svnUpdateTask.getSvnURI()));
		     ISVNAuthenticationManager authManager = 
                   new BasicAuthenticationManager(svnUpdateTask.getUsername(), svnUpdateTask.getPassword());
		     repository.setAuthenticationManager(authManager);
		     
		 } catch (SVNException e){
		     e.printStackTrace();
		     System.exit(1);
		 }
	}

	@Test
	public void testProcessToHead() throws SVNException {
		SVNCheckoutTaskTest test =  new SVNCheckoutTaskTest();
		test.setUp();
		test.testProcess();
		
		svnUpdateTask.setLocalPath(localPath);
		svnUpdateTask.process();
		
		SVNStatus status = svnUpdateTask.clientManager.getStatusClient().doStatus(new File(localPath), true);
		long revisionInWorkCopy = status.getRevision().getNumber(); 
		long headRevision = repository.getLatestRevision();
		assertEquals(headRevision, revisionInWorkCopy);
	}
	
	@Test
	public void testProcessToRevision() throws SVNException {
		svnUpdateTask.setLocalPath(localPath);
		svnUpdateTask.setRevision("23903");
		svnUpdateTask.process();
		
		SVNStatus status = svnUpdateTask.clientManager.getStatusClient().doStatus(new File(localPath), true);
		long revisionInWorkCopy = status.getRevision().getNumber(); 
		
		assertEquals(23903, revisionInWorkCopy);
	}

}
