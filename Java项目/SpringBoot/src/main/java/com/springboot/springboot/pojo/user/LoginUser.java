package com.springboot.springboot.pojo.user;

import lombok.Data;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Data
public class LoginUser {

    private String account;
    private String password;
    private String username;
    private Short userType;

    /**
     * 设置密码，自动进行 MD5 加密（如果不是 32 位 MD5）
     */
    public void setPassword(String password) {
        if (password != null && password.length() != 32) {
            // MD5 加密密码
            this.password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        } else {
            this.password = password;
        }
    }
}
