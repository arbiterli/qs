package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.QualityEngineFailureDao;
import com.glority.qualityserver.model.QualityEngineFailure;
/**
 * Quality Engine Failure Dao Hibernate class.
 */
@Repository("qualityenginefailureDao")
public class QualityEngineFailureDaoHibernate extends GenericDaoHibernate<QualityEngineFailure, Long> implements
        QualityEngineFailureDao {

    public QualityEngineFailureDaoHibernate() {
        super(QualityEngineFailure.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<QualityEngineFailure> getQualityEngineFailureWithTask(String task) {
        Object[] params = new Object[] { task };
        //TODO:compiler warning,need refactoring code.
        return super.getHibernateTemplate().find("from QualityEngineFailure where taskClassName = ?", params);
    }
}
