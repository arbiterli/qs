package com.glority.qualityserver.web.service.noauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * There's no authentication for this service.
 * @author xxd
 *
 */
@Controller
@RequestMapping("/service/noauth/*")
public class DefaultNoAuthService {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
