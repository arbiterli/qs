package com.glority.qualityserver.manager;

import com.glority.qualityserver.model.User;

/**
 * User manager interface.
 * 
 * @author liheping
 * 
 */
public interface SystemUserManager extends GenericManager<User, Long> {
    /**
     * get user by ites username.
     * 
     * @param username
     * @return
     */
    User getUser(String username);

    /**
     * check whether the user exists.
     * 
     * @param username
     * @return
     */
    boolean userNameExists(String username);

}
