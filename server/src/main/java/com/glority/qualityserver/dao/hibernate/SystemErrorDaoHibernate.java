package com.glority.qualityserver.dao.hibernate;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.SystemErrorDao;
import com.glority.qualityserver.model.SystemError;

/**
 * SystemErrorDaoHibernate.
 * 
 * @author li.heping
 * 
 */
@Repository("systemErrorDao")
public class SystemErrorDaoHibernate extends GenericDaoHibernate<SystemError, Long> implements SystemErrorDao {
    /**
     * Default constructor.
     */
    public SystemErrorDaoHibernate() {
        super(SystemError.class);
    }

    @Override
    public List<SystemError> getSystemErrors(String status) {
        String hql = "from SystemError where status = ? order by create_time desc";
        Object[] params = new Object[] { status };
        return super.getItems(hql, params);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<SystemError> getLimittedSystemErrors(final int pageIndex, final int limit) {
        if ((pageIndex - 1) * limit >= this.getRowCount()) {
            return Collections.emptyList();
        }
        final String hql = "from SystemError order by create_time desc";
        return (List<SystemError>) this.getHibernateTemplate().executeFind(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) {
                final Query query = session.createQuery(hql);
                query.setMaxResults(limit);
                query.setFirstResult((pageIndex - 1) * limit);
                return query.list();
            }
        });
    }

    @Override
    public long getRowCount() {
        String hql = "select count(*) from SystemError";
        Long count = (Long) this.getHibernateTemplate().find(hql).listIterator().next();
        return count.intValue();
    }
}
