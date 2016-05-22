package com.glority.qualityserver;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * The contain keeps all application settings.
 * 
 * @author XQS
 * 
 */
public final class ServerSettings {
    private static final Logger LOGGER = Logger.getLogger(ServerSettings.class);

    private Properties props;

    private static final ServerSettings INSTANCE = new ServerSettings();

    /**
     * constructor.
     */
    private ServerSettings() {
        props = new Properties();
        try {
            props.load(FeatureGate.class.getClassLoader().getResourceAsStream(Constants.QUALITY_SERVER_PROPERTY_FILE));
        } catch (Exception e) {
            LOGGER.error("Load application settings failed");
        }
    }

    /**
     * Get the singleton instance of the application settings.
     * 
     * @return ServerSettings instance
     */
    public static ServerSettings getInstance() {
        return INSTANCE;
    }

    /**
     * Get the setting with the specified key.
     * 
     * @param settingKey
     *            the key in the settings
     * @return value in the form of String in the settings
     */
    public String getSetting(String settingKey) {
        return props.getProperty(settingKey);
    }
}
