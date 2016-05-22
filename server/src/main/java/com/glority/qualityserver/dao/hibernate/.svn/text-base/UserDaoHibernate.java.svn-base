package com.glority.qualityserver.dao.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.UserDao;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;

/**
 * Hibernate implement for user dao.
 */
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao, UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(UserDaoHibernate.class);
    private static final String EMAIL_SUFFIX = "@glority.com";

    /**
     * Default constructor.
     */
    public UserDaoHibernate() {
        super(User.class);
    }

    /**
     * Get user by username and password.
     * 
     * @param username
     *            the user's username
     * @param password
     *            the user's password
     * @return the specified user, if not exists, return null
     */
    @SuppressWarnings("unchecked")
    public User getUser(String username, String password) {
        List<User> userList = super.getHibernateTemplate().find("from User where login = ? and password = ?",
                new Object[] { username, password });

        if (userList == null || userList.isEmpty()) {
            return null;
        }

        return userList.get(0);
    }

    /**
     * get user by username.
     * 
     * @param username
     *            the user's username
     * @return the user, if not exists, return null.
     */
    @SuppressWarnings("unchecked")
    public User getUser(String username) {
        List<User> userList = super.getHibernateTemplate().find("from User where login = ? ", username);

        if (userList == null || userList.isEmpty()) {
            return null;
        }

        return userList.get(0);
    }

    /**
     * Gets users information based on login name.
     * 
     * @param userName
     *            the user's username
     * @return userDetails populated userDetails object
     */
    @SuppressWarnings("unchecked")
    public UserDetails loadUserByUsername(String userName) {
        List<User> users = getHibernateTemplate().find("from User where login=?", userName);
        if (users == null || users.isEmpty()) {
            LOGGER.debug("user '" + userName + "' not found...");
            // throw new UsernameNotFoundException("user '" + userName
            // + "' not found...");
            synchronized (this) {
                List<User> researchUsers = getHibernateTemplate().find("from User where login=?", userName);
                if (researchUsers == null || researchUsers.isEmpty()) {
                    User user = new User();

                    user.setLogin(userName);
                    // user.setPassword(userName);
                    user.setName(userName);
                    user.setEmail(userName + EMAIL_SUFFIX);
                    user.setCreatedAt(new Timestamp(new Date().getTime()));

                    return super.save(user);
                } else {
                    return this.assembleAuth(researchUsers.get(0));
                }
            }
        } else {
            return this.assembleAuth(users.get(0));
        }
    }

    private UserDetails assembleAuth(User user) {
        if (user == null) {
            return null;
        }

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            authorities.add(new GrantedAuthorityImpl(role.getUserRole().toString()));
        }

        user.setAuthorities(authorities);

        return user;
    }
}
