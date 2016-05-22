package com.glority.qualityserver.manager;

import com.glority.qualityserver.model.Role;

/**
 * Role manager interface.
 * 
 * @author liheping
 * 
 */
public interface SystemRoleManager extends GenericManager<Role, Long> {
    /**
     * get the user's role in product.
     * 
     * @param userId
     * @param productId
     * @return
     */
    Role getUserProductRole(long userId, long productId);

    /**
     * Get the user's role in product.
     * @param productId The product id
     * @param roleName The role name.
     * @return Role, if not exists, return null
     */
    Role getUserProductRole(Long productId, String roleName);

    /**
     * validate role.
     * 
     * @param role
     */
    void validate(Role role);
}
