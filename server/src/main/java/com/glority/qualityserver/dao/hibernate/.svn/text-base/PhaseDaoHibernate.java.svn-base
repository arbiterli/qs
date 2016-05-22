package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.PhaseDao;
import com.glority.qualityserver.model.Phase;

/**
 * Hibernate implementation for Phase DAO.
 * 
 * @author liheping
 * 
 */
@Repository("phaseDao")
public class PhaseDaoHibernate extends GenericDaoHibernate<Phase, Long> implements PhaseDao {
    /**
     * Default constructor.
     */
    public PhaseDaoHibernate() {
        super(Phase.class);
    }

    /**
     * get phase for productId.
     * 
     * @param productId
     *            the product id
     * @param phase
     *            String value of the phase
     * @return Phase, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public Phase getPhase(long productId, String phase) {
        List<Phase> phases = this.getHibernateTemplate().find("from Phase where product_id = ? and type = ?",
                new Object[] { Long.valueOf(productId), phase });

        if (phases == null || phases.size() == 0) {
            return null;
        }

        return phases.get(0);
    }
}
