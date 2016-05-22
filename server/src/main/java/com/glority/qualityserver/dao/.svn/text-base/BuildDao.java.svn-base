package com.glority.qualityserver.dao;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Build;

/**
 * Build DAO interface.
 */
public interface BuildDao extends GenericDao<Build, Long> {
    /**
     * get build by product id , jenkins build job and jenkins build id.
     * 
     * @param productId
     *            the product's id
     * @param jenkinsBuildJob
     *            jenkins build job
     * @param jenkinsBuildId
     *            jenkins build id.
     * @return Build, if not exists return null
     */
    Build getBuild(long productId, String jenkinsBuildJob, long jenkinsBuildId);

    /**
     * get the all builds in the version created before the date.
     * 
     * @param productId
     *            the product' id
     * @param versionId
     *            the version's id
     * @param date
     *            specified date
     * @return List<Build>, if not exists, it is an empty list
     */
    List<Build> getBuildsInVersionBeforeDate(long productId, long versionId, Timestamp date);

    /**
     * get all the builds for product in version, the result is order by create time desc.
     * 
     * @param productId
     *            the product's id
     * @param versionId
     *            the version's id
     * @return List<Build>, if not exists, it is an empty list
     */
    List<Build> getAllBuildsForProductInVersion(long productId, long versionId);

    /**
     * get all the builds for product that created_at > startTime & created_at < endTime,
     * the result is order by jenkins_buildeid desc.
     * 
     * @param productId
     *              the product's id.
     * @param startTime
     *              the start time.
     * @param endTime
     *              the end time.
     * @param pageSize
     *              the page size.
     * @param currentPage
     *              the current page number.
     * @return
     *              the build list, or an empty list, not null.
     */
    List<Build> getBuilds(long productId, Timestamp startTime, Timestamp endTime, int pageSize, int currentPage);

    /**
     * get the builds count for product that created_at > startTime & created_at < endTime.
     * 
     * @param productId
     *              the product's id.
     * @param startTime
     *              the start time.
     * @param endTime
     *              the end time.
     * @return
     *              the builds count.
     */
    int getBuildsCount(long productId, Timestamp startTime, Timestamp endTime);

    /**
     * Get all builds for current product.
     * @param productId id of product
     * @param productStage stage of product
     * @param date the date limit
     * @return latest build for current product
     */
    Build getProductLatestBuild(long productId, ProductStage productStage, Timestamp date);
}
