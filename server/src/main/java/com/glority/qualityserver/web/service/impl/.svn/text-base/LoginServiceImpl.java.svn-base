package com.glority.qualityserver.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.service.LoginService;

/**
 * Login service implementation.
 * 
 * @author liheping
 * 
 */
@Service("loginService")
public class LoginServiceImpl extends DBBaseService implements LoginService {
    @Autowired
    private AccessControlService aclService;

    // public User login(String username, String password) {
    // String encodePassword = MD5.getMD5ofStr(password);
    // User user = this.userManager.getUser(username, encodePassword);
    // return user;
    // }

    public boolean canUserAccessProduct(String username, long productId) {
        User user = super.userManager.getUser(username);
        Product product = super.productManager.get(productId);

        if (user != null && product != null) {
            if (!this.aclService.getRoles(user, product).isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
