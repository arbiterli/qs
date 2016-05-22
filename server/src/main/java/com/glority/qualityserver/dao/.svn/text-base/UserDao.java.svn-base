package com.glority.qualityserver.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.glority.qualityserver.model.User;

/**
 * User DAO interface.
 */
public interface UserDao extends GenericDao<User, Long> {

    /**
     * Gets users information based on login name.
     * 
     * @param username
     *            the user's username
     * @return userDetails populated userDetails object
     */
    @Transactional
    UserDetails loadUserByUsername(String username);

    /**
     * Get user by username and password.
     * 
     * @param username
     *            the user's username
     * @param password
     *            the user's password
     * @return the specified user, if not exists, return null
     */
    User getUser(String username, String password);

    /**
     * get user by username.
     * 
     * @param username
     *            the user's username
     * @return the user, if not exists, return null.
     */
    User getUser(String username);

}
