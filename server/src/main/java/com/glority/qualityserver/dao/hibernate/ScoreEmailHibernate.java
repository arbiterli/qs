/**
 * 
 */
package com.glority.qualityserver.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.glority.qualityserver.dao.ScoreEmailDao;
import com.glority.qualityserver.model.ScoreEmail;

/**
 * .
 * 
 * @author CLB
 * 
 */
@Repository("scoreOwnerEmailDao")
public class ScoreEmailHibernate extends GenericDaoHibernate<ScoreEmail, Long> implements ScoreEmailDao {
    public ScoreEmailHibernate() {
        super(ScoreEmail.class);
    }

    @Override
    public boolean save(long productId, String scoreName, String email) {
        ScoreEmail scoreEmail = getScoreEmailBy(productId, scoreName);
        if (scoreEmail == null) {
            scoreEmail = new ScoreEmail();
            scoreEmail.setEmail(email);
            scoreEmail.setProductId(productId);
            scoreEmail.setScoreName(scoreName);
        } else {
            scoreEmail.setEmail(email);
        }
        return (super.save(scoreEmail) == null) ? false : true;
    }

    @Override
    public ScoreEmail getScoreEmailBy(long productId, String scoreName) {
        List<ScoreEmail> list = getScoreEmails(productId, scoreName);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean hasSetEmail(long productId, String scoreName) {
        List<ScoreEmail> list = getScoreEmails(productId, scoreName);
        if (list != null && !list.isEmpty()) {
            String email = list.get(0).getEmail();
            if (email == null || email.isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public Object getEmail(long productId, String scoreName) {
        List<ScoreEmail> list = getScoreEmails(productId, scoreName);
        if (list != null && !list.isEmpty()) {
            System.out.println(list.get(0).getEmail());
            return list.get(0).getEmail();
        }
        return null;
    }

    private List<ScoreEmail> getScoreEmails(long productId, String scoreName) {
        @SuppressWarnings("unchecked")
        List<ScoreEmail> list = super.getHibernateTemplate().find(
                "from ScoreEmail where product_id = ? and score_name = ?",
                new Object[] { Long.valueOf(productId), scoreName });
        return list;
    }
}
