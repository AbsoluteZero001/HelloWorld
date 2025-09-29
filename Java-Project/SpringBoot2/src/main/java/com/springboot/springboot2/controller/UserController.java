package com.springboot.springboot2.controller;

import com.springboot.springboot2.pojo.ResponsePojo;
import com.springboot.springboot2.pojo.User;
import com.springboot.springboot2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Schema(name = "UserController", description = "业主相关 API")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "新增业主信息，默认为未激活状态，采用默认密码，生成随机账号")
    public ResponsePojo<Integer> insertUser(
            @Parameter(description = "身份证号", required = true) @RequestParam String idcard,
            @Parameter(description = "年龄", required = true) @RequestParam Integer age,
            @Parameter(description = "用户名", required = true) @RequestParam String username,
            @Parameter(description = "性别") @RequestParam(required = false) Integer gender,
            @Parameter(description = "房间ID", required = true) @RequestParam Integer userRoomId
    ) {
        User user = new User();
        user.setIdcard(idcard);
        user.setUsername(username);

        // 将 Integer 转 Short
        user.setAge(age != null ? age.shortValue() : null);
        user.setGender(gender != null ? gender.shortValue() : 0); // 默认 0-未知
        user.setUserRoomId(userRoomId != null ? userRoomId.shortValue() : null);

        Integer result = null;
        try {
            result = userService.insertUser(user);
            return ResponsePojo.success(result);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return ResponsePojo.fail(result, "用户名重复");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponsePojo.fail(result, "未知异常，请联系管理员");
        }
    }

}

