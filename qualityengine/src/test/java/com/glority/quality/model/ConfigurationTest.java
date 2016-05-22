package com.glority.quality.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

public class ConfigurationTest extends AbstractBaseTaskTest{
	private Configuration configuration1;
	private Configuration configuration2;
	
	@Before
	public void setUp(){
		configuration1 = new Configuration();
		configuration2 = new Configuration();
	}
	
	@Test
	public void testHashCode(){
		configuration1.setId("name");
		configuration1.setEnvironments(new Environments());
		configuration1.setSoftwares(new ArrayList<String>());
		assertEquals(133243860, configuration1.hashCode());
	}
	
	@Test
	public void testEquals(){
		assertEquals(true, configuration1.equals(configuration1));
		assertEquals(true, configuration1.equals(configuration2));
		configuration2 = null;
		assertEquals(false, configuration1.equals(configuration2));
		assertEquals(false, configuration1.equals(new String()));
		setUp();
		configuration1.setEnvironments(null);
		configuration2.setEnvironments(new Environments());
		assertEquals(false, configuration1.equals(configuration2));
		setUp();
		Environments environments1 = new Environments();
		Environments environments2 = new Environments();
		environments1.setLanguage("language1");
		environments2.setLanguage("language2");
		configuration1.setEnvironments(environments1);
		configuration2.setEnvironments(environments2);
		assertEquals(false, configuration1.equals(configuration2));
		setUp();
		configuration1.setId(null);
		configuration2.setId("id2");
		assertEquals(false, configuration1.equals(configuration2));
		setUp();
		configuration1.setId("id1");
		configuration2.setId("id2");
		assertEquals(false, configuration1.equals(configuration2));
		setUp();
		configuration1.setSoftwares(null);
		configuration2.setSoftwares(new ArrayList<String>());
		assertEquals(false, configuration1.equals(configuration2));
		setUp();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("1");
		list2.add("2");
		configuration1.setSoftwares(list1);
		configuration2.setSoftwares(list2);
		assertEquals(false, configuration1.equals(configuration2));
		
	}
}
