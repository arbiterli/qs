package com.glority.quality.model;

import java.util.List;
/**
 * Configuration model.
 * @author liheping
 *
 */
public class Configuration {
    private String id;
    private Environments environments;
    private List<String> softwares;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Environments getEnvironments() {
        return environments;
    }

    public void setEnvironments(Environments environments) {
        this.environments = environments;
    }

    public List<String> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<String> softwares) {
        this.softwares = softwares;
    }

    public void addSoftware(String software) {
        this.softwares.add(software);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Configuration [id=");
        builder.append(id);
        builder.append(", environments=");
        builder.append(environments);
        builder.append(", softwares=");
        builder.append(softwares);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((environments == null) ? 0 : environments.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((softwares == null) ? 0 : softwares.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) obj;
        if (environments == null) {
            if (other.environments != null) {
                return false;
            }
        } else if (!environments.equals(other.environments)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (softwares == null) {
            if (other.softwares != null) {
                return false;
            }
        } else if (!softwares.equals(other.softwares)) {
            return false;
        }
        return true;
    }

}
