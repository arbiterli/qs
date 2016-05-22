package com.glority.qualityserver.web.service;

import java.util.List;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.model.User;

/**
 * System user service.
 * 
 * @author liheping
 * 
 */
public interface SystemUserService {
    /**
     * create a user.
     * 
     * @param name
     * @param email
     * @param password
     * @throws Exception
     */
    User createUser(String name, String email, String password);

    /**
     * get All users.
     * 
     * @return list of User.
     */
    List<User> getAllUser();

    /**
     * modify user info.email and name.
     * 
     * @param id
     * @param name
     * @param email
     */
    User modifyUserInfo(User user);

    /**
     * get user's role in product.
     * 
     * @param userId
     * @param productId
     * @return
     */
    String getUserRoleInProduct(long userId, long productId);

    /**
     * update user's product role.
     * 
     * @param userId
     * @param productId
     * @param role
     */
    void updateUserProductRole(long userId, long productId, UserRole role);

    /**
     * get user by Name.
     * 
     * @param userName
     * @return User
     */
    User getUserById(long userId);

}
