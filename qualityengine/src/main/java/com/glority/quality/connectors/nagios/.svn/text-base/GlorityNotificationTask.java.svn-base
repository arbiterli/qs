/**
 * 
 */
package com.glority.quality.connectors.nagios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.glority.common.connectors.nagios.ServiceNotification;

/**
 * glority notification task.
 * 
 * @author CLB, changed by Li.heping
 * 
 */
public class GlorityNotificationTask extends NagiosTask {

    private List<ServiceNotification> notifications = new ArrayList<ServiceNotification>();
    private String contact = "quality";
    private List<Integer> dayList = Arrays.asList(0);

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<ServiceNotification> getResult() {
        return notifications;
    }

    public void setDayList(List<Integer> dayList) {
        this.dayList = dayList;
    }

    @Override
    protected void proccessWithConnector() throws Exception {
        for (Integer day : this.dayList) {
            List<ServiceNotification> notificationList = super.connector.getServiceNotifications(day);
            if (notificationList != null && !notificationList.isEmpty()) {
                for (ServiceNotification notification : notificationList) {
                    if (this.contact == null || this.contact.equalsIgnoreCase(notification.getContact())) {
                        this.notifications.add(notification);
                    }
                }
            }
        }
    }
}
