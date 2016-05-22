package com.glority.qualityserver.metricengine.calculator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import com.glority.qualityserver.metricengine.MetricEngineCache;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.metricengine.MetricItem;
import com.glority.qualityserver.model.RecordMetric;

/**
 * StatisticInvalidChangesCalculator.
 * 
 * @author li.heping
 * 
 */
public class StatisticInvalidChangesCalculator extends AbstractCalculator {
    private final String no = "no";
    private final String yes = "yes";

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "statisticInvalidChanges";
    }

    @Override
    public List<Object> calculateMetric(MetricItem metircItem, MetricEngineProfile profile, MetricEngineCache cache) {
        List<Object> result = new ArrayList<Object>();
        getLogger().debug("before get metric list : " + metircItem);
        List<Object> metricList = cache.getMetricValues(metircItem.getMetricType(), metircItem.getMetricName(),
                profile.getBuildId(), profile.getRqSampleTime(), profile.getIfaSampleTime());

        String resultRecordValue = this.no;
        if (metricList != null && !metricList.isEmpty()) {
            for (Object obj : metricList) {
                if (obj instanceof RecordMetric) {
                    RecordMetric record = (RecordMetric) obj;
                    if (record.getNewValue().equalsIgnoreCase(this.yes)) {
                        resultRecordValue = this.yes;
                        break;
                    }
                } else {
                    throw new NotImplementedException(
                            "metric not instance of recordmetric in"
                            + " StatisticInvalidChanges method is not implemented.");
                }
            }
            RecordMetric metric = new RecordMetric();
            metric.setNewValue(resultRecordValue);
            result.add(metric);
            return result;
        }
        return null;
    }

}
