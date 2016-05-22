/**
 * 
 */
package com.glority.qualityserver.web.service.auth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.glority.qualityserver.web.filter.GetProduct;
import com.glority.qualityserver.web.filter.GetProduct.ProductParamName;
import com.glority.qualityserver.web.service.ScoreEmailSettingService;

/**
 * ScoreOwnerEmailSettingService for dwr.
 * 
 * @author CLB
 * 
 */
@RemoteProxy(name = "scoreEmailSettingService")
public class ScoreOwnerEmailSettingService extends AbstractACLDwrService {
    @Autowired
    private ScoreEmailSettingService scoreEmailSettingService;

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Object setScoreEmail(long productId, String scoreName, String email) {
        if (productId < 0 || scoreName == null) {
            return "System error, please reload the page!";
        }
        Pattern p = Pattern.compile("^\\S+@\\S+.com$");
        Matcher m = p.matcher(email);
        if (!m.find()) {
            return "Email is not correct!";
        }
        return this.scoreEmailSettingService.setScoreEmail(productId, scoreName, email);
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Object hasSetEmail(long productId, String scoreName) {
        if (productId < 0 || scoreName == null) {
            return "System error, please reload the page!";
        }
        return this.scoreEmailSettingService.hasSetEmail(productId, scoreName);
    }

    @RemoteMethod
    @GetProduct(paramName = ProductParamName.PRODUCT_ID)
    public Object getEmail(long productId, String scoreName) {
        if (productId < 0 || scoreName == null) {
            return null;
        }
        return this.scoreEmailSettingService.getEmail(productId, scoreName);
    }

    @Override
    public String getFeatureName() {
        return "SCORE_EMAIL_SETTING";
    }
}
