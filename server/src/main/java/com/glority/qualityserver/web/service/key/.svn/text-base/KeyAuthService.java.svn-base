package com.glority.qualityserver.web.service.key;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.exception.PermissionDeniedException;

/**
 * Key Auth service.
 * 
 * @author liheping
 * 
 */
public class KeyAuthService {
    private static final Logger LOGGER = Logger.getLogger(KeyAuthService.class);
    public static final String KEY = "key";
    public static final String SERVER_DEFAULT_AUTH_KEY = "qualityServerAuthKey";

    protected void defaultKeyAuth(String key) {
        String defaultKey = ServerSettings.getInstance().getSetting(SERVER_DEFAULT_AUTH_KEY);
        if (StringUtils.isEmpty(defaultKey)) {
            LOGGER.error("service auth key is not configed. all default key auth will go on.");
            return;
        }

        if (!defaultKey.equals(key)) {
            throw new PermissionDeniedException("Invalid key: " + key);
        }
    }
}
