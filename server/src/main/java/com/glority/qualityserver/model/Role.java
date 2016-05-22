package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
import org.springframework.security.core.GrantedAuthority;

import com.glority.qualityserver.UserRole;

/**
 * Role model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "role", catalog = "qualitysystem",
          uniqueConstraints = @UniqueConstraint(columnNames = { "product_id", "user_id", "name" }))
@XmlRootElement
@DataTransferObject
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 6565759812709451865L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @RemoteProperty
    private Long id;

    @Column(name = "product_id")
    @RemoteProperty
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name")
    @RemoteProperty
    private String name;

    @Column(name = "scope")
    @RemoteProperty
    private String scope;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("productId", productId)
                .append("user", user).append("name", name).append("scope", scope).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Role)) {
            return false;
        }
        Role castOther = (Role) other;
        return new EqualsBuilder().append(id, castOther.id).append(productId, castOther.productId)
                .append(user, castOther.user).append(name, castOther.name).append(scope, castOther.scope).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(productId).append(user).append(name).append(scope).toHashCode();
    }

    public String getAuthority() {
        return this.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRole getUserRole() {
        return UserRole.getUserRole(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
