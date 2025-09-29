package com.springboot.springboot.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.springboot.mapper.BuildingMapper;
import com.springboot.springboot.mapper.FloorMapper;
import com.springboot.springboot.mapper.RoomMapper;
import com.springboot.springboot.pojo.Floor;
import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public PageResult<Room> pageOfRoom(Integer current, Integer size, String number) {
        // 开启分页
        PageHelper.startPage(current, size);

        // 查询房间列表
        Page<Room> rooms = roomMapper.findAllRoom(number);

        // 遍历房间，填充楼层号和楼栋名称
        rooms.stream().forEach(room -> {
            Floor floor = floorMapper.queryById(room.getRoomFloorId()); // 注意驼峰
            if (floor != null) {
                room.setFloorNumber(floor.getFloorNumber().intValue()); // 注意驼峰
                room.setBuildingName(buildingMapper.queryNameById(floor.getBelongBuilding())); // 注意方法名
            }
        });

        // 返回分页结果
        return PageResult.restPage(rooms);
    }
}
