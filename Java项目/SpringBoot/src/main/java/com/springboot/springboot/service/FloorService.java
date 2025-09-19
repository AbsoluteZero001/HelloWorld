package com.springboot.springboot.service;

import com.springboot.springboot.pojo.Floor;
import com.springboot.springboot.pojo.PageResult;

public interface FloorService {
    PageResult<Floor> pageOfFloor(Integer current, Integer size, String number);
}
