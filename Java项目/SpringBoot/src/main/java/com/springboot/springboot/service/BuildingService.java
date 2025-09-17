package com.springboot.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot.pojo.Building;
import com.springboot.springboot.pojo.PageResult;

public interface BuildingService {
    // 新增：带 number 条件的分页查询 只声明了方法，没有实现
   PageResult<Building> pageOfBuilding(Integer current, Integer size, String number);
}
