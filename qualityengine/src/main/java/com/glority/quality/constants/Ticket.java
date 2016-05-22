package com.glority.quality.constants;

/**
 * ticket of assembla
 * 
 * @author CLB
 * 
 */
public enum Ticket {
    TICKET("ticket"),
    CREATE_ON("created-on"), // create on time
    SUMMARY("summary"), // summary
    STATUS_NAME("status-name"), // status name
    DESCRIPTION("description"); // description

    private String value;

    /**
     * Create Ticket instance.
     * @param ticket
     *            the ticket to set.
     */
    private Ticket(String ticket) {
        this.value = ticket;
    }

    /**
     * toString.
     * @return value the value.
     */
    public String toString() {
        return this.value;
    }

    /**
     * Get Ticket with name.
     * @param ticket
     *            the ticket of String.
     * @return Ticket.
     */
    public static Ticket getValueOf(String ticket) {
        for (Ticket tic : Ticket.values()) {
            if (tic.toString().equals(ticket)) {
                return tic;
            }
        }
        return null;
    }
}