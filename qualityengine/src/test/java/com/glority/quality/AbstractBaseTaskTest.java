package com.glority.quality;

import java.io.File;

import org.apache.tools.ant.Project;
import org.junit.Ignore;

import junit.framework.TestCase;
/**
 * The base class for quality engine tasks. 
 * 
 * TODO: will it be better to use Ant BuildFileTest framework that calls the targets 
 * in testtasks build.xml straightly.   
 * 
 * @author XQS
 *
 */
@Ignore
public abstract class AbstractBaseTaskTest extends TestCase{
	public static final String TEST_OUT_PATH = "testtasks" + File.separator + "out";
	public static final String TEST_SAMPLE_REPORTS = "testtasks" + File.separator + "reports";
	public static final String TEST_ROOT = "testtasks";
	protected Project project;	
	protected String qualityXmlPath;
	protected BaseTask task;
	
	public void setUp() {
		project = new Project();
		qualityXmlPath = TEST_OUT_PATH + File.separator + "quality.xml";
		if (task != null) {
		    task.setProject(project);
		    //task.setQualityXmlPath(qualityXmlPath);
		    task.execute();
		}
	}
}
