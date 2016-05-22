package com.glority.qualityserver.metricengine;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;

import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.RecordMetric;
import com.glority.qualityserver.schedule.job.BaseJobBean;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.util.DateUtils;

/**
 * cache for engine. this class is to cache the data for engine.
 * 
 * @author liheping
 * 
 */
public class MetricEngineCache {
    private static final Logger LOGGER = Logger.getLogger(MetricEngineCache.class);
    // db data cache for build metrics, the key of the map is build id
    private Map<Long, List<BuildMetric>> buildMetricsMap;
    // db data cache for record metrics
    private Map<Date, List<RecordMetric>> recordMetricsMap;
    // this map put the date reference for score calculate, include dev, test,
    // stage, product phase and sscSampleTime smSampleTime
    private Map<Date, MetricEngineProfile> scoreDateRefMap;

    private MetricEngineDBService dbService;
    private MetricEngineProfile profile;
    private Boolean hasServer;

    /**
     * constructor.
     */
    public MetricEngineCache() {
        this.buildMetricsMap = new HashMap<Long, List<BuildMetric>>();
        this.recordMetricsMap = new HashMap<Date, List<RecordMetric>>();
        this.scoreDateRefMap = new HashMap<Date, MetricEngineProfile>();
    }

    public void setMetricEngineDBService(MetricEngineDBService metricEngineDBService) {
        this.dbService = metricEngineDBService;
    }

    public void setProfile(MetricEngineProfile profile) {
        this.profile = profile;
    }

    /**
     * init the cache, based on the profile.
     */
    public void initCache() {
        if (this.cacheShouldInit()) {
            Date smallestTime = DateUtils.getSmallestDateTime(this.profile.getDateList());
            Timestamp startTime = new Timestamp(DateUtils.getDateStartTime(smallestTime).getTime());

            Date largestTime = DateUtils.getLargestDateTime(this.profile.getDateList());
            Timestamp endTime = new Timestamp(DateUtils.getDateEndTime(largestTime).getTime());

            this.loadBuildMetrics(startTime, endTime);
            this.loadRecordMetrics(startTime, endTime);
            this.initDateScoreRelation();
        }
    }

    /**
     * check whether the cache should be init based on the setted profile.
     * 
     * @return
     */
    private boolean cacheShouldInit() {
        if (this.profile == null) {
            return false;
        }

        if (this.profile.getProductId() < 0) {
            return false;
        }

        if (this.profile.getDateList() == null || this.profile.getDateList().isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * load all the build metrics in the time period.
     * 
     * @param startTime
     * @param endTime
     */
    private void loadBuildMetrics(Timestamp startTime, Timestamp endTime) {

        List<BuildMetric> buildMetricList = this.dbService.getBuildMetrics(this.profile.getProductId(), startTime,
                endTime);

        if (buildMetricList != null) {
            for (BuildMetric metric : buildMetricList) {
                Long buildId = Long.valueOf(metric.getBuilds().getId());
                List<BuildMetric> metricList = this.buildMetricsMap.get(buildId);

                if (metricList == null) {
                    metricList = new ArrayList<BuildMetric>();
                    this.buildMetricsMap.put(buildId, metricList);
                }

                metricList.add(metric);
            }
        }

    }

    /**
     * load all the record metrics in the time period.
     * 
     * @param startTime
     * @param endTime
     */
    private void loadRecordMetrics(Timestamp startTime, Timestamp endTime) {

        LOGGER.debug("startTime :" + new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS).format(startTime));
        LOGGER.debug("endTime :" + new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS).format(endTime));
        List<RecordMetric> recordMetricList = this.dbService.getRecordMetrics(this.profile.getProductId(), startTime,
                endTime);

        if (recordMetricList != null) {
            for (RecordMetric metric : recordMetricList) {
                Date keyDate = this.getKeyForDate(metric.getSampleTime());
                List<RecordMetric> metricList = this.recordMetricsMap.get(keyDate);

                if (metricList == null) {
                    metricList = new ArrayList<RecordMetric>();
                    this.recordMetricsMap.put(keyDate, metricList);
                }

                metricList.add(metric);
            }
        }

    }

