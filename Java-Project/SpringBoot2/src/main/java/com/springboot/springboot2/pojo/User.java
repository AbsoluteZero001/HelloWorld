package com.springboot.springboot2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Data
@Schema(description = "用户信息，包含管理员、物业人员和住户")
public class User {

    @Schema(description = "用户账号")
    private String account;

    @Schema(description = "用户姓名")
    private String username;

    @Schema(description = "用户密码")
    private String password;

    @Schema(description = "用户类型：1-管理员，2-物业，3-业主等")
    private Short userType;

    @Schema(description = "用户ID（主键）")
    private Integer userId;  // 对应数据库自增主键

    @Schema(description = "用户性别，0-未知，1-男，2-女")
    private Short gender;

    @Schema(description = "用户年龄")
    private Short age;

    @Schema(description = "用户状态：1-正常，2-禁用，3-未激活")
    private Short userStatus;

    @Schema(description = "用户所属房屋ID")
    private Short userRoomId;

    @Schema(description = "身份证号")
    private String idcard;

    @Schema(description = "用户房间信息, 可能一个人有多套房")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Room> rooms;

    // ===== 自定义 setPassword（MD5加密）=====
    public void setPassword(String password) {
        if (password != null && password.length() != 32) {
            this.password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        } else {
            this.password = password;
        }
    }

    // ===== 重写 toString =====
    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", userId=" + userId +
                ", gender=" + gender +
                ", age=" + age +
                ", userStatus=" + userStatus +
                ", userRoomId=" + userRoomId +
                ", idcard='" + idcard + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
