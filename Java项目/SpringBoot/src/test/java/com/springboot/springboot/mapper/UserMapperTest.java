package com.springboot.springboot.mapper;

import com.springboot.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("123456");
        user.setAccount("testaccount");
        user.setIdcard("123456789012345678");
        user.setGender(1); // 1=男, 2=女

        int result = userMapper.insertUser(user);

        System.out.println("影响行数: " + result);
        System.out.println("插入ID: " + user.getId());
        System.out.println("完整对象: " + user);
    }
}
