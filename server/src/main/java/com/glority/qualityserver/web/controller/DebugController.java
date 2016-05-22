package com.glority.qualityserver.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * quality system debug controller.
 * 
 * @author liheping
 * 
 */
@Controller
@RequestMapping("/qsdebug")
public class DebugController extends BasicController {

    @RequestMapping("/jobdebug")
    public String testServerCheckSamping(HttpServletRequest request, HttpServletResponse response) {
        return "jobdebug";
    }
}
