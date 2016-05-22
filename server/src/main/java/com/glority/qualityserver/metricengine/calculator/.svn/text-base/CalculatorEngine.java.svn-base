package com.glority.qualityserver.metricengine.calculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ServerErrorCollector;
import com.glority.qualityserver.metricengine.BasicItem;
import com.glority.qualityserver.metricengine.DataItem;
import com.glority.qualityserver.metricengine.ExtendItem;
import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.metricengine.ScoreItem;

/**
 * Used to calculate the score.
 * 
 * @author xxd
 */
public enum CalculatorEngine {
    INSTANCE;

    public static final String DATA_TYPE_INTEGER = "Integer";
    public static final String DATA_TYPE_DOUBLE = "Double";
    public static final String DATA_TYPE_DOUBLE_THREE = "DoubleThree";
    public static final String DATA_TYPE_PERCENT_ONE = "PercentOne";
    public static final String DATA_TYPE_PERCENT_THREE = "PercentThree";

    public static final int PERCENT_FRACTION_DIGIT_ONE = 1;
    public static final int PERCENT_FRACTION_DIGIT_THREE = 3;

    private static NumberFormat tdnf = new DecimalFormat("0.000");
    private static NumberFormat dnf = new DecimalFormat("0.00");
    private static NumberFormat inf = new DecimalFormat("0");
    private static NumberFormat pnf = NumberFormat.getPercentInstance();

    private static final Logger LOGGER = Logger.getLogger(CalculatorEngine.class);
    private Map<String, ScoreCalculator> calculators;

    CalculatorEngine() {
        calculators = new HashMap<String, ScoreCalculator>();
        this.addCalculator(new LinearScoreCalculator());
        this.addCalculator(new LinearScoreWithBackupDataCalculator());
        this.addCalculator(new LinearScoreWithFullScoreForNoDataCalculator());
        this.addCalculator(new Per1000RateLinearScoreCalculator());
        this.addCalculator(new SumScoreWithDynamicPower());
        this.addCalculator(new SumWithPowerCalculator());
        this.addCalculator(new FullScoreWithSpecifiedStatusCalculator());
        this.addCalculator(new HasServerCalculator());
        this.addCalculator(new SumScoreWithCheckExists());
        this.addCalculator(new HasCloudWatchCalculator());
        this.addCalculator(new HasNagiosWatchCalculator());
        this.addCalculator(new AverageMetricCalculator());
        this.addCalculator(new SumMetricCalculator());
        this.addCalculator(new StatisticInvalidChangesCalculator());
        this.addCalculator(new FullScoreWithSpecifiedStatusCalculator());
        this.addCalculator(new HasServerCalculator());
        this.addCalculator(new SumScoreWithCheckExists());
        this.addCalculator(new ReduceOneHundredCalculator());
        this.addCalculator(new HasTestCalculator());
    }

    public void addCalculator(ScoreCalculator calculator) {
        calculators.put(calculator.getName(), calculator);
    }

    public List<Object> calculateMetric(MetricItem item, MetricEngineProfile profile, MetricEngineCache cache) {
        if (StringUtils.isEmpty(item.getMethod())) {
            return Collections.emptyList();
        }
        ScoreCalculator calculator = calculators.get(item.getMethod());

        if (calculator == null) {
            LOGGER.error(item.getMethod() + " method for metric calculate not exist in CalculatorEngine");
            return new ArrayList<Object>();
        }

        return calculator.calculateMetric(item, profile, cache);
    }

    public ExtendItem calculateScore(ScoreItem scoreItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (StringUtils.isEmpty(scoreItem.getMethod())) {
            return null;
        }
        ScoreCalculator calculator = calculators.get(scoreItem.getMethod());

        if (calculator == null) {
            LOGGER.error(scoreItem.getMethod() + " method for score calculate not exist in CalculatorEngine");
            return null;
        }

        ExtendItem result = calculator.calculateScore(scoreItem, profile, cache);
        this.formatExtendItemData(result, scoreItem);

        return result;
    }

    private void formatExtendItemData(ExtendItem result, ScoreItem scoreItem) {
        if (result == null || StringUtils.isEmpty(scoreItem.getDataType())) {
            return;
        }

        if (Constants.NO_DATA.equals(scoreItem.getData())) {
            return;
        }

        try {
            double value = Double.parseDouble(scoreItem.getData());
            if (DATA_TYPE_INTEGER.equalsIgnoreCase(scoreItem.getDataType())) {
                scoreItem.setData(inf.format(value));
            } else if (DATA_TYPE_DOUBLE.equalsIgnoreCase(scoreItem.getDataType())) {
                scoreItem.setData(dnf.format(value));
            } else if (DATA_TYPE_PERCENT_ONE.equalsIgnoreCase(scoreItem.getDataType())) {
                pnf.setMaximumFractionDigits(PERCENT_FRACTION_DIGIT_ONE);
                pnf.setMinimumFractionDigits(PERCENT_FRACTION_DIGIT_ONE);
                scoreItem.setData(pnf.format(value));
            } else if (DATA_TYPE_PERCENT_THREE.equalsIgnoreCase(scoreItem.getDataType())) {
                pnf.setMaximumFractionDigits(PERCENT_FRACTION_DIGIT_THREE);
                pnf.setMinimumFractionDigits(PERCENT_FRACTION_DIGIT_THREE);
                scoreItem.setData(pnf.format(value));
            } else if (DATA_TYPE_DOUBLE_THREE.equalsIgnoreCase(scoreItem.getDataType())) {
                scoreItem.setData(tdnf.format(value));
            } else {
                LOGGER.info(scoreItem.getDataType() + " type is not supported");
            }
        } catch (Exception e) {
            if (!Constants.NO_DATA.equals(scoreItem.getData())) {
                ServerErrorCollector.getInstance().collectError(
                        "data format for score " + scoreItem.getName() + "failed, wrong data value "
                                + scoreItem.getData(), null);
            }
            LOGGER.info("give up data format");
        }
    }

    public boolean existConditionCheck(ExtendItem extendItem, MetricEngineProfile profile, MetricEngineCache cache) {
        if (StringUtils.isEmpty(extendItem.getExists())) {
            return false;
        }
        ScoreCalculator calculator = calculators.get(extendItem.getExists());

        if (calculator == null) {
            ServerErrorCollector.getInstance().collectError(
                    extendItem.getExists() + " method for exist check not exist in CalculatorEngine", null);
            return false;
        }

        return calculator.existsConditionCheck(extendItem, profile, cache);
    }

    public List<Object> getValues(BasicItem item, MetricEngineProfile profile, MetricEngineCache cache) {
        List<Object> result = new ArrayList<Object>();
        if (item != null) {
            if (item instanceof DataItem) {
                result.add(((DataItem) item).getValue());
            } else if (item instanceof MetricItem) {
                MetricItem metricItem = (MetricItem) item;
                if (StringUtils.isNotEmpty(metricItem.getMethod())) {
                    return calculateMetric(metricItem, profile, cache);
                } else {
                    return cache.getMetricValues(metricItem.getMetricType(), metricItem.getMetricName(),
                            profile.getBuildId(), profile.getRqSampleTime(), profile.getIfaSampleTime());
                }
            } else if (item instanceof ScoreItem) {
                ScoreItem scoreItem = (ScoreItem) item;
                ExtendItem extendItem = calculateScore(scoreItem, profile, cache);
                int score = (extendItem == null) ? 0 : (int) extendItem.getScore();
                result.add(Integer.valueOf(score));
            }
        }
        return result;
    }

}
