package com.glority.qualityserver.schedule.job;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.quartz.JobExecutionException;

import com.amazonaws.services.cloudwatch.model.Datapoint;
import com.glority.quality.constants.Amazon.AmazonMetricName;
import com.glority.qualityserver.model.Alert;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
/**
 * CloudWatchJobTest. when run this test, you must make sure that the config for this job is OK,
 * that is the feature gate is opened.
 * @author li.heping
 *
 */
public class CloudWatchJobTest extends CloudWatchJob {
    private TSchedulerService tss = new TSchedulerService();
    private TAlertManager tam = new TAlertManager();
    private Map<AmazonMetricName, List<Datapoint>> cloudWatchStatus;

    // sample period is 1h, and every 1m get one data point.
    private int countForSample = 60;

    public CloudWatchJobTest() {
        super.schedulerService = this.tss;
        super.alertManager = this.tam;
    }

    @Override
    protected Map<AmazonMetricName, List<Datapoint>> getCloudWatchStatus(Server server, Timestamp sampleTime) {
        return cloudWatchStatus;
    }

    public void testEntry() throws JobExecutionException {
        super.executeInternal(null);
    }

    // since there is a loop for server, so just use one to cover.
    private void initCommonProperty(CloudWatchJobTest test) {
        test.tam.setServerAlerts(new ArrayList<Alert>());

        Server server = new Server();
        server.setId(1L);
        List<Server> cloudWatchIsActiveServerList = new ArrayList<Server>();
        cloudWatchIsActiveServerList.add(server);
        test.tss.setCloudWatchActiveServer(cloudWatchIsActiveServerList);

        Product product = new Product();
        product.setId(1L);
        test.tss.setProduct(product);
    }

    private void setSampledDatas(CloudWatchJobTest test, List<AmazonMetricName> names, List<Double> values) {
        Map<AmazonMetricName, List<Datapoint>> status = new HashMap<AmazonMetricName, List<Datapoint>>();

        for (int k = 0; k < names.size(); k++) {
            AmazonMetricName name = names.get(k);
            Double value = values.get(k);
            List<Datapoint> pointList = new ArrayList<Datapoint>();
            for (int i = 0; i < countForSample; i++) {
                Datapoint data = new Datapoint();
                // job only use this data for calculate.
                data.setAverage(value);

                data.setTimestamp(new Timestamp(new Date().getTime()));
                pointList.add(data);
            }
            status.put(name, pointList);
        }

        test.cloudWatchStatus = status;
    }

    @Test
    public void testCpuAlert() throws Exception {
        CloudWatchJobTest test = new CloudWatchJobTest();
        this.initCommonProperty(test);
        List<AmazonMetricName> names = new ArrayList<AmazonMetricName>();
        names.add(AmazonMetricName.CPU_UTILIZATION);
        List<Double> values = new ArrayList<Double>();

        double valueBelowThreshold = 60.0;
        values.add(valueBelowThreshold);
        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> blowAlerts = test.tss.getCloudWatchAlerts();
        if (blowAlerts == null) {
            assertTrue(false);
        }
        int belowExceptedValue = 0;
        assertTrue("cpu utilization below is failed, actual size - " + blowAlerts.size() + ", expected - "
                + belowExceptedValue, blowAlerts.size() == belowExceptedValue);

        double valueEqualsThreshold = 90.0;
        values.clear();
        values.add(valueEqualsThreshold);
        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> equalAlerts = test.tss.getCloudWatchAlerts();
        // expected value = sample perid / hit time period, so is 3600/600
        int equalExpectedValue = 6;
        assertTrue("cpu utilization equal is failed, actual size - " + equalAlerts.size() + ", expected - "
                + equalExpectedValue, equalAlerts.size() == equalExpectedValue);

        double valueUpperThreshold = 100.0;
        values.clear();
        values.add(valueUpperThreshold);
        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> upperAlerts = test.tss.getCloudWatchAlerts();
        // expected value = sample perid / hit time period, so is 3600/600
        int upperExpectedValue = 6;
        assertTrue("cpu utilization upper is failed, actual size - " + upperAlerts.size() + ", expected - "
                + upperExpectedValue, upperAlerts.size() == upperExpectedValue);
    }

    @Test
    public void testBindwith() throws Exception {
        CloudWatchJobTest test = new CloudWatchJobTest();
        this.initCommonProperty(test);
        List<AmazonMetricName> names = new ArrayList<AmazonMetricName>();
        names.add(AmazonMetricName.NETWORK_IN);
        names.add(AmazonMetricName.NETWORK_OUT);
        List<Double> values = new ArrayList<Double>();

        // bindwith is network in + network out
        // threshold value is 5000000.
        double belowValueIn = 2400000;
        double belowValueOut = 2400000;
        values.add(belowValueIn);
        values.add(belowValueOut);
        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> belowAlerts = test.tss.getCloudWatchAlerts();
        int belowExpectedValue = 0;
        assertTrue("network bindwith below is failed, actual size - " + belowAlerts.size() + ", expected - "
                + belowExpectedValue, belowAlerts.size() == belowExpectedValue);

        values.clear();
        double equalValueIn = 2500000;
        double equalValueOut = 2500000;
        values.add(equalValueIn);
        values.add(equalValueOut);
        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> equalAlerts = test.tss.getCloudWatchAlerts();
        // expected = 3600s/1800s
        int equalExpectedValue = 2;
        assertTrue("network bindwith equal is failed, actual size - " + equalAlerts.size() + ", expected - "
                + equalExpectedValue, equalAlerts.size() == equalExpectedValue);

        values.clear();
        double upperValueIn = 2600000;
        double upperValueOut = 2600000;
        values.add(upperValueIn);
        values.add(upperValueOut);
        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> upperAlerts = test.tss.getCloudWatchAlerts();
        // expected = 3600s/1800s
        int upperExpectedValue = 2;
        assertTrue("network bindwith upper is failed, actual size - " + upperAlerts.size() + ", expected - "
                + upperExpectedValue, upperAlerts.size() == upperExpectedValue);
    }

    @Test
    public void testMixed() throws Exception {
        CloudWatchJobTest test = new CloudWatchJobTest();
        this.initCommonProperty(test);
        List<AmazonMetricName> names = new ArrayList<AmazonMetricName>();
        names.add(AmazonMetricName.CPU_UTILIZATION);
        names.add(AmazonMetricName.NETWORK_IN);
        names.add(AmazonMetricName.NETWORK_OUT);

        double valueEqualsCPUThreshold = 90.0;
        double equalBindwidthValueIn = 2500000;
        double equalBindwidthValueOut = 2500000;
        List<Double> values = new ArrayList<Double>();
        values.add(valueEqualsCPUThreshold);
        values.add(equalBindwidthValueIn);
        values.add(equalBindwidthValueOut);

        this.setSampledDatas(test, names, values);
        test.testEntry();
        List<Alert> equalAlerts = test.tss.getCloudWatchAlerts();
        // expected = 6+2;
        int equalExpectedValue = 8;
        assertTrue("mix is failed, actual size - " + equalAlerts.size() + ", expected - " + equalExpectedValue,
                equalAlerts.size() == equalExpectedValue);
    }
}
