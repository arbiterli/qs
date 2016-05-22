package com.glority.qualityserver.manager;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.model.BuildMetric;

/**
 * BuildMetric manager interface.
 * 
 * @author liheping
 * 
 */
public interface BuildMetricManager extends GenericManager<BuildMetric, Long> {

    /**
     * get the metrics for score calculate.
     * 
     * @param buildId
     * @return
     */
    List<BuildMetric> getMetricsForScoreCalculate(long buildId);

    /**
     * get all the metrics in build.
     * 
     * @param buildId
     * @return
     */
    List<BuildMetric> getBuildMetrics(long buildId);

    /**
     * get all build metrics of build created in the period.
     * 
     * the result order by buildId and create time
     * 
     * @return
     */
    List<BuildMetric> getBuildMetricsInTimePeriod(long productId, Timestamp startTime, Timestamp endTime);
}
