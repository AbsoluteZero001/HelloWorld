package com.springboot.springboot.controller;

import com.springboot.springboot.config.WeChat;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // 添加一个基础路径
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private WeChat weChat;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello Spring Boot!");
    }

    @GetMapping("/getWeChat")
    public ResponseEntity<?> getWeChat() {
        try {
            if (weChat == null) {
                throw new IllegalStateException("WeChat service is not initialized.");
            }
            return ResponseEntity.ok(weChat);
        } catch (Exception e) {
            logger.error("Error occurred while processing /getWeChat request: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().body("Failed to load WeChat config.");
        }
    }
}
