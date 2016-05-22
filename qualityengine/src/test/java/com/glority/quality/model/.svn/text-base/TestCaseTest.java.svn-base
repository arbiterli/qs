package com.glority.quality.model;

import org.junit.Before;

import com.glority.quality.AbstractBaseTaskTest;

public class TestCaseTest extends AbstractBaseTaskTest{
	private TestCase testCase1;
	private TestCase testCase2;
	private TestCase testCase3;
	private TestCase testCase4;
	
	@Before
	public void setUp(){
		testCase1 = new TestCase();
		testCase2 = new TestCase();
		testCase3 = new TestCase();
		testCase4 = new TestCase();
	}
	
	@org.junit.Test
	public void testHashCode(){
		testCase1.setName("name");
		testCase1.setResult("result");
		testCase1.setSvnRevision("svnRevision");
		testCase1.setSvnUrl("svnUrl");
		testCase1.setTime("time");
		testCase3.setName("name");
		testCase3.setResult("result");
		testCase3.setSvnRevision("svnRevision");
		testCase3.setSvnUrl("svnUrl");
		testCase3.setTime("time");
		testCase4.setName("otherName");
		testCase4.setResult("result");
		testCase4.setSvnRevision("svnRevision");
		testCase4.setSvnUrl("svnUrl");
		testCase4.setTime("time");
		assertEquals(testCase1.hashCode(), testCase3.hashCode());
		assertFalse(testCase1.hashCode() == testCase4.hashCode());
	}
	
	@org.junit.Test
	public void testEquals(){
		assertEquals(true, testCase1.equals(testCase1));
		assertEquals(true, testCase1.equals(testCase2));
		assertEquals(false, testCase1.equals(null));
		assertEquals(false, testCase1.equals(new String()));
		testCase1.setName(null);
		testCase2.setName("name");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setName("name1");
		testCase2.setName("name2");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setResult(null);
		testCase2.setResult("result");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setResult("result1");
		testCase2.setResult("result2");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setSvnUrl(null);
		testCase2.setSvnUrl("svnUrl");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setSvnUrl("svnUrl1");
		testCase2.setSvnUrl("svnUrl2");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setSvnRevision(null);
		testCase2.setSvnRevision("svnRevision");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setSvnRevision("svnRevision1");
		testCase2.setSvnRevision("svnRevision2");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setTime(null);
		testCase2.setTime("time");
		assertEquals(false, testCase1.equals(testCase2));
		setUp();
		testCase1.setTime("time1");
		testCase2.setTime("time2");
		assertEquals(false, testCase1.equals(testCase2));
		
	}
}
