package com.glority.qualityserver.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.common.connectors.nagios.ServiceNotification;
import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.connectors.supportdb.StdEmailContent;
import com.glority.quality.model.CurrentStatus;
import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.error.erroranalyser.ErrorAnalyser;
import com.glority.qualityserver.error.erroranalyser.ServerCheckAnalyser;
import com.glority.qualityserver.model.Alert;
import com.glority.qualityserver.model.Deploy;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.MailService;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.service.QualitySystemErrorService;
import com.glority.qualityserver.service.SchedulerService;

/**
 * SchedulerService Implementation.
 * 
 * @author liheping
 * 
 */
@Service
public class SchedulerServiceImpl extends DBBaseService implements SchedulerService {
    private static final Logger LOGGER = Logger.getLogger(SchedulerServiceImpl.class);
    public static final String SERVER_CHANGE = "Alert";
    public static final String SERVER_CHANGE_TITLE = "Server Invalid Changes";
    public static final String NOTIFICATION = "Notification";
    public static final String NOTIFICATION_TITLE = "Notification From Nagios";
    public static final String CLOUD_WATCH = "Alert";
    public static final String CLOUD_WATCH_TITLE = "Alert From Cloud Watch";

    @Autowired
    private MetricEngineDBService dbService;

    @Autowired
    private MailService mailService;

    @Autowired
    private QualitySystemErrorService qsErrorService;

    public List<Product> getAllProducts() {

        return super.productManager.getAllProducts();
    }

    public List<Server> getCheckServers() {

        List<Server> result = new ArrayList<Server>();

        List<Server> serverList = this.getPhaseServers(ProductStage.PROD, Constants.SERVER_TYPE_OFFICIAL);
        for (Server server : serverList) {
            if (super.serverManager.validateServerForChangeCheck(server)) {
                LOGGER.debug("add server to server change check" + server.getId());
                result.add(server);
            }
        }

        return result;
    }

    /**
     * get all product's production server.
     * 
     * @return
     */
    @Transactional
    private List<Server> getPhaseServers(ProductStage phase, String serverType) {
        List<Product> productList = super.productManager.getAllProducts();

        List<Server> result = new ArrayList<Server>();
        for (Product product : productList) {
            Phase prodPhase = super.phaseManager.getPhase(product.getId(), phase);
            if (prodPhase != null) {
                List<Server> serverList = super.serverManager.getSpecifiedServer(prodPhase.getId(), serverType);
                if (serverList != null && !serverList.isEmpty()) {
                    result.addAll(serverList);
                }
            }
        }

        return result;
    }

    public void saveChange(String detail, Server server) {
        if (StringUtils.isEmpty(detail) || server == null) {
            return;
        }

        ErrorAnalyser analyer = new ServerCheckAnalyser();
        String causedBy = analyer.analyse(detail);

        Product product = super.productManager.getProduct(server);

        if (causedBy.equals(ErrorAnalyser.CAUSED_BY_PRODUCT)) {

            Alert alert = super.alertManager.createAlert(product.getId(), server.getId(), AlertType.SERVER_CHANGE,
                    detail, null, null);
            super.alertManager.saveAlertWithCheckExist(alert);

            SupportDBEngine engine = new SupportDBEngine();
            try {
                engine.init();
            } catch (Exception e) {
                LOGGER.error("init SupportDBEngine failed ! email to support db can not work!");
                return;
            }

            StdEmailContent content = new StdEmailContent();
            content.setInfo(detail);
            content.setProductName(product.getName());
            content.setServerName(server.getName());
            content.setTitle(SERVER_CHANGE_TITLE);
            content.setType(SERVER_CHANGE);
            engine.sendMailToSupportDB(mailService, content);

        } else if (causedBy.equals(ErrorAnalyser.CAUSED_BY_QUALITY_SYSTEM)) {
            this.qsErrorService.doProcessAlerts(server, detail);
        }
    }

    public void saveRecordMetric(Product product, Server server, MetricType type, MetricName name, String value,
            Timestamp sampleTime) {

        super.recordMetricManager.saveRecordMetric(product, server, type, name, value, sampleTime, null);
    }

    public List<Server> getAllNagiosIsActiveServer() {
        List<Server> result = new ArrayList<Server>();

        List<Server> serverList = this.getPhaseServers(ProductStage.PROD, Constants.SERVER_TYPE_OFFICIAL);
        for (Server server : serverList) {
            if (super.serverManager.validateServerForNagiosMonitoring(server)) {
                LOGGER.debug("add server to server monitoring" + server.getId());
                result.add(server);
            }
        }

        return result;
    }

