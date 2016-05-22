package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.Deploy;

/**
 * Deploy Dao interface.
 * 
 * @author liheping
 * 
 */
public interface DeployDao extends GenericDao<Deploy, Long> {
    /**
     * get all the hot deploys for preview.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Deploy>, if not exists, it is an empty list
     */
    List<Deploy> getPreviewHotDeploys(long phaseId);

    /**
     * get all the hot deploys for production.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Deploy>, if not exist, it is an empty list
     */
    List<Deploy> getProductionHotDeploys(long phaseId);

    /**
     * get the latest success base deploy for phase.
     * 
     * @param phaseId
     *            the phase id.
     * @return Deploy, if not exists, return null
     */
    Deploy getLatestSuccessBaseDeploy(long phaseId);

    /**
     * get all the deploys in phase, order by create time.
     * 
     * @param phaseId
     *            the phase id
     * @return List<Deploy>, if not exists, return null
     */
    List<Deploy> getAllDeploys(long phaseId);

    /**
     * get all deploys for phase with build.
     * 
     * @param phaseId
     *            the phase id
     * @param buildId
     *            the build id
     * @return List<Deploy>, if not exists, it is an empty list
     */
    List<Deploy> getAllDeploys(long phaseId, long buildId);

    /**
     * get all the deploys that has the specified result.
     * 
     * @param result
     *            the specified result
     * @return List<Deploy>, if not exists, it is an empty list
     */
    List<Deploy> getDeployWithSpecifiedResult(String result);

    /**
     * check the specified phase server whether deploying.
     * 
     * @param phaseId
     *            the specified phase
     * @return whether the phase server is deploying
     */
    boolean isPhaseServerDeploying(long phaseId);

    /**
     * get the latest success hot deploy for phase.
     * 
     * @param phaseId
     *            the phase id.
     * @return Deploy, if not exists, return null
     */
    Deploy getLatestSuccessHotDeploy(long phaseId);
}
