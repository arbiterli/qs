package com.glority.qualityserver.manager.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.dao.ProductDao;
import com.glority.qualityserver.dao.UserDao;
import com.glority.qualityserver.manager.SystemRoleManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.ScoreOwnerMapping;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.web.model.ScoreOwner;

/**
 * Test cases for ScoreOwnerManager.
 * 
 * @author cz
 * 
 */
public class ScoreOwnerMappingManagerImplTest extends AbstractBaseTest {

    @Autowired
    private ScoreOwnerMappingManagerImpl manager;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SystemRoleManager roleManager;

    @Test
    public void testGetScoreOwner() {
        String childScoreName = "JAVA MI";
        String parentScoreName = "BUILD SCORE";
        Product product = productDao.getProduct("QualitySystem");
        User user = (User) userDao.loadUserByUsername("unit_test");
        user.setEmail("test@glority.com");

        Role role = new Role();
        role.setName("ROLE_MANAGER");
        role.setProductId(product.getId());
        role.setUser(user);
        this.roleManager.save(role);

        ScoreOwnerMapping ownerMapping = manager.saveScoreOwner(product, parentScoreName, user);
        assertEquals(parentScoreName, ownerMapping.getScoreName());

        assertTrue(manager.getScoreOwner(product.getId(), childScoreName).size() > 0);
    }

    @Test
    public void testGetScoreOwnerDirectScore() {
        String parentScoreName = "BUILD SCORE";
        Product product = productDao.getProduct("QualitySystem");
        User user = (User) userDao.loadUserByUsername("unit_test");
        user.setEmail("test@glority.com");

        Role role = new Role();
        role.setName("ROLE_MANAGER");
        role.setProductId(product.getId());
        role.setUser(user);
        this.roleManager.save(role);

        ScoreOwnerMapping ownerMapping = manager.saveScoreOwner(product, parentScoreName, user);
        assertEquals(parentScoreName, ownerMapping.getScoreName());

        List<ScoreOwner> scoreOwners = manager.getScoreOwner(product.getId(), parentScoreName);
        Set<String> contacts = new HashSet<String>();
        for (ScoreOwner owner : scoreOwners) {
            contacts.add(owner.getContactName());
        }
        assertTrue(contacts.contains("unit_test"));
    }
}