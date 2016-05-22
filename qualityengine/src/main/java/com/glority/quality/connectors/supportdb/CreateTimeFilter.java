package com.glority.quality.connectors.supportdb;

import java.util.Date;

import com.glority.quality.model.SupportTicket;

/**
 * filter support ticket base on create time. if time is not specified, regarded
 * as meet condition.
 * 
 * @author Administrator
 * 
 */
public class CreateTimeFilter implements SupportTicketFilter {
    private Date startDate;
    private Date endDate;

    @Override
    public boolean meetCondition(SupportTicket ticket) {
        if (ticket == null || ticket.getCreateOn() == null) {
            return false;
        }

        if (startDate != null) {
            if (startDate.after(ticket.getCreateOn())) {
                return false;
            }
        }

        if (endDate != null) {
            if (endDate.before(ticket.getCreateOn())) {
                return false;
            }
        }

        return true;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
