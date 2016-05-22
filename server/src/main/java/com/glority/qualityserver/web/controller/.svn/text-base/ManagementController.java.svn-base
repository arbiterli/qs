package com.glority.qualityserver.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.web.model.VersionExt;

/**
 * ManagentController holds all management request.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("/admin/management")
public class ManagementController extends BasicController {

    /**
     * this method to get the admin page.
     * 
     * @param request
     * @param response
     * @return admin.jsp
     */
    @RequestMapping("/admin")
    public String getAdminPage() {
        return "admin/admin";
    }

    /**
     * this method to get the user management page.
     * 
     * @param request
     * @param response
     * @return usermanagement.jsp
     */
    @RequestMapping("/usermanagement")
    public String getUsermanagementPage(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = this.userService.getAllUser();
        request.setAttribute("userList", userList);
        return "admin/usermanagement";
    }

    /**
     * this method to get the product management page.
     * 
     * @param request
     * @param response
     * @return productmanagement.jsp
     */
    @RequestMapping("/productmanagement")
    public String getProductmanagementPage(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productService.getAllProducts();
        request.setAttribute("productList", productList);
        return "admin/productmanagement";
    }

    /**
     * this method to get the version management page.
     * 
     * @param request
     * @param response
     * @return versionmanagement.jsp
     */
    @RequestMapping("/versionmanagement")
    public String getVersionmanagementPage(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.productService.getAllValidProducts();
        List<Long> idList = this.getAllProductId(productList);
        request.setAttribute("idList", idList);
        return "admin/versionmanagement";
    }

    /**
     * this method to get the error management page.
     * 
     * @param request
     * @param response
     * @return errormanagement.jsp
     */
    @RequestMapping("/errormanagement")
    public String getErrorManagementPage(HttpServletRequest request, HttpServletResponse response) {

        List<com.glority.qualityserver.model.Product> productList = this.productService.getAllValidProducts();
        List<Long> idList = getAllProductId(productList);
        request.setAttribute("idList", idList);

        return "admin/errormanagement";
    }

    /**
     * this method to get the role management page.
     * 
     * @param request
     * @param response
     * @return rolemanagement.jsp
     */
    @RequestMapping("/rolemanagement")
    public String getRoleManagementPage(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = this.userService.getAllUser();
        request.setAttribute("userList", userList);
        return "admin/rolemanagement";
    }

    /**
     * this method to get the role of user page.
     * 
     * @param request
     * @param response
     * @return roleofuser.jsp
     */
    @RequestMapping("/roleofuser")
    public String getRoleOfUserPage(@RequestParam(value = USER_ID, defaultValue = "-1") long userId,
            HttpServletRequest request, HttpServletResponse response) {
        if (userId < 0) {
            return "error";
        }

        User user = this.userService.getUserById(userId);
        request.setAttribute("roles", user.getRoles().toArray());

        return "admin/roleofuser";
    }

    /**
     * this method to get the versionofproduct page.
     * 
     * @param request
     * @param response
     * @return versionofproduct.jsp
     */

    @RequestMapping("/versionofproduct")
    public String getVersionOfProductPage(@RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            HttpServletRequest request, HttpServletResponse response) {
        if (productId < 0) {
            return "error";
        }

        List<VersionExt> versionList = this.versionService.getVersionByProductId(productId);
        request.setAttribute("versionList", versionList);
        return "admin/versionofproduct";
    }

    private List<Long> getAllProductId(List<Product> productList) {
        List<Long> idList = new ArrayList<Long>();
        for (Product product : productList) {
            idList.add(product.getId());
        }
        return idList;
    }
}
