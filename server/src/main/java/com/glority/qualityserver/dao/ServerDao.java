package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.Server;

/**
 * Server DAO interface.
 * 
 * @author liheping
 * 
 */
public interface ServerDao extends GenericDao<Server, Long> {
    /**
     * get all the active servers in phase.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Server>, if not exists, it is an empty list
     */
    List<Server> getAllServersInPhase(long phaseId);

}
