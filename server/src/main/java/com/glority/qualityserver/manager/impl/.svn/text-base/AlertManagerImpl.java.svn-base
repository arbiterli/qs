package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.dao.AlertDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.AlertManager;
import com.glority.qualityserver.model.Alert;

/**
 * AlertManagerImpl.
 * 
 * @author liheping
 * 
 */
@Service("alertManager")
public class AlertManagerImpl extends GenericManagerImpl<Alert, Long> implements AlertManager {
    // private static final Logger LOGGER =
    // Logger.getLogger(AlertManagerImpl.class);
    @Autowired
    private AlertDao alertDao;

    @Override
    protected GenericDao<Alert, Long> getDao() {
        return this.alertDao;
    }

    @Override
    public Alert createAlert(long productId, long serverId, AlertType type, String info, Timestamp startTime,
            Timestamp endTime) {
        Alert alert = new Alert();
        alert.setProductId(productId);
        alert.setServerId(serverId);
        alert.setType(type.toString());
        alert.setInfo(info);
        alert.setStartTime(startTime);
        alert.setEndTime(endTime);
        alert.setCreatedAt(new Timestamp(new Date().getTime()));
        return alert;
    }

    @Override
    public List<Alert> getServerAlerts(long serverId, AlertType type, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -hours);
        Timestamp time = new Timestamp(cal.getTime().getTime());
        return this.alertDao.getAlertsAfterTime(serverId, type, time);
    }

    @Override
    public Alert saveAlertWithCheckExist(Alert alert) {
        List<Alert> latestAlert = this.alertDao.getAlerts(alert.getServerId(), AlertType.valueOf(alert.getType()));
        if (latestAlert != null && !latestAlert.isEmpty()) {
            if (alert.getInfo() != null && alert.getInfo().equalsIgnoreCase(latestAlert.get(0).getInfo())) {
                return null;
            }
        }
        return this.alertDao.save(alert);
    }

}
