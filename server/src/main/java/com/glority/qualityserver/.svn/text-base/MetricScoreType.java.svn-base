package com.glority.qualityserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Metric score type enum.
 * 
 * @author liheping
 * 
 */
public enum MetricScoreType {
    METRIC_TYPE_DUPLICATION("DUPLICATION"), // Duplications of codes, mainly for
                                            // cpd
    METRIC_TYPE_MI("MI"), // Maintainibility Index
    METRIC_TYPE_TEST("TEST"), // Tests general number
    METRIC_TYPE_COVERAGE("COVERAGE"), // Coverage
    METRIC_TYPE_LINT("LINT"), // Code style lint, include lint and check styles
    METRIC_TYPE_DEFECTS("DEFECTS"); // Bugs and Defects reported by rule engine
                                    // like findbugs

    private String value;

    /**
     * constructor.
     * 
     * @param value
     *            string value of the type
     */
    private MetricScoreType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * get all useful types.
     * 
     * @return List<MetricScoreType>
     */
    public static List<MetricScoreType> getAllUsefulTypes() {
        List<MetricScoreType> typeList = new ArrayList<MetricScoreType>();

        typeList.add(METRIC_TYPE_DUPLICATION);
        typeList.add(METRIC_TYPE_MI);
        typeList.add(METRIC_TYPE_TEST);
        typeList.add(METRIC_TYPE_COVERAGE);
        typeList.add(METRIC_TYPE_LINT);
        typeList.add(METRIC_TYPE_DEFECTS);

        return typeList;
    }
}
