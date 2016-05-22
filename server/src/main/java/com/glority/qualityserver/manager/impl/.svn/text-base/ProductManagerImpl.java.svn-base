package com.glority.qualityserver.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.PhaseDao;
import com.glority.qualityserver.dao.ProductDao;
import com.glority.qualityserver.dao.ProductExtendPropertyDao;
import com.glority.qualityserver.manager.ProductManager;
import com.glority.qualityserver.model.IssueTrack;
import com.glority.qualityserver.model.Phase;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.ProductExtendProperty;
import com.glority.qualityserver.model.Server;
import com.glority.qualityserver.model.TestRail;
import com.glority.qualityserver.model.filler.ModelFiller;

/**
 * ProductManager implementation.
 * 
 * @author Administrator
 * 
 */
@Service("productManager")
public class ProductManagerImpl extends GenericManagerImpl<Product, Long> implements ProductManager {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private PhaseDao phaseDao;

    @Autowired
    private ProductExtendPropertyDao propertyDao;

    @Override
    protected GenericDao<Product, Long> getDao() {
        return this.productDao;
    }

    public Product getProduct(String name) {

        return this.productDao.getProduct(name);
    }

    public Product getProduct(Server server) {
        if (server == null) {
            return null;
        }

        Phase phase = this.phaseDao.get(server.getPhaseId());

        if (phase == null) {
            return null;
        }

        return this.productDao.get(phase.getProductId());
    }

    /**
     * check whether the product can synchronize issue.
     * 
     * default implementation : check all the field in the product
     * 
     * @param product
     * @return
     */
    public boolean isIssueDBConfiged(Product product) {
        if (product == null) {
            return false;
        }
        IssueTrack issueTrack = product.getIssueTrack();

        if (issueTrack == null) {
            return false;
        }

        if (issueTrack.getIssueTrackBaseUrl() == null) {
            return false;
        }

        if (issueTrack.getIssueTrackProductName() == null) {
            return false;
        }

        if (issueTrack.getIssueTrackUsername() == null) {
            return false;
        }

        if (issueTrack.getIssueTrackPassword() == null) {
            return false;
        }

        return true;
    }

    public boolean isTestRailConfiged(Product product) {
        if (product == null) {
            return false;
        }
        TestRail testRail = product.getTestRail();
        if (testRail == null) {
            return false;
        }

        if (testRail.getTestrailServer() == null) {
            return false;
        }

        if (testRail.getTestrailProductId() == null) {
            return false;
        }

        if (testRail.getTestrailPassword() == null) {
            return false;
        }

        return true;
    }

    public boolean hasProductionServer(long productId) {
        Product product = this.productDao.get(productId);
        if (product != null) {
            return product.getHasServer() == null ? false : product.getHasServer();
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDao.getAllProduct();
    }

    @Override
    public String getDisplayName(Product product) {
        if (product == null) {
            return null;
        }

        if (StringUtils.isNotEmpty(product.getDisplayName())) {
            return product.getDisplayName();
        }

        return product.getName();
    }

    @Override
    public void validate(Product product) {
        // TODO Auto-generated method stub
    }

    @Override
    public Product getProductWithExtendProperties(long productId) {
        Product product = this.productDao.get(productId);
        List<ProductExtendProperty> propertyList = this.propertyDao.getProperties(productId);
        ModelFiller.fillModelWithProperties(product, new ArrayList<Object>(propertyList));
        return product;
    }

    @Override
    public Product fillProductWithExtendProperties(Product product) {
        if (product == null) {
            return null;
        }
        List<ProductExtendProperty> propertyList = this.propertyDao.getProperties(product.getId());
        ModelFiller.fillModelWithProperties(product, new ArrayList<Object>(propertyList));
        return product;
    }

    @Override
    public List<Product> getAllProductsWithExtendProperties() {
        List<Product> productList = this.getAllProducts();
        if (productList != null && !productList.isEmpty()) {
            for (Product product : productList) {
                this.fillProductWithExtendProperties(product);
            }
        }
        return productList;
    }

    @Override
    public List<Product> getAutoScanNewReportProducts() {
        List<Product> result = new ArrayList<Product>();
        List<Product> productList = this.getAllProductsWithExtendProperties();
        for (Product product : productList) {
            if (this.validateProductForAutoScan(product)) {
                result.add(product);
            }
        }
        return result;
    }

    private boolean validateProductForAutoScan(Product product) {
        if (product.getName() == null) {
            return false;
        }

        if (product.getFtpReportScope() == null) {
            return false;
        }

        return true;
    }
}
