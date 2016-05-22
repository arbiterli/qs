package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.manager.AlertManager;
import com.glority.qualityserver.model.Alert;

public class TAlertManager implements AlertManager {
    private List<Alert> allList;
    private Alert AlertById;
    private boolean exists;
    private Alert saveObject;
    private Collection<Alert> saveAll;
    private List<Alert> serverAlertList;
    private long saveId;

    @Override
    public List<Alert> getAll() {
        // TODO Auto-generated method stub
        return this.allList;
    }

    public void setAll(List<Alert> allList) {
        this.allList = allList;
    }

    @Override
    public Alert get(Long id) {
        return this.AlertById;
    }

    public void set(Alert alert) {
        this.AlertById = alert;
    }

    @Override
    public boolean exists(Long id) {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public void setSaveAlertId(long id) {
        this.saveId = id;
    }

    @Override
    public Alert save(Alert object) {
        // TODO Auto-generated method stub
        object.setId(this.saveId);
        this.saveObject = object;
        return saveObject;
    }

    public Alert getSave() {
        return this.saveObject;
    }

    @Override
    public void remove(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveOrUpdateAll(Collection c) {
        this.saveAll = c;
    }

    public Collection<Alert> getSaveOrUpdateAll() {
        return this.saveAll;
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
        return this.serverAlertList;
    }
    
    public void setServerAlerts(List<Alert> alerts){
        this.serverAlertList = alerts;
    }

    @Override
    public Alert saveAlertWithCheckExist(Alert alert) {
        // TODO Auto-generated method stub
        return null;
    }

}
