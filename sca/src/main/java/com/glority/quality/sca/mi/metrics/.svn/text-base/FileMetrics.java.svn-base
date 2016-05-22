package com.glority.quality.sca.mi.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * FileMetrics.
 * 
 * @author
 * 
 */
public class FileMetrics extends MIMetrics {
    private String filePath;
    private List<FunctionMetrics> functions;
    private int fileOrder;

    public FileMetrics() {
        functions = new ArrayList<FunctionMetrics>();
        fileOrder = -1;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<FunctionMetrics> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionMetrics> functions) {
        this.functions = functions;
    }

    public int getFileOrder() {
        return fileOrder;
    }

    public void setFileOrder(int fileOrder) {
        this.fileOrder = fileOrder;
    }

    public void setMi(float mi) {
        this.mi = mi;
    }

    public void setCmi(float cmi) {
        this.cmi = cmi;
    }

    @Override
    public float getAvgLoc() {
        if (functions.size() == 0) {
            return this.getLoc();
        } else {
            return this.getLoc() / functions.size();
        }
    }

    @Override
    public float getAvgLom() {
        if (functions.size() == 0) {
            return this.getLom();
        } else {
            return this.getLom() / functions.size();
        }
    }

    public void addFunction(FunctionMetrics fm) {
        this.functions.add(fm);
    }

    public void calculateAvgMetrics() {
        if (functions.size() == 0) {
            this.setAvgHalsteadVolume(0);
            this.setAvgCcVolume(0);
        } else {
            float totalH = 0;
            float totalCC = 0;
            for (int i = 0; i < functions.size(); i++) {
                FunctionMetrics fm = (FunctionMetrics) functions.get(i);
                totalH += fm.getAvgHalsteadVolume();
                totalCC += fm.getAvgCcVolume();
            }
            this.setAvgHalsteadVolume(totalH / functions.size());
            this.setAvgCcVolume(totalCC / functions.size());
        }
    }

    /**
     * files sorted by cmi.
     */
    public void sortFiles() {
        for (int i = 0; i < functions.size(); i++) {
            for (int j = i + 1; j < functions.size(); j++) {
                if (functions.get(j).getCmi() < functions.get(i).getCmi()) {
                    swap(i, j);
                }
            }
        }
    }

    /**
     * exchange two FileMetrics.
     */
    private void swap(int i, int j) {
        FunctionMetrics temp = functions.get(i);
        functions.set(i, functions.get(j));
        functions.set(j, temp);
    }
}
