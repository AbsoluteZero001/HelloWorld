package com.springboot.springboot.mapper;

import com.github.pagehelper.Page;
import com.springboot.springboot.entity.User;
import com.springboot.springboot.pojo.Building;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username, password, account, idcard, gender) " +
            "VALUES(#{username}, #{password}, #{account}, #{idcard}, #{gender})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    // 分页查询楼栋，带条件
    Page<Building> findAllBuilding(@Param("number") String number);
}
