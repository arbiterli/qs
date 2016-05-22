package com.glority.qualityserver.web.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.OverlappingFileLockException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.codehaus.jettison.json.JSONArray;

import com.glority.quality.connectors.svn.SVNDiffTask;
import com.glority.quality.connectors.svn.SVNShowLogTask;
import com.glority.quality.model.SVNLog;
import com.glority.qualityserver.model.HotDeployConfig;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.util.FileLockUtils;
import com.glority.qualityserver.web.controller.HotDeployController;
import com.glority.qualityserver.web.service.SvnSyncService;

/**
 * svn sync serveice implementation.
 * 
 * @author zm.
 * 
 */
public class SvnSyncServiceImpl implements SvnSyncService {

    private static final Logger LOGGER = Logger.getLogger(HotDeployController.class);

    private List<SVNLog> svnLogCache;

    private Map<String, List<String>> svnDiffCache;

    private String svnURI;

    private SVNLog deployLog;

    private String svnUser;

    private String svnPassword;

    private Date lastRefreshTime;

    private String cacheFolder;

    private String diffFolder;

    private static final int GROUP_NUM = 10;

    private static final int AMOUNT_DEFAULT = 10;

    private static final int AMOUNT_MAX = 100;

    private static final String NIL = "nil";

    private static final int SLEEP_TIME = 1000;

    private static final String PROP_FILE_PATH = "hotdeploy.properties";

    private static final String CACHE_FOLDER_TAG = "svnLogFolder";

    private static final String DIFF_CACHE_FOLDER_TAG = "svnDiffFolder";

    public SvnSyncServiceImpl() {
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream(PROP_FILE_PATH));
            this.cacheFolder = prop.getProperty(CACHE_FOLDER_TAG);
            this.diffFolder = prop.getProperty(DIFF_CACHE_FOLDER_TAG);
            File svnCacheFolder = new File(cacheFolder);
            if (!svnCacheFolder.exists()) {
                if (!svnCacheFolder.mkdir()) {
                    LOGGER.error("Cann't make directory " + cacheFolder);
                }
            }

