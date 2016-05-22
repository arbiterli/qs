package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.List;

import com.glority.common.connectors.nagios.ServiceNotification;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.model.Alert;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.SchedulerService;

/**
 * this class is specified for CloudWatchJobTest. Only CloudWatchJob used method is implemented.
 * 
 * @author Li.heping
 * 
 */
public class TSchedulerService implements SchedulerService {
    private List<Server> cloudWatchActiveServerList;
    private List<Alert> cloudWatchAlerts;
    private Product product;

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Server> getCheckServers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Server> getAllNagiosIsActiveServer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveChange(String detail, Server server) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveRecordMetric(Product product, Server server, MetricType type, MetricName name, String value,
            Timestamp sampleTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveRecordMetric(Server server, MetricType type, MetricName name, String value, Timestamp sampleTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Deploy> getAllRunningDeploys() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clearDeadDeploys(List<Deploy> deployList) {
        // TODO Auto-generated method stub

    }

    @Override
    public Product getProduct(Server server) {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public List<Server> getAllCloudwatchIsActiveServer() {
        return this.cloudWatchActiveServerList;
    }

    public void setCloudWatchActiveServer(List<Server> serverList) {
        this.cloudWatchActiveServerList = serverList;
    }

    @Override
    public void saveCloudWatchAlerts(List<Alert> alertList, Product product, Server server) {
        this.cloudWatchAlerts = alertList;
    }

    public List<Alert> getCloudWatchAlerts() {
        return this.cloudWatchAlerts;
    }

    @Override
    public void saveNotifications(List<ServiceNotification> notificationList, Server server) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Server> getNagiosWatchedServers(long productId) {
        // TODO Auto-generated method stub
        return null;
    }
}
