package com.glority.quality.model;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

public class BuildTest extends AbstractBaseTaskTest{
	private Build build1;
	private Build build2;
	
	@Before
	public void setUp(){
		build1 = new Build();
		build2 = new Build();
	}
	
	@Test
	public void testHashCode(){
		setTestData();
		assertEquals(-599345292, build1.hashCode());
	}
	
	@Test
	public void testToString(){
		setTestData();
		assertEquals("Build [id=id, jenkinsbuild=build, jenkinsjob=job, result=result]", build1.toString());
	}
	
	@Test
	public void testEquals(){
		assertEquals(true, build1.equals(build1));
		assertEquals(true, build1.equals(build2));
		build2 = null;
		assertEquals(false, build1.equals(build2));
		assertEquals(false, build1.equals(new String()));
		setUp();
		build1.setId(null);
		build2.setId("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setId("id");
		build2.setId("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setJenkinsbuild(null);
		build2.setJenkinsbuild("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setJenkinsbuild("build");
		build2.setJenkinsbuild("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setJenkinsjob(null);
		build2.setJenkinsjob("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setJenkinsjob("job");
		build2.setJenkinsjob("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setResult(null);
		build2.setResult("notnull");
		assertEquals(false, build1.equals(build2));
		setUp();
		build1.setResult("result");
		build2.setResult("notnull");
		assertEquals(false, build1.equals(build2));
	}
	
	public void setTestData(){
		build1.setId("id");
		build1.setJenkinsbuild("build");
		build1.setJenkinsjob("job");
		build1.setResult("result");
	}

}
