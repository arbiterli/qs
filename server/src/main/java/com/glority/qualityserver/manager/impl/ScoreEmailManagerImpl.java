/**
 * 
 */
package com.glority.qualityserver.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.dao.GenericDao;
import com.glority.qualityserver.dao.ScoreEmailDao;
import com.glority.qualityserver.manager.ScoreEmailManager;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.ScoreEmail;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.web.service.SystemUserService;

/**
 * the implement of ScoreOwnerEmailManager.
 * 
 * @author CLB
 * 
 */
@Service("scoreOwnerEmailManager")
public class ScoreEmailManagerImpl extends GenericManagerImpl<ScoreEmail, Long> implements ScoreEmailManager {
    @Autowired
    private ScoreEmailDao scoreEmailDao;

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private AccessControlService accessControlService;

    @Override
    public boolean save(long productId, String scoreName, String email) {
        return scoreEmailDao.save(productId, scoreName, email);
    }

    @Override
    public List<String> getScoreEmailBy(Product product, String scoreName) {
        List<String> emailList = new ArrayList<String>();
        ScoreEmail scoreEmail = scoreEmailDao.getScoreEmailBy(product.getId(), scoreName);
        if (null != scoreEmail) {
            String email = scoreEmail.getEmail();
            if (null != email) {
               emailList.add(email);
            }
            return emailList;
        }

        List<String> techManagerEmails = getProductTechiManagerEmails(product);
        return techManagerEmails;

    }

    @Override
    protected GenericDao<ScoreEmail, Long> getDao() {
        return this.scoreEmailDao;
    }

    @Override
    public boolean hasSetEmail(long productId, String scoreName) {
        return scoreEmailDao.hasSetEmail(productId, scoreName);
    }

    @Override
    public Object getEmail(long productId, String scoreName) {
        return scoreEmailDao.getEmail(productId, scoreName);
    }

    private List<String> getProductTechiManagerEmails(Product product) {
        List<String> emailList = new ArrayList<String>();
        List<User> users = systemUserService.getAllUser();
        for (User user : users) {
            List<Product> products = accessControlService.getAuthorizedProducts(user);
            if (products.contains(product)) {
                Set<Role> roles = accessControlService.getRoles(user, product);
                for (Role role : roles) {
                    if (role.getUserRole().equals(UserRole.ROLE_TECHNICALMANAGER)) {
                        String email = user.getEmail();
                        if (null != email) {
                            emailList.add(user.getEmail());
                        }
                    }
                }
            }
        }
        return emailList;
    }
}
