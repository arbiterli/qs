package com.glority.qualityserver.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.ConfigurationDao;
import com.glority.qualityserver.model.Configuration;

/**
 * Hibernate implement for configuration dao.
 */
@Repository("configurationDao")
public class ConfigurationDaoHibernate extends GenericDaoHibernate<Configuration, Long> implements ConfigurationDao {
    /**
     * Default constructor.
     */
    public ConfigurationDaoHibernate() {
        super(Configuration.class);
    }

}
