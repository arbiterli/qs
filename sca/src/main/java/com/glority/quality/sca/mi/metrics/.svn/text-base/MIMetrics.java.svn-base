package com.glority.quality.sca.mi.metrics;

/**
 * Model for MI metrics.
 * 
 * @author XQS
 * 
 */
public abstract class MIMetrics {
    private static final int MI_BASE_VALUE = 171;
    private static final double V_FACTOR = 5.2;
    private static final double G_FACTOR = 0.23;
    private static final double LOC_FACTOR = 16.2;
    private static final double LOM_FACTOR = 50;
    private static final double CMRATE_FACTOR = 2.4;

    protected float loc; // Lines of code
    protected float lom; // Lines of comment
    protected float avgHalsteadVolume; // Halstead Volume
    /**
     * MI = 171 - 5.2 * ln(V) - 0.23 * (G) - 16.2 * ln(LOC).
     */
    protected float mi; // Maintianablity index
    /**
     * MI = 171 - 5.2 * log2(V) - 0.23 * G - 16.2 * ln(LOC) + 50 * sin (sqrt(2.4
     * * CMRate)).
     */
    protected float cmi; // Maintainability index with comment rate

    /**
     * We used a simplified CC metric, just count the number of branching, loop
     * tokens.
     * 
     */
    protected float avgCcVolume; // Cyclomatic complexity

    public float getLoc() {
        return loc;
    }

    public void setLoc(float loc) {
        this.loc = loc;
    }

    public float getLom() {
        return lom;
    }

    public void setLom(float lom) {
        this.lom = lom;
    }

    public float getAvgHalsteadVolume() {
        return avgHalsteadVolume;
    }

    public void setAvgHalsteadVolume(float halsteadVolume) {
        this.avgHalsteadVolume = halsteadVolume;
    }

    public float getAvgCcVolume() {
        return avgCcVolume;
    }

    public void setAvgCcVolume(float ccVolume) {
        this.avgCcVolume = ccVolume;
    }

    public float getMi() {
        return mi;
    }

    public float getCmi() {
        return cmi;
    }

    public abstract float getAvgLoc();

    public abstract float getAvgLom();

    /**
     * Calculate the avg values of the metrics.
     * 
     * @return
     */
    public abstract void calculateAvgMetrics();

    /**
     * Calculate the MI values.
     * 
     * @return
     */
    public void calculateMI() {
        calculateAvgMetrics();
        straightGetMI();
    }

    public void straightGetMI() {
        if (getAvgLoc() <= 0 || getAvgHalsteadVolume() <= 0) {
            this.mi = MI_BASE_VALUE;
            this.cmi = MI_BASE_VALUE;
            return;
        }
        double vmi = MI_BASE_VALUE - V_FACTOR * Math.log(getAvgHalsteadVolume()) - G_FACTOR
                * getAvgCcVolume() - LOC_FACTOR * Math.log(getAvgLoc());
        this.mi = (float) vmi;

        double cmRate = (double) getAvgLom() / (double) (getAvgLoc() + getAvgLom());
        double vcmi = LOM_FACTOR * Math.sin(Math.sqrt(CMRATE_FACTOR * cmRate));
        this.cmi = this.mi + (float) vcmi;
    }
}
