package com.glority.qualityserver.web.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.exception.PermissionDeniedException;
import com.glority.qualityserver.web.filter.DwrService;

/**
 * Demo for dwr.
 *
 * @author xxd
 *
 */

@Service
@RemoteProxy(name = "dwrService")
public class DwrServiceDemo implements DwrService {

    private Logger log = Logger.getLogger(this.getClass());


    public Logger getLog() {
        return log;
    }

    @RemoteMethod
    public String getStuff() {
        return "Stuff";
    }

    @RemoteMethod
    public String crash() {
        throw new PermissionDeniedException("I'm crashed");
    }

    @RemoteMethod
    public String updateString(String value) {
        getLog().debug("dwr update string with: " + value);
        return value;
    }

    @RemoteMethod
    public List<String> updateList(List<String> value) {
        getLog().debug("dwr update list with: " + value);
        return value;
    }

    @Override
    public Collection<UserRole> getAllowedRoles() {
        return Arrays.asList(UserRole.ROLE_ADMIN);
    }
}
