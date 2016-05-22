/**
 * 
 */
package com.glority.quality.connectors.amazon;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.glority.quality.BaseTask;
import com.glority.quality.constants.Amazon.AmazonDimensionName;
import com.glority.quality.constants.Amazon.AmazonEndPoint;
import com.glority.quality.constants.Amazon.AmazonMetricName;
import com.glority.quality.constants.Amazon.AmazonMetricNamespace;

/**
 * CloudWatchTask to get all metric statistic from amazon.
 * 
 * @author CLB
 * 
 */
public class CloudWatchTask extends BaseTask {
    private Integer period;
    private Date start;
    private Date end;
    private AmazonDimensionName dimensionName;
    private AmazonMetricNamespace namespace;
    private String accessKey;
    private String secretKey;
    private AmazonEndPoint amazonEndPoint;
    private String instanceId;
    private Map<AmazonMetricName, List<Datapoint>> metricDatapoint;

    /**
     * default construct.
     */
    public CloudWatchTask() {
        amazonEndPoint = AmazonEndPoint.US_WEST_2;
        dimensionName = AmazonDimensionName.INSTANCE_ID;
        namespace = AmazonMetricNamespace.EC2;
    }

    public AmazonMetricNamespace getNamespace() {
        return namespace;
    }

    public void setNamespace(AmazonMetricNamespace namespace) {
        this.namespace = namespace;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public AmazonEndPoint getAmazonEndPoint() {
        return amazonEndPoint;
    }

    public void setAmazonEndPoint(AmazonEndPoint amazonEndPoint) {
        this.amazonEndPoint = amazonEndPoint;
    }

    public void setMetricDatapoint(Map<AmazonMetricName, List<Datapoint>> metricDatapoint) {
        this.metricDatapoint = metricDatapoint;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public AmazonDimensionName getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(AmazonDimensionName dimensionName) {
        this.dimensionName = dimensionName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Map<AmazonMetricName, List<Datapoint>> getMetricDatapoint() {
        return metricDatapoint;
    }

    @Override
    public void process() {
        getAllMetricDatapoint();
    }

    /**
     * get all metric Datapoint.
     */
    private void getAllMetricDatapoint() {
        metricDatapoint = new HashMap<AmazonMetricName, List<Datapoint>>();
        CloudWatchClient cloudWatchClient = new CloudWatchClient();
        cloudWatchClient.setCloudWatch(accessKey, secretKey, amazonEndPoint);
        for (AmazonMetricName metricName : AmazonMetricName.values()) {
            cloudWatchClient.setMetricStatisticsRequest(namespace, metricName, dimensionName, instanceId, period,
                    start, end);
            metricDatapoint.put(metricName, cloudWatchClient.getMetricStatistic());
        }
    }
}
