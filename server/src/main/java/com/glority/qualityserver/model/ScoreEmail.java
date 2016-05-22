/**
 * 
 */
package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * the model for table score_owner_email
 * 
 * @author CLB
 * 
 */
@Entity
@Table(name = "score_email", catalog = "qualitysystem")
@XmlRootElement
public class ScoreEmail {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "score_name")
    private String scoreName;

    @Column(name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getScoreName() {
        return scoreName;
    }

    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((scoreName == null) ? 0 : scoreName.hashCode());
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        ScoreEmail other = (ScoreEmail) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        if (scoreName == null) {
            if (other.scoreName != null) {
                return false;
            }
        } else if (!scoreName.equals(other.scoreName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ScoreEmail [id=" + id + ", productId=" + productId + ", scoreName="
                + scoreName + ", email=" + email + "]";
    }
}
