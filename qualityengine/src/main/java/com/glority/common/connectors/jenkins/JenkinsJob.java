package com.glority.common.connectors.jenkins;

import java.util.List;

/**
 * jenkins job model.
 * 
 * @author zm
 * 
 */
public class JenkinsJob {
    private String name;
    private String url;
    private JobColor color;
    private List<JenkinsBuild> builds;
    private List<Parameter> parameters;

    public List<JenkinsBuild> getBuilds() {
        return builds;
    }

    public void setBuilds(List<JenkinsBuild> builds) {
        this.builds = builds;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JobColor getColor() {
        return color;
    }

    public void setColor(JobColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "JenkinsJob [name=" + name + ", url=" + url + ", color=" + color + ", builds=" + builds
                + ", parameters=" + parameters + "]";
    }

    /**
     * Job display color.
     * 
     * @author li.heping
     * 
     */
    public static enum JobColor {
        red, yellow, blue;
    }
}
