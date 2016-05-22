package com.glority.qualityserver.dao.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.RecordMetricDao;
import com.glority.qualityserver.model.RecordMetric;

/**
 * Hibernate implementation for RecordMetric DAO.
 * 
 * @author liheping
 * 
 */
@Repository("recordMetricDao")
public class RecordMetricDaoHibernate extends GenericDaoHibernate<RecordMetric, Long> implements RecordMetricDao {
    /**
     * Default constructor.
     */
    public RecordMetricDaoHibernate() {
        super(RecordMetric.class);
    }

    /**
     * get the latest sample metrics whose type is specified.
     * 
     * @param productId
     *            the product id
     * @param type
     *            the metric type
     * @return List<RecordMetric>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<RecordMetric> getLatestSampleMetrics(long productId, String type) {
        List<RecordMetric> metricList = super.getHibernateTemplate().find(
                "from RecordMetric where product_id = ? and type = ? order by sample_time desc",
                new Object[] { Long.valueOf(productId), type });

        if (metricList == null || metricList.isEmpty()) {
            return new ArrayList<RecordMetric>();
        }

        // all the data sampled by one cron is the same, so the following method
        // is used to get the same batch metrics
        Timestamp latestSampleTime = metricList.get(0).getSampleTime();

        List<RecordMetric> result = new ArrayList<RecordMetric>();

        for (RecordMetric metric : metricList) {
            if (latestSampleTime.equals(metric.getSampleTime())) {
                result.add(metric);
            }
        }

        return result;
    }

    /**
     * get all the record metrics sampled at sample time.
     * 
     * @param productId
     *            the product id
     * @param sampleTime
     *            the sample time
     * @return List<RecordMetric>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<RecordMetric> getRecordMetricsForSampleTime(long productId, Timestamp sampleTime) {
        List<RecordMetric> metricList = super.getHibernateTemplate().find(
                "from RecordMetric where product_id = ? and sample_time = ? ",
                new Object[] { Long.valueOf(productId), sampleTime });

        if (metricList == null) {
            return new ArrayList<RecordMetric>();
        }

        return metricList;
    }

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
    @SuppressWarnings("unchecked")
    public List<RecordMetric> getRecordMetrics(long productId, Timestamp startTime, Timestamp endTime) {

        List<RecordMetric> metricList = super.getHibernateTemplate().find(
                "from RecordMetric where product_id = ? and sample_time >= ? and "
                        + "sample_time <= ? order by sample_time desc",
                new Object[] { Long.valueOf(productId), startTime, endTime });

        if (metricList == null) {
            return new ArrayList<RecordMetric>();
        }

        return metricList;
    }

    @SuppressWarnings("unchecked")
    public List<RecordMetric> getRecordMetrics(long productId, String metricType, String metricName, int limit) {
        //TODO:compiler warning,need refactoring code.
        List<RecordMetric> metricList = super.getHibernateTemplate().find(
                "from RecordMetric where product_id = ? and type = ? and name = ? order by sample_time desc ",
                new Object[] { Long.valueOf(productId), metricType, metricName });

        if (metricList != null && !metricList.isEmpty()) {
            if (metricList.size() <= limit) {
                return metricList;
            }

            return metricList.subList(0, limit);
        }

        return new ArrayList<RecordMetric>();
    }
}
