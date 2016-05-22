package com.glority.qualityserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glority.qualityserver.Constants;
import com.glority.qualityserver.ProductStage;
import com.glority.qualityserver.ServerSettings;
import com.glority.qualityserver.manager.BuildManager;
import com.glority.qualityserver.manager.ScoreEmailManager;
import com.glority.qualityserver.model.Build;
import com.glority.qualityserver.model.Product;
import com.glority.qualityserver.schedule.job.ScoreCheckJob;
import com.glority.qualityserver.service.MailService;
import com.glority.qualityserver.service.ScoreCheckService;
import com.glority.qualityserver.web.service.PhaseService;
import com.glority.qualityserver.web.service.ProductService;

/**
 * ScoreCheckServiceImpl.
 * 
 * @author moved by li.heping
 * 
 */
@Service
public class ScoreCheckServiceImpl implements ScoreCheckService {
    private static final Logger LOGGER = Logger.getLogger(ScoreCheckJob.class);

    @Autowired
    protected BuildManager buildManager;

    @Autowired
    protected PhaseService phaseService;

    @Autowired
    protected ScoreEmailManager scoreMailManager;

    @Autowired
    protected MailService mailService;

    @Autowired
    protected ProductService productService;

    private static final String SERVER_URL = "serverUrl";

    private static final String MAIL_SUBJECT = "Quality portal score alert daily report";

    private static final String MAIL_TEMPLATE = "score_fail_report.vm";

    protected String serverUrl;

    @PostConstruct
    public void init() {
        ServerSettings settings = ServerSettings.getInstance();
        serverUrl = settings.getSetting(SERVER_URL);
    }

    @Override
    public void checkScore() {
        LOGGER.info("start scoreCheckJob ..");
        List<Product> products = productService.getAllProducts();
        List<ScoreEmail> emails = new ArrayList<ScoreEmail>();
        for (Product product : products) {
            List<ScoreEmail> emailList = new ArrayList<ScoreEmail>();
            checkScoreForProduct(product, emailList);
            emails.addAll(emailList);
        }
        sendEmail(emails);
        LOGGER.info("end scoreCheckJob ..");
    }

