package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class ServerDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private ServerDaoHibernate server;

    @Test
    public void testGetPhase() {
        assertEquals(0, server.getAllServersInPhase(0).size());
        assertEquals(2, server.getAllServersInPhase(24).size());
    }
}
