package com.glority.qualityserver.manager;

import java.sql.Timestamp;
import java.util.List;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.RecordMetric;
import com.glority.qualityserver.model.Server;

/**
 * RecordMetric manager interface.
 * 
 * @author liheping
 * 
 */
public interface RecordMetricManager extends GenericManager<RecordMetric, Long> {

    /**
     * save one recordMetric item.
     * 
     * @param product
     * @param server
     * @param type
     * @param name
     * @param value
     * @param sampleTime
     * @param createTime
     * @return
     */
    RecordMetric saveRecordMetric(Product product, Server server, MetricType type, MetricName name, String value,
            Timestamp sampleTime, String externInfo);

    /**
     * get the latest sample metrics for type.
     * 
     * @param productId
     * @param type
     * @return
     */
    List<RecordMetric> getLatestSampleMetrics(long productId, MetricType type);

    /**
     * get the latest sample time for type in db.
     * 
     * @param productId
     * @param metricTypeServerChangeCheck
     * @return
     */
    Timestamp getLatestSampleTime(long productId, MetricType type);

    /**
     * get all the metrics sampled at sample time.
     * 
     * @param productId
     * @param sampleTime
     * @return
     */
    List<RecordMetric> getRecordMetricsForSampleTime(long productId, Timestamp sampleTime);

    /**
     * get all the record metrics in time period.
     * 
     * @param productId
     * @param paramStartTime
     * @param paramEndTime
     * @return
     */
    List<RecordMetric> getRecordMetrics(long productId, Timestamp paramStartTime, Timestamp paramEndTime);

    /**
     * to get the latest record metric.
     * 
     * @param productId
     *            the product id.
     * @param type
     *            the metric type.
     * @return the latest record metric.
     */
    RecordMetric getLatestMetricRecord(long productId, MetricType type, MetricName name);
}