    /**
     * set the map relation for date and the related score calculate date.
     */
    private void initDateScoreRelation() {
        Map<ProductStage, Map<Date, Build>> phaseBuildsMap = new HashMap<ProductStage, Map<Date, Build>>();

        List<ProductStage> usefulStageList = ProductStage.getAllUsefulStage();
        for (ProductStage phase : usefulStageList) {
            Map<Date, Build> dateBuildMap = this.dbService.getBuilds(this.profile.getProductId(), phase,
                    this.profile.getDateList());
            phaseBuildsMap.put(phase, dateBuildMap);
        }

        Map<Date, Timestamp> rqTimeMap = this.getSampleTimes(MetricType.METRIC_TYPE_RUN_QUALITY);

        Map<Date, Timestamp> ifaTimeMap = this.getSampleTimes(MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY);

        for (Date date : this.profile.getDateList()) {
            MetricEngineProfile profile = new MetricEngineProfile();

            Map<ProductStage, Long> phaseBuildMap = new HashMap<ProductStage, Long>();
            for (ProductStage phase : usefulStageList) {
                phaseBuildMap.put(phase, phaseBuildsMap.get(phase).get(date).getId());
            }
            profile.setPhaseBuildMap(phaseBuildMap);

            profile.setRqSampleTime(rqTimeMap.get(date));
            profile.setIfaSampleTime(ifaTimeMap.get(date));
            profile.setProductId(this.profile.getProductId());

            Date keyDate = this.getKeyForDate(date);
            this.scoreDateRefMap.put(keyDate, profile);
        }
    }

    /**
     * get the map key for date.
     * 
     * @param date
     * @return
     */
    private Date getKeyForDate(Date date) {
        return DateUtils.getDateEndTime(date);
    }

    /**
     * get metric values base on the metric name.
     * 
     * if metric name is in build metric, buildId is required if metric name is in record metric, then related sample
     * time is required
     * 
     * @param metricType
     * @param metricName
     * @param buildId
     * @param rqSampleTime
     * @param ifaSampleTime
     * @return
     */
    public List<Object> getMetricValues(String metricType, String metricName, long buildId, Timestamp rqSampleTime,
            Timestamp ifaSampleTime) {

        LOGGER.debug("getMetricValues : metricType - " + metricType + " metricName - " + metricName);

        MetricType type = MetricType.getValueOf(metricType);
        if (MetricType.METRIC_TYPE_RUN_QUALITY == type) {
            return this.getMetricValuesFromRecordMetrics(metricType, metricName, rqSampleTime);
        } else if (MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY == type) {
            return this.getMetricValuesFromRecordMetrics(metricType, metricName, ifaSampleTime);
        } else if (MetricType.METRIC_TYPE_INVALID != type) {
            return this.getMetricValuesFromBuildMetrics(metricType, metricName, buildId);
        }
        return new ArrayList<Object>();
    }

    /**
     * get metric values from record metrics.
     * 
     * @param metricType
     * @param metricName
     * @param sampleTime
     * @return
     */
    private List<Object> getMetricValuesFromRecordMetrics(String metricType, String metricName, Timestamp sampleTime) {
        List<Object> result = new ArrayList<Object>();

        if (sampleTime == null) {
            LOGGER.debug("no sample time");
            return null;
        }
        Date keyDate = this.getKeyForDate(sampleTime);
        LOGGER.debug("keyDate : " + new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS).format(keyDate) + "\t"
                + keyDate.hashCode());
        if (!this.recordMetricsMap.keySet().contains(keyDate)) {
            this.lazyLoadRecordMetric(keyDate);
        }

