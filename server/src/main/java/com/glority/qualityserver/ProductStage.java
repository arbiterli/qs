package com.glority.qualityserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Product stage enums.
 */
public enum ProductStage {
    INVALID("invalid"), DEV("Dev"), TEST("Test"), STAGE("Stage"), PROD("Production");

    private String value;

    /**
     * Hidden constructor for ProductStage.
     * 
     * @param value
     *            value.
     */
    private ProductStage(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * get the next ProductStage which is greater than this.
     * 
     * @return next greater stage, if not exists, return INVALID
     */
    public ProductStage getNextProductStage() {
        ProductStage[] stages = ProductStage.values();
        for (ProductStage stage : stages) {
            if (stage.compareTo(this) == 1) {
                return stage;
            }
        }

        return INVALID;
    }

    /**
     * compare this stage with specified stage.
     * 
     * @param stage
     *            specified the compared to stage
     * @return if this stage equal or bigger than the specified stage, return true. otherwise, false
     */
    public boolean isEqualOrBiggerThan(ProductStage stage) {
        if (this.compareTo(stage) >= 0) {
            return true;
        }

        return false;
    }

    /**
     * Genereate product stage singleton instance by the input value.
     * 
     * @param value
     *            the value
     * @return the product stage singleton instance.
     */
    public static ProductStage getProductStage(String value) {

        ProductStage[] stages = ProductStage.values();
        for (ProductStage stage : stages) {
            if (stage.value.equalsIgnoreCase(value)) {
                return stage;
            }
        }

        return INVALID;

    }

    /**
     * get all usefull stage.
     * 
     * @return List<ProductStage>
     */
    public static List<ProductStage> getAllUsefulStage() {
        List<ProductStage> list = new ArrayList<ProductStage>();
        list.add(DEV);
        list.add(TEST);
        list.add(STAGE);
        list.add(PROD);
        return list;
    }
}
