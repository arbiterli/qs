package com.glority.qualityserver.manager.impl;

import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.quality.StringUtil;
import com.glority.qualityserver.dao.BuildMetricDao;
import com.glority.qualityserver.manager.MetricsDescriptionManager;
import com.glority.qualityserver.manager.ScoreOwnerMappingManager;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricDescriptionParser;
import com.glority.qualityserver.metricengine.MetricEngine;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.metricengine.ScoreItem;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.web.model.ComplexMetricScoreFormula;
import com.glority.qualityserver.web.model.MetricScoreFormula;
import com.glority.qualityserver.web.model.MetricsDescription;

/**
 * Retrieve the metrics description from xml file.
 * 
 * @author Chenhong
 */
@Service("metricDescriptionService")
public class DefaultMetricsDescriptionManagerImpl implements MetricsDescriptionManager {

    private static final Log LOGGER = LogFactory.getLog(DefaultMetricsDescriptionManagerImpl.class.getName());

    @Autowired
    private BuildMetricDao metricDao;

    @Autowired
    private ScoreOwnerMappingManager scoreOwnerManager;

    private static final String DEFAULT_CONFIG_FILE = "metricsdescription.xml";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");
    private static final double FULL_SCORE = 100.0;

    private String configFile = DEFAULT_CONFIG_FILE;

    private MetricDescriptionParser parser = new MetricDescriptionParser();

    private Map<String, MetricsDescription> metricsDescriptions = new HashMap<String, MetricsDescription>();

    /**
     * Create default XMLMetricsDescriptionManagerImpl instance.
     */
    public DefaultMetricsDescriptionManagerImpl() {
        metricsDescriptions = parser.parse(getClass().getClassLoader().getResourceAsStream(configFile));
    }

    /**
     * Set metric description config file.
     * 
     * @param metricDescriptionConfigFile
     *            the metric description configuration file
     * @throws FileNotFoundException
     *             if file not found
     */
    protected void setConfigFile(String metricDescriptionConfigFile) throws FileNotFoundException {
        if (StringUtil.isEmpty(metricDescriptionConfigFile)) {
            throw new IllegalArgumentException("The parameter metricDescriptionConfigFile should not be null.");
        }
        this.configFile = metricDescriptionConfigFile;
        metricsDescriptions = parser.parse(new FileInputStream(new File(metricDescriptionConfigFile)));
    }

    /**
     * Parse the MetricsDescription from DOM element.
     * 
     * @param metricsName
     *            the metrics name such as MI, PMD
     * @param product id the optional parameter for product
     * @return MetricsDescription the MetricsDescription instance
     */
    public MetricsDescription getMetricsDesciption(String metricsName, long productId) {
        if (StringUtil.isEmpty(metricsName)) {
            throw new IllegalArgumentException("The metrics should not be null.");
        }

        MetricsDescription metricDescription = metricsDescriptions.get(metricsName);
        if (metricDescription == null) {
            metricDescription = createDefaultMetricsDescription(metricsName);
        }
        MetricScoreFormula metricScoreFormula = MetricEngine.getScoreItemFormula(metricsName);
        if (metricScoreFormula != null && metricScoreFormula.isProductBased()) {
            ComplexMetricScoreFormula complexFormula = (ComplexMetricScoreFormula) metricScoreFormula;

            metricScoreFormula = adjustProductBaseMetricScoreFormula(complexFormula, productId);
            metricDescription.setMetricFormula(metricScoreFormula);
        }
        metricDescription.setMetricFormula(metricScoreFormula);
        // set the score owner.
        metricDescription.setOwners(scoreOwnerManager.getScoreOwner(productId, metricsName));
        // retrieve the score owner for this metric.
        return metricDescription;
    }


    /**
     * Get all metric names for the latest build of the given product.
     * @param productId the product id
     * @return metric name collection of the latest build of the product
     */
    private Set<String> getExistMetricsForProduct(long productId) {
        List<BuildMetric> buildMetricList = this.metricDao.getLatestMetricWithProduct(productId);
        Set<String> metricsExitedInProduct = new HashSet<String>();
        for (BuildMetric buildMetric : buildMetricList) {
            metricsExitedInProduct.add(buildMetric.getName());
        }

        return metricsExitedInProduct;
    }

