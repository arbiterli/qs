package com.glority.qualityserver.web.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.exception.NoDataException;
import com.glority.qualityserver.metricengine.MetricEngine;
import com.glority.qualityserver.metricengine.MetricEngineProfile;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.PhaseStatus;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.ProductStatus;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.service.MetricEngineDBService;
import com.glority.qualityserver.service.impl.DBBaseService;
import com.glority.qualityserver.util.DateUtils;
import com.glority.qualityserver.web.service.PhaseService;
import com.glority.qualityserver.web.service.ProductService;

/**
 * ProductService implementation.
 * 
 * @author liheping
 * 
 */
@Service("productService")
@Transactional(readOnly = true)
public class ProductServiceImpl extends DBBaseService implements ProductService {
    private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
    @Autowired
    private MetricEngineDBService dbService;

    @Autowired
    private PhaseService phaseService;

    @Autowired
    private AccessControlService accessControlService;

    public List<ProductStatus> getProductsStatus() {
        List<ProductStatus> statusList = new ArrayList<ProductStatus>();

        User user = accessControlService.getCurrentUser();
        List<Product> productList = this.accessControlService.getAuthorizedProducts(user);
        Timestamp now = new Timestamp(new Date().getTime());
        if (productList != null) {
            for (Product product : productList) {
                statusList.add(this.getProductStatus(product.getId(), now));
            }
        }

        return statusList;
    }

    /**
     * get the history score for product, since last month.
     * 
     * @param productId
     * @return List<ProductScore>
     */
    public List<List<Object>> getProductHistoryScore(long productId) {
        final int historyDateNumber = 30;
        int increStep = 1;

        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DATE, -historyDateNumber + 1);
        Date startTime = calendar.getTime();
        List<Date> dateList = DateUtils.getDateList(startTime, endTime, increStep);

        MetricEngineProfile profile = new MetricEngineProfile();
        profile.setProductId(productId);
        profile.setDateList(dateList);
        LOGGER.info(profile);

        MetricEngine engine = new MetricEngine(profile, this.dbService);

        List<Integer> devScoreList = engine.getPhaseScores(ProductStage.DEV);
        List<Integer> testScoreList = engine.getPhaseScores(ProductStage.TEST);
        List<Integer> stageScoreList = engine.getPhaseScores(ProductStage.STAGE);
        List<Integer> prodScoreList = engine.getPhaseScores(ProductStage.PROD);

        List<List<Object>> result = new ArrayList<List<Object>>();
        result.add(this.generateMockMetricScoreTitle());

        SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT_STRING);

        for (int i = 0; i < historyDateNumber; i++) {
            List<Object> item = new ArrayList<Object>();

            item.add(df.format(calendar.getTime()));
            item.add(devScoreList.get(i).intValue());
            item.add(testScoreList.get(i).intValue());
            item.add(stageScoreList.get(i).intValue());
            item.add(prodScoreList.get(i).intValue());

            result.add(item);

            calendar.add(Calendar.DATE, 1);
        }

        return result;
    }

    private List<Object> generateMockMetricScoreTitle() {
        List<Object> title = new ArrayList<Object>();
        title.add("day");
        title.add("Develop");
        title.add("Test");
        title.add("Stage");
        title.add("Production");
        return title;
    }

    private PhaseStatus getPhaseStatus(long productId, ProductStage phase, Timestamp date) {
        Build devBuild = this.dbService.getBuildForScore(productId, phase, date);
        if (devBuild == null) {
            return null;
        }
        return phaseService.getPhaseStatus(devBuild.getId(), phase, false);
    }

    public ProductStatus getProductStatus(long productId, Timestamp date) {
        ProductStatus productStatus = new ProductStatus();

        Product product = super.productManager.get(productId);
        productStatus.setProduct(product);
        if (product != null) {
            DateUtils.setTimeToDateEndTime(date);
            productStatus.setDevStatus(getPhaseStatus(productId, ProductStage.DEV, date));
            productStatus.setTestStatus(getPhaseStatus(productId, ProductStage.TEST, date));
            productStatus.setStageStatus(getPhaseStatus(productId, ProductStage.STAGE, date));
            productStatus.setProdStatus(getPhaseStatus(productId, ProductStage.PROD, date));

        }
        return productStatus;
    }

    public String getProductNameForDisplay(long productId) {
        Product product = super.productManager.get(productId);
        return product.getDisplayName();
    }

    /**
     * this method is to get all products.
     * 
     * @return list of product
     */
    public List<Product> getAllProducts() {
        return this.productManager.getAll();
    }

    /**
     * this method is to modify product info.
     * 
     */
    @Transactional
    public Product modifyProductInfo(Product product) {
        super.productManager.validate(product);
        Product existProduct = super.productManager.get(product.getId());
        if (existProduct == null) {
            throw new NoDataException();
        }

        existProduct.setDisplayName(product.getDisplayName());
        existProduct.setName(product.getName());
        existProduct.setGroup(product.getGroup());
        existProduct.setDiscarded(product.getDiscarded());
        existProduct.setTrunkSvnUrl(product.getTrunkSvnUrl());

        return this.productManager.save(existProduct);

    }

    @Override
    public Product getProductById(long productId) {
        Product product = super.productManager.get(productId);
        if (product != null) {
            product.setDisplayName(super.productManager.getDisplayName(product));
        }

        return product;
    }

    @Override
    public List<Product> getAllValidProducts() {
        return this.productManager.getAllProducts();
    }

    @Override
    public Product getProductByBuild(long buildId) {
        Build build = super.buildManager.get(buildId);
        if (build != null) {
            Product product = build.getProduct();
            product.setDisplayName(super.productManager.getDisplayName(product));
            return product;
        }
        return null;
    }
}
