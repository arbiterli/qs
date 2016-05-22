package com.glority.quality.connectors.supportdb;

import java.util.List;

import com.glority.quality.Constants.SupportTicketStatus;
import com.glority.quality.model.SupportTicket;

/**
 * filter support ticket by status. if statusList not specified, regarded as
 * meet condition.
 * 
 * @author Administrator
 * 
 */
public class StatusFilter implements SupportTicketFilter {
    private List<SupportTicketStatus> statusList;

    @Override
    public boolean meetCondition(SupportTicket ticket) {
        if (ticket == null || ticket.getStatus() == null) {
            return false;
        }

        if (statusList == null) {
            return true;
        }

        if (statusList.contains(ticket.getStatus())) {
            return true;
        }

        return false;
    }

    public List<SupportTicketStatus> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<SupportTicketStatus> statusList) {
        this.statusList = statusList;
    }

}
