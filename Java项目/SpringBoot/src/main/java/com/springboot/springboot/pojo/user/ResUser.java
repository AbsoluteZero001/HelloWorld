package com.springboot.springboot.pojo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "用于返回前端作为登录验证的用户类")
public class ResUser {

    @Schema(description = "用户账号")
    private String account;

    @Schema(description = "用户 token")
    private String token;

    @Schema(description = "用户姓名")
    private String username;

    @Schema(description = "用户类型")
    private Short userType;

    public static ResUser fromUser(User user) {
        ResUser res = new ResUser();
        res.setAccount(user.getAccount());
        res.setUsername(user.getUsername());
        res.setUserType(user.getUserType() != null ? user.getUserType().shortValue() : null);
        // 生成随机 token
        res.setToken(UUID.randomUUID().toString());
        return res;
    }
}
