package com.springboot.springboot2.mapper;

import com.springboot.springboot2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 插入用户，自动生成 id
     */
    int insertUser(User user);

    /**
     * 检查账号是否存在
     */
    int countByAccount(@Param("account") String account);

    /**
     * 查询所有用户
     */
    List<User> selectAllUsers();

    /**
     * 根据 account 查询用户
     */
    User selectUserByAccount(@Param("account") String account);

    /**
     * 根据 id 删除用户
     */
    int deleteUserById(@Param("id") Integer id);

    /**
     * 更新用户信息
     */
    int updateUser(User user);
}
