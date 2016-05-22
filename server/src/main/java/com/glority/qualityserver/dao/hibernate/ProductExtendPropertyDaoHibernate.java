package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.ProductExtendPropertyDao;
import com.glority.qualityserver.model.ProductExtendProperty;

/**
 * ProductExtendPropertyDaoHibernate.
 * 
 * @author li.heping
 * 
 */
@Repository("productExtendPropertyDao")
public class ProductExtendPropertyDaoHibernate extends GenericDaoHibernate<ProductExtendProperty, Long> implements
        ProductExtendPropertyDao {

    public ProductExtendPropertyDaoHibernate() {
        super(ProductExtendProperty.class);
    }

    @Override
    public List<ProductExtendProperty> getProperties(long productId) {
        String hql = "from ProductExtendProperty where product_id = ?";
        Object[] params = new Object[] { Long.valueOf(productId) };
        return super.getItems(hql, params);
    }
}
