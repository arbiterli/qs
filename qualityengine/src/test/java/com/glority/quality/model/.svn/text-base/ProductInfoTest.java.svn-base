package com.glority.quality.model;

import org.junit.Before;

import com.glority.quality.AbstractBaseTaskTest;

public class ProductInfoTest extends AbstractBaseTaskTest{
	private ProductInfo productInfo1;
	private ProductInfo productInfo2;
	
	@Before
	public void setUp(){
		productInfo1 = new ProductInfo();
		productInfo1 = new ProductInfo();
	}
	
	@org.junit.Test
	public void testHashCode(){
		setUpTestData();
		assertEquals(productInfo1.hashCode(), -1841991376);
	}
	
	@org.junit.Test
	public void testToString(){
		setUpTestData();
		assertEquals(productInfo1.toString(), "ProductInfo [businessUnit=businessUnit, productName=productName, " +
				"productVersion=productVersion, svnUrl=svnUrl, svnRevision=svnRevision, productVersionId=productVersionId]");
	}
	
	@org.junit.Test
	public void testEquals(){
		assertEquals(false, productInfo1.equals(productInfo2));
		assertEquals(true, productInfo1.equals(productInfo1));
		assertEquals(false, productInfo1.equals(null));
		assertEquals(false, productInfo1.equals(new String()));
		productInfo1.setBusinessUnit(null);
		productInfo1.setBusinessUnit("businessUnit");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setBusinessUnit("businessUnit1");
		productInfo1.setBusinessUnit("businessUnit2");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setProductName(null);
		productInfo1.setProductName("productName");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setProductName("productName1");
		productInfo1.setProductName("productName2");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setProductVersion(null);
		productInfo1.setProductVersion("productVersion");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setProductVersion("productVersion1");
		productInfo1.setProductVersion("productVersion2");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setProductVersionId(null);
		productInfo1.setProductVersionId("productVersionId");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setProductVersionId("productVersionId1");
		productInfo1.setProductVersionId("productVersionId2");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setSvnRevision(null);
		productInfo1.setSvnRevision("svnRevision");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setSvnRevision("svnRevision1");
		productInfo1.setSvnRevision("svnRevision2");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setSvnUrl(null);
		productInfo1.setSvnUrl("svnUrl");
		assertEquals(false, productInfo1.equals(productInfo2));
		setUp();
		productInfo1.setSvnUrl("svnUrl1");
		productInfo1.setSvnUrl("svnUrl2");
		assertEquals(false, productInfo1.equals(productInfo2));
	}
	
	public void setUpTestData(){
		productInfo1.setBusinessUnit("businessUnit");
		productInfo1.setProductName("productName");
		productInfo1.setProductVersion("productVersion");
		productInfo1.setProductVersionId("productVersionId");
		productInfo1.setSvnRevision("svnRevision");
		productInfo1.setSvnUrl("svnUrl");
	}
}
