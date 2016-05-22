package com.glority.qualityserver.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.tools.ant.Project;

import com.glority.quality.Constants.SupportTicketStatus;
import com.glority.quality.StringUtil;
import com.glority.quality.connectors.supportdb.GlorityOperationsDBTask;
import com.glority.quality.connectors.supportdb.ProductNameFilter;
import com.glority.quality.connectors.supportdb.StatusFilter;
import com.glority.quality.connectors.supportdb.StdEmailContent;
import com.glority.quality.connectors.supportdb.SupportDBBaseTask;
import com.glority.quality.connectors.supportdb.SupportTicketFilter;
import com.glority.quality.constants.SupportTicketType;
import com.glority.quality.model.SupportTicket;
import com.glority.qualityserver.FeatureGate;
import com.glority.qualityserver.FeatureGateName;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.service.MailService;
import com.glority.qualityserver.service.SchedulerService;

/**
 * SupportDBEngine. deal with support ticket, and send email to support db.
 * 
 * @author Administrator
 * 
 */
public class SupportDBEngine {

    private static final Logger LOGGER = Logger.getLogger(SupportDBEngine.class);
    private static final String BASE_URL = "supportDBBaseUrl";
    private static final String USER_NAME = "supportDBUsername";
    private static final String PASSWORD = "supportDBPassword";
    private static final String REPEAT_COUNT = "repeatCount";
    private static final String SUPPORT_DB_EMAIL = "supportDBEmail";
    private static final String SUPPORT_DB_EMAIL_FROM = "supportDBEmailFrom";
    private final int defaultRepeatCount = 3;
    private SupportDBBaseTask task;

    /**
     * cachedTicketList is used to cache send email. to avoid network delay.
     */
    private List<SupportTicket> cachedTicketList = new ArrayList<SupportTicket>();

    public SupportDBBaseTask getTask() {
        return task;
    }

    public void setTask(SupportDBBaseTask task) {
        this.task = task;
    }

    public void init() {
        if (this.task == null) {
            GlorityOperationsDBTask glTask = new GlorityOperationsDBTask();
            ServerSettings settings = ServerSettings.getInstance();
            String baseUrl = (String) settings.getSetting(BASE_URL);
            String username = (String) settings.getSetting(USER_NAME);
            String password = (String) settings.getSetting(PASSWORD);
            glTask.setBaseUrl(baseUrl);
            glTask.setUserName(username);
            glTask.setPassword(password);
            glTask.setProject(new Project());
            this.task = glTask;
        }

        task.execute();
    }

    public List<SupportTicket> getTickets(List<SupportTicketFilter> filterList) {
        if (this.task != null) {
            this.task.setFilters(filterList);
            return this.task.getTickets();
        } else {
            LOGGER.info("SupportDBBaseTask is not setted,this should not happen!!. return empty list.");
            return new ArrayList<SupportTicket>();
        }
    }

    public static ProductNameFilter getProductNameFilter(Product product, SchedulerService schedulerService) {
        if (product == null || schedulerService == null) {
            return null;
        }

        List<String> nameList = new ArrayList<String>();
        if (product.getName() != null) {
            nameList.add(product.getName());
        }
        if (product.getDisplayName() != null) {
            nameList.add(product.getDisplayName());
        }

        List<Server> serverList = schedulerService.getNagiosWatchedServers(product.getId());
        if (serverList != null) {
            for (Server server : serverList) {
                nameList.add(server.getHost());
            }
        }

        ProductNameFilter nameFilter = new ProductNameFilter();
        nameFilter.setProductNameList(nameList);

        return nameFilter;
    }

