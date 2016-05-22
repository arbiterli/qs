package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.model.Deploy;

/**
 * this manager deal with access to deployDao, deploy's server type, deploy
 * type, version related logic.
 * 
 * @author liheping
 * 
 */
public interface DeployManager extends GenericManager<Deploy, Long> {

    /**
     * get preview deploys order by preview deploy time desc.
     * 
     * @param phaseId
     * @return
     */
    List<Deploy> getPreviewDeploys(long phaseId);

    /**
     * get production deploys order by product deploy time desc.
     * 
     * @param phaseId
     * @return
     */
    List<Deploy> getProductionDeploys(long phaseId);

    /**
     * get the latest deploy version for build.
     * 
     * @param phaseId
     * @param buildId
     * @return
     */
    String getLatestDeployVersion(long phaseId, long buildId);

    /**
     * get the latest success base deploy.
     * 
     * @param phaseId
     * @return
     */
    Deploy getLatestSuccessBaseDeploy(long phaseId);

    /**
     * deploy to preview server. deal with the update and save logic. the deploy
     * type must be assigned.
     * 
     * @param deploy
     */
    Deploy previewDeploy(Deploy deploy, String deployType);

    /**
     * deploy to production server. deal withe the update and save logic. the
     * deploy type must be assigned
     * 
     * @param deploy
     */
    Deploy productionDeploy(Deploy deploy, String deployType);

    /**
     * save one type deploy.
     * 
     * @param deploy
     * @param deployType
     * @return
     */
    Deploy deploy(Deploy deploy, String deployType);

    /**
     * check the phase's server whether being deploying.
     * 
     * @param phaseId
     * @return
     */
    boolean isPhaseServerDeploying(long phaseId);

    /**
     * get the all the deploy with the specified result.
     * 
     * @param result
     * @return
     */
    List<Deploy> getDeployWithSpecifiedResult(String result);

    /**
     * get all the deploys in phase, order by create time.
     * 
     * @param id
     * @return
     */
    List<Deploy> getPhaseDeploys(long phaseId);

    /**
     * get the latest success hot deploy .
     * @param phaseId
     * @return
     */
    Deploy getLatestSuccessHotDeploy(long phaseId);
}
