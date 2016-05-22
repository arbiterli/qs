package com.glority.qualityserver.web.service;

import java.util.List;
import java.util.Map;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.PhaseStatus;
import com.glority.qualityserver.model.Server;

/**
 * Phase service interface.
 * 
 * @author liheping
 * 
 */
public interface PhaseService {

    String SERVER_DETAIL_FOR_UPDATE = "update";
    String SERVER_DETAIL_FOR_VIEW = "view";
    String SERVER_DETAIL_FOR_CREATE = "create";

    PhaseStatus getPhaseStatus(long buildId, ProductStage stage, boolean fullInfo);

    /**
     * get all the server in phase.
     * 
     * @param productId
     * @param stage
     * @return
     */
    List<Server> getServersForStage(long productId, ProductStage stage);

    /**
     * get server detail for server create.
     * 
     * @param productId
     * @param stage
     * @return
     */
    Server getServerDetail(long productId, ProductStage stage);

    /**
     * get server detail for type.
     * 
     * @param serverId
     * @param type
     * @param buildId TODO
     * @return
     */
    Server getServerDetail(long serverId, String type, long buildId);

    Map<String, Long> getDeployedBuild(long serverId);

    Map<String, Long> getActiveBuild(long serverId);

    Map<String, Long> getActiveBuild(long productId, ProductStage stage);

    /**
     * update the active build for product phase.
     * 
     * @param productId
     * @param buildId
     * @param stage
     * @return actciveBuild info
     */
    Map<String, Long> updateActiveBuild(long productId, long buildId, ProductStage stage);

    /**
     * update server.
     * 
     * @param detail
     * @return
     * @throws Exception
     */
    Server updateServer(Server server) throws Exception;

    /**
     * create server.
     * 
     * @param detail
     * @return
     */
    Server createServer(Server server);

    /**
     * delete server.
     * 
     * @param serverId
     */
    void deleteServer(long serverId);

    /**
     * get related detail scores for build and phase.
     * 
     * @param buildId
     * @param phase
     * @return
     */
    List<List<List<Object>>> getMetricScore(long buildId, ProductStage phase);

    /**
     * get builds in version for phase.
     * 
     * @param versionId
     * @param phase
     * @return
     */
    List<Map<String, Long>> getBuildListInVersion(long versionId, ProductStage phase);

    /**
     * add  flag if the score has setted.
     * @param productId
     * @param scores
     * @return List<List<List<Object>>> after add flag
     */
    List<List<List<Object>>> addScoreEmailSettingFlag(long productId, List<List<List<Object>>> scores);

    /**
     * add submetric index .
     * @param scores
     * @return List<List<List<Object>>> after add submetric index.
     */
    List<List<List<Object>>> addSubmetricIndex(List<List<List<Object>>> scores);

    /**
     * getMetricNameScorePairs.
     * @param buildId
     * @param phase
     * @return the map of name scocre pair
     */
    Map<String, Object> getMetricNameScorePairs(long buildId, ProductStage phase);
}
