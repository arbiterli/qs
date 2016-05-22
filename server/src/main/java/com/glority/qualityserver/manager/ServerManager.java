package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.model.Server;

/**
 * Server manager interface.
 * 
 * @author liheping
 * 
 */
public interface ServerManager extends GenericManager<Server, Long> {
    /**
     * get all the servers in phase.
     * 
     * @param phaseId
     * @return
     */
    List<Server> getAllServersInPhase(long phaseId);

    /**
     * get the server whose type is specified.
     * 
     * @param phaseId
     * @param serverType
     * @return
     */
    List<Server> getSpecifiedServer(long phaseId, String serverType);

    /**
     * soft delete server.
     * 
     * @param serverId
     */
    void deleteServer(long serverId);

    /**
     * validate server from web.
     * 
     * @param server
     */
    void validate(Server server);

    /**
     * validate the server properity for server change check.
     * 
     * @param server
     * @return
     */
    boolean validateServerForChangeCheck(Server server);

    /**
     * validate the server property for nagios minitoring.
     * 
     * @param server
     * @return
     */
    boolean validateServerForNagiosMonitoring(Server server);

    /**
     * validate the server property for cloud watch.
     * 
     * @param server
     * @return
     */
    boolean validateServerForCloudwatchMornitoring(Server server);
}
