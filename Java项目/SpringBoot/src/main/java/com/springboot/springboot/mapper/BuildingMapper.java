package com.springboot.springboot.mapper;

import com.github.pagehelper.Page;
import com.springboot.springboot.pojo.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BuildingMapper {

    /**
     * 按条件查询建筑信息（分页交给 PageHelper 控制）
     */
    Page<Building> findAllBuilding(@Param("number") String number);
}
