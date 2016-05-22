package com.glority.qualityserver.metricengine.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.RecordMetric;
/**
 * ReduceOneHundredCalculator
 * @author LHP
 *
 */
public class ReduceOneHundredCalculator extends AbstractCalculator {
    private final double oneHundred = 100;

    @Override
    public String getName() {
        return "reduceOneHundred";
    }

    @Override
    public List<Object> calculateMetric(MetricItem metricItem, MetricEngineProfile profile,
            MetricEngineCache metricsCache) {
        List<Object> result = new ArrayList<Object>();
        getLogger().debug("before get metric list : " + metricItem);
        List<Object> metricList = metricsCache.getMetricValues(metricItem.getMetricType(), metricItem.getMetricName(),
                profile.getBuildId(), profile.getRqSampleTime(), profile.getIfaSampleTime());

        getLogger().debug(metricItem.getName() + "\t" + metricList);
        if (metricList != null && !metricList.isEmpty()) {
            Object obj = metricList.get(0);
            if (obj instanceof RecordMetric) {

                RecordMetric record = (RecordMetric) obj;
                try {
                    double value = Double.parseDouble(record.getNewValue());
                    value = value / this.oneHundred;
                    RecordMetric resultItem = new RecordMetric();
                    resultItem.setNewValue(Double.toString(value));
                    result.add(resultItem);
                } catch (Exception e) {
                    getLogger().error(e.getMessage(), e);
                    getLogger().error("failed to reduce the value, return empty value");
                }

            } else if (obj instanceof BuildMetric) {

                BuildMetric record = (BuildMetric) obj;
                try {
                    double value = Double.parseDouble(record.getNewValue());
                    value = value / this.oneHundred;
                    BuildMetric resultItem = new BuildMetric();
                    resultItem.setNewValue(Double.toString(value));
                    result.add(resultItem);
                } catch (Exception e) {
                    getLogger().error(e.getMessage(), e);
                    getLogger().error("failed to reduce the value, return empty value");
                }
            } else {
                throw new NotImplementedException(
                "metric not instance of recordmetric and buildmetric in reduceOneHundred method is not implemented.");
            }
        }
        getLogger().debug("result " + result);
        return result;
    }
}
