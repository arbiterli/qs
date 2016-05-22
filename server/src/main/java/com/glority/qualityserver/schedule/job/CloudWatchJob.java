/**
 * 
 */
package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.connectors.amazon.CloudWatchTask;
import com.glority.quality.constants.Amazon.AmazonMetricName;
import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.exception.InvalidDataException;
import com.glority.qualityserver.manager.AlertManager;
import com.glority.qualityserver.model.Alert;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.schedule.QuartzJob;

/**
 * amazon cloud watch.
 * 
 * @author CLB
 * 
 */
// "0/20 * * * * ?"
// "0 0 0/1 * * ?"
@QuartzJob(name = "cloudWatchJob", cronExp = "0 0 0/1 * * ?")
public class CloudWatchJob extends BaseJobBean {
    public static final String CPU_UTILIZATION_UPPER_THRESHOLD_VALUE_INFO = "CPU UTILIZATION UPPER THRESHOLD VALUE";
    public static final String BINDWIDTH_UPPER_THRESHOLD_VALUE_INFO = "NETWORK BINDWIDTH UPPER THRESHOLD VALUE";

    private static final Logger LOGGER = Logger.getLogger(NagiosCheckJob.class);

    private static final int SAMPLE_INTERVAL = 60; // s
    private static final int SAMPLE_PERIOD = 3600; // s
    private static final int S2MS_RATE = 1000;

    private static final int CPU_UPPER_THRESHOLDVALUE_TIME = 600; // s
    private static final double THRESHOLDVALUE_CPU = 90.0; // percent

    private static final long THRESHOLDVALUE_BINDWIDTH = 5000000; // B 5MB
    private static final long BINDWIDTH_UPPER_THRESHOLDVALUE = 1800; // s

