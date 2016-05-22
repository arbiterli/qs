package com.glority.quality.connectors.supportdb;

import java.util.ArrayList;
import java.util.List;

import com.glority.common.connectors.ConnectorException;
import com.glority.quality.BaseTask;
import com.glority.quality.model.SupportTicket;

/**
 * The general task to get data from support DB. A support db is the operations
 * ticket management system used for manage the daily tasks
 * 
 * The new implements should have initialClient implemented
 * 
 * @author XQS
 * 
 */
public abstract class SupportDBBaseTask extends BaseTask {
    /**
     * filters that used to filter ticket.
     */
    List<SupportTicketFilter> filterList;
    /**
     * . The return result
     */
    private List<SupportTicket> tickets;
    /**
     * . The support db client implementations
     */
    private SupportDBClient supportDbClient;

    @Override
    public void process() throws ConnectorException {
        initialClient();
        tickets = supportDbClient.get();
    }

    /**
     * . Initialized the support db client
     */
    public abstract void initialClient() throws ConnectorException;

    public List<SupportTicket> getTickets() {
        List<SupportTicket> result = new ArrayList<SupportTicket>();

        if (this.filterList != null && !this.filterList.isEmpty() && this.tickets != null && this.tickets != null) {
            for (SupportTicket ticket : this.tickets) {
                boolean meetAllFilterCondition = true;
                for (SupportTicketFilter filter : this.filterList) {
                    if (!filter.meetCondition(ticket)) {
                        meetAllFilterCondition = false;
                        break;
                    }
                }

                if (meetAllFilterCondition) {
                    result.add(ticket);
                }
            }
        } else {
            if (this.tickets != null) {
                result.addAll(this.tickets);
            }
        }

        return result;
    }

    public void setTickets(List<SupportTicket> tickets) {
        this.tickets = tickets;
    }

    public SupportDBClient getSupportDbClient() {
        return supportDbClient;
    }

    public void setSupportDbClient(SupportDBClient supportDbClient) {
        this.supportDbClient = supportDbClient;
    }

    public void setFilters(List<SupportTicketFilter> filterList) {
        this.filterList = filterList;
    }
}
