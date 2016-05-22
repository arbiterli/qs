package com.glority.qualityserver.web.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.BuildMetric;

/**
 * Build service interface.
 * 
 * @author liheping
 * 
 */
public interface BuildService {
    List<List<Object>> getFailedTestCase(long buildId);

    List<List<Object>> getSuccessTestCase(long buildId);

    List<HashMap<String, Object>> getHistoryBuildInfo(long productId, Timestamp startDate,
            Timestamp endDate, int pageSize, int currentPage);

    Map<String, Object> getBuildDetail(long buildId);

    // List<Build> getAllBuildsInTheSameVersionWithBuild(long buildId);

    List<BuildMetric> getMetrics(long buildId);

    void certifyBuild(long buildId, ProductStage stage);

    int getBuildsCount(long productId, Timestamp startTime, Timestamp endTime);
}