            File diffCacheFolder = new File(diffFolder);
            if (!diffCacheFolder.exists()) {
                if (!diffCacheFolder.mkdir()) {
                    LOGGER.error("Cann't make directory " + diffFolder);
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public JSONArray getProductSvnLog(Map<String, String> paramMap) {
        int amount = AMOUNT_DEFAULT;
        int start = 0;
        String sStart = String.valueOf(paramMap.get("iDisplayStart"));
        String sAmount = String.valueOf(paramMap.get("iDisplayLength"));

        if (sStart != null) {
            start = Integer.parseInt(sStart);
            if (start < 0) {
                start = 0;
            }
        }
        if (sAmount != null) {
            amount = Integer.parseInt(sAmount);
            if (amount < AMOUNT_DEFAULT || amount > AMOUNT_MAX) {
                amount = AMOUNT_DEFAULT;
            }
        }

        return getLogData(start, amount);
    }

    public void initCache(Product product, String deployRevision) {
        HotDeployConfig hotDeployConfig = product.getHotDeployConfig();
        if (hotDeployConfig == null) {
            throw new IllegalArgumentException("hotDeployConfig is null");
        }
        this.svnURI = hotDeployConfig.getHotDeploySvn();
        this.svnUser = hotDeployConfig.getSvnUser();
        this.svnPassword = hotDeployConfig.getSvnPassword();
        if (null == svnURI) {
            LOGGER.error("svn uri cann't be null.");
            return;
        }
        svnLogCache = getSvnLogsFromFile(product.getId().toString());
        if (null == svnLogCache) {
            svnLogCache = getSvnLogsFromTask(product);
            lastRefreshTime = new Date();
        }
        Collections.sort(svnLogCache, new SVNLogComparator());
        if (!deployRevision.equals(NIL)) {
            setDeployLog(deployRevision);
            insertDeployLogAsTag();
            initDiffCache(deployRevision, product.getId().toString());
        }
    }

    @Override
    public void refreshCache(Product product, String deployRevision) {
        svnLogCache = getSvnLogsFromTask(product);
        markDeployRevisionInCache(deployRevision, product.getId().toString());
        lastRefreshTime = new Date();
    }

    private void setDeployLog(String deployRevision) {
        for (SVNLog log : svnLogCache) {
            if (log.getRevision().toString().equals(deployRevision)) {
                deployLog = log;
                break;
            }
        }

        if (null == deployLog) {
            LOGGER.error("Deploy revision cann't be found in history.");
        }
    }

    private void insertDeployLogAsTag() {
        int counter = 0;
        boolean hasDeploy = false;
        for (int i = 0; i < svnLogCache.size(); i++) {
            SVNLog tempLog = svnLogCache.get(i);
            if (tempLog.equals(deployLog)) {
                hasDeploy = true;
            }
            counter++;
            if (counter >= GROUP_NUM) {
                if (!hasDeploy) {
                    if (deployLog.getRevision() > svnLogCache.get(i - GROUP_NUM + 1).getRevision()) {
                        svnLogCache.add(i - GROUP_NUM + 1, deployLog);
                    } else {
                        svnLogCache.add(i, deployLog);
                    }
                }
                counter = 0;
                hasDeploy = false;
            }
        }

        if (counter > 0) {
            if (!hasDeploy) {
                if (deployLog.getRevision() > svnLogCache.get(svnLogCache.size() - counter).getRevision()) {
                    svnLogCache.add(svnLogCache.size() - counter, deployLog);
                } else {
                    svnLogCache.add(svnLogCache.size(), deployLog);
                }
            }
        }
    }

    public List<String> getSvnDiff(String productId, String revNew, String revOld) {
        String key = revNew + "_" + revOld;
        if (svnDiffCache == null) {
            svnDiffCache = new HashMap<String, List<String>>();
        }
        if (svnDiffCache.get(key) != null) {
            return svnDiffCache.get(key);
        }

        List<String> diff = getSvnDiffFromFile(productId, key);
        if (null != diff) {
            svnDiffCache.put(key, diff);
            return diff;
        }

        SVNDiffTask diffTask = new SVNDiffTask();
        diffTask.setUsername(svnUser);
        diffTask.setPassword(svnPassword);
        diffTask.setSvnURI(svnURI);
        diffTask.setRevisionNew(revNew);
        diffTask.setRevisionOld(revOld);
        diffTask.setProject(new Project());
        diffTask.process();
        svnDiffCache.put(revNew + revOld, diffTask.getDiffs());
        serializeProductDiffInfo(diffTask.getDiffs(), productId, key);
        return diffTask.getDiffs();
    }

    private JSONArray getLogData(int start, int size) {
        JSONArray logs = new JSONArray();
        for (int i = start; i < start + size; i++) {
            if (i > svnLogCache.size() - 1) {
                break;
            }
            SVNLog log = this.svnLogCache.get(i);
            logs.put(convertToJsonArray(log));
        }
        return logs;
    }

    private JSONArray convertToJsonArray(SVNLog log) {
        JSONArray jsSVNLog = new JSONArray();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsSVNLog.put(log.getRevision().toString());
        jsSVNLog.put(log.getAuthor());
        jsSVNLog.put(log.getMessage());
        jsSVNLog.put(format.format(log.getDate()));
        return jsSVNLog;
    }

    public int getCacheSize() {
        return svnLogCache.size();
    }

    @Override
    public Date getLastRefreshTime() {
        return this.lastRefreshTime;
    }

    /**
     * to compare svn log.
     * 
     * @author zm.
     * 
     */
    private class SVNLogComparator implements Comparator<SVNLog> {

        public int compare(SVNLog log1, SVNLog log2) {
            Long rev1 = log1.getRevision();
            Long rev2 = log2.getRevision();
            return rev1 > rev2 ? -1 : rev1 == rev2 ? 0 : 1;
        }
    }

    private void initDiffCache(final String deployRevision, final String productId) {
        svnDiffCache = new HashMap<String, List<String>>();
        Thread initDiffThread = new Thread(new Runnable() {
            public void run() {
                SVNDiffTask diffTask = new SVNDiffTask();
                diffTask.setUsername(svnUser);
                diffTask.setPassword(svnPassword);
                diffTask.setSvnURI(svnURI);
                diffTask.setProject(new Project());
                final int size = svnLogCache.size();
                for (int i = 0; i < GROUP_NUM; i++) {
                    if (i > size - 1) {
                        break;
                    }
                    String newRevision = svnLogCache.get(i).getRevision().toString();
                    String key = newRevision + "_" + deployRevision;

                    List<String> diff = getSvnDiffFromFile(productId, key);
                    if (null != diff) {
                        svnDiffCache.put(key, diff);
                    } else if (!deployRevision.equals(newRevision)) {
                        diffTask.setRevisionNew(newRevision);
                        diffTask.setRevisionOld(deployRevision);
                        diffTask.process();
                        svnDiffCache.put(key, diffTask.getDiffs());
                        serializeProductDiffInfo(diffTask.getDiffs(), productId, key);
                    }
                }
            }
        });
        initDiffThread.start();
        return;
    }

    @SuppressWarnings("unchecked")
    private List<SVNLog> getSvnLogsFromFile(String productId) {
        List<SVNLog> logs = null;
        File productSvnLogFile = new File(this.cacheFolder + File.separator + productId);
        if (!productSvnLogFile.exists()) {
            return null;
        }
        FileInputStream fileIs = null;
        ObjectInputStream is = null;
        try {
            fileIs = new FileInputStream(productSvnLogFile);
            while (true) {
                try {
                    FileLockUtils.tryLock(productSvnLogFile);
                    is = new ObjectInputStream(fileIs);
                    logs = (List<SVNLog>) is.readObject();
                    FileLockUtils.releaseLock(productSvnLogFile);
                    break;
                } catch (OverlappingFileLockException e) {
                    LOGGER.info(e.getMessage(), e);
                    Thread.sleep(SLEEP_TIME);
                }
            }
            lastRefreshTime = new Date(productSvnLogFile.lastModified());
        } catch (Exception e) {
            LOGGER.error("Serialize product " + productId + " log info failed", e);
            return null;
        } finally {
            try {
                if (null != fileIs) {
                    fileIs.close();
                }

                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return logs;
    }

    @SuppressWarnings("unchecked")
    private List<String> getSvnDiffFromFile(String productId, String key) {
        List<String> diff = null;
        File productSvnDiffFile = new File(this.diffFolder + File.separator + productId
                + File.separator + key);
        if (!productSvnDiffFile.exists()) {
            return null;
        }
        FileInputStream fileIs = null;
        ObjectInputStream is = null;
        try {
            fileIs = new FileInputStream(productSvnDiffFile);
            while (true) {
                try {
                    FileLockUtils.tryLock(productSvnDiffFile);
                    is = new ObjectInputStream(fileIs);
                    diff = (List<String>) is.readObject();
                    FileLockUtils.releaseLock(productSvnDiffFile);
                    break;
                } catch (OverlappingFileLockException e) {
                    LOGGER.info(e.getMessage(), e);
                    Thread.sleep(SLEEP_TIME);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Get product " + productId + " diff info failed", e);
            return null;
        } finally {
            try {
                if (null != fileIs) {
                    fileIs.close();
                }

                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return diff;
    }

    /**
     * to get svn log by svn task.
     * 
     * @param product
     *            the product.
     * @return the svn Logs.
     */
    private List<SVNLog> getSvnLogsFromTask(final Product product) {
        SVNShowLogTask svnShowLogTask = new SVNShowLogTask();
        HotDeployConfig hotDeployConfig = product.getHotDeployConfig();
        svnShowLogTask.setUsername(hotDeployConfig.getSvnUser());
        svnShowLogTask.setPassword(hotDeployConfig.getSvnPassword());
        svnShowLogTask.setSvnURI(hotDeployConfig.getHotDeploySvn());
        svnShowLogTask.setProject(new Project());
        svnShowLogTask.process();
        final List<SVNLog> logs = svnShowLogTask.getSvnLogs();
        Collections.sort(logs, new SVNLogComparator());
        Thread serializeSvnLogsThread = new Thread(new Runnable() {
            public void run() {
                serializeProductLogInfo(logs, product.getId().toString());
            }
        });
        serializeSvnLogsThread.start();
        return logs;
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
     * to mark deploy revision in the cache.
     * 
     * @param deployRevision
     *            the deploy revision.
     */
    private void markDeployRevisionInCache(String deployRevision, String productId) {
        Collections.sort(svnLogCache, new SVNLogComparator());
        if (!deployRevision.equals(NIL)) {
            setDeployLog(deployRevision);
            insertDeployLogAsTag();
            initDiffCache(deployRevision, productId);
        }
    }
}
