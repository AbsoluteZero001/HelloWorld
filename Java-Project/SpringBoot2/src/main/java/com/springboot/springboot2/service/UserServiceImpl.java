package com.springboot.springboot2.service;

import com.springboot.springboot2.mapper.UserMapper;
import com.springboot.springboot2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) throws Exception {
        // 默认密码
        user.setPassword("123456");

        // 设置用户类型和状态
        user.setUserType((short) 3);   // 业主类型
        user.setUserStatus((short) 3); // 未激活状态

        // 生成唯一账号
        String account = generateUniqueAccount(user.getUsername());
        user.setAccount(account);

        // 插入数据库，并捕获唯一索引异常
        try {
            return insertUserWithExceptionHandling(user);
        } catch (DuplicateKeyException e) {
            System.out.println("账号已存在，可能触发唯一索引: " + user.getAccount());
            throw e; // 上层可根据需要处理
        }
    }

    /**
     * 封装数据库插入方法，可捕获 DuplicateKeyException
     */
    private int insertUserWithExceptionHandling(User user) throws DuplicateKeyException {
        int result = -1;
        result = userMapper.insertUser(user);
        return result;
    }

    /**
     * 生成唯一 account（MD5 + 时间戳 + 随机数）
     * 避免唯一索引冲突
     */
    private String generateUniqueAccount(String username) throws Exception {
        String account;
        int maxRetry = 5; // 最多尝试 5 次
        int attempt = 0;

        do {
            String base = DigestUtils.md5DigestAsHex(username.getBytes(StandardCharsets.UTF_8))
                    .substring(13, 20);
            account = base + (System.currentTimeMillis() % 10000);

            try {
                // 检查账号是否已存在
                if (userMapper.countByAccount(account) == 0) {
                    return account; // 唯一，返回
                }
            } catch (Exception e) {
                throw new Exception("检查账号唯一性失败", e);
            }

            attempt++;
        } while (attempt < maxRetry);

        throw new Exception("生成唯一账号失败，请稍后重试");
    }
}
