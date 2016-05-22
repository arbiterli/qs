package com.glority.qualityserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.glority.quality.StringUtil;
import com.glority.qualityserver.web.filter.QualityServerACLFilter;

/**
 * Security Settings. This class load the config in PERMISSION_SETTING_FILE=security.properties.
 * then divide the config into role based parts.
 * A permission record in the file should like <feature>=<role1>,<role2>...
 * 
 * @author liheping
 * 
 */
public final class SecuritySettings {
    public static final String HOT_DEPLOY = "hotDeploy";
    public static final String BASE_DEPLOY = "baseDeploy";

    private static final Logger LOGGER = Logger.getLogger(SecuritySettings.class);

    private static final String PERMISSION_SETTING_FILE = "security.properties";

    private Map<UserRole, Set<String>> rolePermissions;
    private Set<String> securities;
    private static final SecuritySettings INSTANCE = new SecuritySettings();

    private SecuritySettings() {
        this.securities = new HashSet<String>();
        this.rolePermissions = new HashMap<UserRole, Set<String>>();
        try {
            Properties props = new Properties();
            props.load(QualityServerACLFilter.class.getClassLoader().getResourceAsStream(PERMISSION_SETTING_FILE));
            for (Map.Entry<?, ?> security : props.entrySet()) {
                String securityName = (String) security.getKey();
                String roles = (String) security.getValue();
                List<String> roleList = StringUtil.splitByComma(roles);
                for (String role : roleList) {
                    UserRole userRole = UserRole.getUserRole(role);
                    Set<String> securityNameSet = this.rolePermissions.get(userRole);
                    if (securityNameSet == null) {
                        securityNameSet = new HashSet<String>();
                        this.rolePermissions.put(userRole, securityNameSet);
                    }

                    if (!securityNameSet.contains(securityName)) {
                        securityNameSet.add(securityName);
                    }

                    if (!this.securities.contains(securityName)) {
                        this.securities.add(securityName);
                    }
                }

            }
        } catch (IOException e) {
            LOGGER.error("Load application settings failed");
        }
    }

    public static SecuritySettings getInstance() {
        return INSTANCE;
    }
    /**
     * get the role's all allowed permissions.
     * @param roleStr
     * @return
     */
    public Set<String> getRolePermissions(String roleStr) {
        UserRole role = UserRole.getUserRole(roleStr);
        Set<String> permissions = rolePermissions.get(role);
        return permissions == null ? new HashSet<String>() : permissions;
    }

    /**
     * get all security parts which is controlled by the property file.
     * @return
     */
    public Set<String> getAllSecurities() {
        return this.securities;
    }

    /**
     * check whether the role hase permission for the security part.
     * @param role
     * @param security
     * @return
     */
    public boolean roleHasPermission(String role, String security) {
        Set<String> securitySet = this.getRolePermissions(role);
        return securitySet.contains(security);
    }
}
