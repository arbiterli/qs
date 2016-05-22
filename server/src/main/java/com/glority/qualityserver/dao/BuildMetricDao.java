package com.glority.qualityserver.dao;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.model.BuildMetric;

/**
 * Metric DAO interface.
 */
public interface BuildMetricDao extends GenericDao<BuildMetric, Long> {

    /**
     * get the latest metrics in build whose type is the specified one.
     * 
     * @param buildId
     *            the specified build from where to get the build metric
     * @param type
     *            the specified type which the build metric's type is
     * @return List<BuildMetric>, if not exists, return empty list
     */
    List<BuildMetric> getLatestMetricInBuildForType(long buildId, String type);

    /**
     * get all the metrics in build order by time desc.
     * 
     * @param buildId
     *            the specified build from where to get the build metric
     * @return List<BuildMetric>, if not exists, return empty list
     */
    List<BuildMetric> getBuildMetrics(long buildId);

    /**
     * get all the build metrics for build in the period.
     * 
     * @param productId
     *            the product's id
     * @param startTime
     *            the start time of the period
     * @param endTime
     *            the end time of the period
     * @return List<BuildMetric>, if not exists, return empty list
     */
    List<BuildMetric> getBuildMetricsInTimePeriod(long productId, Timestamp startTime, Timestamp endTime);

    /**
     * Get latest build metric for given product.
     * @param productId the product id
     * @return list of BuildMetric
     */
    List<BuildMetric> getLatestMetricWithProduct(long productId);

}
