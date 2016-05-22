package com.glority.qualityserver.manager.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.VersionDao;
import com.glority.qualityserver.manager.BuildManager;
import com.glority.qualityserver.manager.VersionManager;
import com.glority.qualityserver.model.Version;

/**
 * Version manager implementation.
 * 
 * @author liheping
 * 
 */
@Service("versionManager")
public class VersionManagerImpl extends GenericManagerImpl<Version, Long> implements VersionManager {
    @Autowired
    private VersionDao versionDao;

    @Autowired
    private BuildManager buildManager;

    @Override
    protected GenericDao<Version, Long> getDao() {
        return this.versionDao;
    }

    public boolean exists(String version, long productId) {

        return this.versionDao.exists(version, productId);
    }

    public List<Version> getStageVersions(long productId, ProductStage stage, Timestamp date) {
        return this.versionDao.getVersions(productId, stage, date);
    }

    public List<Version> getStageVersionsBeforeDate(long productId, ProductStage stage, Timestamp date) {
        return this.versionDao.getVersionsBeforeDate(productId, stage, date);
    }

    public List<Version> getStageVersionsBeforeToday(long productId, ProductStage stage) {
        Timestamp now = new Timestamp(new Date().getTime());

        return getStageVersionsBeforeDate(productId, stage, now);
    }

    public Version getVersion(String version, long productId) {

        return this.versionDao.getVersion(version, productId);
    }

    public List<Version> getVersions(long productId) {
        return this.versionDao.getVersions(productId);
    }

    @Override
    public List<Version> getVersions(long productId, ProductStage phase) {
        List<Version> result = new ArrayList<Version>();

        List<Version> versionList = this.versionDao.getVersions(productId);
        for (Version version : versionList) {
            if (buildManager.getBuildInVersion(productId, version.getId(), phase) != null) {
                result.add(version);
            }
        }
        return result;
    }

    @Override
    public void validate(Version version) {
        // TODO Auto-generated method stub
    }

}
