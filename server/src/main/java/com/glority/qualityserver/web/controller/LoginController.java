package com.glority.qualityserver.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glority.quality.StringUtil;
import com.glority.qualityserver.Constants;
import com.glority.qualityserver.web.service.LoginService;

/**
 * LoginController holds all request about login.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BasicController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginaction")
    public String login(@RequestParam(value = ACCESS_DENIED, required = false) String denied,
            @RequestParam(value = LOGOUT, required = false) String logout, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        if (!StringUtil.isEmpty(denied)) {
            return "accessdenied";
        } else if (!StringUtil.isEmpty(logout)) {
            return "logout";
        } else {
            return "error";
        }
    }

    // FIXME since zhang.miao will remove this method, just keep it there to let
    // the server go.
    @RequestMapping("/outersystemlogin")
    @ResponseBody
    public String outerSystemLogin(@RequestParam(value = PRODUCT_ID, defaultValue = "-1") long productId,
            @RequestParam(value = Constants.USERNAME, required = false) String username, HttpServletRequest request,
            HttpServletResponse response) {

        if (productId < 0) {
            return Constants.FAIL;
        }

        if (this.loginService.canUserAccessProduct(username, productId)) {
            return Constants.SUCCESS;
        } else {
            return Constants.FAIL;
        }
    }
}
