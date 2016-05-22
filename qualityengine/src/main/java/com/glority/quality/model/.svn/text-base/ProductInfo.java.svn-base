package com.glority.quality.model;
/**
 * Product info.
 * @author liheping
 *
 */
public class ProductInfo {
    private String businessUnit;
    private String productName;
    private String productVersion;
    private String svnUrl;
    private String svnRevision;
    private String productVersionId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getSvnUrl() {
        return svnUrl;
    }

    public void setSvnUrl(String svnUrl) {
        this.svnUrl = svnUrl;
    }

    public String getSvnRevision() {
        return svnRevision;
    }

    public void setSvnRevision(String svnRevision) {
        this.svnRevision = svnRevision;
    }

    public String getProductVersionId() {
        return productVersionId;
    }

    public void setProductVersionId(String productVersionId) {
        this.productVersionId = productVersionId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProductInfo [businessUnit=");
        builder.append(businessUnit);
        builder.append(", productName=");
        builder.append(productName);
        builder.append(", productVersion=");
        builder.append(productVersion);
        builder.append(", svnUrl=");
        builder.append(svnUrl);
        builder.append(", svnRevision=");
        builder.append(svnRevision);
        builder.append(", productVersionId=");
        builder.append(productVersionId);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((businessUnit == null) ? 0 : businessUnit.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productVersion == null) ? 0 : productVersion.hashCode());
        result = prime * result + ((productVersionId == null) ? 0 : productVersionId.hashCode());
        result = prime * result + ((svnRevision == null) ? 0 : svnRevision.hashCode());
        result = prime * result + ((svnUrl == null) ? 0 : svnUrl.hashCode());
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
        if (!(obj instanceof ProductInfo)) {
            return false;
        }
        ProductInfo other = (ProductInfo) obj;
        if (businessUnit == null) {
            if (other.businessUnit != null) {
                return false;
            }
        } else if (!businessUnit.equals(other.businessUnit)) {
            return false;
        }
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        if (productVersion == null) {
            if (other.productVersion != null) {
                return false;
            }
        } else if (!productVersion.equals(other.productVersion)) {
            return false;
        }
        if (productVersionId == null) {
            if (other.productVersionId != null) {
                return false;
            }
        } else if (!productVersionId.equals(other.productVersionId)) {
            return false;
        }
        if (svnRevision == null) {
            if (other.svnRevision != null) {
                return false;
            }
        } else if (!svnRevision.equals(other.svnRevision)) {
            return false;
        }
        if (svnUrl == null) {
            if (other.svnUrl != null) {
                return false;
            }
        } else if (!svnUrl.equals(other.svnUrl)) {
            return false;
        }
        return true;
    }

}
