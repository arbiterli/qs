package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.PhaseDao;
import com.glority.qualityserver.manager.PhaseManager;
import com.glority.qualityserver.model.Phase;

/**
 * PhaseManager implementation.
 * 
 * @author Administrator
 * 
 */
@Service("phaseManager")
public class PhaseManagerImpl extends GenericManagerImpl<Phase, Long> implements PhaseManager {
    @Autowired
    private PhaseDao phaseDao;

    @Override
    protected GenericDao<Phase, Long> getDao() {

        return this.phaseDao;
    }

    public Phase getPhase(long productId, ProductStage stage) {

        return this.phaseDao.getPhase(productId, stage.toString());
    }

    public void updatePhaseActiveBuild(Phase phase, long buildId) {
        if (phase != null) {
            phase.setDefaultBuild(buildId);

            this.phaseDao.save(phase);
        }

    }

}
