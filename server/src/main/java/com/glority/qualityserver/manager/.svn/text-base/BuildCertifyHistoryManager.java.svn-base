package com.glority.qualityserver.manager;

import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildCertifyHistory;
import com.glority.qualityserver.model.Phase;

/**
 * BuildCertifyHistory manager interface.
 * 
 * @author liheping
 * 
 */
public interface BuildCertifyHistoryManager extends GenericManager<BuildCertifyHistory, Long> {

    /**
     * save one record for build certify history.
     * 
     * @param build
     * @param phase
     * @param certifiedBy
     */
    void save(Build build, Phase phase, String certifiedBy);
}