    private static final int HOURS_FOR_SAMPLE = 24;
    @Autowired
    protected AlertManager alertManager;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        boolean featureEnabled = FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SERVER_MONITORING);
        if (!featureEnabled) {
            LOGGER.info("CloudWatchJob is disabled");
            return;
        }

        Timestamp sampleTime = super.getSampleTime();
        List<Server> serverList = super.schedulerService.getAllCloudwatchIsActiveServer();
        for (Server server : serverList) {
            Product product = super.schedulerService.getProduct(server);
            this.doGetServerWatchResult(server, product, sampleTime);
            this.doSampleServerAlerts(server, product, sampleTime);
        }
    }

    private void doSampleServerAlerts(Server server, Product product, Timestamp sampleTime) {
        try {
            List<Alert> alertList = this.alertManager.getServerAlerts(server.getId(), AlertType.CLOUD_WATCH,
                    HOURS_FOR_SAMPLE);
            String alertsCount = (alertList == null ? "0" : Integer.toString(alertList.size()));
            this.schedulerService.saveRecordMetric(server, MetricType.METRIC_TYPE_RUN_QUALITY,
                    MetricName.CLOUD_WATCH_ALERTS, alertsCount, sampleTime);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private void doGetServerWatchResult(Server server, Product product, Timestamp sampleTime) {
        try {
            Map<AmazonMetricName, List<Datapoint>> watchResult = getCloudWatchStatus(server, sampleTime);
            this.validateWatchResult(watchResult);

            List<Alert> alertList = new ArrayList<Alert>();

            alertList.addAll(this.cpuUsageCheck(watchResult, product.getId(), server.getId(), sampleTime));
            alertList.addAll(this.networkBindwidthCheck(watchResult, product.getId(), server.getId(), sampleTime));

            super.schedulerService.saveCloudWatchAlerts(alertList, product, server);
        } catch (Exception e) {
            super.reportError(e, "server : " + server.getName());
            LOGGER.error(e.getMessage(), e);
        }
    }

    private void validateWatchResult(Map<AmazonMetricName, List<Datapoint>> watchResult) {
        int dataSize = (SAMPLE_PERIOD / SAMPLE_INTERVAL);

        for (Map.Entry<AmazonMetricName, List<Datapoint>> entry : watchResult.entrySet()) {
            if (entry.getValue().size() != dataSize) {
                throw new InvalidDataException("excpeted size - " + dataSize + " actual size "
                        + entry.getValue().size() + "for " + entry.getKey());
            }
        }
    }

    private List<Alert> networkBindwidthCheck(Map<AmazonMetricName, List<Datapoint>> watchResult, long productId,
            long serverId, Timestamp sampleTime) {
        List<Alert> result = new ArrayList<Alert>();
        if (watchResult != null) {
            List<Datapoint> networkInList = watchResult.get(AmazonMetricName.NETWORK_IN);
            List<Datapoint> networkOutList = watchResult.get(AmazonMetricName.NETWORK_IN);

            if (networkInList == null || networkOutList == null) {
                LOGGER.equals("data for bondwidth is null, server id - " + serverId);
                return result;
            }

            List<Double> valueList = new ArrayList<Double>();
            for (int i = 0; i < networkOutList.size(); i++) {
                Datapoint inPoint = networkInList.get(i);
                Datapoint outPoint = networkOutList.get(i);
                valueList.add(Double.valueOf(inPoint.getAverage() + outPoint.getAverage()));
            }

            Map<Integer, Integer> periods = this.getUpperTimePeriodIndexPairs(valueList, THRESHOLDVALUE_BINDWIDTH,
                    BINDWIDTH_UPPER_THRESHOLDVALUE);
            if (!periods.isEmpty()) {
                for (Map.Entry<Integer, Integer> entry : periods.entrySet()) {
                    Timestamp startTime = new Timestamp(networkInList.get(entry.getKey()).getTimestamp().getTime());
                    Timestamp endTime = new Timestamp(networkInList.get(entry.getValue()).getTimestamp().getTime());

                    Alert alert = this.alertManager.createAlert(productId, serverId, AlertType.CLOUD_WATCH,
                            BINDWIDTH_UPPER_THRESHOLD_VALUE_INFO, startTime, endTime);
                    alert.setCreatedAt(sampleTime);

                    result.add(alert);
                }
            }

        }

        return result;

    }

    private List<Alert> cpuUsageCheck(Map<AmazonMetricName, List<Datapoint>> watchResult, long productId,
            long serverId, Timestamp sampleTime) {
        List<Alert> result = new ArrayList<Alert>();
        if (watchResult != null) {
            List<Datapoint> cpuUsageList = watchResult.get(AmazonMetricName.CPU_UTILIZATION);

            if (cpuUsageList == null) {
                LOGGER.equals("data for CPU_UTILIZATION is null, server id - " + serverId);
                return result;
            }

            List<Double> valueList = new ArrayList<Double>();
            for (int i = 0; i < cpuUsageList.size(); i++) {
                valueList.add(cpuUsageList.get(i).getAverage());
            }

            Map<Integer, Integer> periods = this.getUpperTimePeriodIndexPairs(valueList, THRESHOLDVALUE_CPU,
                    CPU_UPPER_THRESHOLDVALUE_TIME);
            if (!periods.isEmpty()) {
                for (Map.Entry<Integer, Integer> entry : periods.entrySet()) {
                    Timestamp startTime = new Timestamp(cpuUsageList.get(entry.getKey()).getTimestamp().getTime());
                    Timestamp endTime = new Timestamp(cpuUsageList.get(entry.getValue()).getTimestamp().getTime());

                    Alert alert = this.alertManager.createAlert(productId, serverId, AlertType.CLOUD_WATCH,
                            CPU_UTILIZATION_UPPER_THRESHOLD_VALUE_INFO, startTime, endTime);
                    alert.setCreatedAt(sampleTime);

                    result.add(alert);
                }
            }

        }

        return result;
    }

    /**
     * use average method to find the upper time period index pairs.
     * 
     * @param upperList
     * @param period
     * @return
     */
    private Map<Integer, Integer> getUpperTimePeriodIndexPairs(List<Double> srcList,
            double thresholdValue, long period) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        int countForSampeTime = (int) period / SAMPLE_INTERVAL;

        if (srcList.size() >= countForSampeTime && countForSampeTime > 0) {
            int index = 0;
            while (index < srcList.size()) {
                int skipIndex = index + countForSampeTime;
                if (skipIndex <= srcList.size()) {
                    double sum = 0.0;
                    for (int i = index; i < skipIndex; i++) {
                        sum += srcList.get(i);
                    }
                    double averageValue = sum / countForSampeTime;
                    if (averageValue >= thresholdValue) {
                        result.put(Integer.valueOf(index), Integer.valueOf(skipIndex) - 1);
                        index = skipIndex;
                    } else {
                        index++;
                    }
                } else {
                    break;
                }
            }
        }

        return result;
    }

    // protected is for test.
    protected Map<AmazonMetricName, List<Datapoint>> getCloudWatchStatus(Server server, Timestamp sampleTime) {
        CloudWatchTask cloudWatchTask = new CloudWatchTask();
        cloudWatchTask.setPeriod(Integer.valueOf(SAMPLE_INTERVAL));

        Date endTime = sampleTime;
        Date startTime = new Date(endTime.getTime() - SAMPLE_PERIOD * S2MS_RATE);
        cloudWatchTask.setStart(startTime);
        cloudWatchTask.setEnd(endTime);

        Project project = new Project();
        cloudWatchTask.setProject(project);

        cloudWatchTask.setInstanceId(server.getCloudwatchInstanceId());
        cloudWatchTask.setAccessKey(server.getCloudwatchAccessKey());
        cloudWatchTask.setSecretKey(server.getCloudwatchSecretKey());

        cloudWatchTask.execute();

        return cloudWatchTask.getMetricDatapoint();
    }

}
