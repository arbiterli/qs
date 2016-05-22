package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.RoleDao;
import com.glority.qualityserver.manager.SystemRoleManager;
import com.glority.qualityserver.model.Role;

/**
 * system role manager impelementation.
 * 
 * @author liheping
 * 
 */
@Service("systemRoleManager")
public class SystemRoleManagerImpl extends GenericManagerImpl<Role, Long> implements SystemRoleManager {

    @Autowired
    private RoleDao roleDao;

    @Override
    protected GenericDao<Role, Long> getDao() {
        return this.roleDao;
    }

    public Role getUserProductRole(long userId, long productId) {
        return this.roleDao.getUserProductRole(userId, productId);
    }

    /**
     * Get the user's role in product.
     * @param productId The product id
     * @param roleName The role name.
     * @return Role, if not exists, return null
     */
    public Role getUserProductRole(Long productId, String roleName) {
        return this.roleDao.getUserProductRole(productId, roleName);
    }

    @Override
    public void validate(Role role) {
        // TODO Auto-generated method stub
    }

}
