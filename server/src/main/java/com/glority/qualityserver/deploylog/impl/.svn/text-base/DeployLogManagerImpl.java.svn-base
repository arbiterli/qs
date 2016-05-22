package com.glority.qualityserver.deploylog.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;

import org.apache.log4j.Logger;

import com.glority.quality.StringUtil;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.deploylog.DeployLog;
import com.glority.qualityserver.deploylog.DeployLogManager;

/**
 * Implementation for DeployLogManager.
 * 
 * @author liheping
 * 
 */
public class DeployLogManagerImpl implements DeployLogManager {
    private static final Logger LOGGER = Logger.getLogger(DeployLogManagerImpl.class);
    private static final String LOG_PATH = "logPath";
    private static final String LOG_FILE_PREFIX = "logFilePrefix";
    private static final String LOG_FILE_SUFFIX = "logFileSuffix";
    private static final String CLEAR_START_TIME = "clearStartTime";
    private static final String CLEAR_INTERVAL_TIME = "clearIntervalTime";

    private String logFilePrefix = "log_";
    private String logFileSuffix = ".log";

    private static final long DEFALUT_CLEAR_START_TIME = 1800000L;
    private static final long DEFAULT_CLEAR_INTERVAL_TIME = 180000L;
    private long clearStartTime = DEFALUT_CLEAR_START_TIME;
    private long cleartIntervalTime = DEFAULT_CLEAR_INTERVAL_TIME;

    private String deployLogPath = null;

    private Hashtable<String, DeployLog> logTable = new Hashtable<String, DeployLog>();

    public DeployLogManagerImpl() {
        ServerSettings settings = ServerSettings.getInstance();
        this.deployLogPath = (String) settings.getSetting(LOG_PATH);

        String prefix = settings.getSetting(LOG_FILE_PREFIX);
        if (!StringUtil.isEmpty(prefix)) {
            this.logFilePrefix = prefix;
        }

        String suffix = settings.getSetting(LOG_FILE_SUFFIX);
        if (!StringUtil.isEmpty(suffix)) {
            this.logFileSuffix = suffix;
        }

        String clearStartTimeString = settings.getSetting(CLEAR_START_TIME);
        if (!StringUtil.isEmpty(clearStartTimeString)) {
            this.clearStartTime = Long.parseLong(clearStartTimeString);
        }

        String cleartIntervalTimeString = settings.getSetting(CLEAR_INTERVAL_TIME);
        if (!StringUtil.isEmpty(cleartIntervalTimeString)) {
            this.cleartIntervalTime = Long.parseLong(cleartIntervalTimeString);
        }

        LOGGER.info("Log path: " + this.deployLogPath + "   logFilePrefix: " + this.logFilePrefix
                + "    logFileSuffix: " + this.logFileSuffix + "    clearStartTime: " + this.clearStartTime
                + " cleartIntervalTime: " + this.cleartIntervalTime);

        // start a thread to clear
        Timer timer = new Timer();
        timer.schedule(new ClearTask(this.logTable), this.clearStartTime, this.cleartIntervalTime);

    }

    public Map<Object, Object> getLogInfo(String key) {
        DeployLog log = this.logTable.get(key);
        LOGGER.debug("get logger , Key : " + key + " log : " + log);
        Map<Object, Object> result = new HashMap<Object, Object>();
        if (log == null) {
            LOGGER.debug("log is removed : " + key);
            result.put(DEPLOY_FINISHED, true);
            List<String> loglist = this.getPersistLog(key);
            result.put(DEPLOY_LOG, loglist);
            return result;
        }

        if (log.isLogRunning()) {
            LOGGER.debug("log is running : " + key);
            result.put(DEPLOY_FINISHED, false);
            List<String> loglist = log.getRunningLog();
            result.put(DEPLOY_LOG, loglist);
        } else {
            LOGGER.debug("log is stopped : " + key);
            this.logTable.remove(key);
            result.put(DEPLOY_FINISHED, true);
            List<String> loglist = this.getPersistLog(key);
            result.put(DEPLOY_LOG, loglist);
        }

        return result;
    }

    private List<String> getPersistLog(String key) {
        List<String> result = new ArrayList<String>();

        File logFile = new File(this.deployLogPath, key);
        if (!logFile.exists() || logFile.isDirectory()) {
            return new ArrayList<String>();
        }
        String filePath = logFile.getAbsolutePath();
        if (filePath != null) {
            FileReader fileReader = null;
            BufferedReader reader = null;
            try {
                fileReader = new FileReader(filePath);
                reader = new BufferedReader(fileReader);
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    result.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }

    public String addDeployLog(DeployLog log) throws Exception {
        String key = getMapKey(log);
        LOGGER.info("generate key : " + key);
        File output = new File(this.deployLogPath, key);
        output.createNewFile();

        log.setPersistentOuput(output);
        this.logTable.put(key, log);

        return key;
    }

    /**
     * use the log file name to be the map key.
     * 
     * @param log
     * @return
     * @throws Exception
     */
    private String getMapKey(DeployLog log) throws Exception {
        if (log == null) {
            return null;
        }

        return this.logFilePrefix + log.getUniquePrefix() + "-" + new Date().getTime() + this.logFileSuffix;
    }

    public void disposeDeployLog(String key) {
        DeployLog log = this.logTable.get(key);
        if (log != null) {
            logTable.remove(key);

            log.dispose();
        }
    }

    /**
     * clear task.
     * 
     * @author Administrator
     * 
     */
    public static class ClearTask extends java.util.TimerTask {
        private Hashtable<String, DeployLog> logTable;

        public ClearTask(Hashtable<String, DeployLog> logTable) {
            this.logTable = logTable;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public void run() {
            if (this.logTable != null) {
                List<String> toRemoveList = new ArrayList<String>();
                for (Iterator iter = logTable.entrySet().iterator(); iter.hasNext();) {
                    Entry entry = (Entry) iter.next();
                    DeployLog log = (DeployLog) entry.getValue();
                    if (!log.isLogRunning()) {
                        toRemoveList.add((String) entry.getKey());
                    }
                }
                for (String toRemoveKey : toRemoveList) {
                    logTable.remove(toRemoveKey);
                }
            }
        }
    }
}
