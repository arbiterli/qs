package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;

/**
 * ScoreOwnerMapping Model.
 * 
 * @author cz
 * 
 */
@Entity
@Table(name = "score_owner_mapping", catalog = "qualitysystem",
    uniqueConstraints = @UniqueConstraint(columnNames = { "product_id", "score_name" }))
@XmlRootElement
public class ScoreOwnerMapping extends BaseObject implements Serializable {

    private static final long serialVersionUID = 7933459487962618247L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "score_name", nullable = false)
    private String scoreName;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        if (!(obj instanceof ScoreOwnerMapping)) {
            return false;
        }
        ScoreOwnerMapping other = (ScoreOwnerMapping) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (product == null) {
            if (other.product != null) {
                return false;
            }
        } else if (!product.equals(other.product)) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
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
        StringBuilder builder = new StringBuilder();
        builder.append("ScoreRole [id=");
        builder.append(id);
        if (product != null) {
            builder.append(", product=");
            builder.append(product);
        }
        if (user != null) {
            builder.append(", user=");
            builder.append(user);
        }
        builder.append(", scoreName=");
        builder.append(scoreName);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Getter method for product.
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for id.
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for product.
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter method for product.
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Getter method for user.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter method for score name.
     * @return the scoreName
     */
    public String getScoreName() {
        return scoreName;
    }

    /**
     * Setter method for score name.
     * @param scoreName the scoreName to set
     */
    public void setScoreName(String scoreName) {
        this.scoreName = scoreName;
    }
}
