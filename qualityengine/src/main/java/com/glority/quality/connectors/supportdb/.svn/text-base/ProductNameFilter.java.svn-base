package com.glority.quality.connectors.supportdb;

import java.util.List;

import com.glority.quality.model.SupportTicket;

/**
 * 
 * product name filter. if productNameList is null, return true.
 * 
 * @author Li.heping
 * 
 */
public class ProductNameFilter implements SupportTicketFilter {
    private List<String> productNameList;

    public List<String> getProductNameList() {
        return productNameList;
    }

    public void setProductNameList(List<String> productNameList) {
        this.productNameList = productNameList;
    }

    @Override
    public boolean meetCondition(SupportTicket ticket) {
        if (this.productNameList == null) {
            return true;
        }

        if (ticket == null || ticket.getProduct() == null) {
            return false;
        }

        return this.productNameList.contains(ticket.getProduct());
    }

}
