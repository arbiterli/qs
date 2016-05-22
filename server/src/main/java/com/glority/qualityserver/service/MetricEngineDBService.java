package com.glority.qualityserver.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.RecordMetric;

/**
 * this interface is for score engine.
 * 
 * @author liheping
 * 
 */
public interface MetricEngineDBService {
    /**
     * get build metric whose type and name are specified.
     * 
     * @param type
     * @param name
     * @param buildId
     * @return
     */
    List<BuildMetric> getBuildMetric(String type, String name, long buildId);

    /**
     * get all the metrics in build.
     * 
     * @param buildId
     * @return
     */
    List<BuildMetric> getBuildMetrics(long buildId);

    /**
     * get all the metrics in builds which are created in the time period.
     * 
     * if both time is null, get all the metrics in product, else if start time
     * is null, then get all the metrics before endTime, else if end tiem is
     * null, then get all the metrics after startTime
     * 
     * @param productId
     * @param startTime
     * @param endTime
     * @return
     */
    List<BuildMetric> getBuildMetrics(long productId, Timestamp startTime, Timestamp endTime);

    /**
     * get the build for score calculate, time is set to be now.
     * 
     * @param productId
     * @param stage
     * @return
     */
    Build getBuildForScore(long productId, ProductStage stage);

    /**
     * get the build for score calculate.
     * 
     * @param productId
     * @param stage
     * @param date
     * @return
     */
    Build getBuildForScore(long productId, ProductStage stage, Timestamp date);

    /**
     * get all the builds for score calculate in the time period.
     * 
     * if build not exists for score calculate in one day, this is represented
     * by a build with id =-1
     * 
     * @param productId
     * @param phase
     * @param startTime
     * @param endTime
     * @return
     */
    Map<Date, Build> getBuilds(long productId, ProductStage phase, List<Date> dateList);

    /**
     * get all the record metrics sampled in time period.
     * 
     * @param productId
     * @return
     */
    List<RecordMetric> getRecordMetrics(long productId, Timestamp startTime, Timestamp endTime);

    /**
     * get all the record metrics in this sample time.
     * 
     * @param sampleTime
     * @return
     */
    List<RecordMetric> getRecordMetrics(long productId, Timestamp sampleTime);

    /**
     * Get build by ID.
     * 
     * @param buildId
     * @return
     */
    Build getBuild(long buildId);

    /**
     * get phase.
     * 
     * @param productId
     * @param phase
     * @return
     */
    Phase getPhase(long productId, ProductStage phase);

    /**
     * check whether the product has server.
     * 
     * @param productId
     * @return
     */
    boolean hasProductionServer(long productId);

    /**
     * check whether the nagios watch is working. include feature open and
     * nagios config is ok.
     * 
     * @param productId
     * @param phase
     * @return
     */
    boolean checkNagiosWatch(long productId, ProductStage phase);

    /**
     * check whether the cloud watch is working, include feature open and cloud
     * watch config is ok.
     * 
     * @param productId
     * @param phase
     * @return
     */
    boolean checkCloudWatch(long productId, ProductStage phase);
}