    /**
     * send mail to support db. check the same content new ticket not repeat
     * more than the configed times.
     * 
     * @param mailService
     * @param content
     */
    public void sendMailToSupportDB(MailService mailService, StdEmailContent content) {
        if (!FeatureGate.getInstance().isFeatureEnabled(FeatureGateName.SUPPORT_DB_EMAIL_SEND)) {
            LOGGER.info(FeatureGateName.SUPPORT_DB_EMAIL_SEND + " is not enabled, no email send to support db.");
        }

        int repeatCount = this.defaultRepeatCount;
        try {
            String repeatCountStr = ServerSettings.getInstance().getSetting(REPEAT_COUNT);
            repeatCount = Integer.parseInt(repeatCountStr);
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
            LOGGER.info("use default repeat count 3.");
            repeatCount = this.defaultRepeatCount;
        }

        List<SupportTicket> ticketList = this.getSameContentSupportTickets(content);

        if (ticketList == null || ticketList.size() < repeatCount) {
            String emailAddress = ServerSettings.getInstance().getSetting(SUPPORT_DB_EMAIL);
            String emailFrom = ServerSettings.getInstance().getSetting(SUPPORT_DB_EMAIL_FROM);
            if (StringUtil.isEmpty(emailAddress) || StringUtil.isEmpty(emailFrom)) {
                LOGGER.error("support db email not config. can not send email");
                return;
            }
            LOGGER.info("send email : title " + content.getFomartTitle());
            mailService.sendPlainEmail(emailFrom, emailAddress, content.getFomartTitle(), content.getEmailContent());
            this.saveEmailToCachedTickets(content);
        } else {
            LOGGER.info("more opened ticket than setted repeat value");
        }
    }

    private List<SupportTicket> getSameContentSupportTickets(StdEmailContent content) {
        List<SupportTicket> result = new ArrayList<SupportTicket>();

        List<SupportTicketFilter> mailFilterList = this.getFiltersForEmailSend(content);
        result.addAll(this.getTickets(mailFilterList));

        if (mailFilterList != null) {
            for (SupportTicket ticket : this.cachedTicketList) {
                boolean meetAllConditions = true;
                for (SupportTicketFilter filter : mailFilterList) {
                    if (!filter.meetCondition(ticket)) {
                        meetAllConditions = false;
                        break;
                    }
                }

                if (meetAllConditions) {
                    result.add(ticket);
                }
            }
        }

        return result;
    }

    private void saveEmailToCachedTickets(StdEmailContent content) {
        SupportTicket ticket = new SupportTicket();
        ticket.setContent(content.getEmailContent());
        ticket.setCreateOn(new Date());
        ticket.setProduct(content.getProductName());
        ticket.setStatus(SupportTicketStatus.NEW);
        ticket.setTitle(content.getTitle());
        ticket.setSystem(content.getServerName());
        ticket.setType(SupportTicketType.QUALITY_SERVER);
        this.cachedTicketList.add(ticket);
    }

    private List<SupportTicketFilter> getFiltersForEmailSend(StdEmailContent content) {
        List<SupportTicketFilter> filterList = new ArrayList<SupportTicketFilter>();

        ProductNameFilter nameFilter = new ProductNameFilter();
        List<String> nameList = new ArrayList<String>();
        nameList.add(content.getProductName());
        nameFilter.setProductNameList(nameList);
        filterList.add(nameFilter);

        StatusFilter statusFilter = new StatusFilter();
        statusFilter.setStatusList(SupportTicketStatus.getOpenStatus());
        filterList.add(statusFilter);

        filterList.add(new SupportTicketTypeFilter(SupportTicketType.QUALITY_SERVER));

        filterList.add(new SupportTicketTitleFilter(content.getTitle()));

        return filterList;
    }

    /**
     * ticket title filter.
     * 
     * @author Administrator
     * 
     */
    public class SupportTicketTitleFilter implements SupportTicketFilter {
        private String title;

        public SupportTicketTitleFilter(String title) {
            this.title = title;
        }

        @Override
        public boolean meetCondition(SupportTicket ticket) {
            if (this.title == null) {
                return true;
            }
            if (ticket == null) {
                return false;
            }
            return this.title.equals(ticket.getTitle());
        }

    }

    /**
     * ticket type filter.
     * 
     * @author Administrator
     * 
     */
    public class SupportTicketTypeFilter implements SupportTicketFilter {
        private SupportTicketType type;

        public SupportTicketTypeFilter(SupportTicketType type) {
            this.type = type;
        }

        @Override
        public boolean meetCondition(SupportTicket ticket) {
            if (ticket == null) {
                return false;
            }

            if (ticket.getType() == this.type) {
                return true;
            }

            return false;
        }
    }

}
