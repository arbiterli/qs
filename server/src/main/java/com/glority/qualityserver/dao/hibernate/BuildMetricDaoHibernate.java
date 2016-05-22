package com.glority.qualityserver.dao.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.BuildMetricDao;
import com.glority.qualityserver.model.BuildMetric;

/**
 * Hibernate implement for BuildMetric DAO.
 */
@Repository("buildMetricDao")
public class BuildMetricDaoHibernate extends GenericDaoHibernate<BuildMetric, Long> implements BuildMetricDao {

    /**
     * Default constructor.
     */
    public BuildMetricDaoHibernate() {
        super(BuildMetric.class);
    }

    /**
     * get the latest metrics in build whose type is the specified one.
     * 
     * @param buildId
     *            the specified build from where to get the build metric
     * @param type
     *            the specified type which the build metric's type is
     * @return List<BuildMetric>, if not exists, return empty list
     */
    @SuppressWarnings("unchecked")
    public List<BuildMetric> getLatestMetricInBuildForType(long buildId, String type) {

        List<BuildMetric> metrics = this.getHibernateTemplate().find(
                "from BuildMetric where type = ? and build_id = ? order by created_at desc",
                new Object[] { type, Long.valueOf(buildId) });

        if (metrics == null || metrics.isEmpty()) {
            return new ArrayList<BuildMetric>();
        }

        List<BuildMetric> resultList = new ArrayList<BuildMetric>();

        BuildMetric standardMetric = metrics.get(0);

        for (BuildMetric metric : metrics) {

            if (!metric.getCreatedAt().equals(standardMetric.getCreatedAt())) {
                break;
            }

            resultList.add(metric);
        }

        return resultList;
    }

    /**
     * get all the metrics in build order by time desc.
     * 
     * @param buildId
     *            the specified build from where to get the build metric
     * @return List<BuildMetric>, if not exists, return empty list
     */
    @SuppressWarnings("unchecked")
    public List<BuildMetric> getBuildMetrics(long buildId) {
        List<BuildMetric> metrics = this.getHibernateTemplate().find(
                "from BuildMetric where build_id = ? order by created_at desc",
                new Object[] { Long.valueOf(buildId) });

        if (metrics == null || metrics.isEmpty()) {
            return new ArrayList<BuildMetric>();
        }

        return metrics;
    }

    /**
     * get all the build metrics for build in the period.
     * 
     * @param productId
     *            the product's id
     * @param startTime
     *            the start time of the period
     * @param endTime
     *            the end time of the period
     * @return List<BuildMetric>, if not exists, return empty list
     */
    @SuppressWarnings("unchecked")
    public List<BuildMetric> getBuildMetricsInTimePeriod(long productId, Timestamp startTime, Timestamp endTime) {
        List<Object> metricAndBuilds = this.getHibernateTemplate().find(
                "from BuildMetric bm, Build b where 1=1 and bm.builds = b and"
                        + " b.product.id = ? and b.createdAt > ? and b.createdAt < ? order by b.id, b.createdAt desc",
                new Object[] { Long.valueOf(productId), startTime, endTime });

        List<BuildMetric> metricList = new ArrayList<BuildMetric>();

        if (metricAndBuilds != null) {
            for (Object obj : metricAndBuilds) {
                Object[] metricAndBuild = (Object[]) obj;
                metricList.add((BuildMetric) metricAndBuild[0]);
            }
        }
        return metricList;
    }

    /**
     * Get the latest BuildMetric with given product id.
     * @param productId the product id
     * @return list of BuildMetric, empty list of not exists
     */
    @SuppressWarnings("unchecked")
    public List<BuildMetric> getLatestMetricWithProduct(long productId) {
        String hql = "from BuildMetric bm where bm.produtId = " + productId  + " and bm.builds.id "
            + "= (select max(t.builds.id) from BuildMetric t where t.produtId = " + productId + ")";
        return this.getHibernateTemplate().find(hql);
    }
}
