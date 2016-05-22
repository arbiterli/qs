/**
 * 
 */
package com.glority.qualityserver.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.glority.qualityserver.exception.NoDataException;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.web.service.RoleService;

/**
 * role service implementation.
 * 
 * @author User
 * 
 */
@Service("roleService")
public class RoleServiceImpl extends DBBaseService implements RoleService {

    public Role modifyRole(Role role) {
        super.roleManager.validate(role);
        Role existRole = super.roleManager.get(role.getId());
        if (existRole == null) {
            throw new NoDataException();
        }
        existRole.setScope(role.getScope());
        existRole.setProductId(role.getProductId());
        existRole.setName(role.getName());

        return super.roleManager.save(existRole);
    }

    public List<Role> getAllRole() {
        return super.roleManager.getAll();
    }

    @Override
    public Role getRole(long id) {
        return super.roleManager.get(id);
    }
}
