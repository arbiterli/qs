package com.glority.quality.config.configmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.glority.quality.StringUtil;

/**
 * Used for config the quality engine component.
 * 
 * Currently only the failure system required quality server url configuration.
 * 
 * @author Chen.hong
 * 
 */
public class ConfigManager {
    //TODO: this class need to be refatored
    private static final String CONFIG_FILE = "config.properties";
    private static Log log = LogFactory.getLog(ConfigManager.class.getName());

    private static ConfigManager instance = new ConfigManager();

    private static Properties configProperties = new Properties();

    static {
        try {
            configProperties.load(ConfigManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
        } catch (FileNotFoundException e) {
            log.error("config.properties is not found", e);
        } catch (IOException e) {
            log.error("Error read config.properties, caused by " + e.getMessage(), e);
        }
    }

    public static ConfigManager getInstance() {
        return instance;
    }

    public String getConfigValue(String key, String defaultValue) {
        String configValue = configProperties.getProperty(key);

        return StringUtil.isEmpty(configValue) ? defaultValue : configValue;
    }
}
