package com.glority.qualityserver.manager;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Build;

/**
 * this manager deal with access to build dao, and the logic of certification.
 * 
 * @author liheping
 * 
 */
public interface BuildManager extends GenericManager<Build, Long> {
    /**
     * get the build by product id and job and buildId.
     * 
     * @param productId
     * @param job
     * @param buidId
     * @return
     */
    Build getBuild(long productId, String job, long buidId);

    /**
     * get the last trunk build in version, whose certification is not smaller
     * than stage.
     * 
     * @param productId
     * @param versionId
     * @return
     */
    Build getBuildInVersion(long productId, long versionId, ProductStage stage);

    /**
     * get the last trunk build in version which before date, whose
     * certification is not smaller than stage.
     * 
     * @param productId
     * @param versionId
     * @param date
     * @return
     */
    Build getBuildInVersion(long productId, long versionId, ProductStage stage, Timestamp date);

    /**
     * get all the builds in version, whose certification is not smaller than
     * stage.
     * 
     * @param productId
     * @param versionId
     * @return
     */
    List<Build> getAllBuildsInVersion(long productId, long versionId, ProductStage stage);

    /**
     * get all the builds for product that created_at > startTime & created_at <
     * endTime, the result is order by jenkins_buildeid desc.
     * 
     * @param productId
     *            the product's id.
     * @param startTime
     *            the start time.
     * @param endTime
     *            the end time.
     * @param pageSize
     *            the page size.
     * @param currentPage
     *            the current page number.
     * @return the build list, or an empty list, not null.
     */
    List<Build> getBuildsInPeriod(long productId, Timestamp startTime,
            Timestamp endTime, int pageSize, int currentPage);

    /**
     * certify build to next stage. if the build has a higher stage, it will not
     * set. if the next stage is setted, return the the next stage, otherwise
     * return null.
     * 
     * @param buildId
     * @param stage
     */
    ProductStage certifyBuild(Build build, ProductStage stage);

    /**
     * get the builds count for product that created_at > startTime & created_at
     * < endTime.
     * 
     * @param productId
     *            the product's id.
     * @param startTime
     *            the start time.
     * @param endTime
     *            the end time.
     * @return the builds count.
     */
    int getBuildsCount(long productId, Timestamp startTime, Timestamp endTime);

    /**
     * to get the latest build of the product in certain stage.
     * 
     * @param productId
     *            the product id.
     * @param productStage
     *            the product stage.
     * @return the latest build.
     */
    Build getProductLatestBuild(long productId, ProductStage productStage);
}
