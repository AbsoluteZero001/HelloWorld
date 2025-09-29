package com.springboot.springboot.service;

import com.springboot.springboot.pojo.user.LoginUser;
import com.springboot.springboot.pojo.user.ResUser;
import com.springboot.springboot.pojo.user.User;
import com.springboot.springboot.pojo.PageResult;

public interface UserService {

    /**
     * 用户登录
     */
    ResUser login(LoginUser loginUser);

    /**
     * 分页查询用户
     *
     * @param current   当前页
     * @param size      每页条数
     * @param condition 查询条件（用户名/身份证/账号等）
     * @param userType  用户类型
     * @return PageResult<User> 分页结果
     */
    PageResult<User> pageOfUser(Integer current, Integer size, String condition, Integer userType);

    /**
     * 根据用户ID查询用户
     */
    User searchById(int id);

    /**
     * 更新用户头像
     * @param id 用户ID
     * @param fileName 保存到磁盘的文件名
     * @return 返回头像存储路径（通常是相对路径）
     */
    String updateAvatar(Integer id, String fileName);
}
