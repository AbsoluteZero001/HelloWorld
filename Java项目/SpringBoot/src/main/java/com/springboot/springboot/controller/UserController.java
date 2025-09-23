package com.springboot.springboot.controller;

import com.springboot.springboot.pojo.user.LoginUser;
import com.springboot.springboot.pojo.user.ResUser;
import com.springboot.springboot.pojo.user.User;
import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.ResponsePojo;
import com.springboot.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@Tag(name = "用户管理", description = "用户登录与管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    // 注入 yml 配置的上传路径
    @Value("${avatar.upload-path}")
    private String uploadPath;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "根据账号和密码进行登录操作", description = "<span style='color:red'>模拟操作，密码为明文密码</span>")
    public ResponsePojo<ResUser> login(
            @Parameter(description = "用户账号", required = true) @RequestParam String account,
            @Parameter(description = "用户密码", required = true) @RequestParam String password
    ) {
        LoginUser user = new LoginUser();
        user.setAccount(account);
        user.setPassword(password);
        user.setUserType((short) 1);

        ResUser result = userService.login(user);
        return Optional.ofNullable(result)
                .map(ResponsePojo::success)
                .orElse(ResponsePojo.fail(null, "验证失败"));
    }

    @GetMapping(value = "/page/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "返回用户分页数据", description = "支持根据姓名或身份证进行模糊查询，并按用户类型筛选")
    public ResponsePojo<PageResult<User>> getPage(
            @Parameter(description = "当前页码", example = "1") @RequestParam(defaultValue = "1") Integer current,
            @Parameter(description = "每页行数", example = "10") @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "姓名或身份证查询关键字", required = false) @RequestParam(required = false) String condition,
            @Parameter(description = "用户类型(1=管理员,2=物业,3=业主)", required = true, example = "1") @RequestParam(name = "user_type") Integer userType
    ) {
        PageResult<User> users = userService.pageOfUser(current, size, condition, userType);
        return ResponsePojo.success(users);
    }

    @GetMapping(value = "/byid", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "根据 id 查找单个用户", description = "<span style='color:red'>根据用户 id 查询用户信息</span>")
    public ResponsePojo<User> queryById(
            @Parameter(description = "用户 id", required = true, example = "1001") @RequestParam Integer id
    ) {
        User u = userService.searchById(id);
        return ResponsePojo.success(u);
    }

    @PostMapping(value = "/updateAvatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "上传用户头像", description = "上传头像文件并更新用户信息")
    public ResponsePojo<Map<String, String>> updateAvatar(
            @Parameter(description = "上传的文件", required = true) @RequestParam("multipartFile") MultipartFile multipartFile,
            @Parameter(description = "用户 ID", required = true) @RequestParam("id") Integer id
    ) {
        Map<String, String> map = new HashMap<>();

        if (multipartFile.isEmpty()) {
            return ResponsePojo.fail(map, "文件为空");
        }

        String originalFileName = multipartFile.getOriginalFilename();
        if (originalFileName == null) {
            return ResponsePojo.fail(map, "无法获取文件名");
        }

        // 获取后缀名并校验
        String sufName = originalFileName.substring(originalFileName.lastIndexOf('.') + 1).toLowerCase();
        if (!List.of("png", "jpg", "jpeg", "gif", "svg").contains(sufName)) {
            return ResponsePojo.fail(map, "后缀名不是常见图片格式");
        }

        // 文件大小限制 500KB
        if (multipartFile.getSize() > 500 * 1024) {
            return ResponsePojo.fail(map, "文件超过500KB");
        }

        // 生成唯一文件名
        String fileName = (originalFileName.length() > 3 ? originalFileName.substring(0, 3) : originalFileName)
                + System.currentTimeMillis() + (int) (Math.random() * 1000) + "." + sufName;

        // 保存文件到磁盘
        File dir = new File(uploadPath);
        if (!dir.exists()) dir.mkdirs();

        File dest = new File(dir, fileName);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponsePojo.fail(map, "文件保存失败：" + e.getMessage());
        }

        // 调用 Service 更新数据库，只传文件名或路径
        String avatarPath = userService.updateAvatar(id, fileName);

        map.put("avatarPath", avatarPath);
        map.put("message", "保存成功");
        return ResponsePojo.success(map);
    }
}
