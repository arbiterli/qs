package com.glority.quality.model;
/**
 * Build model.
 * @author liheping
 *
 */
//TODO add status and during
public class Build {
    private String id;
    private String jenkinsbuild;
    private String jenkinsjob;
    private String result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenkinsbuild() {
        return jenkinsbuild;
    }

    public void setJenkinsbuild(String jenkinsbuild) {
        this.jenkinsbuild = jenkinsbuild;
    }

    public String getJenkinsjob() {
        return jenkinsjob;
    }

    public void setJenkinsjob(String jenkinsjob) {
        this.jenkinsjob = jenkinsjob;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Build [id=");
        builder.append(id);
        builder.append(", jenkinsbuild=");
        builder.append(jenkinsbuild);
        builder.append(", jenkinsjob=");
        builder.append(jenkinsjob);
        builder.append(", result=");
        builder.append(result);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((jenkinsbuild == null) ? 0 : jenkinsbuild.hashCode());
        result = prime * result + ((jenkinsjob == null) ? 0 : jenkinsjob.hashCode());
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
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
        if (!(obj instanceof Build)) {
            return false;
        }
        Build other = (Build) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (jenkinsbuild == null) {
            if (other.jenkinsbuild != null) {
                return false;
            }
        } else if (!jenkinsbuild.equals(other.jenkinsbuild)) {
            return false;
        }
        if (jenkinsjob == null) {
            if (other.jenkinsjob != null) {
                return false;
            }
        } else if (!jenkinsjob.equals(other.jenkinsjob)) {
            return false;
        }
        if (result == null) {
            if (other.result != null) {
                return false;
            }
        } else if (!result.equals(other.result)) {
            return false;
        }
        return true;
    }

}
