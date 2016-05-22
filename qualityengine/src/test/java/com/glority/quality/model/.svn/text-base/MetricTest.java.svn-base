package com.glority.quality.model;

import org.junit.Before;
import org.junit.Test;

import com.glority.quality.AbstractBaseTaskTest;
import com.glority.quality.Constants.MetricResult;
import com.glority.quality.Constants.MetricType;

public class MetricTest extends AbstractBaseTaskTest{
	private Metric metric1;
	private Metric metric2;
	
	@Before
	public void setUp(){
		metric1 = new Metric();
		metric2 = new Metric();
	}
	
	@Test
	public void testHashCode(){
		metric1.setFailure("failure");
		metric1.setFaileCount(100);
		metric1.setName("metric");
		metric1.setNewValue("1");
		metric1.setOldValue("2");
		assertEquals(-1246582090, metric1.hashCode());
	}
	
	@Test
	public void testEquals(){
		assertEquals(false, metric1.equals(null));
		assertEquals(true, metric1.equals(metric1));
		assertEquals(true, metric1.equals(metric2));
		assertEquals(false, metric1.equals(new String("")));
		metric2.setFaileCount(1);
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setFailure(null);
		metric2.setFailure("");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setFailure("notnull");
		metric2.setFailure("");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setName(null);
		metric2.setName("");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setName("notnull");
		metric2.setName("");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setNewValue(null);
		metric2.setNewValue(1);
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setNewValue(2);
		metric2.setNewValue(1);
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setOldValue(null);
		metric2.setOldValue("1");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setOldValue("2");
		metric2.setOldValue("1");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setTime(null);
		metric2.setTime("1");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setTime("2");
		metric2.setTime("1");
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setResult(MetricResult.METRIC_INVALID);
		metric2.setResult(MetricResult.METRIC_FAIL);
		assertEquals(false, metric1.equals(metric2));
		setUp();
		metric1.setType(MetricType.METRIC_TYPE_COVERAGE);
		metric2.setType(MetricType.METRIC_TYPE_CODEBASEINFO);
		assertEquals(false, metric1.equals(metric2));
	}
}
