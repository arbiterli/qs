package com.glority.quality.model;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;
import com.glority.quality.Constants.Language;

public class EnvironmentsTest extends AbstractBaseTaskTest{
	private Environments environments1;
	private Environments environments2;
	
	@Before
	public void setUp(){
		environments1 = new Environments();
		environments2 = new Environments();
	}
	
	@Test
	public void testHashCode(){
		environments1.setArch("arch");
		environments1.setLanguage(Language.JAVA.toString());
		environments1.setOs("os");
		assertEquals(-1339214025, environments1.hashCode());
	}
	
	@Test
	public void testEquals(){
		assertEquals(true, environments1.equals(environments1));
		assertEquals(true, environments1.equals(environments2));
		assertEquals(false, environments1.equals(new String()));
		assertEquals(false, environments1.equals(null));
		environments1.setArch(null);
		environments2.setArch("arch");
		assertEquals(false, environments1.equals(environments2));
		setUp();
		environments1.setArch("arch1");
		environments2.setArch("arch2");
		assertEquals(false, environments1.equals(environments2));
		setUp();
		environments1.setLanguage(null);
		environments2.setLanguage(Language.JAVA.toString());
		assertEquals(false, environments1.equals(environments2));
		setUp();
		environments1.setLanguage(Language.CPP.toString());
		environments2.setLanguage(Language.JAVA.toString());
		assertEquals(false, environments1.equals(environments2));
		setUp();
		environments1.setOs(null);
		environments2.setOs("os");
		assertEquals(false, environments1.equals(environments2));
		setUp();
		environments1.setOs("os1");
		environments2.setOs("os2");
		assertEquals(false, environments1.equals(environments2));
	}
}
