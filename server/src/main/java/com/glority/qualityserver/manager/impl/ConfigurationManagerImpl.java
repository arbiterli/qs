package com.glority.qualityserver.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.ConfigurationDao;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.manager.ConfigurationManager;
import com.glority.qualityserver.model.Configuration;

/**
 * Implementation for Configuration manager.
 * 
 * @author liheping
 * 
 */
@Service("configurationManager")
public class ConfigurationManagerImpl extends GenericManagerImpl<Configuration, Long> implements ConfigurationManager {
    @Autowired
    private ConfigurationDao configurationDao;

    @Override
    protected GenericDao<Configuration, Long> getDao() {
        return this.configurationDao;
    }

}
