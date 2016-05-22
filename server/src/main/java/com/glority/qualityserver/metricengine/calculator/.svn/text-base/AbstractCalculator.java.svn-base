package com.glority.qualityserver.metricengine.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.glority.qualityserver.metricengine.BasicItem;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.metricengine.ScoreItem;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.RecordMetric;

/**
 * Abstract calculator.
 * 
 * @author xxd
 *
 */
public abstract class AbstractCalculator implements ScoreCalculator {
    protected static final int FULL_SCORE = 100;
    // FIXME: thread not safe
    protected static NumberFormat dnf = new DecimalFormat("0.00");
    protected static NumberFormat inf = new DecimalFormat("0");

    private final Logger logger = Logger.getLogger(this.getClass());

    protected Logger getLogger() {
        return logger;
    }

    @Override
    public List<Object> calculateMetric(MetricItem metircItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return Collections.emptyList();
    }

    @Override
    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return null;
    }

    @Override
    public boolean existsConditionCheck(ExtendItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        return false;
    }
    /**
     * get one value from extendItem.
     * 
     * all the types of value are translate to String.
     * 
     * @param extendItem
     * @return
     */
    protected String getOneValueFromItem(ExtendItem extendItem, MetricEngineProfile profile, MetricEngineCache cache) {
        BasicItem basicItem = extendItem.getBasicItem();
        return getOneValueFromItem(basicItem, profile, cache);
    }

    protected String getOneValueFromItem(BasicItem basicItem, MetricEngineProfile profile, MetricEngineCache cache) {
        List<Object> values = CalculatorEngine.INSTANCE.getValues(basicItem, profile, cache);
        if (values != null && !values.isEmpty()) {
            if (values.get(0) instanceof BuildMetric) {
                BuildMetric metric = (BuildMetric) values.get(0);
                return metric.getNewValue();
            } else if (values.get(0) instanceof RecordMetric) {
                RecordMetric metric = (RecordMetric) values.get(0);
                return metric.getNewValue();
            } else if (values.get(0) instanceof Double) {
                Double doubleValue = (Double) values.get(0);
                return doubleValue.toString();
            } else if (values.get(0) instanceof Integer) {
                Integer intValue = (Integer) values.get(0);
                return intValue.toString();
            } else if (values.get(0) instanceof String) {
                return (String) values.get(0);
            }
        }

        return null;
    }

    /**
     * calculate extend item score, and set related property in extend item.
     * 
     * @param extendItem
     * @param totalPower
     */
    protected void calculateScoreItem(ExtendItem extendItem, double totalPower, MetricEngineProfile profile,
            MetricEngineCache cache) {
        if (extendItem.getPower() <= 0) {
            this.logger.info("processing power 0");
            extendItem.setScore(0);
            extendItem.setRate(0);
            extendItem.setRateScore(0);
        } else {
            String scoreStr = getOneValueFromItem(extendItem, profile, cache);
            getLogger().debug("calculateScoreItem scoreStr" + scoreStr);

            double score = 0;
            if (scoreStr != null) {
                score = Double.parseDouble(scoreStr);
                extendItem.setScore(score);
            }

            if (totalPower != 0) {
                extendItem.setRate(extendItem.getPower() / totalPower);
                extendItem.setRateScore(score * extendItem.getPower() / totalPower);
            } else {
                extendItem.setScore(0);
            }
        }
    }
}
