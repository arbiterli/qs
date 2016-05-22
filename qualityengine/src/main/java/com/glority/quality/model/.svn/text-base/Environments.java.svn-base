package com.glority.quality.model;
/**
 * Environments model.
 * @author liheping
 *
 */
public class Environments {
    private String os;
    private String arch;
    private String language;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Environments [os=");
        builder.append(os);
        builder.append(", arch=");
        builder.append(arch);
        builder.append(", language=");
        builder.append(language);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((arch == null) ? 0 : arch.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((os == null) ? 0 : os.hashCode());
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
        if (!(obj instanceof Environments)) {
            return false;
        }
        Environments other = (Environments) obj;
        if (arch == null) {
            if (other.arch != null) {
                return false;
            }
        } else if (!arch.equals(other.arch)) {
            return false;
        }
        if (language == null) {
            if (other.language != null) {
                return false;
            }
        } else if (!language.equals(other.language)) {
            return false;
        }
        if (os == null) {
            if (other.os != null) {
                return false;
            }
        } else if (!os.equals(other.os)) {
            return false;
        }
        return true;
    }

}
