package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.UserDao;
import com.glority.qualityserver.manager.SystemUserManager;
import com.glority.qualityserver.model.User;

/**
 * system user manager implementation.
 * 
 * @author liheping
 * 
 */
@Service("systemUserManager")
public class SystemUserManagerImpl extends GenericManagerImpl<User, Long> implements SystemUserManager {
    @Autowired
    private UserDao userDao;

    @Override
    protected GenericDao<User, Long> getDao() {
        return this.userDao;
    }

    public User getUser(String username, String password) {

        return this.userDao.getUser(username, password);

    }

    public boolean userNameExists(String username) {
        User user = this.userDao.getUser(username);

        return user != null;
    }

    public User getUser(String username) {
        User user = this.userDao.getUser(username);
        return user;
    }

}
