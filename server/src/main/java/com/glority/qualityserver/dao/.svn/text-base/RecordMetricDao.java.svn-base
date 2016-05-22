package com.glority.qualityserver.dao;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.model.RecordMetric;

/**
 * Record metric DAO interface.
 * 
 * @author liheping
 * 
 */
public interface RecordMetricDao extends GenericDao<RecordMetric, Long> {
    /**
     * get the latest sample metrics whose type is specified.
     * 
     * @param productId
     *            the product id
     * @param type
     *            the metric type
     * @return List<RecordMetric>, if not exists, it is an empty list
     */
    List<RecordMetric> getLatestSampleMetrics(long productId, String type);

    /**
     * get all the record metrics sampled at sample time.
     * 
     * @param productId
     *            the product id
     * @param sampleTime
     *            the sample time
     * @return List<RecordMetric>, if not exists, it is an empty list
     */
    List<RecordMetric> getRecordMetricsForSampleTime(long productId, Timestamp sampleTime);

    /**
     * get record metrics sampled in time period.
     * 
     * @param productId
     *            the product id
     * @param startTime
     *            the start time of the period
     * @param endTime
     *            the end time of the period
     * @return List<RecordMetric>, if not exists, it is an empty list
     */
    List<RecordMetric> getRecordMetrics(long productId, Timestamp startTime, Timestamp endTime);

    /**
     * to get record metric by type and name.
     * 
     * @param productId
     *            product id.
     * @param metricType
     *            metric type.
     * @param metricName
     *            metric name.
     * @param limit
     *            the number to return.
     * @return a list of record metrics.
     */
    List<RecordMetric> getRecordMetrics(long productId, String metricType, String metricName, int limit);

}
