package com.glority.qualityserver.dao;

import java.util.List;

import com.glority.qualityserver.model.Product;

/**
 * Product DAO interface.
 */
public interface ProductDao extends GenericDao<Product, Long> {

    /**
     * get the product with the name .
     * 
     * @param name
     *            the product's name
     * 
     * @return Product, if not exists, return null
     */
    Product getProduct(String name);

    /**
     * get all valid product.
     * 
     * @return
     */
    List<Product> getAllProduct();

    /**
     * to get product by id.
     * @param product id.
     * @return the product.
     */
    Product getProductById(Long id);
}
