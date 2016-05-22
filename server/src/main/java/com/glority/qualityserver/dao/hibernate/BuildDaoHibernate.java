package com.glority.qualityserver.dao.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.dao.BuildDao;
import com.glority.qualityserver.model.Build;

/**
 * Hibernate implement for build dao.
 */
@Repository("buildDao")
public class BuildDaoHibernate extends GenericDaoHibernate<Build, Long> implements BuildDao {
    private static final Logger LOGGER = Logger.getLogger(BuildDaoHibernate.class);

    /**
     * Default constructor.
     */
    public BuildDaoHibernate() {
        super(Build.class);
    }

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
    @SuppressWarnings("unchecked")
    public Build getBuild(long productId, String jenkinsBuildJob, long jenkinsBuildId) {
        List<Build> buildList = super.getHibernateTemplate().find(
                "from Build where product_id = ? and jenkins_jobname = ? and jenkins_buildeid = ?",
                new Object[] { Long.valueOf(productId), jenkinsBuildJob, Long.valueOf(jenkinsBuildId) });

        if (buildList == null || buildList.size() == 0) {
            return null;
        }

        return buildList.get(0);
    }

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
    @SuppressWarnings("unchecked")
    public List<Build> getBuildsInVersionBeforeDate(long productId, long versionId, Timestamp date) {

        List<Build> buildList = super.getHibernateTemplate().find(
                "from Build where product_id = ? and version_id = ? and created_at <= ? "
                        + "order by created_at desc, jenkins_buildeid desc",
                new Object[] { Long.valueOf(productId), Long.valueOf(versionId), date });

        if (buildList == null) {
            return new ArrayList<Build>();
        }
        return buildList;
    }

    /**
     * get all the builds for product in version, the result is order by create
     * time desc.
     * 
     * @param productId
     *            the product's id
     * @param versionId
     *            the version's id
     * @return List<Build>, if not exists, it is an empty list
     */
    @SuppressWarnings("unchecked")
    public List<Build> getAllBuildsForProductInVersion(long productId, long versionId) {
        List<Build> buildList = super.getHibernateTemplate().find(
                "from Build where product_id = ? and version_id = ? order by created_at desc, jenkins_buildeid desc",
                new Object[] { Long.valueOf(productId), Long.valueOf(versionId) });

        if (buildList == null) {
            return new ArrayList<Build>();
        }
        return buildList;
    }

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
    @SuppressWarnings("unchecked")
    public List<Build> getBuilds(final long productId, final Timestamp startTime,
            final Timestamp endTime, final int pageSize, final int currentPage) {
        final StringBuilder hql = new StringBuilder("from Build where product_id = :productId ");
        if (null != startTime) {
            hql.append("and created_at > :startTime ");
        }
        if (null != endTime) {
            hql.append("and created_at < :endTime ");
        }
        hql.append("order by created_at desc, jenkins_buildeid desc");

        List<Build> buildList = super.getHibernateTemplate().executeFind(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) {
                try {
                    final Query query = session.createQuery(hql.toString());
                    query.setFirstResult((currentPage - 1) * pageSize);
                    query.setMaxResults(pageSize);
                    query.setParameter("productId", productId);
                    if (null != startTime) {
                        query.setParameter("startTime", startTime);
                    }
                    if (null != endTime) {
                        query.setParameter("endTime", endTime);
                    }
                    return query.list();
                } catch (HibernateException e) {
                    LOGGER.error("get builds by productId = " + productId
                            + ", startTime = " + startTime
                            + ", endTime = " + endTime
                            + ", pageSize = " + pageSize
                            + ", currentPage = " + currentPage
                            + " fail.");
                    return new ArrayList<Build>();
                }
            }
        });

        if (null == buildList) {
            return new ArrayList<Build>();
        }
        return buildList;
    }

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
    public int getBuildsCount(final long productId, final Timestamp startTime, final Timestamp endTime) {
        final StringBuilder hql = new StringBuilder("select count(*) from Build where product_id = :productId");
        if (null != startTime) {
            hql.append(" and created_at > :startTime");
        }
        if (null != endTime) {
            hql.append(" and created_at < :endTime");
        }

        @SuppressWarnings("rawtypes")
        List buildListCount = super.getHibernateTemplate().executeFind(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) {
                try {
                    final Query query = session.createQuery(hql.toString());
                    query.setParameter("productId", productId);
                    if (null != startTime) {
                        query.setParameter("startTime", startTime);
                    }
                    if (null != endTime) {
                        query.setParameter("endTime", endTime);
                    }
                    return query.list();
                } catch (HibernateException e) {
                    LOGGER.error("get builds count by productId = " + productId
                            + ", startTime = " + startTime
                            + ", endTime = " + endTime
                            + " fail.");
                    return new ArrayList<Build>();
                }
            }
        });

        if (null == buildListCount || 0 == buildListCount.size()) {
            return 0;
        }

        return Integer.parseInt(buildListCount.get(0).toString());
    }

    @Override
    public Build getProductLatestBuild(long productId, ProductStage productStage, Timestamp date) {
        String hql = "from Build bu where bu.product.id = ? and bu.createdAt < ?";
        switch (productStage) {
        case DEV:
            //dev should contain all build.
 //           hql += " and bu.certification in ('dev','test','stage','production')";
            break;
        case TEST:
            hql += " and bu.certification in ('test','stage','production')";
            break;
        case STAGE:
            hql += " and bu.certification in ('stage','production')";
            break;
        case PROD:
            hql += " and bu.certification in ('production')";
            break;
        default:
            return null;
        }
        hql += " order by bu.createdAt desc, bu.jenkinsBuildId desc";
        return super.getItem(hql, new Object[] { Long.valueOf(productId), date });
    }

}
