/**
 * 
 */
package com.glority.qualityserver.web.service;

import java.util.List;

import com.glority.qualityserver.model.Role;

/**
 * Role Service.
 * 
 * @author User
 * 
 */
public interface RoleService {

    Role modifyRole(Role role);

    List<Role> getAllRole();

    /**
     * get role by id.
     * 
     * @param id
     * @return
     */
    Role getRole(long id);
}
