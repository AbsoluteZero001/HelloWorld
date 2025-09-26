package com.springboot.springboot.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.Page;
import com.springboot.springboot.mapper.UserMapper;
import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.user.LoginUser;
import com.springboot.springboot.pojo.user.ResUser;
import com.springboot.springboot.pojo.user.User;
import com.springboot.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 注入 yml 配置的上传路径
    @Value("${avatar.upload-path}")
    private String uploadPath;

    @Override
    public ResUser login(LoginUser loginUser) {
        User conditionUser = User.toUser(loginUser);
        List<User> users = userMapper.queryOnCondition(conditionUser);
        return users.size() == 1 ? users.get(0).toResUser() : null;
    }

    @Override
    public PageResult<User> pageOfUser(Integer current, Integer size, String condition, Integer userType) {
        Page<User> page = PageHelper.startPage(current, size);
        List<User> users = userMapper.findUsersByType(condition, userType);
        return PageResult.restPage(page);
    }

    @Override
    public User searchById(int id) {
        return userMapper.selectById(id);
    }

    /**
     * 根据文件名更新用户头像路径
     * @param id 用户ID
     * @param fileName 文件名（Controller 已经保存到磁盘）
     * @return 数据库存储的相对路径
     */
    @Override
    public String updateAvatar(Integer id, String fileName) {
        if (fileName == null || fileName.isEmpty()) return null;

        // 构建数据库相对路径
        String avatarPath = "/img/" + fileName;

        // 确保上传目录存在（防止误删）
        File dir = new File(uploadPath);
        if (!dir.exists()) dir.mkdirs();

        // 更新数据库
        userMapper.updateAvatarById(avatarPath, id);

        return avatarPath;
    }
}
