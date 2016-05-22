package com.glority.quality.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.glority.quality.AbstractBaseTaskTest;

public class TestGroupTest extends AbstractBaseTaskTest{
	private TestGroup testGroup1;
	private TestGroup testGroup2;
	
	@Before
	public void setUp(){
		testGroup1 = new TestGroup();
		testGroup2 = new TestGroup();
	}
	
	@org.junit.Test
	public void testHashCode(){
		testGroup1.setId("id");
		testGroup1.setTests(new ArrayList<Test>());
		assertEquals(104967, testGroup1.hashCode());
	}
	
	@org.junit.Test
	public void testEquals(){
		assertEquals(true, testGroup1.equals(testGroup1));
		assertEquals(true, testGroup1.equals(testGroup2));
		assertEquals(false, testGroup1.equals(null));
		assertEquals(false, testGroup1.equals(new String()));
		testGroup1.setId(null);
		testGroup2.setId("id");
		assertEquals(false, testGroup1.equals(testGroup2));
		setUp();
		testGroup1.setId("id1");
		testGroup2.setId("id2");
		assertEquals(false, testGroup1.equals(testGroup2));
		setUp();
		testGroup1.setTests(null);
		testGroup2.setTests(new ArrayList<Test>());
		assertEquals(false, testGroup1.equals(testGroup2));
		setUp();
		List<Test> list1 = new ArrayList<Test>();
		List<Test> list2 = new ArrayList<Test>();
		Test test1 = new Test();
		Test test2 = new Test();
		test1.setId("id1");
		test2.setId("id2");
		list1.add(test1);
		list2.add(test2);
		testGroup1.setTests(list1);
		testGroup2.setTests(list2);
		assertEquals(false, testGroup1.equals(testGroup2));
	}
}
