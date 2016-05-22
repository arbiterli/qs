package com.glority.qualityserver.web.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.exception.NoDataException;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.service.SystemUserService;

/**
 * system user service implementation.
 * 
 * @author liheping
 * 
 */
@Service("systemUserService")
public class SystemUserServiceImpl extends DBBaseService implements SystemUserService {

    public User createUser(String name, String email, String password) {
        if (super.userManager.userNameExists(email)) {
            return null;
        }
        // String encodePassword = MD5.getMD5ofStr(password);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setCreatedAt(new Timestamp(new Date().getTime()));

        return super.userManager.save(user);
    }

    public String getUserRoleInProduct(long userId, long productId) {
        Role role = super.roleManager.getUserProductRole(userId, productId);

        return role == null ? null : role.getName();
    }

    public void updateUserProductRole(long userId, long productId, UserRole userRole) {
        Role role = super.roleManager.getUserProductRole(userId, productId);
        if (role != null) {
            // role exist.
            // if (UserRole.INVALID_ROLE == userRole) {
            // super.roleManager.remove(role.getId());
            // } else {
            // role.setName(userRole.toString());
            // super.roleManager.save(role);
            // }
            role.setName(userRole.toString());
            super.roleManager.save(role);
        } else {
            if (UserRole.INVALID_ROLE != userRole) {
                role = new Role();

                role.setName(userRole.toString());
                role.setProductId(productId);
                User user = super.userManager.get(userId);
                role.setUser(user);

                super.roleManager.save(role);
            }
        }

    }

    @Override
    public List<User> getAllUser() {
        return super.userManager.getAll();
    }

    public User modifyUserInfo(User user) {
        User existUser = super.userManager.get(user.getId());
        if (existUser == null) {
            throw new NoDataException();
        }
        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());
        return super.userManager.save(existUser);

    }

    public User getUserById(long userId) {
        return super.userManager.get(userId);
    }
}
