package com.glority.qualityserver.dao;

import com.glority.qualityserver.model.Role;

/**
 * Role DAO interface.
 * 
 * @author liheping
 * 
 */
public interface RoleDao extends GenericDao<Role, Long> {
    /**
     * get user's role in product.
     * 
     * @param userId
     *            the user's id
     * @param productId
     *            the product id
     * @return Role, if not exists, return null
     */
    Role getUserProductRole(long userId, long productId);

    /**
     * Get user's role in product.
     * @param productId The product id
     * @param name The role name.
     * @return Role, if not exists, return null
     */
    Role getUserProductRole(long productId, String name);

}
