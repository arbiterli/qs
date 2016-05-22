package com.glority.qualityserver.encoder;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * MD5 encoder, implementation for PasswordEncoder.
 * 
 * @author liheping
 * 
 */
@Component("md5Encoder")
public class MD5Encoder implements PasswordEncoder {

    public String encodePassword(String origPwd, Object salt) {
        return MD5.getMD5ofStr(origPwd);
    }

    public boolean isPasswordValid(String encPwd, String origPwd, Object salt) {
        return encPwd.equals(encodePassword(origPwd, salt));
    }

}
