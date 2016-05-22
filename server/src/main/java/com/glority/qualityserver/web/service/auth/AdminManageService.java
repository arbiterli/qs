package com.glority.qualityserver.web.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.web.controller.BasicController;
import com.glority.qualityserver.web.model.VersionExt;
import com.glority.qualityserver.web.service.ProductService;
import com.glority.qualityserver.web.service.RoleService;
import com.glority.qualityserver.web.service.SystemUserService;
import com.glority.qualityserver.web.service.VersionService;

/**
 * admin service.
 * 
 * @author Administrator
 * 
 */
@RemoteProxy(name = "adminService")
public class AdminManageService extends AbstractACLDwrService {
    private static final Logger LOGGER = Logger.getLogger(AdminManageService.class);

    @Autowired
    private ProductService productService;
    @Autowired
    private VersionService versionService;
    @Autowired
    private SystemUserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public String getFeatureName() {
        return "ADMIN";
    }

    @RemoteMethod
    public Map<String, Object> modifyUser(User user) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            User dbUser = this.userService.modifyUserInfo(user);
            result.put(BasicController.STATUS, Constants.SUCCESS);
            result.put(BasicController.USER_ID, dbUser.getId());
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result.put(BasicController.STATUS, Constants.FAIL);
        }

        return result;
    }

    @RemoteMethod
    public Map<String, Object> modifyProduct(Product product) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Product dbProduct = this.productService.modifyProductInfo(product);
            result.put(BasicController.STATUS, Constants.SUCCESS);
            result.put(BasicController.PRODUCT_ID, dbProduct.getId());
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result.put(BasicController.STATUS, Constants.FAIL);
        }
        return result;
    }

    @RemoteMethod
    public Map<String, Object> modifyVersion(VersionExt versionExt) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Version dbVersion = this.versionService.modifyVersion(versionExt.getWrappedVersion());
            result.put(BasicController.STATUS, Constants.SUCCESS);
            result.put(BasicController.VERSION_ID, dbVersion.getId());
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result.put(BasicController.STATUS, Constants.FAIL);
        }
        return result;
    }

    @RemoteMethod
    public Map<String, Object> modifyRole(Role role) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Role dbRole = this.roleService.modifyRole(role);
            result.put(BasicController.STATUS, Constants.SUCCESS);
            result.put(BasicController.VERSION_ID, dbRole.getId());
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            result.put(BasicController.STATUS, Constants.FAIL);
        }
        return result;
    }
}
