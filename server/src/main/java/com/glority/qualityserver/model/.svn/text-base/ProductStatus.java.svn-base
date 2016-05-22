package com.glority.qualityserver.model;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * Status of a product
 *
 */
@DataTransferObject
public class ProductStatus {
    @RemoteProperty
    private Product product;

    @RemoteProperty
    private PhaseStatus devStatus;

    @RemoteProperty
    private PhaseStatus testStatus;

    @RemoteProperty
    private PhaseStatus stageStatus;

    @RemoteProperty
    private PhaseStatus prodStatus;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public PhaseStatus getDevStatus() {
        return devStatus;
    }
    public void setDevStatus(PhaseStatus devStatus) {
        this.devStatus = devStatus;
    }
    public PhaseStatus getTestStatus() {
        return testStatus;
    }
    public void setTestStatus(PhaseStatus testStatus) {
        this.testStatus = testStatus;
    }
    public PhaseStatus getStageStatus() {
        return stageStatus;
    }
    public void setStageStatus(PhaseStatus stageStatus) {
        this.stageStatus = stageStatus;
    }
    public PhaseStatus getProdStatus() {
        return prodStatus;
    }
    public void setProdStatus(PhaseStatus prodStatus) {
        this.prodStatus = prodStatus;
    }

    public ProductStatus toPojo() {
        ProductStatus productStatus = new ProductStatus();
        productStatus.setDevStatus(this.getDevStatus());
        productStatus.setTestStatus(this.getTestStatus());
        productStatus.setStageStatus(this.getTestStatus());
        productStatus.setProdStatus(this.getProdStatus());

        Product product = new Product();
        product.setId(this.product.getId());
        product.setDisplayName(this.product.getDisplayName());
        productStatus.setProduct(product);
        return productStatus;
    }
}
