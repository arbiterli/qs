package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.dao.BuildDao;
import com.glority.qualityserver.dao.ProductDao;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildMetric;
import com.glority.qualityserver.model.Product;

public class BuildMetricDaoHibernateTest extends AbstractBaseTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuildDao buildDao;

    private Product product;
    private Build latestBuild;
    private BuildMetric metric1;
    private BuildMetric metric2;
    private int buildMetricCountBefore;

    @Autowired
    private BuildMetricDaoHibernate buildMetric;

    @Before
    public void setUp() {
        product = productDao.getProduct("QualitySystem");
        List<Build> buildList = buildDao.getBuilds(product.getId(), null, null, Constants.PAGE_SIZE, 1);

        for (int i = 0; i < buildList.size(); i++) {
            if (i == 0) {
                latestBuild = buildList.get(i);
            } else {
                if (buildList.get(i).getId() > latestBuild.getId()) {
                    latestBuild = buildList.get(i);
                }
            }
        }
        assertNotNull(latestBuild);

        buildMetricCountBefore = buildMetric.getBuildMetrics(latestBuild.getId()).size();

        // after get the latest build, create BuildMetric now.
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        metric1 = new BuildMetric();
        metric1.setBuilds(latestBuild);
        metric1.setProdutId(product.getId());
        metric1.setName("test_metric_name_1");
        metric1.setNewValue("test_value_1");
        metric1.setType("test_type");
        metric1.setCreatedAt(createTime);

        metric2 = new BuildMetric();
        metric2.setBuilds(latestBuild);
        metric2.setProdutId(product.getId());
        metric2.setName("test_metric_name_2");
        metric2.setType("test_type");
        metric2.setCreatedAt(createTime);

        buildMetric.save(metric1);
        buildMetric.save(metric2);
    }

    @Test
    public void testGetLatestMetricInBuildForType() {
        assertEquals(0, buildMetric.getLatestMetricInBuildForType(latestBuild.getId(), "DOES_NOT_EXIST").size());
        assertEquals(2, buildMetric.getLatestMetricInBuildForType(latestBuild.getId(), "test_type").size());
    }

    @Test
    public void testGetBuildMetrics() {
        assertEquals(0, buildMetric.getBuildMetrics(0).size());
        // get current build metrics
        List<BuildMetric> ret = buildMetric.getBuildMetrics(latestBuild.getId());
        assertEquals(buildMetricCountBefore + 2, ret.size());
    }

    @Test
    public void getLastestMetricWithProduct() {
        List<BuildMetric> ret = buildMetric.getLatestMetricWithProduct(product.getId());
        Set<String> metricNames = new HashSet<String>();
        for (BuildMetric buildMetricInstance : ret) {
            metricNames.add(buildMetricInstance.getName());
        }
        assertTrue(metricNames.contains("test_metric_name_1"));
        assertTrue(metricNames.contains("test_metric_name_2"));
    }

}