    private void checkScoreForProduct(Product product, List<ScoreEmail> emailList) {
        Long productId = product.getId();
        ProductStage[] stages = ProductStage.values();
        for (ProductStage stage : stages) {
            Build latestBuild = buildManager.getProductLatestBuild(productId, stage);
            if (null == latestBuild) {
                continue;
            }
            Map<String, Object> scoreMap = phaseService.getMetricNameScorePairs(latestBuild.getId(), stage);
            checkScoreAndSendEmail(scoreMap, product, stage, latestBuild.getId(), emailList);
        }
    }

    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    private void checkScoreAndSendEmail(Map<String, Object> scoreMap, Product product, ProductStage stage,
            Long buildId, List<ScoreEmail> emailList) {
        Iterator iter = scoreMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> score = (Map.Entry<String, Object>) iter.next();
            String metricName = score.getKey().toString();
            float scoreValue = Float.parseFloat(score.getValue().toString());
            if (scoreValue < Constants.PASSING_SCORE) {
                markScoreOwnerEmail(product, metricName,
                        createScoreRecord(metricName, scoreValue, stage, product, emailList), emailList);
            }
        }
    }

    private void markScoreOwnerEmail(Product product, String scoreName,
            ScoreRecord record, List<ScoreEmail> emailList) {
        List<String> emailAddressList = scoreMailManager.getScoreEmailBy(product, scoreName);
        for (String address : emailAddressList) {
            ScoreEmail scoreEmail = null;
            for (ScoreEmail email : emailList) {
                if (address.equals(email.getAddress())) {
                    scoreEmail = email;
                    break;
                }
            }
            if (null == scoreEmail) {
                scoreEmail = createNewScoreEmail(address, product);
                scoreEmail.addRecord(record);
                emailList.add(scoreEmail);
                continue;
            }
            scoreEmail.addRecord(record);
        }
    }

    private String getDetailUrl(ProductStage stage, Long productId) {
        Build latestBuild = buildManager.getProductLatestBuild(productId, stage);
        return this.serverUrl + "/phase?stage=" + stage.toString() + "&buildId=" + latestBuild.getId() + "&productId="
                + productId;
    }

    private ScoreEmail createNewScoreEmail(String address, Product product) {
        ScoreEmail scoreEmail = new ScoreEmail();
        scoreEmail.setAddress(address);
        scoreEmail.setProduct(product);
        return scoreEmail;
    }

    private ScoreRecord createScoreRecord(String metricName, float score, ProductStage stage, Product product,
            List<ScoreEmail> emailList) {
        ScoreRecord record = new ScoreRecord();
        record.setExpected(Constants.PASSING_SCORE);
        record.setMetricName(metricName);
        record.setScore(score);
        record.setStage(stage);
        record.setUrl(getDetailUrl(stage, product.getId()));
        return record;
    }

    @SuppressWarnings(value = { "unchecked", "rawtypes" })
    private void sendEmail(List<ScoreEmail> emailList) {
        Map<String, List<ScoreEmail>> emails = mergeProductsWithSameEmailAddr(emailList);
        for (String emailAddr : emails.keySet()) {
            Map model = new HashMap();
            model.put("contents", emails.get(emailAddr));
            model.put("serverUrl", serverUrl);
            mailService.sendHTMLEmail(emailAddr, MAIL_SUBJECT, MAIL_TEMPLATE, model);
        }
    }

    private Map<String, List<ScoreEmail>> mergeProductsWithSameEmailAddr(List<ScoreEmail> emailList) {
        Map<String, List<ScoreEmail>> emails = new HashMap<String, List<ScoreEmail>>();
        for (ScoreEmail scoreEmail : emailList) {
            String emailAddr = scoreEmail.getAddress().trim();
            if (emails.containsKey(emailAddr)) {
                emails.get(emailAddr).add(scoreEmail);
            } else {
                List<ScoreEmail> scoreEmails = new ArrayList<ScoreEmail>();
                scoreEmails.add(scoreEmail);
                emails.put(emailAddr, scoreEmails);
            }
        }
        return emails;
    }

    /**
     * to hold score email info.
     * 
     * @author zm.
     * 
     */
    public class ScoreEmail {
        private String address;

        private Product product;

        private List<ScoreRecord> records;

        public ScoreEmail() {
            records = new ArrayList<ScoreRecord>();
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public List<ScoreRecord> getRecords() {
            return records;
        }

        public void addRecord(ScoreRecord record) {
            this.records.add(record);
        }

        public Map<ProductStage, List<ScoreRecord>> parseRecords() {
            HashMap<ProductStage, List<ScoreRecord>> recordsMap = new HashMap<ProductStage, List<ScoreRecord>>();
            for (ScoreRecord record : records) {
                if (recordsMap.containsKey(record.getStage())) {
                    recordsMap.get(record.getStage()).add(record);
                } else {
                    List<ScoreRecord> list = new ArrayList<ScoreRecord>();
                    list.add(record);
                    recordsMap.put(record.getStage(), list);
                }
            }
            return recordsMap;
        }

        public String getProductUrl() {
            return serverUrl + "/product?productId=" + product.getId();
        }
    }

    /**
     * to hold score record info.
     * 
     * @author zm.
     * 
     */
    public class ScoreRecord {
        private ProductStage stage;

        private String metricName;

        private float score;

        private int expected = Constants.PASSING_SCORE;

        private String url;

        public ProductStage getStage() {
            return stage;
        }

        public void setStage(ProductStage stage) {
            this.stage = stage;
        }

        public String getMetricName() {
            return metricName;
        }

        public void setMetricName(String metricName) {
            this.metricName = metricName;
        }

        public float getScore() {
            return score;
        }

        public void setScore(float score) {
            this.score = score;
        }

        public int getExpected() {
            return expected;
        }

        public void setExpected(int expected) {
            this.expected = expected;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
