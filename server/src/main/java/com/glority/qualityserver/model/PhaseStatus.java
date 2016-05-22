package com.glority.qualityserver.model;

import java.util.List;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

/**
 * The status of a phase
 *
 */
@DataTransferObject
public class PhaseStatus {
    private Phase phase;

    @RemoteProperty
    private int score;

    @RemoteProperty
    private Build activeBuild;

    private List<Build> buildList;

    private List<Version> versionList;

    public Phase getPhase() {
        return phase;
    }
    public void setPhase(Phase phase) {
        this.phase = phase;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Build getActiveBuild() {
        return activeBuild;
    }
    public void setActiveBuild(Build activeBuild) {
        this.activeBuild = activeBuild;
    }
    public List<Build> getBuildList() {
        return buildList;
    }
    public void setBuildList(List<Build> buildList) {
        this.buildList = buildList;
    }
    public List<Version> getVersionList() {
        return versionList;
    }
    public void setVersionList(List<Version> versionList) {
        this.versionList = versionList;
    }
}
