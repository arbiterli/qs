package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;

public class ProductDaoHibernateTest extends AbstractBaseTest {

    @Autowired
    private ProductDaoHibernate product;

    @Test
    public void testGetProduct() {
        assertTrue(product.getProduct("") == null);
        assertEquals("Quality System", String.valueOf(product.getProduct("QualitySystem").getDisplayName()));
    }
}
