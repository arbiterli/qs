package com.glority.qualityserver.manager.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.ScoreOwnerMappingDao;
import com.glority.qualityserver.manager.ScoreOwnerMappingManager;
import com.glority.qualityserver.manager.SystemRoleManager;
import com.glority.qualityserver.metricengine.MetricEngine;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.ScoreOwnerMapping;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.web.model.ScoreOwner;

/**
 * Implementation for ScoreOwner manager.
 * @author cz
 *
 */
@Service("ScoreOwnerMappingManager")
public class ScoreOwnerMappingManagerImpl extends GenericManagerImpl<ScoreOwnerMapping, Long>
        implements ScoreOwnerMappingManager {

    private static final Log LOGGER = LogFactory.getLog(ScoreOwnerMappingManagerImpl.class.getName());

    @Autowired
    private ScoreOwnerMappingDao scoreOwnerMappingDao;

    @Autowired
    private SystemRoleManager roleManager;

    @Override
    protected GenericDao<ScoreOwnerMapping, Long> getDao() {
        return this.scoreOwnerMappingDao;
    }

    /**
     * Get ScoreOwnerMapping based on product id and score name.
     * @param productId Product id
     * @param scoreName Score name
     * @return ScoreOwner
     */
    public List<ScoreOwner> getScoreOwner(long productId, String scoreName) {
        List<ScoreOwnerMapping> ownerMappings = scoreOwnerMappingDao.getProductScoreOwner(productId, scoreName);

        List<ScoreOwner> scoreOwners = new ArrayList<ScoreOwner>();
        for (ScoreOwnerMapping scoreOwnerMapping : ownerMappings) {
            scoreOwners.add(transferUserToScoreOwner(scoreOwnerMapping.getUser()));
        }
        if (ownerMappings.isEmpty()) {
            scoreOwners.add(transferUserToScoreOwner(getUser(productId, scoreName)));
        }
        return scoreOwners;
     }

    private User getUser(long productId, String scoreName) {
        String roleName = MetricEngine.getDefaultScoreOwnerMappingRole(scoreName);
        if (roleName == null) {
            LOGGER.error("No role for " + scoreName + " is configured.");
            return null;
        }
        Role role = roleManager.getUserProductRole(productId, roleName);
        if (role == null) {
            LOGGER.error("No role is configured for product=" + productId +  " role name=" +  roleName);
            return null;
        }
        return role.getUser();
    }

    private ScoreOwner transferUserToScoreOwner(User user) {
        ScoreOwner scoreOwner = new ScoreOwner();
        if (user != null) {
            scoreOwner.setContactName(user.getName());
            scoreOwner.setEmail(user.getEmail());
        }
        return scoreOwner;
    }

    /**
     * Save score owner mapping.
     * @param product Current product
     * @param scoreName Score name
     * @param user User
     * @return The saved score owner
     */
    public ScoreOwnerMapping saveScoreOwner(Product product, String scoreName, User user) {
        ScoreOwnerMapping scoreOwner = new ScoreOwnerMapping();

        scoreOwner.setProduct(product);
        scoreOwner.setScoreName(scoreName);
        scoreOwner.setUser(user);

        return super.save(scoreOwner);
    }
}
