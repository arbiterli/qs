package com.glority.qualityserver.manager;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Version;

/**
 * Version manager interface.
 * 
 * @author liheping
 * 
 */
public interface VersionManager extends GenericManager<Version, Long> {
    Version getVersion(String version, long productId);

    boolean exists(String version, long productId);

    // Version getVersion(String version, long productId);
    /**
     * get the version for stage which contains the date.
     * 
     * @param productId
     * @param stage
     * @param date
     * @return
     */
    List<Version> getStageVersions(long productId, ProductStage stage, Timestamp date);

    /**
     * get all the version for the stage before this date, order by time.
     * 
     * @param productId
     * @param stage
     * @param date
     * @return
     */
    List<Version> getStageVersionsBeforeDate(long productId, ProductStage stage, Timestamp date);

    /**
     * get all the version for the stage before today, order by time.
     * 
     * @param productId
     * @param stage
     * @param date
     * @return
     */
    List<Version> getStageVersionsBeforeToday(long productId, ProductStage stage);

    /**
     * get all version for product.
     * 
     * @param productId
     * @return
     */
    List<Version> getVersions(long productId);

    /**
     * get all version for product, which contains certified build for phase.
     * 
     * @param productId
     * @param phase
     * @return
     */
    List<Version> getVersions(long productId, ProductStage phase);

    /**
     * validate version.
     * 
     * @param version
     */
    void validate(Version version);

}
