package com.glority.qualityserver.web.filter;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

import javax.naming.NoPermissionException;

import org.apache.log4j.Logger;
import org.directwebremoting.AjaxFilter;
import org.directwebremoting.AjaxFilterChain;
import org.directwebremoting.annotations.GlobalFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.exception.NoAnnotationException;
import com.glority.qualityserver.exception.NoDataException;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;

/**
 * This class controls the access privileges to the DWR services according to
 * the login's roles.
 */
@GlobalFilter
@Component
public class DwrAccessFilter implements AjaxFilter {
    private static final Logger LOGGER = Logger.getLogger(DwrAccessFilter.class);
    private static final String ADMIN_MANAGER_SERVICE = "AdminManagerService";
    private static final String DEBUG_JOB_SERVICE = "DebugJobService";

    @Autowired
    private AccessControlService acl;

    @Override
    public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception {
        Assert.isTrue(obj instanceof DwrService, obj.getClass() + " must implement DwrService");
        boolean isAllowed = false;

        if (obj.getClass().getName().contains(ADMIN_MANAGER_SERVICE)
                || obj.getClass().getName().contains(DEBUG_JOB_SERVICE)) {
            // Admin service access, just check the user whether have admin
            // role.
            Set<Role> roles = this.acl.getCurrentUser().getRoles();
            for (Role role : roles) {
                if (UserRole.ROLE_ADMIN == role.getUserRole()) {
                    isAllowed = true;
                    break;
                }
            }
        } else {
            if (!method.isAnnotationPresent(GetProduct.class)) {
                LOGGER.error("method " + method.getName() + " has no GetProduct annotation, can not get product.");
                throw new NoAnnotationException("method " + method.getName() + " has no GetProduct annotation.");
            }
            GetProduct getProductAnno = method.getAnnotation(GetProduct.class);
            Object param = params[getProductAnno.index()];
            Product product = this.acl.getProduct(param, getProductAnno.paramName());
            if (product == null) {
                LOGGER.debug("no product for " + getProductAnno.paramName() + " - " + param);
                throw new NoDataException("no product for " + getProductAnno.paramName() + " - " + param);
            }

            User user = this.acl.getCurrentUser();
            // if this get role api is changed, there should change.
            Set<Role> userRoles = this.acl.getRoles(user, product);

            if (!userRoles.isEmpty()) {
                DwrService dwrService = (DwrService) obj;
                Collection<UserRole> allowedRoles = dwrService.getAllowedRoles();
                for (Role role : userRoles) {
                    if (allowedRoles.contains(role.getUserRole())) {
                        isAllowed = true;
                    }
                }
            }
        }

        if (!isAllowed) {
            LOGGER.warn("Reject " + acl.getCurrentUser().getUsername() + "  accessing " + method);
            throw new NoPermissionException();
        }

        LOGGER.debug("Accept " + acl.getCurrentUser().getUsername() + "  accessing " + method);

        return chain.doFilter(obj, method, params);
    }
}
