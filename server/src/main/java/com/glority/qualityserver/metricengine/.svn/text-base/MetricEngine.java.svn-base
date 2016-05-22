package com.glority.qualityserver.metricengine;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.metricengine.calculator.CalculatorEngine;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.web.model.MetricScoreFormula;

/**
 * metric engine.
 * 
 * Only getInstance method can get the engine instance.
 * 
 * DBService should be set, before all the operation
 * 
 * TODO: the cache is tightly coupled with the engine
 * TODO: the engine is not used as singleton, seems vialate the initial design
 * @author liheping
 * 
 */
public class MetricEngine {

    public static final String BUILD_SCORE_ENGINE = "codeQualityScore";

    public static final String PRODUCT_SCORE_ENGINE = "prodScore";

    private static final Logger LOGGER = Logger.getLogger(MetricEngine.class);

    public static final String LINES_OF_CODE = "LINES_OF_CODE";
    public static final String LINES_OF_COMMENT = "LINES_OF_COMMENT";
    public static final String TEST_TOTAL_COUNT = "TEST_TOTAL_COUNT";
    public static final String TEST_FAILURE_COUNT = "TEST_FAILED_COUNT";

    private MetricEngineCache metricsCache;
    private MetricEngineProfile metricsEngineProfile;

    private static Map<String, BasicItem> items;
    /**
     * Represents the mapping of MetricName and ScoreItem for fast access the score formula.
     */
    private static Map<String, ScoreItem> scoreItems = new HashMap<String, ScoreItem>();

    static {
        MetricEngineConfigParser parser = new MetricEngineConfigParser();
        items = parser.parse();
        filterScoreItem();
    }

    public MetricEngine(MetricEngineProfile profile, MetricEngineDBService dbService) {
        this.metricsEngineProfile = profile;
        this.metricsCache = new MetricEngineCache();
        this.metricsCache.setMetricEngineDBService(dbService);
        this.metricsCache.setProfile(profile);
        if (profile != null) {
            initialCache();
        }
    }

    @Transactional
    private void initialCache() {
        this.metricsCache.initCache();
    }

    private int getScore(ScoreItem scoreItem, MetricEngineProfile profile) {
        if (scoreItem != null) {
            List<Object> values = CalculatorEngine.INSTANCE.getValues(scoreItem, profile, metricsCache);
            if (values == null || values.isEmpty()) {
                LOGGER.debug("values is null or empty");
                return 0;
            } else {
                LOGGER.debug("get value : " + values.get(0));
                return ((Integer) values.get(0)).intValue();
            }
        }

        return 0;
    }

    private List<ExtendItem> getDetailedScore(ScoreItem scoreItem) {
        LOGGER.debug("Score Item : " + scoreItem);
        if (scoreItem != null) {
            CalculatorEngine.INSTANCE.getValues(scoreItem, metricsEngineProfile, metricsCache);
            return scoreItem.getItemList();
        }

        return new ArrayList<ExtendItem>();
    }

    /**
     * get phase score item by phase. this should be the only entry for score
     * item get.
     * 
     * @param profile
     * @param phase
     * @return
     */
    private ScoreItem getPhaseScoreItem(MetricEngineProfile profile, ProductStage phase) {
        profile.setPhase(phase);
        switch (phase) {
        case DEV:
        case TEST:
        case STAGE:
            return (ScoreItem) this.getItem(BUILD_SCORE_ENGINE);
        case PROD:
            return (ScoreItem) this.getItem(PRODUCT_SCORE_ENGINE);
        default:
            return null;
        }
    }

    private BasicItem getItem(String itemName) {
        BasicItem item = items.get(itemName);
        if (item == null) {
            LOGGER.error("item with item name " + itemName + " is not configed in metric engine config.");
            return null;
        }
        return item.clone();
    }

    private int getPhaseScore(MetricEngineProfile profile, ProductStage phase) {
        ScoreItem scoreItem = getPhaseScoreItem(profile, phase);
        LOGGER.info("score item - " + scoreItem);
        return this.getScore(scoreItem, profile);
    }

    /**
     * this method to get history build scores.
     * 
     * @param profile
     * @return
     */
    public List<Integer> getPhaseScores(ProductStage phase) {
        if (metricsEngineProfile == null) {
            return new ArrayList<Integer>();
        }
        List<MetricEngineProfile> profileList = this.metricsCache.getProfiles(phase);

        List<Integer> result = new ArrayList<Integer>();
        if (profileList != null && !profileList.isEmpty()) {
            for (MetricEngineProfile profile : profileList) {
                int score = this.getPhaseScore(profile, phase);
                result.add(Integer.valueOf(score));
            }
        }

        return result;
    }

    /***
     * get phase score.
     * 
     * @param phase
     * @return
     */
    public int getPhaseScore(ProductStage phase) {
        return this.getPhaseScore(this.metricsEngineProfile, phase);
    }

    public List<ExtendItem> getPhaseDetailScore(ProductStage phase) {
        ScoreItem scoreItem = getPhaseScoreItem(this.metricsEngineProfile, phase);
        return this.getDetailedScore(scoreItem);
    }

    public String getMetric(String metricName, long buildId) {
        List<String> valueStrList = this.metricsCache.getBuildMetricValuesWithFuzzyName(metricName, buildId);
        LOGGER.debug("get metric(" + metricName + "): " + valueStrList);
        return this.translateListNumberToSumStr(valueStrList);
    }

    private String translateListNumberToSumStr(List<String> valueStrList) {
        if (valueStrList != null && !valueStrList.isEmpty()) {
            double finalValue = 0.0;
            for (String valueStr : valueStrList) {
                double value = 0;
                try {
                    value = Double.parseDouble(valueStr);
                } catch (Exception e) {
                    LOGGER.debug(e);
                }
                finalValue += value;
            }
            return Double.toString(finalValue);
        }
        return Constants.NO_DATA;
    }

    public Timestamp getSampleTime(Date date, MetricType type) {
        return this.metricsCache.getSampleTime(date, type);
    }

    /**
     * Iterator all the BasicItem to filter out all ScoreItems.
     */
    private static void filterScoreItem() {
        for (BasicItem basicItem : items.values()) {
            if (basicItem instanceof ScoreItem) {
                scoreItems.put(basicItem.getName(), (ScoreItem) basicItem);
            }
        }
    }

    /**
     * Get the MetricScoreFormula with given name.
     * @param name the metric name.
     * @return MetricScoreFormula with given metric name such as JAVA_MI.
     */
    public static MetricScoreFormula getScoreItemFormula(String name) {
        ScoreItem scoreItem = scoreItems.get(name);
        if (scoreItem == null) {
            return null;
        }
        return scoreItem.getFormula();
    }

    /**
     * Get default score owner mapping role.
     * @param imputScoreName Score name
     * @return The default role
     */
    public static String getDefaultScoreOwnerMappingRole(String imputScoreName) {
        Iterator<String> keyIterator = items.keySet().iterator();
        while (keyIterator.hasNext()) {
            String scoreName = keyIterator.next();
            BasicItem item = items.get(scoreName);
            if (item instanceof ScoreItem) {
                ScoreItem scoreItem = (ScoreItem) item;
                if (scoreItem.getName().equalsIgnoreCase(imputScoreName)) {
                    return scoreItem.getRole();
                }
            }
        }
        return null;
    }

    /**
     * Get the MetricScoreFormula with given name.
     * @param name the metric name.
     * @return MetricScoreFormula with given metric name such as JAVA_MI.
     */
    public static ScoreItem getScoreItem(String name) {
        return scoreItems.get(name);
    }
}
