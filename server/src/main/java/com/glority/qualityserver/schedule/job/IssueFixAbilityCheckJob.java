/**
 * 
 */
package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.quality.Constants.MetricName;
import com.glority.quality.Constants.MetricType;
import com.glority.quality.Constants.SupportTicketStatus;
import com.glority.quality.connectors.supportdb.CreateTimeFilter;
import com.glority.quality.connectors.supportdb.ProductNameFilter;
import com.glority.quality.connectors.supportdb.StatusFilter;
import com.glority.quality.connectors.supportdb.SupportTicketFilter;
import com.glority.quality.model.SupportTicket;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.service.impl.SupportDBEngine;

/**
 * Issue fix ability check.
 * 
 * @author chenzuying
 * 
 */
@QuartzJob(name = "issueFixAbilityCheckJob", cronExp = "0 0 0/1 * * ?")
public class IssueFixAbilityCheckJob extends BaseJobBean {

    private static final Logger LOGGER = Logger.getLogger(IssueFixAbilityCheckJob.class);

    private static final int HOURS = 24;
    private static final int ONE_HUNDRED = 100;
    @Autowired
    private ProductManager productManager;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        boolean featureEnabled = FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.ISSUE_FIX_ABILITY_CHECK);
        if (!featureEnabled) {
            LOGGER.info("IssueFixAbilityCheckJob is disabled");
            return;
        }
        LOGGER.info("issueFixAbilityCheckJob start ..");
        SupportDBEngine engine = new SupportDBEngine();
        try {
            engine.init();
        } catch (Exception e) {
            super.reportError(e, "support db issue get failed.");
            LOGGER.error(e.getMessage(), e);
            LOGGER.info("exception occurs in SupportDBEngine init, terminate IssueFixAbilityCheck job!.");
            return;
        }
        List<Product> productList = this.productManager.getAllProducts();
        Timestamp sampleTime = super.getSampleTime();

        if (productList != null && !productList.isEmpty()) {
            for (Product product : productList) {

                int allOpenIssue = getAllOpenIssue(product, engine);
                double fixedRateInHours = getFixedRateInHours(product, engine, sampleTime);
                double formatedFixedRate = fixedRateInHours * ONE_HUNDRED;
                int newIssueInHours = getNewIssueInHours(product, engine, sampleTime);

                super.schedulerService.saveRecordMetric(product, null, MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY,
                        MetricName.ALL_OPEN_ISSUE, Integer.toString(allOpenIssue), sampleTime);
                super.schedulerService.saveRecordMetric(product, null, MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY,
                        MetricName.ISSUE_FIX_RATE, Double.toString(formatedFixedRate), sampleTime);
                super.schedulerService.saveRecordMetric(product, null, MetricType.METRIC_TYPE_ISSUE_FIX_ABILITY,
                        MetricName.NEW_ISSUE, Integer.toString(newIssueInHours), sampleTime);
            }
        }
        LOGGER.info("issueFixAbilityCheckJob finished");

    }

    private int getAllOpenIssue(Product product, SupportDBEngine engine) {

        ProductNameFilter nameFilter = SupportDBEngine.getProductNameFilter(product, super.schedulerService);

        StatusFilter statusFilter = new StatusFilter();
        statusFilter.setStatusList(SupportTicketStatus.getOpenStatus());

        List<SupportTicketFilter> filterList = new ArrayList<SupportTicketFilter>();
        filterList.add(nameFilter);
        filterList.add(statusFilter);

        List<SupportTicket> ticketList = engine.getTickets(filterList);
        return ticketList == null ? 0 : ticketList.size();
    }

    private double getFixedRateInHours(Product product, SupportDBEngine engine, Timestamp sampleTime) {
        ProductNameFilter nameFilter = SupportDBEngine.getProductNameFilter(product, super.schedulerService);

        CreateTimeFilter timeFilter = new CreateTimeFilter();
        timeFilter.setEndDate(sampleTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sampleTime);
        cal.add(Calendar.HOUR, -HOURS);
        timeFilter.setStartDate(cal.getTime());

        StatusFilter legalStatusFilter = new StatusFilter();
        legalStatusFilter.setStatusList(SupportTicketStatus.getLegalStatus());

        List<SupportTicketFilter> filterList = new ArrayList<SupportTicketFilter>();
        filterList.add(nameFilter);
        filterList.add(timeFilter);
        filterList.add(legalStatusFilter);

        List<SupportTicket> allLegalTicketList = engine.getTickets(filterList);
        if (allLegalTicketList == null || allLegalTicketList.isEmpty()) {
            return 1;
        }

        StatusFilter fixStatusFilter = new StatusFilter();
        List<SupportTicketStatus> fixStatusList = new ArrayList<SupportTicketStatus>();
        fixStatusList.add(SupportTicketStatus.FIXED);
        fixStatusFilter.setStatusList(fixStatusList);
        filterList.add(fixStatusFilter);

        List<SupportTicket> fixedTicketList = engine.getTickets(filterList);

        if (fixedTicketList == null || fixedTicketList.isEmpty()) {
            return 0;
        }

        return (double) fixedTicketList.size() / allLegalTicketList.size();
    }

    private int getNewIssueInHours(Product product, SupportDBEngine engine, Timestamp sampleTime) {
        ProductNameFilter nameFilter = SupportDBEngine.getProductNameFilter(product, super.schedulerService);

        CreateTimeFilter timeFilter = new CreateTimeFilter();
        timeFilter.setEndDate(sampleTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sampleTime);
        cal.add(Calendar.HOUR, -HOURS);
        timeFilter.setStartDate(cal.getTime());

        StatusFilter newStatusFilter = new StatusFilter();
        List<SupportTicketStatus> newStatusList = new ArrayList<SupportTicketStatus>();
        newStatusList.add(SupportTicketStatus.NEW);
        newStatusFilter.setStatusList(newStatusList);

        List<SupportTicketFilter> filterList = new ArrayList<SupportTicketFilter>();
        filterList.add(nameFilter);
        filterList.add(timeFilter);
        filterList.add(newStatusFilter);

        List<SupportTicket> newTicketList = engine.getTickets(filterList);

        return newTicketList == null ? 0 : newTicketList.size();
    }
}
