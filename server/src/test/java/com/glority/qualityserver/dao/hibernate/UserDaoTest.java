package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.TestUtil;
import com.glority.qualityserver.dao.UserDao;
import com.glority.qualityserver.model.User;

/**
 * Junit test for UserDao.
 * 
 * @author Chenhong
 * 
 */
public class UserDaoTest extends AbstractBaseTest {

    private static final String USER_NAME = "test_user";
    private static final String PASSWORD = "password";

    @Autowired
    private UserDao userDao;

    private User user;

    @Before
    public void setUp() {
        user = TestUtil.createUser(USER_NAME, PASSWORD);
        userDao.save(user);
    }

    @Test
    public void testGetUser() {
        User ret = userDao.getUser(USER_NAME);
        assertEquals(USER_NAME, ret.getLogin());
        assertEquals(PASSWORD, ret.getPassword());
    }

    @Test
    public void testGetUserByLoginName() {
        User ret = userDao.getUser(USER_NAME, "invalid_password");
        assertNull(ret);

        ret = userDao.getUser(USER_NAME, PASSWORD);
        assertEquals(USER_NAME, ret.getLogin());
        assertEquals(PASSWORD, ret.getPassword());
    }

    @Test
    public void testLoadUserByUsername() {
        User ret = (User) userDao.loadUserByUsername(USER_NAME);
        assertEquals(USER_NAME, ret.getLogin());
        assertEquals(PASSWORD, ret.getPassword());

        User newUser = (User) userDao.loadUserByUsername("does_not_exist");
        assertNotNull(newUser);
        assertEquals("does_not_exist", newUser.getUsername());
    }

}
