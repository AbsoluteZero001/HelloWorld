package com.springboot.springboot.mapper;

import com.github.pagehelper.Page;
import com.springboot.springboot.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomMapper {

    /**
     * 分页查询房屋信息，可根据房号模糊查询
     *
     * @param number 房号（可为空，支持模糊匹配）
     * @return 分页房屋列表
     */
    Page<Room> findAllRoom(@Param("number") String number);
}
