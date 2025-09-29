package com.springboot.springboot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("物业管理项目管理员系统")   // 标题
                        .description("进行基础资料的管理") // 描述
                        .version("1.0")                  // 版本
                        .contact(new Contact()
                                .name("成都工业职业技术学院唐进杰")
                                .url("http://localhost:8080/")
                                .email("TANGJINJIE2006@outlook.com")));
    }
}
