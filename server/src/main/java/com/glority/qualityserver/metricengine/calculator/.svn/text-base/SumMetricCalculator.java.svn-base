package com.glority.qualityserver.metricengine.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.model.RecordMetric;

/**
 * Sum metric. some metric is saved by server, such as alerts. when used these
 * data for score, we should pre do sth.
 * 
 * @author xxd
 */
public class SumMetricCalculator extends AbstractCalculator {

    @Override
    public List<java.lang.Object> calculateMetric(MetricItem metricItem, MetricEngineProfile profile,
            MetricEngineCache cache) {
        List<Object> result = new ArrayList<Object>();

        List<Object> metricList = cache.getMetricValues(metricItem.getMetricType(), metricItem.getMetricName(),
                profile.getBuildId(), profile.getRqSampleTime(), profile.getIfaSampleTime());

        getLogger().debug(metricItem.getName() + "\t" + metricList);
        if (metricList != null && !metricList.isEmpty()) {
            Object obj = metricList.get(0);
            if (obj instanceof RecordMetric) {
                double sumValue = 0.0;
                for (Object metric : metricList) {
                    RecordMetric record = (RecordMetric) metric;
                    try {
                        double value = Double.parseDouble(record.getNewValue());
                        sumValue += value;
                    } catch (Exception e) {
                        getLogger().debug(e.getMessage(), e);
                        getLogger().debug("do no increase sum value.");
                    }
                }
                RecordMetric resultItem = new RecordMetric();
                resultItem.setNewValue(Double.toString(sumValue));
                result.add(resultItem);
            } else {
                throw new NotImplementedException(
                        "metric not instance of recordmetric in sumMetric method is not implemented.");
            }
        }
        getLogger().debug("result - " + result);
        return result;
    }

    @Override
    public String getName() {
        return "sumMetric";
    }

}