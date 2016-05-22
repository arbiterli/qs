package com.glority.qualityserver.dao.hibernate;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.AbstractBaseTest;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.dao.BuildDao;
import com.glority.qualityserver.dao.ProductDao;
import com.glority.qualityserver.dao.VersionDao;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Version;

/**
 * Junit test for BuildAO.
 * 
 * @author Chenhong
 * 
 */
public class BuildDaoTest extends AbstractBaseTest {
    @Autowired
    private BuildDao buildDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private VersionDao versionDao;

    private static final long BEFORE_JENKINS_BUILD_ID = 1001L;
    private static final long IN_JENKINS_BUILD_ID = 1002L;
    private static final long AFTER_JENKINS_BUILD_ID = 1003L;
    private static final int NUM_3 = 3;
    private static final int NUM_TO_CREATE = 200;

    private Timestamp earlierTime = Timestamp.valueOf("2112-09-10 00:00:00");
    private Timestamp laterTime = Timestamp.valueOf("2112-10-01 00:00:00");

    private Timestamp beforeTime = Timestamp.valueOf("2112-09-09 00:00:00");
    private Timestamp inTime = Timestamp.valueOf("2112-09-11 00:00:00");
    private Timestamp afterTime = Timestamp.valueOf("2112-11-01 00:00:00");

    private Product product;
    private Version version;
    private int beforeBuildCount = 0;
    private int beforeBuildInPeriodCount;

    private Build buildBefore;
    private Build buildIn;
    private Build buildAfter;

    /**
     * Setup.
     */
    @Before
    public void setUp() {

        product = productDao.getProduct("QualitySystem");

        version = versionDao.getVersions(product.getId()).get(0);

        beforeBuildCount = buildDao.getAllBuildsForProductInVersion(product.getId(), version.getId()).size();
        beforeBuildInPeriodCount = buildDao.getBuildsCount(product.getId(), earlierTime, laterTime);

        buildBefore = new Build();
        buildBefore.setJenkinsJobname("test_jenkins_job_before");
        buildBefore.setJenkinsBuildId(BEFORE_JENKINS_BUILD_ID);
        buildBefore.setProduct(product);
        buildBefore.setVersion(version);
        buildBefore.setCreatedAt(beforeTime);

        buildIn = new Build();
        buildIn.setJenkinsJobname("test_jenkins_job_in");
        buildIn.setJenkinsBuildId(IN_JENKINS_BUILD_ID);
        buildIn.setProduct(product);
        buildIn.setVersion(version);
        buildIn.setCreatedAt(inTime);

        buildAfter = new Build();
        buildAfter.setJenkinsJobname("test_jenkins_job_after");
        buildAfter.setJenkinsBuildId(AFTER_JENKINS_BUILD_ID);
        buildAfter.setProduct(product);
        buildAfter.setVersion(version);
        buildAfter.setCreatedAt(afterTime);

        buildDao.save(buildBefore);
        buildDao.save(buildIn);
        buildDao.save(buildAfter);

    }

    @Test
    public void testGetBuild() {
        Build ret = buildDao.getBuild(product.getId(), "test_jenkins_job_before", BEFORE_JENKINS_BUILD_ID);
        assertEquals(BEFORE_JENKINS_BUILD_ID, ret.getJenkinsBuildId().longValue());
        assertEquals("test_jenkins_job_before", ret.getJenkinsJobname());
    }

    @Test
    public void testGetBuildsInVersionBeforeDate() {
        Long productId = product.getId();
        Long versionId = version.getId();
        List<Build> beforeTimeList = buildDao.getBuildsInVersionBeforeDate(productId, versionId, earlierTime);
        List<Build> inTimeList = buildDao.getBuildsInVersionBeforeDate(productId, versionId, laterTime);

        assertTrue(inTimeList.size() > 0);

        inTimeList.removeAll(beforeTimeList);

        assertTrue(inTimeList.size() == 1);

        Build build = inTimeList.get(0);
        assertEquals("test_jenkins_job_in", build.getJenkinsJobname());
    }

    @Test
    public void testGetAllBuildsForProductInVersion() {
        List<Build> ret = buildDao.getAllBuildsForProductInVersion(product.getId(), version.getId());

        int currentBuildCount = ret.size();
        assertEquals(beforeBuildCount + NUM_3, currentBuildCount);
    }

    @Test
    public void testGetBuildsInPeriod() {
        List<Build> ret = buildDao.getBuilds(product.getId(), earlierTime, laterTime, Constants.PAGE_SIZE, 1);
        assertTrue(ret.size() == 1);

        assertEquals(beforeBuildInPeriodCount + 1, ret.size());

        Build build = ret.get(ret.size() - 1);
        assertEquals("test_jenkins_job_in", build.getJenkinsJobname());

    }

    @Test
    public void testGetBuildsAfterDate() {
        List<Build> afterEarly = buildDao.getBuilds(product.getId(), earlierTime, null, Constants.PAGE_SIZE, 1);
        List<Build> afterLater = buildDao.getBuilds(product.getId(), laterTime, null, Constants.PAGE_SIZE, 1);

        assertTrue(afterLater.size() < afterEarly.size());
    }

    @Test
    public void testGetBuildsBeforeDate() {
        List<Build> beforeTimeList = buildDao.getBuilds(product.getId(), null, earlierTime, Constants.PAGE_SIZE, 1);
        List<Build> inTimeList = buildDao.getBuilds(product.getId(), null, laterTime, Constants.PAGE_SIZE, 1);

        assertTrue(inTimeList.size() > 0);

        inTimeList.removeAll(beforeTimeList);

        assertTrue(inTimeList.size() == 1);

        Build build = inTimeList.get(0);
        assertEquals("test_jenkins_job_in", build.getJenkinsJobname());
    }

    @Test
    public void testCreatePerformance() {
        List<Build> ret = this.buildDao.getAll();
        int before = ret.size();
        List<Build> list = new ArrayList<Build>();
        for (int i = 0; i < NUM_TO_CREATE; i++) {
            Build build = new Build();
            build.setCertification("certification");
            build.setDuration(new Long(i));
            build.setStatus("status");
            build.setSvnUrl("url");

            Product product = new Product();
            product.setId(1L);

            Version version = new Version();
            version.setId(1L);

            build.setProduct(product);
            build.setVersion(version);
            list.add(build);
        }

        for (int i = 0; i < list.size(); i++) {
            this.buildDao.save(list.get(i));
        }

        ret = this.buildDao.getAll();
        int after = ret.size();
        assertEquals(NUM_TO_CREATE, (after - before));
    }
}
