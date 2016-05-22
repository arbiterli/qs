package com.glority.qualityserver.web.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.service.Environment;
import com.glority.qualityserver.web.filter.DwrService;

/**
 * Abstract ACLDwr Service class.
 */
public abstract class AbstractACLDwrService implements DwrService {

    @Autowired
    private Environment env;

    /**
     * Get the feature name of this ACL service. The access control will be
     * configured in the ACL security config file
     * 
     * @return the feature name, which is the key in the security config file
     */
    public abstract String getFeatureName();

    @Override
    public final Collection<UserRole> getAllowedRoles() {
        String rolesForFeature = env.getSecurityProperty(getFeatureName());
        if (!StringUtils.hasText(rolesForFeature)) {
            return Collections.emptyList();
        }

        String[] roleNames = rolesForFeature.split(",");
        List<UserRole> roles = new ArrayList<UserRole>(roleNames.length);
        for (String roleName : roleNames) {
            roles.add(UserRole.valueOf(roleName));
        }
        return roles;
    }

}
