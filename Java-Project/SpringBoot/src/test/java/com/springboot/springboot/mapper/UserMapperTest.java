package com.springboot.springboot.mapper;

import com.github.pagehelper.PageHelper;
import com.springboot.springboot.mapper.UserMapper;
import com.springboot.springboot.pojo.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试插入用户
     */
    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("123456");
        user.setAccount("testaccount");
        user.setIdcard("123456789012345678");
        user.setGender(1); // 1=男, 2=女
        user.setUserType(1); // 假设用户类型
        user.setUserStatus(1); // 假设用户状态
        user.setUserRoomid(101); // 假设房间号

        int result = userMapper.insertUser(user);

        System.out.println("影响行数: " + result);
        System.out.println("插入ID: " + user.getId());
        System.out.println("完整对象: " + user);
    }

    /**
     * 测试根据条件查询用户（登录验证）
     */
    @Test
    public void queryOnConditionTest() {
        User user = new User();
        user.setAccount("admin");
        user.setPassword("e10adc3949ba59abbe56e057f20f883e"); // MD5 密码

        List<User> result = userMapper.queryOnCondition(user);

        System.out.println("查询条件: " + user);
        System.out.println("查询结果: " + result);
    }

    /**
     * 测试分页查询用户
     */
    @Test
    public void findByTypeTest() {
        // 开启分页，第1页，每页5条
        int pageNum = 1;
        int pageSize = 5;
        PageHelper.startPage(pageNum, pageSize);

        // 调用 Mapper 方法（返回 List<User>）
        List<User> list = userMapper.findUsersByType("三", 1);

        // 使用 PageInfo 包装分页信息，而不是强制转换
        com.github.pagehelper.PageInfo<User> pageInfo = new com.github.pagehelper.PageInfo<>(list);

        System.out.println("总记录数: " + pageInfo.getTotal());
        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("当前页: " + pageInfo.getPageNum());
        System.out.println("每页条数: " + pageInfo.getPageSize());

        for (User user : pageInfo.getList()) {
            System.out.println(user);
        }
    }

    /**
     * 测试更新用户头像
     */

    @Test
    public void updateAvatarTest() {
        User user = new User();
        user.setId(1);  // ⚠️ 对应 User 实体里的 id 字段（映射数据库 userid）

        user.setUserAvatar("img/123.jpg"); // ⚠️ 实体类属性应该是 userAvatar，而不是 user avatar

        int rows = userMapper.updateAvatar(user);
        System.out.println("更新影响行数 = " + rows);
    }

}
