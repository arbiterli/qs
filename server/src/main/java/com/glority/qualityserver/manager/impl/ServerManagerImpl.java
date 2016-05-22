package com.glority.qualityserver.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.ServerDao;
import com.glority.qualityserver.manager.ServerManager;
import com.glority.qualityserver.model.Server;

/**
 * Server manager implementation.
 * 
 * @author liheping
 * 
 */
@Service("serverManager")
public class ServerManagerImpl extends GenericManagerImpl<Server, Long> implements ServerManager {
    @Autowired
    private ServerDao serverDao;

    @Override
    protected GenericDao<Server, Long> getDao() {
        return this.serverDao;
    }

    public List<Server> getAllServersInPhase(long phaseId) {
        // TODO Auto-generated method stub
        return this.serverDao.getAllServersInPhase(phaseId);
    }

    public List<Server> getSpecifiedServer(long phaseId, String serverType) {
        List<Server> result = new ArrayList<Server>();
        if (phaseId < 0 || serverType == null) {
            return result;
        }

        List<Server> serverList = this.serverDao.getAllServersInPhase(phaseId);
        if (serverList != null && !serverList.isEmpty()) {
            for (Server server : serverList) {
                if (serverType.equalsIgnoreCase(server.getType())) {
                    result.add(server);
                }
            }
        }

        return result;
    }

    public void deleteServer(long serverId) {
        Server server = this.serverDao.get(serverId);
        if (server != null) {
            server.setIsDiscarded(true);
            this.serverDao.save(server);
        }

    }

    @Override
    public void validate(Server server) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean validateServerForChangeCheck(Server server) {
        if (server == null) {
            return false;
        }

        if (server.getCheckIsActive() == null || !server.getCheckIsActive()) {
            return false;
        }

        if (server.getCheckScript() == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean validateServerForNagiosMonitoring(Server server) {
        if (server == null) {
            return false;
        }

        if (server.getNagiosIsActive() == null || !server.getNagiosIsActive()) {
            return false;
        }

        if (server.getNagiosHost() == null) {
            return false;
        }

        if (server.getNagiosPassword() == null) {
            return false;
        }

        if (server.getNagiosUrl() == null) {
            return false;
        }

        if (server.getNagiosUserName() == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean validateServerForCloudwatchMornitoring(Server server) {
        if (server == null) {
            return false;
        }
        if (server.getCloudwatchIsActive() == null || !server.getCloudwatchIsActive()) {
            return false;
        }
        if (server.getCloudwatchInstanceId() == null) {
            return false;
        }
        return true;
    }
}
