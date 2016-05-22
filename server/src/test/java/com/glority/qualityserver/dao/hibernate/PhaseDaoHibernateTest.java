package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class PhaseDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private PhaseDaoHibernate phase;

    @Test
    public void testGetPhase() {
        assertTrue(phase.getPhase(0, "test") == null);
        assertEquals("91", String.valueOf(phase.getPhase(1, "test").getDefaultBuild()));
    }
}
