package com.glority.qualityserver.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.util.DaoUtils;
import com.glority.qualityserver.web.controller.BasicController;
import com.glority.qualityserver.web.filter.GetProduct.ProductParamName;

/**
 * AccessControllerService implementation.
 * 
 * @author liheping
 * 
 */
@Service("accessControlService")
public class AccessControlServiceImpl extends DBBaseService implements AccessControlService {
    private static final Logger LOGGER = Logger.getLogger(AccessControlServiceImpl.class);

    public List<Product> getAuthorizedProducts(User user) {
        List<Product> result = new ArrayList<Product>();

        Set<Long> productIds = new HashSet<Long>();
        Set<Role> roles = user.getRoles();
        for (Role r : roles) {
            if (r.getProductId() == null || r.getProductId() <= 0) {
                return super.productManager.getAllProducts();
            } else {
                Product product = super.productManager.get(r.getProductId());
                if (!productIds.contains(product.getId())) {
                    result.add(product);
                    productIds.add(product.getId());
                }
            }
        }
        return result;
    }

    public Set<Role> getRoles(User user, Product p) {
        Set<Role> result = new HashSet<Role>();

        Set<Role> roles = user.getRoles();
        for (Role r : roles) {
            if (r.getProductId() == null || r.getProductId() <= 0 || r.getProductId().equals(p.getId())) {
                result.add(r);
            }
        }

        return result;
    }

    // TODO: Authentication should be done after login, and should not change during following accesses.
    public void setAuthority(User user, Product p) {
        Collection<GrantedAuthority> authorities = new LinkedHashSet<GrantedAuthority>();
        Set<Role> roles = user.getRoles();
        if (p == null) {
            LOGGER.debug("Product is not selected");
            authorities.addAll(roles);
        } else {
            LOGGER.debug("Selected product " + p.getId());
            for (Role r : roles) {
                if (r.getProductId() == null || r.getProductId() <= 0 || r.getProductId() == p.getId()) {
                    LOGGER.debug("Granted role: " + r.getName());
                    authorities.add(r);
                }
            }
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(),
                authorities);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }

    public User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null) {
            Authentication authentication = securityContext.getAuthentication();
            if (authentication != null) {
                Object userDetail = authentication.getPrincipal();
                if (userDetail instanceof User) {
                    User user = (User) userDetail;
                    return user;
                }
            }
        }
        return null;
    }

    public Product getCurrentProduct(ServletRequest request) {
        long productId = DaoUtils.parseStringToId(request.getParameter(BasicController.PRODUCT_ID));
        if (productId > 0) {
            return super.productManager.get(productId);
        }
        long phaseId = DaoUtils.parseStringToId(request.getParameter(BasicController.PHASE_ID));
        if (phaseId > 0) {
            Phase p = super.phaseManager.get(phaseId);
            if (p != null && p.getProductId() > 0) {
                return super.productManager.get(p.getProductId());
            }
        }
        long buildId = DaoUtils.parseStringToId(request.getParameter(BasicController.BUILD_ID));
        if (buildId > 0) {
            Build b = super.buildManager.get(buildId);
            if (b != null) {
                return b.getProduct();
            }
        }
        long serverId = DaoUtils.parseStringToId(request.getParameter(BasicController.SERVER_ID));
        if (serverId > 0) {
            Server s = super.serverManager.get(serverId);
            if (s != null && s.getPhaseId() > 0) {
                Phase p = super.phaseManager.get(s.getPhaseId());
                if (p != null && p.getProductId() > 0) {
                    return super.productManager.get(p.getProductId());
                }
            }
        }

        return null;
    }

    @Override
    public Product getProduct(Object param, ProductParamName paramName) {
        switch (paramName) {
        case PRODUCT_ID:
            return super.productManager.get((Long) param);
        case VERSION_ID:
            Version version = super.versionManager.get((Long) param);
            return version == null ? null : super.productManager.get(version.getProductId());
        case PHASE_ID:
            Phase phase = super.phaseManager.get((Long) param);
            return phase == null ? null : super.productManager.get(phase.getProductId());
        case SERVER_ID:
            Server server = super.serverManager.get((Long) param);
            return server == null ? null : super.buildManager.get(server.getBuildId()).getProduct();
        case BUILD_ID:
            return super.buildManager.get((Long) param).getProduct();
        default:
            return null;
        }
    }

}
