package com.springboot.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * WeChat配置类，绑定 application.yml 或 application.properties 中的 wechat.* 属性。
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChat {

    /**
     * 微信公众号的 appId
     */
    private String appId;

    /**
     * 微信公众号的 token
     */
    private String token;

    /**
     * 微信公众号的 appSecret
     */
    private String appSecret;

    // Getter & Setter
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public String toString() {
        return "WeChat{" +
                "appId='" + appId + '\'' +
                ", token='" + token + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }
}
