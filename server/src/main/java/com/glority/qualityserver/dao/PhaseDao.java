package com.glority.qualityserver.dao;

import com.glority.qualityserver.model.Phase;

/**
 * Phase DAO interface.
 * 
 * @author liheping
 * 
 */
public interface PhaseDao extends GenericDao<Phase, Long> {
    /**
     * get phase for productId.
     * 
     * @param productId
     *            the product id
     * @param phase
     *            String value of the phase
     * @return Phase, if not exists, return null
     */
    Phase getPhase(long productId, String phase);

}
