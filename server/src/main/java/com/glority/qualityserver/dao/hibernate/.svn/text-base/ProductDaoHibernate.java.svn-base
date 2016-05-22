package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.ProductDao;
import com.glority.qualityserver.model.Product;

/**
 * Hibernate implement for product DAO.
 */
@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long>
        implements ProductDao {
    /**
     * default constructor.
     */
    public ProductDaoHibernate() {
        super(Product.class);
    }

    /**
     * get the product with the name .
     * 
     * @param name
     *            the product's name
     * 
     * @return Product, if not exists, return null
     */
    public Product getProduct(String name) {
        String hql = "from Product where name = ?";
        Object[] params = new Object[] { name };
        return super.getItem(hql, params);
    }

    @Override
    public List<Product> getAllProduct() {
        String hql = "from Product where discarded = ?";
        Object[] params = new Object[] { Boolean.FALSE };
        return super.getItems(hql, params);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Product getProductById(Long id) {
        List<Product> productList = this.getHibernateTemplate().find(
                "from Product where id = ?", new Object[] { id });

        if (productList == null || productList.isEmpty()) {
            return null;
        }

        return productList.get(0);
    }

}
