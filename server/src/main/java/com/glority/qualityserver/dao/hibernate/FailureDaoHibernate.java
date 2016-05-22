package com.glority.qualityserver.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.FailureDao;
import com.glority.qualityserver.model.Failure;

/**
 * Hibernate implement for failure dao.
 */
@Repository("failureDao")
public class FailureDaoHibernate extends GenericDaoHibernate<Failure, Long> implements FailureDao {
    /**
     * Default constructor.
     */
    public FailureDaoHibernate() {
        super(Failure.class);
    }

}
