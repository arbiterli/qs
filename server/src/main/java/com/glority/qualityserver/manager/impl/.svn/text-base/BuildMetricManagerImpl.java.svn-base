package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.BuildMetricDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.BuildMetricManager;
import com.glority.qualityserver.model.BuildMetric;

/**
 * Implementation for BuildMetric manager.
 * 
 * @author liheping
 * 
 */
@Service("buildMetricManager")
public class BuildMetricManagerImpl extends GenericManagerImpl<BuildMetric, Long> implements BuildMetricManager {
    @Autowired
    private BuildMetricDao metricDao;

    @Override
    protected GenericDao<BuildMetric, Long> getDao() {

        return this.metricDao;
    }

    public List<BuildMetric> getMetricsForScoreCalculate(long buildId) {
        List<String> scoreMetricTypeList = getScoreMetricTypeList();

        List<BuildMetric> result = new ArrayList<BuildMetric>();

        for (String type : scoreMetricTypeList) {
            result.addAll(this.metricDao.getLatestMetricInBuildForType(buildId, type));
        }

        return result;
    }

    private List<String> getScoreMetricTypeList() {
        List<String> list = new ArrayList<String>();
        list.add("MI");
        list.add("CODEBASEINFO");
        list.add("DUPLICATION");
        list.add("TEST_SUMMARY");
        list.add("DEFECTS");
        list.add("LINT");
        list.add("COVERAGE");
        return list;
    }

    public List<BuildMetric> getBuildMetrics(long buildId) {

        return this.metricDao.getBuildMetrics(buildId);
    }

    public List<BuildMetric> getBuildMetricsInTimePeriod(long productId, Timestamp startTime, Timestamp endTime) {

        return this.metricDao.getBuildMetricsInTimePeriod(productId, startTime, endTime);
    }

}
