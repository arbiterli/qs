package com.glority.qualityserver.dao;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.model.Alert;

/**
 * AlertDao interface.
 * 
 * @author liheping
 * 
 */
public interface AlertDao extends GenericDao<Alert, Long> {
    List<Alert> getAlertsAfterTime(long serverId, AlertType type, Timestamp date);

    List<Alert> getAlerts(long serverId, AlertType type);
}
