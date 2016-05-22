package com.glority.qualityserver.manager;

import java.util.List;


import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.ScoreOwnerMapping;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.web.model.ScoreOwner;

/**
 * ScoreOwnerMapping Manager.
 * @author cz
 *
 */
public interface ScoreOwnerMappingManager extends GenericManager<ScoreOwnerMapping, Long> {

    /**
     * Get ScoreOwner based on product id and score name.
     * @param productId Product id
     * @param scoreName Score name
     * @return ScoreOwner
     */
    List<ScoreOwner> getScoreOwner(long productId, String scoreName);

    /**
     * Save score owner mapping.
     * @param product Current product
     * @param scoreName Score name
     * @param user User
     * @return The saved score owner
     */
    ScoreOwnerMapping saveScoreOwner(Product product, String scoreName, User user);

}
