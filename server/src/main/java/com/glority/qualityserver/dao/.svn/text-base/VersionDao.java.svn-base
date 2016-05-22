package com.glority.qualityserver.dao;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.model.Version;

/**
 * Version DAO interface.
 * 
 * @author liheping
 * 
 */
public interface VersionDao extends GenericDao<Version, Long> {
    /**
     * check product whether has this version.
     * 
     * @param version
     *            the version string
     * @param productId
     *            the product id
     * @return whether the version is exists
     */
    boolean exists(String version, long productId);

    /**
     * get the versions for stage which contains date.
     * 
     * @param productId
     *            the product id
     * @param stage
     *            product phase
     * @param date
     *            the date to be contained
     * @return List<Version>, if not exists, it is an empty list
     */
    List<Version> getVersions(long productId, ProductStage stage, Timestamp date);

    /**
     * get the versions whose end time is before date.
     * 
     * @param productId
     *            the product id
     * @param stage
     *            product phase
     * @param date
     *            the date
     * @return List<Version>, if not exists, it is an empty list
     */
    List<Version> getVersionsBeforeDate(long productId, ProductStage stage, Timestamp date);

    /**
     * get version by version string.
     * 
     * @param version
     *            the version
     * @param productId
     *            the product id
     * @return Version, if not exists, return null
     */
    Version getVersion(String version, long productId);

    /**
     * get all versions for product.
     * 
     * @param productId
     *            the product id
     * @return List<Version>, if not exists, it is an empty list
     */
    List<Version> getVersions(long productId);
}
