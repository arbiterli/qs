package com.glority.qualityserver.metricengine;

import java.io.IOException;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Factory to create Metric Score generator based on the method name.
 * 
 * @author Chenhong
 * 
 */
public final class ScoreGeneratorFactory {
    private static final Log LOGGER = LogFactory.getLog(ScoreGeneratorFactory.class.getName());

    private static final String SCORE_GENERATOR_CONFIG_FILE = "scoreformulagenerator.properties";
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(ScoreGeneratorFactory.class.getClassLoader().getResourceAsStream(
                    SCORE_GENERATOR_CONFIG_FILE));
        } catch (IOException e) {
            LOGGER.error("Failed to load " + SCORE_GENERATOR_CONFIG_FILE + " caused by " + e.getMessage(), e);
        }
    }

    /**
     * Private ctor.
     */
    private ScoreGeneratorFactory() {
        // empty
    }

    /**
     * create the generator with method name.
     * 
     * @param methodName
     *            the score method
     * @return MetricFormulaGenerator
     */
    static MetricFormulaGenerator getFormulaGenerator(String methodName) {
        String className = properties.getProperty(methodName);
        if (className != null && className.trim().length() > 0) {
            try {
                return (MetricFormulaGenerator) Class.forName(className).newInstance();
            } catch (InstantiationException e) {
                LOGGER.error("Failed to create MetricFormulaGenerator, caused by " + e.getMessage(), e);
            } catch (IllegalAccessException e) {
                LOGGER.error("Failed to create MetricFormulaGenerator, caused by " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                LOGGER.error(className + "class was not found, caused by " + e.getMessage(), e);
            }
        }
        LOGGER.error("MetricFormulaGenerator implementation is not properly configured for " + methodName);
        return null;
    }
}
