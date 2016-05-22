/**
 * 
 */
package com.glority.quality.connectors.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.services.cloudwatch.model.Statistic;
import com.glority.quality.constants.Amazon.AmazonDimensionName;
import com.glority.quality.constants.Amazon.AmazonEndPoint;
import com.glority.quality.constants.Amazon.AmazonMetricName;
import com.glority.quality.constants.Amazon.AmazonMetricNamespace;

/**
 * Client for connect CloudWatch
 * 
 * @author Administrator
 * 
 */
public class CloudWatchClient {
    private AmazonCloudWatchClient cloudWatch;
    private GetMetricStatisticsRequest metricStatisticsRequest;

    public AmazonCloudWatchClient getCloudWatch() {
        return cloudWatch;
    }

    public void setCloudWatch(AmazonCloudWatchClient cloudWatch) {
        this.cloudWatch = cloudWatch;
    }

    public GetMetricStatisticsRequest getMetricStatisticsRequest() {
        return metricStatisticsRequest;
    }

    public void setMetricStatisticsRequest(GetMetricStatisticsRequest metricStatisticsReques) {
        this.metricStatisticsRequest = metricStatisticsReques;
    }

    /**
     * default construct.
     */
    public CloudWatchClient() {
        cloudWatch = new AmazonCloudWatchClient();
        metricStatisticsRequest = new GetMetricStatisticsRequest();
    }

    /**
     * set cloud watch.
     * 
     * @param awsCredentialsPropertyFilePath
     *            the awsCredentialsPropertyFilePath to set.
     * @param amazonEndPoint
     *            the amazonEndPoint to set.
     */
    public void setCloudWatch(String accessKey, String secretKey, AmazonEndPoint amazonEndPoint) {
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        cloudWatch = new AmazonCloudWatchClient(awsCredentials);
        cloudWatch.setEndpoint(amazonEndPoint.toString());
    }

    /**
     * set MetricStatisticsRequest.
     * 
     * @param namespace
     *            the namespace to set.
     * @param metricName
     *            the metricName to set.
     * @param dimensionName
     *            the dimensionName to set.
     * @param instanceId
     *            the instanceId to set.
     * @param period
     *            the period to set.
     * @param start
     *            the start to set.
     * @param end
     *            the end to set.
     */
    public void setMetricStatisticsRequest(AmazonMetricNamespace namespace, AmazonMetricName metricName,
            AmazonDimensionName dimensionName, String instanceId, Integer period, Date start, Date end) {
        metricStatisticsRequest.setPeriod(period);
        metricStatisticsRequest.setNamespace(namespace.toString());
        metricStatisticsRequest.setMetricName(metricName.toString());
        metricStatisticsRequest.setStartTime(start);
        metricStatisticsRequest.setEndTime(end);
        metricStatisticsRequest.setStatistics(getStatistic());
        Collection<Dimension> collection = new ArrayList<Dimension>();
        Dimension dimension = new Dimension();
        dimension.setName(dimensionName.toString());
        dimension.setValue(instanceId);
        collection.add(dimension);
        metricStatisticsRequest.setDimensions(collection);
    }

    /**
     * get all metric statistic form amazon.
     * 
     * @return List<Datapoint> the list of Datapoint.
     */
    public List<Datapoint> getMetricStatistic() {
        GetMetricStatisticsResult getMetricStatisticsResult = cloudWatch.getMetricStatistics(metricStatisticsRequest);
        return getMetricStatisticsResult.getDatapoints();
    }

    /**
     * get statistic.
     * 
     * @return collection of statistic string.
     */
    private Collection<String> getStatistic() {
        Collection<String> collection = new ArrayList<String>();
        for (Statistic statistic : Statistic.values()) {
            collection.add(statistic.toString());
        }
        return collection;
    }
}