        LOGGER.debug("sampleTime : " + new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS).format(sampleTime));

        List<RecordMetric> recordMetricList = this.getRecordMetricsOnSampleTime(sampleTime);

        LOGGER.debug("recordMetricList.size : " + recordMetricList.size());

        if (recordMetricList != null && !recordMetricList.isEmpty() && metricName != null && metricType != null) {
            for (RecordMetric metric : recordMetricList) {
                if (metricName.equalsIgnoreCase(metric.getName()) && metricType.equalsIgnoreCase(metric.getType())) {
                    result.add(metric);
                }
            }
        }

        LOGGER.debug("result.size : " + result.size());

        return result;
    }

    /**
     * get record metrics on sample time.
     * 
     * @param sampleTime
     * @return
     */
    private List<RecordMetric> getRecordMetricsOnSampleTime(Timestamp sampleTime) {
        Date keyDate = this.getKeyForDate(sampleTime);
        List<RecordMetric> recordMetricList = this.recordMetricsMap.get(keyDate);
        LOGGER.debug("get all record : " + recordMetricList.size() + "\t" + keyDate.hashCode());
        BaseJobBean.translateToSampleTime(sampleTime);
        List<RecordMetric> result = new ArrayList<RecordMetric>();
        if (recordMetricList != null && !recordMetricList.isEmpty()) {
            for (RecordMetric metric : recordMetricList) {
                if (sampleTime.equals(metric.getSampleTime())) {
                    result.add(metric);
                }
            }
        }

        return result;
    }

    /**
     * lazy load record metrics sampled in date.
     * 
     * @param date
     */
    private void lazyLoadRecordMetric(Date date) {
        LOGGER.debug("lazy init for sample time : "
                + new SimpleDateFormat(Constants.DATE_TIME_FORMAT_YMD_HMS).format(date));

        Date startTime = DateUtils.getDateStartTime(date);
        Date endTime = DateUtils.getDateEndTime(date);
        List<RecordMetric> recordMetricList = this.dbService.getRecordMetrics(this.profile.getProductId(),
                new Timestamp(startTime.getTime()), new Timestamp(endTime.getTime()));

        Date keyDate = this.getKeyForDate(date);
        this.recordMetricsMap.put(keyDate, recordMetricList);
    }

    /**
     * get build metric values for specified metric name.
     * 
     * @param metricType
     * @param metricName
     * @param buildId
     * @return
     */
    private List<Object> getMetricValuesFromBuildMetrics(String metricType, String metricName, long buildId) {
        LOGGER.debug("buildId : " + buildId);
        if (!this.buildMetricsMap.keySet().contains(Long.valueOf(buildId))) {
            lazyLoadBuildMetrics(buildId);
        }

        List<Object> result = new ArrayList<Object>();
        List<BuildMetric> buildMetricList = this.buildMetricsMap.get(Long.valueOf(buildId));

        if (buildMetricList != null && !buildMetricList.isEmpty() && metricName != null && metricType != null) {
            for (BuildMetric metric : buildMetricList) {
                if (metricName.equalsIgnoreCase(metric.getName()) && metricType.equalsIgnoreCase(metric.getType())) {
                    result.add(metric);
                }
            }
        }
        LOGGER.debug("result.size : " + result.size());
        return result;
    }

    /**
     * lazy load build metrics for build.
     * 
     * @param buildId
     */
    private void lazyLoadBuildMetrics(long buildId) {
        LOGGER.debug("lazy inited for build : " + buildId);
        List<BuildMetric> buildMetricList = this.dbService.getBuildMetrics(buildId);
        this.buildMetricsMap.put(Long.valueOf(buildId), buildMetricList);
    }

    /**
     * get metric values which metric name contains fuzzyMetricName.
     * 
     * @param metricType
     * @param fuzzyMetricName
     * @return
     */
    public List<String> getMetricValuesWithFuzzyName(String metricType, String fuzzyMetricName) {
        LOGGER.debug("getMetricValuesWithFuzzyName : metricType - " + metricType + " fuzzyMetricName - "
                + fuzzyMetricName);

        MetricType type = MetricType.getValueOf(metricType);

        if (MetricType.METRIC_TYPE_RUN_QUALITY == type) {
            throw new NotImplementedException();
        } else if (MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY == type) {
            throw new NotImplementedException();
        } else if (MetricType.METRIC_TYPE_INVALID != type) {
            return getBuildMetricValuesWithFuzzyName(fuzzyMetricName, this.profile.getBuildId());
        }

        return new ArrayList<String>();
    }

    /**
     * get build metric values which metric name contains fuzzyMetricName in the metrics for specified build.
     * 
     * @param fuzzyMetricName
     * @param buildId
     * @return
     */
    public List<String> getBuildMetricValuesWithFuzzyName(String fuzzyMetricName, long buildId) {
        if (!this.buildMetricsMap.keySet().contains(buildId)) {
            this.lazyLoadBuildMetrics(buildId);
        }

        List<BuildMetric> metricList = this.buildMetricsMap.get(buildId);

        List<String> result = new ArrayList<String>();
        if (metricList != null && !metricList.isEmpty()) {
            for (BuildMetric metric : metricList) {
                if (fuzzyMetricName == null || (metric.getName() != null
                        && metric.getName().contains(fuzzyMetricName))) {
                    result.add(metric.getNewValue());
                }
            }
        }

        return result;
    }

    /**
     * get the map for the specified type metric latest sample time before the date.
     * 
     * @param type
     * @return
     */
    private Map<Date, Timestamp> getSampleTimes(MetricType type) {
        Map<Date, Timestamp> result = new HashMap<Date, Timestamp>();
        if (this.profile != null && this.profile.getDateList() != null) {
            for (Date date : this.profile.getDateList()) {
                Timestamp sampleTime = this.getSampleTime(date, type);
                result.put(date, sampleTime);
            }
        }
        return result;
    }

    /**
     * get the latest sample time in one day.
     * 
     * @param date
     * @param type
     * @return
     */
    public Timestamp getSampleTime(Date date, MetricType type) {
        if (date != null) {
            Date keyDate = this.getKeyForDate(date);
            if (!this.recordMetricsMap.containsKey(keyDate)) {
                this.lazyLoadRecordMetric(date);
            }
            // TODO now just get the metric sample in one day, this may cause
            // problem. it should get those befor this date
            List<RecordMetric> recordMetricList = this.recordMetricsMap.get(keyDate);
            for (RecordMetric metric : recordMetricList) {
                if (type == MetricType.getValueOf(metric.getType())) {
                    return metric.getSampleTime();
                }
            }

        }
        return null;
    }

    /**
     * get metric engine profiles for history scores calculate.
     * 
     * @param phase
     * @return
     */
    public List<MetricEngineProfile> getProfiles(ProductStage phase) {
        List<MetricEngineProfile> result = new ArrayList<MetricEngineProfile>();
        if (this.profile != null && this.profile.getDateList() != null) {
            for (Date date : this.profile.getDateList()) {
                MetricEngineProfile profile = this.scoreDateRefMap.get(this.getKeyForDate(date)).clone();

                profile.setBuildId(profile.getPhaseBuildMap().get(phase));

                result.add(profile);
            }

        }
        return result;
    }

    public boolean hasProductionServer() {
        if (this.hasServer == null) {
            this.hasServer = this.dbService.hasProductionServer(this.profile.getProductId());
        }
        return this.hasServer;
    }

    public boolean checkNagiosWatch(long productId, ProductStage phase) {
        return this.dbService.checkNagiosWatch(productId, phase);
    }

    public boolean checkCloudWatch(long productId, ProductStage phase) {
        return this.dbService.checkCloudWatch(productId, phase);
    }

    public boolean checkHasTest(long buildId) {
        if (!buildMetricsMap.keySet().contains(buildId)) {
            lazyLoadBuildMetrics(buildId);
        }
        List<BuildMetric> metricList = buildMetricsMap.get(buildId);
        if (metricList != null && !metricList.isEmpty()) {
            for (BuildMetric metric : metricList) {
                if ("TEST_SUMMARY".equals(metric.getType())) {
                    return true;
                }
            }
        }
        return false;
    }
}
