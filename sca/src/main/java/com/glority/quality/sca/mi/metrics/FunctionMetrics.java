package com.glority.quality.sca.mi.metrics;

/**
 * FunctionMetrics.
 * 
 * @author
 * 
 */
public class FunctionMetrics extends MIMetrics {
    private String functionName;

    /**
     * 
     * Program vocabulary: n = n1 + n1, Program length: N = N1 + N2, Calculated.
     * program length: N^ = n1*log2(n1) * n2*log2(n2). Volume: V = N * log2 n.
     * Difficulty : D = (n1 / 2) * (N2 / n2). Effort: E = D * V.
     * 
     */
    private int hn1; // the number of distinct operators
    private int hn2; // the number of distinct operands
    private int hN1; // the total number of operators
    private int hN2; // the total number of operands

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getHn1() {
        return hn1;
    }

    public void setHn1(int hn1) {
        this.hn1 = hn1;
    }

    public int getHn2() {
        return hn2;
    }

    public void setHn2(int hn2) {
        this.hn2 = hn2;
    }

    public int gethN1() {
        return hN1;
    }

    public void sethN1(int hN1) {
        this.hN1 = hN1;
    }

    public int gethN2() {
        return hN2;
    }

    public void sethN2(int hN2) {
        this.hN2 = hN2;
    }

    public void setMi(float mi) {
        this.mi = mi;
    }

    public void setCmi(float cmi) {
        this.cmi = cmi;
    }

    @Override
    public float getAvgLoc() {
        return this.getLoc();
    }

    @Override
    public float getAvgLom() {
        return this.getLom();
    }

    public void calculateAvgMetrics() {
        double n = hn1 + hn2;
        double ln = hN1 + hN2;
        double h = 0;
        if (n > 0) {
            h = ln * Math.log(n) / Math.log(2);
        }
        this.setAvgHalsteadVolume((float) h);
    }
}
