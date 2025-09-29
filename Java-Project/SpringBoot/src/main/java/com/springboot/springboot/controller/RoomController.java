package com.springboot.springboot.controller;

import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.ResponsePojo;
import com.springboot.springboot.pojo.Room;
import com.springboot.springboot.service.RoomService;
import com.springboot.springboot.service.FloorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 房间相关接口
 */
@Tag(name = "房间相关接口")
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private FloorService floorService;

    /**
     * 分页查询房间信息
     */
    @Operation(summary = "查询房间分页信息", description = "支持根据房号模糊查询")
    @GetMapping("/page")
    public ResponsePojo<PageResult<Room>> pageOfRoom(
            @Parameter(description = "当前页码", example = "1")
            @RequestParam(defaultValue = "1") Integer current,

            @Parameter(description = "每页大小", example = "10")
            @RequestParam(defaultValue = "10") Integer size,

            @Parameter(description = "房间编号(模糊查询)", example = "101")
            @RequestParam(required = false) String number) {

        PageResult<Room> rooms = roomService.pageOfRoom(current, size, number);
        return ResponsePojo.success(rooms);
    }
}
