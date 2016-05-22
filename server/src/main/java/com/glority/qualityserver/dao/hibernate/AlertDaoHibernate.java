package com.glority.qualityserver.dao.hibernate;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.AlertType;
import com.glority.qualityserver.dao.AlertDao;
import com.glority.qualityserver.model.Alert;

/**
 * AlertDaoHibernate.
 * 
 * @author liheping
 * 
 */
@Repository("alertDao")
public class AlertDaoHibernate extends GenericDaoHibernate<Alert, Long> implements AlertDao {
    /**
     * default constructor.
     */
    public AlertDaoHibernate() {
        super(Alert.class);
    }

    @Override
    public List<Alert> getAlertsAfterTime(long serverId, AlertType type, Timestamp date) {
        String hql = "from Alert where server_id=? and type=? and created_at>? order by created_at desc";
        Object[] params = new Object[] { Long.valueOf(serverId), type.toString(), date };
        return super.getItems(hql, params);
    }

    @Override
    public List<Alert> getAlerts(long serverId, AlertType type) {
        String hql = "from Alert where server_id=? and type=? order by created_at desc";
        Object[] params = new Object[] { Long.valueOf(serverId), type.toString() };
        return super.getItems(hql, params);
    }

}
