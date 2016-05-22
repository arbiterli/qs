package com.glority.qualityserver.service.impl;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.glority.qualityserver.service.Environment;

/**
 * EnvironmentImpl class.
 */
@Component
public class EnvironmentImpl implements Environment {
    private static final Logger LOGGER = Logger.getLogger(EnvironmentImpl.class);

    /**
     * The holder of the properties.
     */
    @Autowired(required = true)
    @Qualifier("securityProperties")
    private Properties securityProperties;

    @PostConstruct
    public void logProperties() {
        LOGGER.info("All security properties");
        for (Object key : securityProperties.keySet()) {
            LOGGER.info(key + "=" + securityProperties.getProperty((String) key));
        }
    }

    public Properties getSecurityProperties() {
        return securityProperties;
    }

    public String getSecurityProperty(String featureName) {
        return securityProperties.getProperty(featureName);
    }

}
