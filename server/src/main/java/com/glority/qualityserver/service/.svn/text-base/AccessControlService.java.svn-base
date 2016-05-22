package com.glority.qualityserver.service;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;

import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.web.filter.GetProduct;

/**
 * This is the service to process access controls The qualityserver managed the access by role on product.
 * 
 * @author XQS
 * 
 */
public interface AccessControlService {
    /**
     * Get the list of products the user can access.
     * 
     * @param user
     * @return
     */
    List<Product> getAuthorizedProducts(User user);

    /**
     * Update the user authority base on the picked product.
     * 
     * @param user
     * @param p
     */
    void setAuthority(User user, Product p);

    /**
     * Get the role on the product of the given user.
     * 
     * @return
     */
    Set<Role> getRoles(User user, Product p);

    /**
     * Get the current user of the session.
     * 
     * @return
     */
    User getCurrentUser();

    /**
     * Get the product that is currently selected.
     * 
     * @return
     */
    Product getCurrentProduct(ServletRequest request);

    /**
     * get product by the param.
     * 
     * @param id
     * @param paramName
     * @return
     */
    Product getProduct(Object param, GetProduct.ProductParamName paramName);

}
