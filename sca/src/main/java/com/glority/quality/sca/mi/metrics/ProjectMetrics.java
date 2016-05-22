package com.glority.quality.sca.mi.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectMetrics.
 * 
 * @author
 * 
 */
public class ProjectMetrics extends MIMetrics {
    private String path;
    private List<FileMetrics> files;
    private int totalFunctions;

    public ProjectMetrics() {
        files = new ArrayList<FileMetrics>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FileMetrics> getFiles() {
        return files;
    }

    public void setFiles(List<FileMetrics> files) {
        this.files = files;
    }

    public void addFile(FileMetrics fmi) {
        files.add(fmi);
    }

    public int getTotalFunctions() {
        return totalFunctions;
    }

    public void setTotalFunctions(int totalFunctions) {
        this.totalFunctions = totalFunctions;
    }

    @Override
    public float getAvgLoc() {
        if (totalFunctions == 0) {
            return this.loc;
        } else {
            return loc / totalFunctions;
        }
    }

    @Override
    public float getAvgLom() {
        if (totalFunctions == 0) {
            return this.lom;
        } else {
            return lom / totalFunctions;
        }
    }

    @Override
    public void calculateAvgMetrics() {
        float totalLoc = 0;
        float totalLom = 0;
        float totalH = 0;
        float totalCC = 0;
        for (int i = 0; i < files.size(); i++) {
            FileMetrics fm = (FileMetrics) files.get(i);
            totalLoc += fm.getLoc();
            totalLom += fm.getLom();
            totalH += fm.getAvgHalsteadVolume() * fm.getFunctions().size();
            totalCC += fm.getAvgCcVolume() * fm.getFunctions().size();
            totalFunctions += fm.getFunctions().size();
        }
        this.loc = totalLoc;
        this.lom = totalLom;
        if (totalFunctions == 0) {
            this.setAvgHalsteadVolume(0);
            this.setAvgCcVolume(0);
        } else {
            this.setAvgHalsteadVolume(totalH / (float) totalFunctions);
            this.setAvgCcVolume(totalCC / (float) totalFunctions);
        }
    }

    /**
     * functions sorted by cmi.
     */
    public void sortFiles() {
        for (int i = 0; i < files.size(); i++) {
            for (int j = i + 1; j < files.size(); j++) {
                if (files.get(j).getCmi() < files.get(i).getCmi()) {
                    swap(i, j);
                }
            }
        }
    }

    /**
     * exchange two FunctionMetrics.
     */
    private void swap(int i, int j) {
        FileMetrics temp = files.get(i);
        files.set(i, files.get(j));
        files.set(j, temp);
    }
}
