package com.glority.qualityserver.manager;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Phase;

/**
 * Phase manager interface.
 * 
 * @author liheping
 * 
 */
public interface PhaseManager extends GenericManager<Phase, Long> {
    /**
     * get phase for product.
     * 
     * @param productId
     * @param stage
     * @return
     */
    Phase getPhase(long productId, ProductStage stage);

    /**
     * update the active build for phase.
     * 
     * @param phase
     * @param buildId
     */
    void updatePhaseActiveBuild(Phase phase, long buildId);
}
