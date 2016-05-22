package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.ScoreOwnerMapping;

/**
 * Score owner mapping DAO interface.
 * 
 * @author cz
 * 
 */
public interface ScoreOwnerMappingDao extends GenericDao<ScoreOwnerMapping, Long> {

    /**
     * Get ScoreOwner based on product id and score name.
     * @param productId Product id
     * @param scoreName Score name
     * @return ScoreOwner
     */
    List<ScoreOwnerMapping> getProductScoreOwner(long productId, String scoreName);
}
