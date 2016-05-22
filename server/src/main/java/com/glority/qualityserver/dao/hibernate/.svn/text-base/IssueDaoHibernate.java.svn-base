package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.IssueDao;
import com.glority.qualityserver.model.IssueRecord;

/**
 * Hibernate implemetation for Issue DAO.
 * 
 * @author liheping
 * 
 */
@Repository("issueDao")
public class IssueDaoHibernate extends GenericDaoHibernate<IssueRecord, Long> implements IssueDao {

    /**
     * Default constructor.
     */
    public IssueDaoHibernate() {
        super(IssueRecord.class);
    }

    /**
     * get all issue records in product version.
     * 
     * @param productId
     *            specified product id
     * @param versionId
     *            the version id
     * @return List<IssueRecord>, if not exists, it is an empty list
     */
    public List<IssueRecord> getIssueRecords(long productId, long versionId) {
        String hql = "from IssueRecord where product_id = ? and version_id = ? order by create_time desc";
        Object[] params = new Object[] { Long.valueOf(productId), Long.valueOf(versionId) };
        return super.getItems(hql, params);
    }
}