    /**
     * Adjust the product base metric score formula. Take build score as an example, the build score is consisted
     * with 5 parts, which are Java build score, CPP build score, js build score, cs build score, and test complete
     * score. The Test Complete score is a fixed power score. (Current it is powered by 30%). As the formula is based
     * on 5 factors. The real formula for Build Score should be adjusted if some of these factors existed or not.
     * @param formula
     * @param productID
     * @return
     */
    private ComplexMetricScoreFormula adjustProductBaseMetricScoreFormula(ComplexMetricScoreFormula formula,
            long productID) {
        ComplexMetricScoreFormula cloneScoreFormula = cloneComplexMetriScore(formula);
        Map<String, String> powerMap = cloneScoreFormula.getPowerMap();

        Set<String> metricsExistedInProduct = this.getExistMetricsForProduct(productID);

        List<String> existNoneFixedPowerMetrics = new ArrayList<String>();
        List<String> noneExistMetrics = new ArrayList<String>();
        double powerUsed = 0.0;
        for (Map.Entry<String, String> powerEntry : powerMap.entrySet()) {
            ScoreItem scoreItem = MetricEngine.getScoreItem(powerEntry.getKey());

            if (checkScoreHasMetrics(scoreItem, metricsExistedInProduct)) {
                double fixPower = Double.parseDouble(powerEntry.getValue());
                if (fixPower > 0) {
                    // a fixed power metric item found, such as test complete score in build score.
                    powerUsed += fixPower * FULL_SCORE;
                    // turn power from 0.xx to 100 based
                    powerMap.put(powerEntry.getKey(), String.valueOf(FULL_SCORE * fixPower));
                } else {
                    existNoneFixedPowerMetrics.add(powerEntry.getKey());
                }
            } else {
                noneExistMetrics.add(powerEntry.getKey());
            }
        }
        // remove all metrics which does not existed in the current product.
        for (String metricName : noneExistMetrics) {
            powerMap.remove(metricName);
            cloneScoreFormula.removeSubMetricScoreFormula(metricName);
        }
        // re-calculate the power with all existing metrics.
        double powerLeft = FULL_SCORE - powerUsed;
        for (String metricName : existNoneFixedPowerMetrics) {
            powerMap.put(metricName, calcaulatePower(powerLeft, existNoneFixedPowerMetrics.size()));
        }

        cloneScoreFormula.setPowerMap(powerMap);
        return cloneScoreFormula;
    }

    private String calcaulatePower(double powerLeft, int subScoreCount) {
        return DECIMAL_FORMAT.format(powerLeft / subScoreCount);
    }

    /**
     * Clone a ComplexMetricScore for product base ScoreItem. The product base ScoreItem formula is built dynamically.
     * Clone a new one is to avoid overwrite the base ScoreItem for the next query or other application.
     * @param originalFormula the ComplexMetricScoreFormula
     * @return the clone object
     */
    private ComplexMetricScoreFormula cloneComplexMetriScore(ComplexMetricScoreFormula originalFormula) {
        ComplexMetricScoreFormula cloneScoreFormula = new ComplexMetricScoreFormula(originalFormula.getMetricName());
        cloneScoreFormula.setMetricScoreFormulaList(originalFormula.getScoreFormulaList());
        cloneScoreFormula.setPower(originalFormula.getPower());
        cloneScoreFormula.setID(originalFormula.getID());
        cloneScoreFormula.setPowerMap(originalFormula.getPowerMap());
        cloneScoreFormula.setProductBased(originalFormula.isProductBased());
        cloneScoreFormula.setComplexMetricScore(originalFormula.isComplexMetricScore());
        return cloneScoreFormula;
    }

    /**
     * Check if the ScoreItem has metrics. The parameter existedMetrics including all metrics for the latest build
     * for one product. This method using dfs to search if anyone of the sub metric of given ScoreItem has metric
     * existed in the database.
     * <p>
     * This method should only be called for product base Score, such as Build Score which is a product score including
     * Java Build Score, CS build Score, JS Build Score , Test Complete Score and CPP Build Score.
     * </p>
     * @param scoreItem the ScoreItem
     * @param exsitedMetrics all metrics existed in the latest build for one product
     * @return true if existed otherwise false
     */
    private boolean checkScoreHasMetrics(ScoreItem scoreItem, Set<String> exsitedMetrics) {
        for (ExtendItem subItem : scoreItem.getItemList()) {
            if (subItem.getBasicItem() instanceof ScoreItem) {
                if (checkScoreHasMetrics((ScoreItem) subItem.getBasicItem(), exsitedMetrics)) {
                    return true;
                }
            } else if (subItem.getBasicItem() instanceof MetricItem) {
                MetricItem metricItem = (MetricItem) subItem.getBasicItem();
                if (exsitedMetrics.contains(metricItem.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Create a default MetricsDescription. This method should be removed after
     * all kinds of metrics is prepared. Current return a default
     * MetricsDescription.
     * 
     * @param metricsName
     *            metrics name
     * @return default MetricsDescription
     */
    private MetricsDescription createDefaultMetricsDescription(String metricsName) {
        LOGGER.info("Description for metric : " + metricsName + " does not exist, please fix it ASAP.");

        MetricsDescription description = new MetricsDescription();
        description.setMetricName(metricsName);
        description.setOverview("Overview for " + metricsName + " is not ready now, it would be comming soon...");

        description.setMetricFormula(MetricEngine.getScoreItemFormula(metricsName));

        return description;
    }
}
