package com.springboot.springboot.mapper;

import com.springboot.springboot.pojo.Floor;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FloorMapper {
    /**
     * 查询楼层
     * @param number 楼层号，可模糊查询，传 null 或 "" 查询所有
     * @return 楼层列表
     */
    List<Floor> findAllFloor(String number);
}
