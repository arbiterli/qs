package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.BuildCertifyHistoryDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.BuildCertifyHistoryManager;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.BuildCertifyHistory;
import com.glority.qualityserver.model.Phase;

/**
 * Implementation for BuildCertifyHistory manager.
 * 
 * @author liheping
 * 
 */
@Service("buildCertifyHistoryManager")
public class BuildCertifyHistoryManagerImpl extends GenericManagerImpl<BuildCertifyHistory, Long> implements
        BuildCertifyHistoryManager {

    @Autowired
    private BuildCertifyHistoryDao buildCertifyHistoryDao;

    @Override
    protected GenericDao<BuildCertifyHistory, Long> getDao() {
        return this.buildCertifyHistoryDao;
    }

    public void save(Build build, Phase phase, String certifiedBy) {
        BuildCertifyHistory item = new BuildCertifyHistory();

        item.setBuild(build);
        item.setPhase(phase);
        item.setCertifiedBy(certifiedBy);
        item.setCertifiedAt(new Timestamp(new Date().getTime()));

        this.buildCertifyHistoryDao.save(item);
    }

}
