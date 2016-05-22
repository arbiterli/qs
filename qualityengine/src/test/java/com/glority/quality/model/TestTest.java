package com.glority.quality.model;

import org.junit.Before;

import com.glority.quality.AbstractBaseTaskTest;

public class TestTest extends AbstractBaseTaskTest{
	Test test1;
	Test test2;
	
	@Before
	public void setUp(){
		test1 = new Test();
		test2 = new Test();
	}
	
	@org.junit.Test
	public void testToString(){
		setTestData();
		assertEquals(test1.toString(), "Test [id=id, configurationId=configurationId, " +
				"jenkinsjob=jenkinsjob, jenkinsbuild=jenkinsbuild, result=result]");
	}
	
	@org.junit.Test
	public void testHashCode(){
		setTestData();
		assertEquals(-522982141, test1.hashCode());
	}
	
	@org.junit.Test
	public void testEquals(){
		assertEquals(true, test1.equals(test1));
		assertEquals(true, test1.equals(test2));
		assertEquals(false, test1.equals(null));
		assertEquals(false, test1.equals(new String()));
		test1.setConfigurationId(null);
		test2.setConfigurationId("configurationId");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setConfigurationId("configurationId1");
		test2.setConfigurationId("configurationId2");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setId(null);
		test2.setId("id");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setId("id1");
		test2.setId("id2");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setJenkinsbuild(null);
		test2.setJenkinsbuild("setJenkinsbuild");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setJenkinsbuild("setJenkinsbuild1");
		test2.setJenkinsbuild("setJenkinsbuild2");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setJenkinsjob(null);
		test2.setJenkinsjob("jenkinsjob");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setJenkinsjob("jenkinsjob1");
		test2.setJenkinsjob("jenkinsjob2");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setResult(null);
		test2.setResult("result");
		assertEquals(false, test1.equals(test2));
		setUp();
		test1.setResult("result1");
		test2.setResult("result2");
		assertEquals(false, test1.equals(test2));
	}
	
	public void setTestData(){
		test1.setConfigurationId("configurationId");
		test1.setId("id");
		test1.setJenkinsbuild("jenkinsbuild");
		test1.setJenkinsjob("jenkinsjob");
		test1.setResult("result");
	}
}
