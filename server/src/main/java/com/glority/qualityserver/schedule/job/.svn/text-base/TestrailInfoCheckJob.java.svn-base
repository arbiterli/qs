package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.connectors.testrail.TCOfProductTask;
import com.glority.quality.model.TestCase;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.TestRail;
import com.glority.qualityserver.schedule.QuartzJob;

/**
 * Testrail info check job.
 * 
 * @author liheping
 * 
 */
@QuartzJob(name = "testrailInfoCheckJob", cronExp = "0 0 0/1 * * ?")
public class TestrailInfoCheckJob extends BaseJobBean {

    /**
     * the logger.
     */
    private static final Logger LOGGER = Logger.getLogger(TestrailInfoCheckJob.class);

    /**
     * the product manager.
     */
    @Autowired
    private ProductManager productManager;

    /**
     * the testrail adapter.
     */
    private TCOfProductTask testrail;

    @Override
    @Transactional
    protected void executeInternal(final JobExecutionContext arg0) throws JobExecutionException {
        if (!this.isTestrailInfoCheckEnabled()) {
            LOGGER.info("testrail info check not enabled");
            return;
        }
        LOGGER.debug("start check testrail info ..");
        List<Product> products = super.schedulerService.getAllProducts();
        for (Product product : products) {
            if (!productManager.isTestRailConfiged(product)) {
                continue;
            }
            TestRail rail = product.getTestRail();
            testrail = new TCOfProductTask(rail.getTestrailPassword(), rail.getTestrailServer());
            testrail.setProductId(rail.getTestrailProductId().toString());
            try {
                testrail.process();
            } catch (ConnectorException e) {
                super.reportError(e, "product : " + product.getName());
                LOGGER.error(e.getMessage(), e);
                throw new JobExecutionException(e);
            }
            List<TestCase> testcases = testrail.getTestCases();
            int totalCaseNum = testcases.size();
            int automatedCaseNum = getAutomatedCaseNum(testcases);
            Timestamp sampleTime = super.getSampleTime();
            super.schedulerService.saveRecordMetric(product, null, MetricType.METRIC_TYPE_TESTCASE,
                    MetricName.PRODUCT_TEST_TOTAL_COUNT, String.valueOf(totalCaseNum), sampleTime);
            super.schedulerService.saveRecordMetric(product, null, MetricType.METRIC_TYPE_TESTCASE,
                    MetricName.PRODUCT_AUTOMATED_TEST_COUNT, String.valueOf(automatedCaseNum), sampleTime);
            LOGGER.info("Collect test cases info of product " + product.getDisplayName());
        }
    }

    /**
     * to get the number of automated test cases.
     * @param testcases all the test cases.
     * @return automated test case number.
     */
    private int getAutomatedCaseNum(final List<TestCase> testcases) {
        int counter = 0;
        final int automatedLeftBound = 1;
        final int automatedRightBound = 5;
        for (TestCase testcase : testcases) {
            if (testcase.getStatus() != null) {
                if (testcase.getStatus().ordinal() > automatedLeftBound
                        && testcase.getStatus().ordinal() < automatedRightBound) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * check whether the feature is enabled.
     * @return if enabled.
     */
    private boolean isTestrailInfoCheckEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.TESTRAIL_INFO_CHECK);
    }
}
