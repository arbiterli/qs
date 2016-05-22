package com.glority.quality.model;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

public class BuildTestInfoTest extends AbstractBaseTaskTest{
	private BuildTestInfo buildTestInfo1;
	private BuildTestInfo buildTestInfo2;
	
	@Before
	public void setUp(){
		buildTestInfo1 = new BuildTestInfo();
		buildTestInfo2 = new BuildTestInfo();
	}

	@Test
	public void testHashCode(){
		buildTestInfo1.setCertification("certification");
		buildTestInfo1.setTimestamp("time");
		buildTestInfo1.setBuild(new Build());
		buildTestInfo1.setTestgroup(new TestGroup());
		assertEquals(834214342, buildTestInfo1.hashCode());
	}
	
	@Test
	public void testEquals(){
		assertEquals(true, buildTestInfo1.equals(buildTestInfo2));
		assertEquals(true, buildTestInfo1.equals(buildTestInfo1));
		assertEquals(false, buildTestInfo1.equals(null));
		assertEquals(false, buildTestInfo1.equals(new String()));
		buildTestInfo1.setBuild(null);
		buildTestInfo2.setBuild(new Build());
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		Build build1 = new Build();
		Build build2 = new Build();
		build1.setId("build1");
		build2.setId("build2");
		buildTestInfo1.setBuild(build1);
		buildTestInfo2.setBuild(build2);
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		buildTestInfo1.setCertification(null);
		buildTestInfo2.setCertification("certification2");
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		buildTestInfo1.setCertification("certification1");
		buildTestInfo2.setCertification("certification2");
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		buildTestInfo1.setTimestamp(null);
		buildTestInfo2.setTimestamp("Timestamp2");
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		buildTestInfo1.setTimestamp("Timestamp1");
		buildTestInfo2.setTimestamp("Timestamp2");
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		buildTestInfo1.setTestgroup(null);
		buildTestInfo2.setTestgroup(new TestGroup());
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
		setUp();
		TestGroup testGroup1 = new TestGroup();
		TestGroup testGroup2 = new TestGroup();
		testGroup1.setId("testGroup1");
		testGroup2.setId("testGroup2");
		buildTestInfo1.setTestgroup(testGroup1);
		buildTestInfo2.setTestgroup(testGroup2);
		assertEquals(false, buildTestInfo1.equals(buildTestInfo2));
	}
}
