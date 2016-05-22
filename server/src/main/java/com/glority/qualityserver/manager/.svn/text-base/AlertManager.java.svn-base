package com.glority.qualityserver.manager;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.model.Alert;

/**
 * AlertManager.
 * 
 * @author liheping
 * 
 */
public interface AlertManager extends GenericManager<Alert, Long> {
    /**
     * create alert item.
     * 
     * @param productId
     * @param serverId
     * @param type
     * @param info
     * @param startTime
     * @param endTime
     * @return
     */
    Alert createAlert(long productId, long serverId, AlertType type, String info,
            Timestamp startTime, Timestamp endTime);

    /**
     * get server alerts in hours.
     * 
     * @param id
     * @param hoursForSample
     * @return
     */
    List<Alert> getServerAlerts(long serverId, AlertType type, int hours);

    /**
     * save alert before check the latest same type alert caused by the same
     * server. if they are the same, return null, else return the record in db.
     * 
     * @param alert
     * @return
     */
    Alert saveAlertWithCheckExist(Alert alert);
}
