package com.springboot.springboot.mapper;

import com.springboot.springboot.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(User user);

    List<User> queryOnCondition(User user);

    List<User> findUsersByType(@Param("condition") String condition,
                               @Param("userType") Integer userType);

    User selectById(@Param("id") int id);

    // 原来的方法
    @Update("UPDATE user SET user_avatar = #{userAvatar} WHERE userid = #{id}")
    Integer updateAvatar(User user);

    // 新增方法，直接传 avatar 路径和 id
    @Update("UPDATE user SET user_avatar = #{avatar} WHERE userid = #{id}")
    Integer updateAvatarById(@Param("avatar") String avatar, @Param("id") Integer id);
}

