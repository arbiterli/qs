package com.glority.qualityserver.metricengine;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glority.qualityserver.ProductStage;

/**
 * this class is the param for metric engine.
 * 
 * @author liheping
 * 
 */
public class MetricEngineProfile implements Cloneable {
    // since product id and build id can not be smaller than 0, so use -1 to
    // stand for not setted
    private long productId = -1;
    private long buildId = -1;

    private List<Date> dateList;

    private Timestamp rqSampleTime;
    private Timestamp ifaSampleTime;

    private Map<ProductStage, Long> phaseBuildMap = new HashMap<ProductStage, Long>();

    private ProductStage phase;

    public MetricEngineProfile() {

    }

    /**
     * Constructor, dateList and phaseBuildMap is the same date with profile.
     * 
     * @param profile
     */
    public MetricEngineProfile(MetricEngineProfile profile) {
        this.productId = profile.productId;
        this.buildId = profile.buildId;
        this.rqSampleTime = profile.rqSampleTime;
        this.ifaSampleTime = profile.ifaSampleTime;
        this.phaseBuildMap = profile.phaseBuildMap;
        this.dateList = profile.dateList;
        this.phase = profile.phase;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public List<Date> getDateList() {
        return dateList;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }

    public long getBuildId() {
        return buildId;
    }

    public void setBuildId(long buildId) {
        this.buildId = buildId;
    }

    public Timestamp getRqSampleTime() {
        return rqSampleTime;
    }

    public void setRqSampleTime(Timestamp rqSampleTime) {
        this.rqSampleTime = rqSampleTime;
    }

    public Timestamp getIfaSampleTime() {
        return ifaSampleTime;
    }

    public void setIfaSampleTime(Timestamp ifaSampleTime) {
        this.ifaSampleTime = ifaSampleTime;
    }

    public Map<ProductStage, Long> getPhaseBuildMap() {
        return phaseBuildMap;
    }

    public void setPhaseBuildMap(Map<ProductStage, Long> phaseBuildMap) {
        this.phaseBuildMap = phaseBuildMap;
    }

    public ProductStage getPhase() {
        return phase;
    }

    protected void setPhase(ProductStage phase) {
        this.phase = phase;
    }

    /**
     * date list and phase build map attribute is the same with that in this.
     */
    public MetricEngineProfile clone() {
        return new MetricEngineProfile(this);
    }
}
