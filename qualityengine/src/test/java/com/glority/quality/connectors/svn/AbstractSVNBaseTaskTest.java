package com.glority.quality.connectors.svn;

import java.io.File;

import org.apache.tools.ant.Project;
import org.junit.Before;

import com.glority.quality.AbstractBaseTaskTest;

public abstract class AbstractSVNBaseTaskTest extends AbstractBaseTaskTest {
	protected SVNBaseTask svnTask;
	protected String svnURI;
	protected String username;
	protected String password;
	protected String localPath;

	@Before
	public void setUp() {
		task = svnTask;
		svnTask.setSvnURI("http://svn.glority.com/scripts/chen.zhe");
		svnTask.setUsername("quality");
		svnTask.setPassword("abc-123");
		localPath = TEST_ROOT + File.separator + "svntest";
		
		project = new Project();
		qualityXmlPath = TEST_OUT_PATH + File.separator + "quality.xml";
		task.setProject(project);
	}
    
    public boolean removeDirectory(File  directory) {
    	if (directory == null)
    	    return false;
    	  if (!directory.exists())
    	    return true;
    	  if (!directory.isDirectory())
    	    return false;

    	  String[] list = directory.list();

    	  if (list != null) {
    	    for (int i = 0; i < list.length; i++) {
    	      File entry = new File(directory, list[i]);

    	      if (entry.isDirectory())
    	      {
    	        if (!removeDirectory(entry))
    	          return false;
    	      }
    	      else
    	      {
    	        if (!entry.delete())
    	          return false;
    	      }
    	    }
    	  }

    	  return directory.delete();
    }
}
