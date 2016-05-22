package com.glority.qualityserver.dao.hibernate;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.ScoreOwnerMappingDao;
import com.glority.qualityserver.model.ScoreOwnerMapping;

/**
 * Hibernate implement for ScoreOwner DAO.
 * @author cz
 *
 */
@Repository("scoreOwnerMappingDao")
public class ScoreOwnerMappingDaoHibernate
        extends GenericDaoHibernate<ScoreOwnerMapping, Long> implements ScoreOwnerMappingDao {

    /**
     * Default constructor.
     */
    public ScoreOwnerMappingDaoHibernate() {
        super(ScoreOwnerMapping.class);
    }

    /**
     * Get ScoreOwnerMapping based on product id and score name.
     * @param productId Product id
     * @param scoreName Score name
     * @return ScoreOwner
     */
    @SuppressWarnings("unchecked")
    public List<ScoreOwnerMapping> getProductScoreOwner(long productId, String metricName) {
        List<ScoreOwnerMapping> scoreOwnerMappings = this.getHibernateTemplate().find(
                "from ScoreOwnerMapping where product_id = ? and score_name = ? ",
                new Object[] {Long.valueOf(productId), metricName});

        if (scoreOwnerMappings == null) {
            return new ArrayList<ScoreOwnerMapping>();
        }
        return scoreOwnerMappings;
    }


}
