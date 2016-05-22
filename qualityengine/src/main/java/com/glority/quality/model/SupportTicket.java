package com.glority.quality.model;

import java.util.Date;

import com.glority.quality.Constants.SupportTicketStatus;
import com.glority.quality.constants.SupportTicketType;

/**
 * Support ticket is the abstract model to represents operations ticket of a
 * team.
 * 
 * @author Xu Qingsong
 * 
 */
public class SupportTicket {
    /**
     * The product name of the ticket
     */
    private String product;
    /**
     * The system name of the issue. like a server name
     */
    private String system;
    /**
     * the type of the ticket
     */
    private SupportTicketType type;
    /**
     * The title of the ticket
     */
    private String title;
    /**
     * The content of the ticket
     */
    private String content;

    /**
     * ticket create on.
     */
    private Date createOn;

    /**
     * status
     */
    private SupportTicketStatus status;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isClosed() {
        return this.status.isCloseStatus();
    }

    public SupportTicketType getType() {
        return this.type;
    }

    public void setType(SupportTicketType type) {
        this.type = type;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public SupportTicketStatus getStatus() {
        return status;
    }

    public void setStatus(SupportTicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SupportTicket [product=" + product + ", system=" + system + ", type=" + type + ", title=" + title
                + ", content=" + content + ", createOn=" + createOn + ", status=" + status + "]";
    }

}
