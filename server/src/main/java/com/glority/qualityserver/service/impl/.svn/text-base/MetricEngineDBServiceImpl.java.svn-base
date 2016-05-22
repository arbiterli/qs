package com.glority.qualityserver.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.dao.BuildDao;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.RecordMetric;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.util.DateUtils;

/**
 * metric engine db service implementation.
 * 
 * @author liheping
 * 
 */
@Service("scoreEngineDBService")
public class MetricEngineDBServiceImpl extends DBBaseService implements MetricEngineDBService {

    @Autowired
    private BuildDao buildDao;
    private static final Logger LOGGER = Logger.getLogger(MetricEngineDBServiceImpl.class);

    public List<BuildMetric> getBuildMetric(String type, String name, long buildId) {
        List<BuildMetric> metricList = super.metricManager.getBuildMetrics(buildId);

        List<BuildMetric> result = new ArrayList<BuildMetric>();
        if (metricList != null && !metricList.isEmpty() && name != null && type != null) {
            for (BuildMetric metric : metricList) {
                if (name.equalsIgnoreCase(metric.getName()) && type.equalsIgnoreCase(metric.getType())) {
                    result.add(metric);
                }
            }
        }

        return result;
    }

    public List<BuildMetric> getBuildMetrics(long buildId) {
        return super.metricManager.getBuildMetrics(buildId);
    }

    public Build getBuildForScore(long productId, ProductStage stage) {
        Timestamp now = new Timestamp(new Date().getTime());
        return getBuildForScore(productId, stage, now);
    }

    public Build getBuildForScore(long productId, ProductStage phase, Timestamp date) {
        return this.getBuildForScore(productId, phase, date, null);
    }

    @Transactional
    public Map<Date, Build> getBuilds(long productId, ProductStage phase, List<Date> dateList) {
        Phase cachedPhase = super.phaseManager.getPhase(productId, phase);

        Map<Date, Build> result = new HashMap<Date, Build>();

        for (Date date : dateList) {
            Date endOfDate = DateUtils.getDateEndTime(date);

            Build build = getBuildForScore(productId, phase, new Timestamp(endOfDate.getTime()), cachedPhase);

            if (build == null) {
                build = new Build();
                build.setId(-1L);
            }

            result.put(date, build);
        }

        return result;
    }

    private Build getBuildForScore(long productId, ProductStage phase, Timestamp date, Phase cachedPahse) {
        switch (phase) {
        case DEV:
            return this.getBestBuild(productId, phase, date);
        case TEST:
        case STAGE:
        case PROD:
            Build build = this.buildDao.getProductLatestBuild(productId, phase, date);

            if (build != null) {
                return build;
            }
            return this.getBestBuild(productId, phase, date);
        default:
            return null;
        }
    }

    private Build getBestBuild(long productId, ProductStage stage, Timestamp date) {
        List<Version> versionList = super.versionManager.getStageVersions(productId, stage, date);
        LOGGER.debug("product id : " + productId + " stage : " + stage + " date : "
                + new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS).format(date));
        if (versionList == null || versionList.isEmpty()) {
            return getLatestBuild(productId, stage, date);
        } else {
            for (Version version : versionList) {
                Build build = super.buildManager.getBuildInVersion(productId, version.getId(), stage, date);
                if (build != null) {
                    return build;
                }
            }

            return this.getLatestBuild(productId, stage, date);
        }
    }

    private Build getLatestBuild(long productId, ProductStage stage, Timestamp date) {

        List<Version> versionList = super.versionManager.getStageVersionsBeforeDate(productId, stage, date);

        if (versionList == null || versionList.isEmpty()) {
            return null;
        }

        for (Version version : versionList) {
            Build build = super.buildManager.getBuildInVersion(productId, version.getId(), stage, date);

            if (build != null) {
                return build;
            }
        }

        return null;
    }

    public List<RecordMetric> getRecordMetrics(long productId, Timestamp startTime, Timestamp endTime) {
        Timestamp paramStartTime = startTime == null ? new Timestamp(0) : startTime;
        Timestamp paramEndTime = endTime == null ? new Timestamp(new Date().getTime()) : endTime;

        return super.recordMetricManager.getRecordMetrics(productId, paramStartTime, paramEndTime);
    }

    public List<RecordMetric> getRecordMetrics(long productId, Timestamp sampleTime) {

        return super.recordMetricManager.getRecordMetricsForSampleTime(productId, sampleTime);
    }

    public Build getBuild(long buildId) {
        return super.buildManager.get(buildId);
    }

    public Phase getPhase(long productId, ProductStage phase) {
        return this.phaseManager.getPhase(productId, phase);
    }

    public List<BuildMetric> getBuildMetrics(long productId, Timestamp startTime, Timestamp endTime) {
        // 1970 1 1 00:00:00 is the smallest time which timestamp can represent
        Timestamp paramStartTime = startTime == null ? new Timestamp(0) : startTime;
        Timestamp paramEndTime = endTime == null ? new Timestamp(new Date().getTime()) : endTime;

        return super.metricManager.getBuildMetricsInTimePeriod(productId, paramStartTime, paramEndTime);

    }

    public boolean hasProductionServer(long productId) {
        return super.productManager.hasProductionServer(productId);
    }

    @Override
    public boolean checkNagiosWatch(long productId, ProductStage stage) {
        if (!FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SERVER_MONITORING)) {
            return false;
        }

        Phase phase = super.phaseManager.getPhase(productId, stage);
        if (phase != null) {
            List<Server> serverList = super.serverManager.getSpecifiedServer(phase.getId(),
                    Constants.SERVER_TYPE_OFFICIAL);

            for (Server server : serverList) {
                if (super.serverManager.validateServerForNagiosMonitoring(server)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkCloudWatch(long productId, ProductStage stage) {
        if (!FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SERVER_MONITORING)) {
            return false;
        }

        Phase phase = super.phaseManager.getPhase(productId, stage);
        if (phase != null) {
            List<Server> serverList = super.serverManager.getSpecifiedServer(phase.getId(),
                    Constants.SERVER_TYPE_OFFICIAL);

            for (Server server : serverList) {
                if (super.serverManager.validateServerForCloudwatchMornitoring(server)) {
                    return true;
                }
            }
        }
        return false;
    }

}
