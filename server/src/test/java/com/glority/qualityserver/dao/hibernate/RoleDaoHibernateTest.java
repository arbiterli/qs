package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class RoleDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private RoleDaoHibernate role;

    @Test
    public void testGetPhase() {
        assertTrue(role.getUserProductRole(0, 0) == null);
        assertEquals("ROLE_BUSINESSOWNER", role.getUserProductRole(5, 3).getName());
    }
}
