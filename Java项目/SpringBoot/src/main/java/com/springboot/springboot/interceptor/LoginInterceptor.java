package com.springboot.springboot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器：拦截所有需要鉴权的请求，检查是否携带 Authorization 头部。
 * 适配 Spring Boot 3.x，替代废弃的 HandlerInterceptorAdapter。
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 从请求头获取 token
        String token = request.getHeader("Authorization");

        // 简单校验是否存在
        if (token != null && !token.isBlank()) {
            // 这里你可以加入 JWT 或数据库验证逻辑
            return true; // 放行
        } else {
            // 未登录或未携带 token
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Authorization 无信息，未登录");
            return false;
        }
    }
}
