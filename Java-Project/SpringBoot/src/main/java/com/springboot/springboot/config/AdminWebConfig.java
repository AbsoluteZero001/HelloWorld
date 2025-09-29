package com.springboot.springboot.config;

import com.springboot.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局拦截器配置
 * - 拦截所有请求
 * - 放行登录、Swagger 相关接口、错误页面等
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns( //不需要拦截的接口
                        "/",                // 首页
                        "/admin/login",     // 登录接口
                        "/doc.html",        // Swagger UI
                        "/error",           // 错误页面
                        "/swagger**/**",   // 新版 Swagger3 UI
                        "/webjars/**",
                        "/v3/**"            // OpenAPI v3
                );
    }
}
