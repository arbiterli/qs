package com.glority.qualityserver.web.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;

/**
 * access dispatcher controller. this class forward request based on the role of the user.
 * 
 * @author liheping
 * 
 */
@Controller
public class AccessDispatcherController {
    @Autowired
    private AccessControlService acs;

    @RequestMapping("/dispatcher")
    public void dispatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = acs.getCurrentUser();
        Set<Role> roleSet = user.getRoles();

        long marketingProductId = -1;
        //TODO:compiler warning,need refactoring code.
        for (Iterator<Role> iter = roleSet.iterator(); iter.hasNext();) {
            Role role = (Role) iter.next();
            UserRole roleName = UserRole.getUserRole(role.getName());
            if (roleName == UserRole.ROLE_MARKETING) {
                marketingProductId = role.getProductId();
            }
        }

        if (marketingProductId != -1) {
            response.sendRedirect("/deployhistory?stage=production&productId=" + marketingProductId);
        } else {
            response.sendRedirect("/productlist");
        }
    }
}
