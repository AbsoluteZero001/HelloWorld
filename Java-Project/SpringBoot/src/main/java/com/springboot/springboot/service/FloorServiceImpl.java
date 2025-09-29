package com.springboot.springboot.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot.mapper.BuildingMapper;
import com.springboot.springboot.mapper.FloorMapper;
import com.springboot.springboot.pojo.Building;
import com.springboot.springboot.pojo.Floor;
import com.springboot.springboot.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorMapper floorMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Override
    public PageResult<Floor> pageOfFloor(Integer current, Integer size, String number) {
        // 开启分页
        PageHelper.startPage(current, size);

        // 返回 List，PageHelper 会自动拦截
        Page<Floor> floors = floorMapper.findAllFloor(number);

        // 设置楼栋名称
        floors.forEach(floor -> {
            String buildingName = String.valueOf(buildingMapper.queryById(floor.getBelongBuilding()));
            floor.setBuildingName(buildingName);
        });


        return PageResult.restPage(floors);
    }

}
