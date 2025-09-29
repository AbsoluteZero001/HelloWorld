package com.springboot.springboot.mapper;

import com.github.pagehelper.Page;
import com.springboot.springboot.pojo.Floor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FloorMapper {
    /**
     * 查询楼层
     * @param number 楼层号，可模糊查询，传 null 或 "" 查询所有
     * @return 楼层列表
     */
    Page<Floor> findAllFloor(String number);
    //补充queryByBuildingId方法
@Select("select floor_id, belong_building, floor_number from floor where floor_id = #{id}")
Floor queryById(Integer floorid);
}
