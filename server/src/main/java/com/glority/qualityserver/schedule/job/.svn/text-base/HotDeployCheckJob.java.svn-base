package com.glority.qualityserver.schedule.job;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.channels.OverlappingFileLockException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.glority.quality.connectors.svn.SVNDiffTask;
import com.glority.quality.connectors.svn.SVNShowLogTask;
import com.glority.quality.model.SVNLog;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.model.HotDeployConfig;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.util.FileLockUtils;

/**
 * to do hotdeploy check per 5 minutes.
 * 
 * @author zm
 * 
 */
//@QuartzJob(name = "hotDeployCheckJob", cronExp = "0 0/5 * * * ?")
public class HotDeployCheckJob extends BaseJobBean {

    private String cacheFolder;

    private String diffFolder;

    /**
     * the logger.
     */
    private static final Logger LOGGER = Logger.getLogger(HotDeployCheckJob.class);

    private static final int GROUP_NUM = 10;
    /**
     * the time for this thread to sleep.
     */
    private static final int SLEEP_TIME = 1000;

    private static final String PROP_FILE_PATH = "hotdeploy.properties";

    private static final String CACHE_FOLDER_TAG = "svnLogFolder";

    private static final String DIFF_CACHE_FOLDER_TAG = "svnDiffFolder";

    public HotDeployCheckJob() {
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream(PROP_FILE_PATH));
            this.cacheFolder = prop.getProperty(CACHE_FOLDER_TAG);
            this.diffFolder = prop.getProperty(DIFF_CACHE_FOLDER_TAG);
            File svnCacheFolder = new File(cacheFolder);
            if (!svnCacheFolder.exists()) {
                if (!svnCacheFolder.mkdirs()) {
                    LOGGER.error("Cann't make directory " + cacheFolder);
                }
            }

