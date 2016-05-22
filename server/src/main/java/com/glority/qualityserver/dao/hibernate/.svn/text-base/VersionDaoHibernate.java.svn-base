package com.glority.qualityserver.dao.hibernate;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.dao.VersionDao;
import com.glority.qualityserver.model.Version;

/**
 * Hibernate implementation for version dao.
 * 
 * @author liheping
 * 
 */
@Repository("versionDao")
public class VersionDaoHibernate extends GenericDaoHibernate<Version, Long> implements VersionDao {

    /**
     * Default constructor.
     */
    public VersionDaoHibernate() {
        super(Version.class);
    }

    /**
     * check product whether has this version.
     * 
     * @param version
     *            the version string
     * @param productId
     *            the product id
     * @return whether the version is exists
     */
    public boolean exists(String version, long productId) {
        String hql = "from Version where product_id = ? and version = ?";
        Object[] params = new Object[] { Long.valueOf(productId), version };

        return super.exists(hql, params);
    }

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
    public List<Version> getVersions(long productId, ProductStage stage, Timestamp date) {
        String hql = null;
        switch (stage) {
        case DEV:
            hql = "from Version where product_id = ? and dev_start_time <= ? and dev_end_time >= ? "
                    + "order by dev_start_time desc";
            break;
        case TEST:
            hql = "from Version where product_id = ? and test_start_time <= ? and test_end_time >= ? "
                    + "order by test_start_time desc";
            break;
        case STAGE:
            hql = "from Version where product_id = ? and stage_start_time <= ? and stage_end_time >= ? "
                    + "order by stage_start_time desc";
            break;
        case PROD:
            hql = "from Version where product_id = ? and production_start_time <= ? and production_end_time >= ? "
                    + "order by production_start_time desc";
            break;
        default:
            break;
        }

        Object[] params = new Object[] { Long.valueOf(productId), date, date };

        return super.getItems(hql, params);

    }

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
    public List<Version> getVersionsBeforeDate(long productId, ProductStage stage, Timestamp date) {
        String hql = null;
        switch (stage) {
        case DEV:
            hql = "from Version where product_id = ? and dev_end_time < ? order by dev_end_time desc";
            break;
        case TEST:
            hql = "from Version where product_id = ? and test_end_time < ? order by test_end_time desc";
            break;
        case STAGE:
            hql = "from Version where product_id = ? and stage_end_time < ? order by stage_end_time desc";
            break;
        case PROD:
            hql = "from Version where product_id = ? and production_end_time < ? order by production_end_time desc";
            break;
        default:
            break;
        }

        Object[] params = new Object[] { Long.valueOf(productId), date };

        return super.getItems(hql, params);
    }

    /**
     * get version by version string.
     * 
     * @param version
     *            the version
     * @param productId
     *            the product id
     * @return Version, if not exists, return null
     */
    public Version getVersion(String version, long productId) {
        String hql = "from Version where product_id = ? and version = ?";
        Object[] params = new Object[] { Long.valueOf(productId), version };

        return super.getItem(hql, params);
    }

    /**
     * get all versions for product.
     * 
     * @param productId
     *            the product id
     * @return List<Version>, if not exists, it is an empty list
     */
    public List<Version> getVersions(long productId) {
        String hql = "from Version where product_id = ? ";
        Object[] params = new Object[] { Long.valueOf(productId) };

        return super.getItems(hql, params);
    }

}
