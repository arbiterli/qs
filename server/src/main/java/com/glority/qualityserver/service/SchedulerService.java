package com.glority.qualityserver.service;

import java.sql.Timestamp;
import java.util.List;

import com.glority.common.connectors.nagios.ServiceNotification;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.qualityserver.model.Alert;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;

/**
 * Scheduler service interface.
 * 
 * @author liheping
 * 
 */
public interface SchedulerService {
    /**
     * get all the products in db.
     * 
     * @return
     */
    List<Product> getAllProducts();

    /**
     * get all the servers that needs to do server change check.
     * 
     * @return
     */
    List<Server> getCheckServers();

    /**
     * get all the servers that the nagios is active.
     * 
     * @return
     */
    List<Server> getAllNagiosIsActiveServer();

    /***
     * save the server change info.
     * 
     * @param detail
     * @param server
     */
    void saveChange(String detail, Server server);

    /**
     * save record metric item.
     * 
     * @param product
     * @param server
     * @param type
     * @param name
     * @param value
     * @param sampleTime
     */
    void saveRecordMetric(Product product, Server server, MetricType type, MetricName name, String value,
            Timestamp sampleTime);

    /**
     * save record metric item.
     * 
     * @param server
     * @param type
     * @param name
     * @param value
     * @param sampleTime
     */
    void saveRecordMetric(Server server, MetricType type, MetricName name, String value, Timestamp sampleTime);

    /**
     * get all deploys that are running.
     * 
     * @return
     */
    List<Deploy> getAllRunningDeploys();

    /**
     * clear the dead deploys.
     * 
     * @param deployList
     */
    void clearDeadDeploys(List<Deploy> deployList);

    /**
     * get product by server.
     * 
     * @param server
     * @return
     */
    Product getProduct(Server server);

    /**
     * get all the servers that the cloudwatch is active.
     * 
     * @return
     */
    List<Server> getAllCloudwatchIsActiveServer();

    /**
     * save the cloud watch alert result.
     * 
     * @param alertList
     * @param product
     * @param server
     */
    void saveCloudWatchAlerts(List<Alert> alertList, Product product, Server server);

    /**
     * save notifications got from nagios.
     * 
     * @param notificationList
     * @param server
     */
    void saveNotifications(List<ServiceNotification> notificationList, Server server);

    /**
     * get nagios watched servers. this method is used for get nagios host.
     * 
     * @param productId
     * @return
     */
    List<Server> getNagiosWatchedServers(long productId);
}
