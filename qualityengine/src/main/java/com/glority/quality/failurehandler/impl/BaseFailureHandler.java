package com.glority.quality.failurehandler.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.tools.ant.BuildException;

import com.glority.common.connectors.ConnectorException;
import com.glority.common.connectors.http.HttpConnector;
import com.glority.quality.BaseTask;
import com.glority.quality.config.configmanager.ConfigManager;
import com.glority.quality.failurehandler.TaskFailureHandler;

/**
 * Base failure handler implementation. It will send http request to quality server to report failure message.
 */
public abstract class BaseFailureHandler implements TaskFailureHandler {
    private static final Logger LOGGER = Logger.getLogger(BaseFailureHandler.class);
    private static final String QUALITY_SERVER_URL = "quality_server_url";
    private static final String QUALITY_SERVER_AUTH_KEY = "quality_server_auth_key";
    private static final String DEFAULT_SERVER = "http://localhost:8080/reportQualityEngineFailure";

    public abstract void handleFailue(BaseTask task, BuildException buildException);

    /**
     * Report the failure message to quality server with task and stack trace.
     */
    public void reportFailureMessage(BaseTask task, BuildException buildException) {
        String stackTrace = buildException == null ? "" : getStackTrace(buildException);
        String owner = task.getOwner();

        Map<String, String> params = new HashMap<String, String>();
        params.put("task", task.getClass().getName());
        params.put("owner", owner);
        params.put("stacktrace", stackTrace);
        params.put("key", this.getQualityServerAuthKey());
        HttpConnector connector = new HttpConnector();
        try {
            connector.doPost(getQualityServerUrl(), params);
        } catch (ConnectorException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private String getStackTrace(BuildException buildException) {
        StringWriter strWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(strWriter);
        buildException.printStackTrace(printWriter);

        return strWriter.toString();
    }

    /**
     * Get the quality server url from configuration property file.
     * If the server url is not configured, the default server url will be used instead.
     * @return quality server url
     */
    private String getQualityServerUrl() {
        return ConfigManager.getInstance().getConfigValue(QUALITY_SERVER_URL, DEFAULT_SERVER);
    }

    private String getQualityServerAuthKey() {
        return ConfigManager.getInstance().getConfigValue(QUALITY_SERVER_AUTH_KEY, null);
    }
}
