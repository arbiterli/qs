package com.glority.qualityserver.web.filter;

import java.util.Collection;

import com.glority.qualityserver.UserRole;

/**
 * DwrService interface.
 * @author xxd
 */
public interface DwrService {
    /**
     * Get all roles allowed to access this service. The access control is
     * restricted on all remote method of this service. If the current login has
     * any role returned by this method, the access is allowed. Or the access is
     * rejected. If empty collection returned, no access is allowed for any
     * login.
     *
     * @return the collections roles for this service.
     */
    Collection<UserRole> getAllowedRoles();
}
