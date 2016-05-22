package com.glority.quality.model;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;

public class CurrentStatusTest extends AbstractBaseTaskTest{
	private CurrentStatus currentStatus;
	
	@Before
	public void setUp(){
		currentStatus = new CurrentStatus();
	}
	
	@Test
	public void testSetStatus(){
		currentStatus.setStatus("Ok");
		assertEquals(CurrentStatus.STATUS_OK, currentStatus.getStatus());
		currentStatus.setStatus("CRitiCAL");
		assertEquals(CurrentStatus.STATUS_CRITICAL, currentStatus.getStatus());
		currentStatus.setStatus("WarnING");
		assertEquals(CurrentStatus.STATUS_WARNING, currentStatus.getStatus());
		currentStatus.setStatus("UNknoWN");
		assertEquals(CurrentStatus.STATUS_UNKNOWN, currentStatus.getStatus());
		currentStatus.setStatus("CurrentStatus");
		assertEquals(CurrentStatus.STATUS_PENDING, currentStatus.getStatus());
	}

}