    public void saveRecordMetric(Server server, MetricType type, MetricName name, String value, Timestamp sampleTime) {
        Phase phase = super.phaseManager.get(server.getPhaseId());
        Product product = super.productManager.get(phase.getProductId());

        super.recordMetricManager.saveRecordMetric(product, server, type, name, value, sampleTime, null);

    }

    public void saveRecordMetrics(Server server, MetricType type, MetricName name,
            List<CurrentStatus> currentStatusList, Timestamp sampleTime) {
        if (server == null) {
            return;
        }

        Phase phase = super.phaseManager.get(server.getPhaseId());
        if (phase == null) {
            return;
        }

        Product product = super.productManager.get(phase.getProductId());
        if (product == null) {
            return;
        }

        if (currentStatusList != null && !currentStatusList.isEmpty()) {
            for (CurrentStatus status : currentStatusList) {
                super.recordMetricManager.saveRecordMetric(product, server, type, name, status.getStatus(), sampleTime,
                        status.getAttempt());
            }
        }

    }

    public MetricEngineDBService getDBBaseService() {

        return this.dbService;
    }

    public List<Deploy> getAllRunningDeploys() {
        return super.deployManager.getDeployWithSpecifiedResult(Constants.RUNNING);
    }

    public void clearDeadDeploys(List<Deploy> deployList) {
        if (deployList != null && !deployList.isEmpty()) {
            for (Deploy deploy : deployList) {
                deploy.setResult(Constants.TIME_OUT);
            }
            super.deployManager.saveOrUpdateAll(deployList);
        }
    }

    public Product getProduct(Server server) {
        return super.productManager.getProduct(server);
    }

    @Override
    public List<Server> getAllCloudwatchIsActiveServer() {
        List<Server> result = new ArrayList<Server>();
        List<Server> serverList = this.getPhaseServers(ProductStage.PROD, Constants.SERVER_TYPE_OFFICIAL);
        for (Server server : serverList) {
            if (super.serverManager.validateServerForCloudwatchMornitoring(server)) {
                LOGGER.debug("add server to server monitoring" + server.getId());
                result.add(server);
            }
        }
        return result;
    }

    @Override
    public void saveCloudWatchAlerts(List<Alert> alertList, Product product, Server server) {
        if (alertList == null || alertList.isEmpty()) {
            return;
        }

        super.alertManager.saveOrUpdateAll(alertList);

        SupportDBEngine engine = new SupportDBEngine();
        try {
            engine.init();
        } catch (Exception e) {
            LOGGER.error("init SupportDBEngine failed ! email to support db can not work!");
            return;
        }

        for (Alert alert : alertList) {
            StdEmailContent content = new StdEmailContent();
            content.setProductName(product.getName());
            content.setTitle(CLOUD_WATCH_TITLE);
            content.setServerName(server.getName());
            content.setType(CLOUD_WATCH);
            content.setInfo(alert.getInfo());

            engine.sendMailToSupportDB(this.mailService, content);
        }

    }

    @Override
    public void saveNotifications(List<ServiceNotification> notificationList, Server server) {
        if (notificationList == null || notificationList.isEmpty()) {
            return;
        }

        SupportDBEngine engine = new SupportDBEngine();
        try {
            engine.init();
        } catch (Exception e) {
            LOGGER.error("init SupportDBEngine failed ! email to support db can not work!");
            return;
        }

        Product product = super.productManager.getProduct(server);
        if (server == null || product == null) {
            LOGGER.error("data error!");
            return;
        }

        for (ServiceNotification notification : notificationList) {
            StdEmailContent content = new StdEmailContent();
            content.setProductName(product.getName());
            content.setTitle(NOTIFICATION_TITLE);
            content.setServerName(server.getName());
            content.setType(NOTIFICATION);
            content.setInfo(notification.getInfo());

            engine.sendMailToSupportDB(this.mailService, content);
        }
    }

    @Override
    public List<Server> getNagiosWatchedServers(long productId) {
        Phase phase = super.phaseManager.getPhase(productId, ProductStage.PROD);
        if (phase == null) {
            return new ArrayList<Server>();
        }
        return super.serverManager.getSpecifiedServer(phase.getId(), Constants.SERVER_TYPE_OFFICIAL);
    }
}
