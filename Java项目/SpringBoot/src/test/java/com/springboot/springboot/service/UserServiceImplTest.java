package com.springboot.springboot.service;

import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.user.User;
import com.springboot.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void pageOfUserTest() {
        // 测试分页
        PageResult<User> result1 = userService.pageOfUser(1, 1, null, 1);
        System.out.println("分页查询结果（页1，1条）：" + result1);

        // 测试姓名模糊查询
        PageResult<User> result2 = userService.pageOfUser(1, 5, "四", 1);
        System.out.println("姓名模糊查询结果：" + result2);

        // 测试用户类型查询
        PageResult<User> result3 = userService.pageOfUser(1, 5, null, 2);
        System.out.println("用户类型查询结果：" + result3);

        // 测试身份证模糊查询
        PageResult<User> result4 = userService.pageOfUser(1, 5, "2", 1);
        System.out.println("身份证模糊查询结果：" + result4);
    }

    @Test
    public void searchByIdTest() {
        int userId = 1; // 测试用户ID
        User user = userService.searchById(userId);
        if (user != null) {
            System.out.println("查询用户ID " + userId + " 结果: " + user.getUsername() + ", " + user.getAccount());
        } else {
            System.out.println("未找到ID为 " + userId + " 的用户");
        }
    }
}
