package com.glority.qualityserver.web.service;

import java.util.List;
import java.util.Map;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Server;

/**
 * deploy service interface.
 * 
 * @author liheping
 * 
 */
public interface DeployService {
    /**
     * get the latest preview deploy update history, with maxNumber to specify the max number of items.
     * 
     * @param productId
     * @param stage
     * @param maxNumber
     * @return
     */
    List<Map<String, Object>> getLatestPreviewDeployUpdateHistory(long productId, ProductStage stage, int maxNumber);

    /**
     * get the latest production deploy update history, with maxNumber to specify the max number of items.
     * 
     * @param productId
     * @param stage
     * @param maxNumber
     * @return
     */
    List<Map<String, Object>> getLatestProductionDeployUpdateHistory(long productId, ProductStage stage, int maxNumber);

    Map<String, Object> getBaseDeployRecord(long productId, ProductStage stage);

    /**
     * add a new hot deploy record.
     * 
     * @param productName
     * 
     * @param user
     * @throws Exception
     */
    void hotDeploy(String productName, String user, String revision) throws Exception;

    /**
     * base deploy the server.
     * 
     * @param serverId
     *            .
     * @param buildId
     * @param user
     * @return
     * @throws Exception
     */
    List<String> baseDeploy(long serverId, long buildId, String user) throws Exception;

    Map<Object, Object> getActiveDeploy(String productName, String serverType);

    void updatePreviewServerVersion(String productName);

    void rollbackPreviewServerVersion(String productName);

    void syncFromProductionServerVersion(String productName);

    void syncToProductionServerVersion(String productName);

    String getVersionForPreviewUpdate(String productName);

    String getVersionForRollback(String productName);

    String getVersionForSyncFromProduction(String productName);

    String getVersionnForSyncToProduction(String productName);

    Map<Object, Object> getBaseDeployLog(String logKey);

    List<Deploy> getPhaseDeploys(long productId, ProductStage stage);

    Server getSpecifiedServer(long phaseId, String serverType);

    Deploy getLatestHotdeployRecord(long productId);
}
