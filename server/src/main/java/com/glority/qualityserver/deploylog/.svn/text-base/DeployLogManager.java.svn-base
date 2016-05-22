package com.glority.qualityserver.deploylog;

import java.util.Map;

/**
 * Interface for DeployLogManager.
 * 
 * @author liheping
 * 
 */
public interface DeployLogManager {
    String DEPLOY_FINISHED = "deployFinish";
    String DEPLOY_LOG = "deployLog";

    /**
     * get the log for key.
     * 
     * @param key
     * @return
     */
    Map<Object, Object> getLogInfo(String key);

    /**
     * add a deploy log to the manager.
     * 
     * @param log
     * @return
     * @throws Exception
     */
    String addDeployLog(DeployLog log) throws Exception;

    /**
     * disploy the specified deploy log.
     * 
     * @param key
     */
    void disposeDeployLog(String key);
}
