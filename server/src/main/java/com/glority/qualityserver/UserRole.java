package com.glority.qualityserver;


/**
 * user roles in product.
 * 
 * @author liheping
 * 
 */
public enum UserRole {
    ROLE_DEVELOPER("ROLE_DEVELOPER"), ROLE_TECHNICALMANAGER("ROLE_TECHNICALMANAGER"),
    ROLE_BUSINESSOWNER("ROLE_BUSINESSOWNER"), ROLE_ADMIN("ROLE_ADMIN"), ROLE_MARKETING("ROLE_MARKETING"),
    INVALID_ROLE("INVALID_ROLE");

    private String value;

    /**
     * constructor.
     * 
     * @param value
     *            string value of UserRole
     */
    private UserRole(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * get the user role based on the role value.
     * 
     * @param value
     *            String value of UserRole
     * @return UserRole Enum.
     */
    public static UserRole getUserRole(String value) {
        UserRole[] roles = UserRole.values();
        for (UserRole role : roles) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }

        return INVALID_ROLE;
    }
}
