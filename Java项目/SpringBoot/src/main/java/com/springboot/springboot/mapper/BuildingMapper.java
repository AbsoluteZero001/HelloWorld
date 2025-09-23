package com.springboot.springboot.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.springboot.springboot.pojo.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuildingMapper {

    /**
     * 按条件查询建筑信息（分页交给 PageHelper 控制）
     * @param number 楼栋编号（可模糊查询）
     */
    Page<Building> findAllBuilding(@Param("number") String number);

    /**
     * 根据ID查询整个楼栋信息
     * @param id 楼栋ID
     */
    Building queryById(@Param("id") Integer id);

    /**
     * 根据ID查询楼栋名称（如果只想要名字，可以用这个）
     * @param id 楼栋ID
     */
    String queryNameById(@Param("id") Integer id);
}
