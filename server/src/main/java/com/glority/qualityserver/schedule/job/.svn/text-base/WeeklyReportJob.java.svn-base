/**
 * 
 */
package com.glority.qualityserver.schedule.job;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.UserRole;
import com.glority.qualityserver.model.PhaseStatus;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.model.ProductStatus;
import com.glority.qualityserver.model.Role;
import com.glority.qualityserver.model.User;
import com.glority.qualityserver.schedule.QuartzJob;
import com.glority.qualityserver.service.AccessControlService;
import com.glority.qualityserver.service.MailService;
import com.glority.qualityserver.web.service.ProductService;
import com.glority.qualityserver.web.service.SystemUserService;

/**
 * the job to send weekly report to boss.
 * 
 * @author CLB
 * 
 */
@QuartzJob(name = "weeklyReportJob", cronExp = "0 0 8 ? * MON")
public class WeeklyReportJob extends BaseJobBean {

    private static final int MILLISECOND_PER_WEEK = 24 * 60 * 60 * 7 * 1000;
    private static final String SERVER_URL = "serverURL";
    private static final int SCORE_INVALID = 101;

    private String serverUrl;

    @Autowired
    protected MailService mailService;

    @Autowired
    protected ProductService productService;

    @Autowired
    protected AccessControlService accessControlService;

    @Autowired
    protected SystemUserService systemUserService;

    @PostConstruct
    public void init() {
        ServerSettings settings = ServerSettings.getInstance();
        serverUrl = settings.getSetting(SERVER_URL);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Timestamp now = super.getSampleTime();
        Timestamp aWeekAgo = new Timestamp(now.getTime() - MILLISECOND_PER_WEEK);
        List<User> users = systemUserService.getAllUser();
        for (User user : users) {
            List<Product> products = accessControlService.getAuthorizedProducts(user);
            if (!products.isEmpty()) {
                Map model = new HashMap();
                List list = new ArrayList();
                for (Product product : products) {
                    Set<Role> roles = accessControlService.getRoles(user, product);
                    if (isRoleValid(roles)) {
                        ProductDetail productDetailNow = getProductDetail(now, product.getId());
                        ProductDetail productDetailAWeekAgo = getProductDetail(aWeekAgo, product.getId());
                        if (productDetailNow != null) {
                            list.add(getProductDetail(productDetailNow, productDetailAWeekAgo));
                        }
                    }
                }
                if (!list.isEmpty()) {
                    model.put("products", list);
                }
                if (!model.isEmpty() && user.getEmail() != null && !user.getEmail().isEmpty()) {
                    model.put("passingScore", Constants.PASSING_SCORE);
                    model.put("excellentScore", Constants.EXCELLENT_SCORE);
                    model.put("scoreInvalid", SCORE_INVALID);
                    mailService.sendHTMLEmail(user.getEmail(), "Quality Portal Weekly Report", "weekly_report.vm",
                            model);
                }
            }
        }
    }

    private ProductDetail getProductDetail(ProductDetail now, ProductDetail aWeekAgo) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductname(now.getProductname());
        productDetail.setScores(now.getScores());
        for (int i = 0; i < productDetail.getScores().size(); i++) {
            if (productDetail.getScores().get(i) != null) {
                int scoreNow = productDetail.getScores().get(i).getScore();
                if (aWeekAgo != null) {
                    int scoreAWeekAgo = aWeekAgo.getScores().get(i).getScore();
                    productDetail.getScores().get(i).setVs(scoreNow - scoreAWeekAgo);
                } else {
                    productDetail.getScores().get(i).setVs(SCORE_INVALID);
                }
            }
        }
        return productDetail;
    }

    private ProductDetail getProductDetail(Timestamp date, long productId) {
        ProductStatus productStatus = productService.getProductStatus(productId, date);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductname(productStatus.getProduct().getDisplayName());
        productDetail.setScores(getScores(productStatus));
        return productDetail;
    }

    private List<Score> getScores(ProductStatus productStatus) {
        List<Score> scores = new ArrayList<Score>();
        PhaseStatus dev = productStatus.getDevStatus();
        PhaseStatus test = productStatus.getTestStatus();
        PhaseStatus stage = productStatus.getStageStatus();
        PhaseStatus prod = productStatus.getProdStatus();
        if (dev != null) {
            scores.add(getScore(dev));
        }
        if (test != null) {
            scores.add(getScore(test));
        }
        if (stage != null) {
            scores.add(getScore(stage));
        }
        if (prod != null) {
            scores.add(getScore(prod));
        }
        return scores;
    }

    private Score getScore(PhaseStatus phaseStatus) {
        if (phaseStatus != null) {
            Score score = new Score();
            score.setName(phaseStatus.getPhase().getType());
            score.setScore(phaseStatus.getScore());
            String phaseUrl = serverUrl + "/phase?stage=" + phaseStatus.getPhase().getType();
            phaseUrl += "&productId=" + phaseStatus.getActiveBuild().getProduct().getId();
            phaseUrl += "&buildId=" + phaseStatus.getActiveBuild().getId();
            score.setPhaseUrl(phaseUrl);
            return score;
        }
        return null;
    }

    private boolean isRoleValid(Set<Role> roles) {
        for (Role role : roles) {
            if (role.getUserRole().equals(UserRole.ROLE_BUSINESSOWNER)
             || role.getUserRole().equals(UserRole.ROLE_TECHNICALMANAGER)) {
                return true;
            }
        }
        return false;
    }

    /**
     * model score.
     * 
     * @author CLB;
     * 
     */
    public static class Score {
        private String name;
        private String phaseUrl;
        private int score;
        private int vs;

        public String getPhaseUrl() {
            return phaseUrl;
        }

        public void setPhaseUrl(String phaseUrl) {
            this.phaseUrl = phaseUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getVs() {
            return vs;
        }

        public void setVs(int vs) {
            this.vs = vs;
        }

        @Override
        public String toString() {
            return "Score [name=" + name + ", score=" + score + ", vs=" + vs + "]";
        }

    }

    /**
     * model product.
     * 
     * @author CLB
     * 
     */
    public static class ProductDetail {
        private String productname;
        private List<Score> scores;

        public String getProductname() {
            return productname;
        }

        public void setProductname(String productname) {
            this.productname = productname;
        }

        public List<Score> getScores() {
            return scores;
        }

        public void setScores(List<Score> scores) {
            this.scores = scores;
        }

        @Override
        public String toString() {
            return "ProductDetail [productname=" + productname + ", scores=" + scores + "]";
        }

    }
}
