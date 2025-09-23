package com.springboot.springboot.service;


import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.Room;

public interface RoomService {
    PageResult<Room> pageOfRoom(Integer current, Integer size, String number);



}
