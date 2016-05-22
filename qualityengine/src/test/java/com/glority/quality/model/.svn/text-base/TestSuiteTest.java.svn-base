package com.glority.quality.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.glority.quality.AbstractBaseTaskTest;

public class TestSuiteTest extends AbstractBaseTaskTest{
	private TestSuite testSuite1;
	private TestSuite testSuite2;
	
	@Before
	public void setUp(){
		testSuite1 = new TestSuite();
		testSuite2 = new TestSuite();
	}
	
	@org.junit.Test
	public void testHashCode(){
		testSuite1.setConfigurationId("configurationId");
		testSuite1.setTestCases(new ArrayList<TestCase>());
		testSuite1.setTestId("testId");
		testSuite1.setType("type");
		assertEquals(-632635266, testSuite1.hashCode());
	}
	
	@org.junit.Test
	public void testEquals(){
		assertEquals(true, testSuite1.equals(testSuite2));
		assertEquals(true, testSuite1.equals(testSuite1));
		assertEquals(false, testSuite1.equals(null));
		assertEquals(false, testSuite1.equals(new String()));
		
		testSuite1.setConfigurationId(null);
		testSuite2.setConfigurationId("configurationId");
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		testSuite1.setConfigurationId("configurationId1");
		testSuite2.setConfigurationId("configurationId2");
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		testSuite1.setTestId(null);
		testSuite2.setTestId("testId");
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		testSuite1.setTestId("testId1");
		testSuite2.setTestId("testId2");
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		testSuite1.setType(null);
		testSuite2.setType("type");
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		testSuite1.setType("type1");
		testSuite2.setType("type2");
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		testSuite1.setTestCases(null);
		testSuite2.setTestCases(new ArrayList<TestCase>());
		assertEquals(false, testSuite1.equals(testSuite2));
		setUp();
		List<TestCase> list1 = new ArrayList<TestCase>();
		List<TestCase> list2 = new ArrayList<TestCase>();
		TestCase tc1 = new TestCase();
		TestCase tc2 = new TestCase();
		tc1.setName("tc1");
		tc2.setName("tc2");
		list1.add(tc1);
		list2.add(tc2);
		testSuite1.setTestCases(list1);
		testSuite2.setTestCases(list2);
		assertEquals(false, testSuite1.equals(testSuite2));
	}
}
