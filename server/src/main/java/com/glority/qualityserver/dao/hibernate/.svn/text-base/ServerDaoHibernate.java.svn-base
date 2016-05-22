package com.glority.qualityserver.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.ServerDao;
import com.glority.qualityserver.model.Server;

/**
 * Hibernate implementation for Server DAO.
 * 
 * @author liheping
 * 
 */
@Repository("serverDao")
public class ServerDaoHibernate extends GenericDaoHibernate<Server, Long> implements ServerDao {
    /**
     * default constructor.
     */
    public ServerDaoHibernate() {
        super(Server.class);
    }

    /**
     * get all the active servers in phase.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Server>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<Server> getAllServersInPhase(long phaseId) {
        List<Server> resultList = super.getHibernateTemplate().find("from Server where phase_id = ? and discarded = ?",
                new Object[] { Long.valueOf(phaseId), Boolean.FALSE });
        if (resultList == null) {
            return new ArrayList<Server>();
        }
        return resultList;
    }
}
