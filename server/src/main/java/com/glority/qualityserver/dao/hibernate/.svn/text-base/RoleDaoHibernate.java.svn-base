package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.RoleDao;
import com.glority.qualityserver.model.Role;

/**
 * Hibernate implementation for Role DAO.
 * 
 * @author liheping
 * 
 */
@Repository("roleDao")
public class RoleDaoHibernate extends GenericDaoHibernate<Role, Long> implements RoleDao {

    /**
     * Default constructor.
     */
    public RoleDaoHibernate() {
        super(Role.class);
    }

    /**
     * get user's role in product.
     * 
     * @param userId
     *            the user's id
     * @param productId
     *            the product id
     * @return Role, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public Role getUserProductRole(long userId, long productId) {
        List<Role> roleList = super.getHibernateTemplate().find("from Role where user_id=? and product_id=?",
                new Object[] { Long.valueOf(userId), Long.valueOf(productId) });

        if (roleList == null || roleList.isEmpty()) {
            return null;
        }

        return roleList.get(0);
    }

    /**
     * Get user's role in product.
     * @param productId The product id
     * @param name The role name.
     * @return Role, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public Role getUserProductRole(long productId, String name) {
        List<Role> roleList = super.getHibernateTemplate().find("from Role where product_id=? and name=?",
                new Object[] { Long.valueOf(productId), name });

        if (roleList == null || roleList.isEmpty()) {
            return null;
        }

        return roleList.get(0);
    }

}