            File diffCacheFolder = new File(diffFolder);
            if (!diffCacheFolder.exists()) {
                if (!diffCacheFolder.mkdirs()) {
                    LOGGER.error("Cann't make directory " + diffFolder);
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        if (!this.isHotDeployCheckEnabled()) {
            LOGGER.info("hotDeployCheckJob not enabled");
            return;
        }
        LOGGER.info("start hotDeployCheckJob ..");

        SVNShowLogTask svnShowLogTask = new SVNShowLogTask();
        SVNDiffTask diffTask = new SVNDiffTask();
        List<Product> products = super.schedulerService.getAllProducts();
        for (Product product : products) {
            if (supportHotDeploy(product)) {
                try {
                    HotDeployConfig hotDeployConfig = product.getHotDeployConfig();
                    svnShowLogTask.setUsername(hotDeployConfig.getSvnUser());
                    svnShowLogTask.setPassword(hotDeployConfig.getSvnPassword());
                    svnShowLogTask.setSvnURI(hotDeployConfig.getHotDeploySvn());
                    svnShowLogTask.setProject(new Project());
                    svnShowLogTask.process();
                    List<SVNLog> svnLogs = svnShowLogTask.getSvnLogs();
                    Collections.sort(svnLogs, new SVNLogComparator());
                    serializeProductLogInfo(svnLogs, product.getId().toString());

                    File productSvnDiffFolder = new File(this.diffFolder + File.separator + product.getId().toString());
                    if (!productSvnDiffFolder.exists()) {
                        if (!productSvnDiffFolder.mkdir()) {
                            LOGGER.error("Cann't make directory " + productSvnDiffFolder.toString());
                        }
                    }
                    diffTask.setUsername(hotDeployConfig.getSvnUser());
                    diffTask.setPassword(hotDeployConfig.getSvnPassword());
                    diffTask.setSvnURI(hotDeployConfig.getHotDeploySvn());
                    diffTask.setProject(new Project());
                    final int size = svnLogs.size();
                    List<SVNLog> tempSvnLogs = null;
                    if (size > GROUP_NUM) {
                        tempSvnLogs = svnLogs.subList(0, GROUP_NUM);
                    } else {
                        tempSvnLogs = svnLogs;
                    }
                    for (int i = 0; i < tempSvnLogs.size(); i++) {
                        for (int j = i + 1; j < tempSvnLogs.size(); j++) {
                            String keyOne = tempSvnLogs.get(i).getRevision().toString() + "_"
                                + tempSvnLogs.get(j).getRevision().toString();
                            String keyTwo = tempSvnLogs.get(j).getRevision().toString() + "_"
                                + tempSvnLogs.get(i).getRevision().toString();
                            if (!isDiffFileExist(product.getId().toString(), keyOne)) {
                                diffTask.setRevisionNew(tempSvnLogs.get(i).getRevision().toString());
                                diffTask.setRevisionOld(tempSvnLogs.get(j).getRevision().toString());
                                diffTask.process();
                                serializeProductDiffInfo(diffTask.getDiffs(), product.getId().toString(), keyOne);
                            }
                            if (!isDiffFileExist(product.getId().toString(), keyTwo)) {
                                diffTask.setRevisionNew(tempSvnLogs.get(j).getRevision().toString());
                                diffTask.setRevisionOld(tempSvnLogs.get(i).getRevision().toString());
                                diffTask.process();
                                serializeProductDiffInfo(diffTask.getDiffs(), product.getId().toString(), keyTwo);
                            }
                        }
                    }
                } catch (Exception e) {
                    super.reportError(e, "product : " + product.getName());
                }
            }
        }
        LOGGER.info("hotDeployCheckJob finished");

    }

    /**
     * to check if support hotdeloy.
     * 
     * @param product
     *            the product.
     * @return to check if support hotdeploy.
     */
    private boolean supportHotDeploy(Product product) {
        HotDeployConfig hotDeployConfig = product.getHotDeployConfig();
        if (hotDeployConfig == null) {
            return false;
        }
        if (null == hotDeployConfig.getHotDeploySvn()) {
            return false;
        }

        if (null == hotDeployConfig.getSvnUser()) {
            return false;
        }

        if (null == hotDeployConfig.getSvnPassword()) {
            return false;
        }
        return true;
    }

    private boolean isDiffFileExist(String productId, String key) {
        File productSvnDiffFile = new File(this.diffFolder + File.separator + productId
                + File.separator + key);
        return productSvnDiffFile.exists();
    }

    /**
     * to compare svn log.
     * 
     * @author zm.
     * 
     */
    private static class SVNLogComparator implements Comparator<SVNLog> {

        public int compare(SVNLog log1, SVNLog log2) {
            Long rev1 = log1.getRevision();
            Long rev2 = log2.getRevision();
            return rev1 > rev2 ? -1 : rev1 == rev2 ? 0 : 1;
        }
    }

    /**
     * to serialize the svn log list of a product.
     * 
     * @param logs
     *            the svn logs.
     * @param productId
     *            the product id.
     */
    private void serializeProductLogInfo(List<SVNLog> logs, String productId) {
        FileOutputStream fileOs = null;
        ObjectOutputStream os = null;
        try {
            File productSvnLogFile = new File(this.cacheFolder + File.separator + productId);
            while (true) {
                try {
                    FileLockUtils.tryLock(productSvnLogFile);
                    fileOs = new FileOutputStream(productSvnLogFile);
                    os = new ObjectOutputStream(fileOs);
                    os.writeObject(logs);
                    FileLockUtils.releaseLock(productSvnLogFile);
                    break;
                } catch (OverlappingFileLockException e) {
                    LOGGER.info(productSvnLogFile.getAbsolutePath() + " is in use");
                    Thread.sleep((int) (SLEEP_TIME * Math.random()));
                }
            }
        } catch (Exception e) {
            LOGGER.error("Serialize product " + productId + " log info failed", e);
        } finally {
            try {
                if (null != fileOs) {
                    fileOs.flush();
                    fileOs.close();
                }

                if (null != os) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    private void serializeProductDiffInfo(List<String> diff, String productId, String key) {
        File productSvnDiffFolder = new File(this.diffFolder + File.separator + productId);
        if (!productSvnDiffFolder.exists()) {
            if (!productSvnDiffFolder.mkdir()) {
                LOGGER.error("Cann't make directory " + productSvnDiffFolder.toString());
            }
        }

        FileOutputStream fileOs = null;
        ObjectOutputStream os = null;
        try {
            File productSvnDiffFile = new File(this.diffFolder + File.separator + productId
                    + File.separator + key);
            while (true) {
                try {
                    FileLockUtils.tryLock(productSvnDiffFile);
                    fileOs = new FileOutputStream(productSvnDiffFile);
                    os = new ObjectOutputStream(fileOs);
                    os.writeObject(diff);
                    FileLockUtils.releaseLock(productSvnDiffFile);
                    break;
                } catch (OverlappingFileLockException e) {
                    LOGGER.info(productSvnDiffFile.getAbsolutePath() + " is in use");
                    Thread.sleep((int) (SLEEP_TIME * Math.random()));
                }
            }
        } catch (Exception e) {
            LOGGER.error("Serialize product " + productId + " diff info failed", e);
        } finally {
            try {
                if (null != fileOs) {
                    fileOs.flush();
                    fileOs.close();
                }

                if (null != os) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * check whether the feature is enabled.
     * 
     * @return if enable.
     */
    private boolean isHotDeployCheckEnabled() {
        FeatureGate featureGate = FeatureGate.getInstance();
        return featureGate.isFeatureEnabled(FeatureGateName.HOTDEPLOY_CHECK);
    }
}
