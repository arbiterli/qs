package com.glority.qualityserver.schedule.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.manager.VersionManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Version;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.service.IssueSyncService;

/**
 * synchronize issue data with issue db and testrail.
 * 
 * @author liheping
 * 
 */
@QuartzJob(name = "synchronizeIssueJob", cronExp = "0 0 0/1 * * ?")
public class SynchronizeIssueJob extends BaseJobBean {

    private static final Logger LOGGER = Logger.getLogger(SynchronizeIssueJob.class);

    @Autowired
    private ProductManager productManager;
    @Autowired
    private VersionManager versionManager;
    @Autowired
    private IssueSyncService issueSyncService;

    @Override
    @Transactional
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        if (!this.isSynchronizeIssueEnabled()) {
            LOGGER.info("synchronizeIssueJob not enabled");
            return;
        }
        LOGGER.debug("start synchronizeIssueJob ..");

        List<Product> productList = this.productManager.getAllProducts();

        if (productList != null && !productList.isEmpty()) {
            for (Product product : productList) {
                if (!this.productManager.isIssueDBConfiged(product)) {
                    continue;
                }

                List<Version> versionList = this.versionManager.getVersions(product.getId());
                if (versionList != null && !versionList.isEmpty()) {
                    for (Version version : versionList) {
                        try {
                            this.issueSyncService.synchronizeIssue(product, version);
                        } catch (Exception e) {
                            super.reportError(e, "product " + product.getName()
                                    + " version " + version.getVersion());
                            LOGGER.error(e.getMessage(), e);
                        }
                    }
                }
            }
        }
    }

    /**
     * check whether the feature is enabled.
     * 
     * @return
     */
    private boolean isSynchronizeIssueEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.SYNCHRONIZE_ISSUE);
    }
}
