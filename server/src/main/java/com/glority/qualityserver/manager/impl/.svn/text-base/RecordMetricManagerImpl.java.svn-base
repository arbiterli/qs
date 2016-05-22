package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.RecordMetricDao;
import com.glority.qualityserver.manager.RecordMetricManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.RecordMetric;
import com.glority.qualityserver.model.Server;

/**
 * Record Metric manager implement.
 * 
 * @author liheping
 * 
 */
@Service("recordMetricManger")
public class RecordMetricManagerImpl extends GenericManagerImpl<RecordMetric, Long> implements RecordMetricManager {

    @Autowired
    private RecordMetricDao recordMetricDao;

    @Override
    protected GenericDao<RecordMetric, Long> getDao() {
        return this.recordMetricDao;
    }

    public List<RecordMetric> getLatestSampleMetrics(long productId, MetricType type) {

        return this.recordMetricDao.getLatestSampleMetrics(productId, type.toString());
    }

    public RecordMetric saveRecordMetric(Product product, Server server, MetricType type, MetricName name,
            String value, Timestamp sampleTime, String externInfo) {
        RecordMetric metric = new RecordMetric();

        metric.setCreateTime(new Timestamp(new Date().getTime()));
        metric.setName(name.toString());
        metric.setNewValue(value);
        metric.setProduct(product);
        metric.setSampleTime(sampleTime);
        metric.setType(type.toString());
        metric.setExternInfo(externInfo);
        if (server != null) {
            metric.setServerId(server.getId());
        }
        return super.save(metric);

    }

    public Timestamp getLatestSampleTime(long productId, MetricType type) {
        List<RecordMetric> metricList = this.recordMetricDao.getLatestSampleMetrics(productId, type.toString());

        if (metricList == null || metricList.isEmpty()) {
            return null;
        }

        return metricList.get(0).getSampleTime();
    }

    public RecordMetric getLatestMetricRecord(long productId, MetricType type, MetricName name) {
        List<RecordMetric> metricList = this.recordMetricDao.getRecordMetrics(productId, type.toString(),
                name.toString(), 1);
        if (metricList == null || metricList.isEmpty()) {
            return null;
        }
        return metricList.get(0);
    }

    public List<RecordMetric> getRecordMetricsForSampleTime(long productId, Timestamp sampleTime) {

        return this.recordMetricDao.getRecordMetricsForSampleTime(productId, sampleTime);
    }

    public List<RecordMetric> getRecordMetrics(long productId, Timestamp startTime, Timestamp endTime) {

        return this.recordMetricDao.getRecordMetrics(productId, startTime, endTime);
    }

}
