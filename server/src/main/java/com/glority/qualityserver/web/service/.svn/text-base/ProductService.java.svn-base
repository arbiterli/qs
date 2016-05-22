package com.glority.qualityserver.web.service;

import java.sql.Timestamp;
import java.util.List;

import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.ProductStatus;

/**
 * ProductService interface.
 * 
 * @author liheping
 * 
 */
public interface ProductService {

    List<ProductStatus> getProductsStatus();

    /**
     * get history scores for product in the latest month.
     * 
     * @param productId
     * @return
     */
    List<List<Object>> getProductHistoryScore(long productId);


    ProductStatus getProductStatus(long productId, Timestamp date);

    /**
     * get product, the product should deal with the display name.
     * 
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * get product, the product should deal with the display name.
     * @param buildId
     * @return
     */
    Product getProductByBuild(long buildId);

    String getProductNameForDisplay(long productId);

    /**
     * get the all product.
     * 
     * @return List of product
     */
    List<Product> getAllProducts();

    /**
     * get all valid products.
     * 
     * @return
     */
    List<Product> getAllValidProducts();

    /**
     * modify product.
     * 
     */

    Product modifyProductInfo(Product product);


}
