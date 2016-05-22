package com.glority.qualityserver.web.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.service.Environment;

/**
 * Access controll filter.
 * 
 * @author liheping update by clb
 * 
 */
public class QualityServerACLFilter extends GenericFilterBean {
    private static final Logger LOGGER = Logger.getLogger(QualityServerACLFilter.class);
    /**
     * Used as attribute name for the View Layer. The usage on the View Layer should be like <c:if
     * test='${permissionSetting.feature}'>security area of the feature </c:if>
     */
    private static final String PERMISSION_SETTING_VIEWNAME = "permissionSetting";

    private static final String WEB_SERVICE = "webservice";

    private static final String QUALITY_SERVER_COPYRIGHT = "copyright";

    private static final String PASSING_SCORE = "passingScore";

    private static final String EXCELLENT_SCORE = "excellentScore";
    /**
     * Ingore the self sign cert of CAS server
     * 
     * TODO: This is not the best place to keep this block of code.
     * 
     */
    static {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("quality.glority.com")) {
                    return true;
                }
                return false;
            }
        });
    }

    @Autowired
    private AccessControlService acl;

    @Autowired
    private Environment env;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        User currentUser = this.acl.getCurrentUser();
        if (currentUser != null) {
            Product currentProduct = acl.getCurrentProduct(request);
            this.acl.setAuthority(currentUser, currentProduct);
            LOGGER.info("Product : " + currentProduct + "current user " + currentUser);
            // TODO set the security settings. Maybe this should be add more logics here, not only not null
            if (this.shouldRequestAddPermissionSettings(request, currentProduct)) {
                Map<String, Boolean> permissions = getPermissionSetting(currentUser, currentProduct);
                LOGGER.debug(permissions);
                request.setAttribute(PERMISSION_SETTING_VIEWNAME, permissions);
            }
        } else {
            LOGGER.debug("User is empty");
        }
        request.setAttribute(Constants.USER, currentUser);
        request.setAttribute(QUALITY_SERVER_COPYRIGHT, getCopyright());
        request.setAttribute(PASSING_SCORE, Constants.PASSING_SCORE);
        request.setAttribute(EXCELLENT_SCORE, Constants.EXCELLENT_SCORE);
        chain.doFilter(request, response);
    }

    /**
     * Get the <feature, permission> pair on the specified user and product.
     * 
     * @param aUser
     *            aUser
     * @param aProduct
     *            aProduct
     * @return A Map which key contains all the features in the product setting file pointed by PERMISSION_SETTING_FILE
     *         and which value is the permission of the feature corresponding.
     */
    private Map<String, Boolean> getPermissionSetting(User aUser, Product aProduct) {
        // FIXME: A user in a product might have multiple roles.
        Set<Role> roles = acl.getRoles(aUser, aProduct);
        Map<String, Boolean> permissionMap = new HashMap<String, Boolean>();

        /**
         * A permission record should like <feature>=<role1>,<role2>...
         */
        Properties envProperties = env.getSecurityProperties();
        for (Object property : env.getSecurityProperties().keySet()) {
            String key = (String) property;
            String value = (String) envProperties.get(key);
            // FIXME: if role1.contains(role2), the following implement is not correct.
            boolean hasPermission = false;
            if (!roles.isEmpty()) {
                for (Role role : roles) {
                    if (value.indexOf(role.getUserRole().toString()) != -1) {
                        hasPermission = true;
                        break;
                    }
                }
            }

            permissionMap.put(key, hasPermission);
        }
        return permissionMap;
    }

    /**
     * check the request should add permission settings to the request. now if product is null, request is not
     * HttpServletRequest and a web service request is not need to add.
     * 
     * @param request
     * @param product
     * @return
     */
    private boolean shouldRequestAddPermissionSettings(ServletRequest request, Product product) {
        if (product == null) {
            return false;
        }

        if (!(request instanceof HttpServletRequest)) {
            return false;
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURL().toString();
        LOGGER.info("acl filter processed url - " + url);

        if (url.contains(WEB_SERVICE)) {
            return false;
        }

        return true;
    }

    /**
     * this method is to get copyright for all pages.
     * @return copyright.
     */
    private String getCopyright() {
        Calendar calendar = Calendar.getInstance();
        String copyright = "copyright &copy; " + calendar.get(Calendar.YEAR) + " glority.com";
        return copyright;
    }
}
