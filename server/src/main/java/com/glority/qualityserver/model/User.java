package com.glority.qualityserver.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;
import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * User model.
 * 
 * @author liheping
 * 
 */
@Entity
@Table(name = "users", catalog = "qualitysystem")
@XmlRootElement
@DataTransferObject
public class User extends BaseObject implements Serializable, UserDetails {

    private static final long serialVersionUID = -5410696399096566873L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @RemoteProperty
    private Long id;

    @Column(name = "name", length = 50)
    @RemoteProperty
    private String name;

    @Column(name = "email", length = 50)
    @RemoteProperty
    private String email;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "created_at", length = 19)
    private Timestamp createdAt;

    @Column(name = "login", length = 50)
    private String login;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Role> roles = new HashSet<Role>(0);

    @Transient
    private Collection<GrantedAuthority> authorities;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append("id", id).append("name", name)
                .append("email", email).append("password", password).append("createdAt", createdAt)
                .append("login", login).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User castOther = (User) other;
        return new EqualsBuilder().append(id, castOther.id).append(name, castOther.name).append(email, castOther.email)
                .append(password, castOther.password).append(createdAt, castOther.createdAt)
                .append(login, castOther.login).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(email).append(password).append(createdAt)
                .append(login).toHashCode();
    }

    public Collection<GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = new LinkedHashSet<GrantedAuthority>();
            authorities.addAll(roles);
        }
        return authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getUsername() {
        return this.login;
    }

    public boolean isAccountNonExpired() {
        // TODO: need get this implemented
        return true;
    }

    public boolean isAccountNonLocked() {
        // TODO: need get this implemented
        return true;
    }

    public boolean isCredentialsNonExpired() {
        // TODO: need get this implemented
        return true;
    }

    public boolean isEnabled() {
        // TODO: need get this implemented
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
