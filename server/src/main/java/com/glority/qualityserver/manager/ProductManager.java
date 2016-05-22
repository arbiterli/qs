package com.glority.qualityserver.manager;

import java.util.List;

import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Server;

/**
 * Product manager interface.
 * 
 * @author liheping
 * 
 */
public interface ProductManager extends GenericManager<Product, Long> {

    /**
     * get the product by name and version.
     * 
     * @param name
     * @param versionId
     * @return
     */
    Product getProduct(String name);

    /**
     * check whether the product can synchronize issue.
     * 
     * default implementation : check all the field in the product
     * 
     * @param product
     * @return
     */
    boolean isIssueDBConfiged(Product product);

    /**
     * check whether the product configured test rail.
     * 
     * @param product
     * @return
     */
    boolean isTestRailConfiged(Product product);

    /**
     * get product which contains the server.
     * 
     * @param server
     * @return
     */
    Product getProduct(Server server);

    /**
     * check the product has server.
     * 
     * @param productId
     * @return
     */
    boolean hasProductionServer(long productId);

    /**
     * get all valid products.
     * 
     * @param discared
     * @return
     */
    List<Product> getAllProducts();

    /**
     * get the display name for product.
     * 
     * @param product
     * @return
     */
    String getDisplayName(Product product);

    /**
     * validate product.
     * 
     * @param product
     */
    void validate(Product product);

    /**
     * get the product with Extend Properties.
     * 
     * @param productId
     * @return
     */
    Product getProductWithExtendProperties(long productId);

    /**
     * fill product with extend properties.
     * 
     * @param product
     * @return
     */
    Product fillProductWithExtendProperties(Product product);

    /**
     * get all valid products with extend properties.
     * 
     * @return
     */
    List<Product> getAllProductsWithExtendProperties();

    /**
     * get all the products which can auto scan new quality report.
     * 
     * @return
     */
    List<Product> getAutoScanNewReportProducts();
}
