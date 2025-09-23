package com.springboot.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.springboot.mapper.BuildingMapper;
import com.springboot.springboot.pojo.Building;
import com.springboot.springboot.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public PageResult<Building> pageOfBuilding(Integer current, Integer size, String number) {
        // 开启分页
        PageHelper.startPage(current, size);

        // 调用 Mapper 查询数据
        Page<Building> buildings = buildingMapper.findAllBuilding(number);

        // 封装成 PageResult 返回
        return PageResult.restPage(buildings);
    }
}
