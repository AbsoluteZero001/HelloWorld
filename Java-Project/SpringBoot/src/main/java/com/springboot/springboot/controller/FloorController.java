package com.springboot.springboot.controller;

import com.springboot.springboot.pojo.Floor;
import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.ResponsePojo;
import com.springboot.springboot.service.FloorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 楼层相关接口 Controller
 * 提供楼层分页查询、增删改查等接口
 */
@RestController
@RequestMapping("/floor")  // 根路径统一管理
@Tag(name = "楼层相关接口", description = "楼层分页查询、增删改查等接口")
public class FloorController {

    @Autowired
    private FloorService floorService;

    /**
     * 查询楼层分页信息
     * 支持按楼层编号或名称模糊查询
     *
     * @param current 当前页，默认1
     * @param size    每页条数，默认10
     * @param number  楼层编号或名称，可为空
     * @return 分页结果封装在 ResponsePojo 中
     */
    @GetMapping(value = "/page", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "查询楼层分页信息", description = "分页查询楼层，可按楼层编号或名称模糊查询")
    public ResponsePojo<PageResult<Floor>> pageOfFloor(
            @Parameter(description = "当前页数，默认1") @RequestParam(defaultValue = "1") Integer current,
            @Parameter(description = "每页条数，默认10") @RequestParam(defaultValue = "10") Integer size,
            @Parameter(description = "楼层编号或名称，可为空") @RequestParam(defaultValue = "") String number
    ) {
        PageResult<Floor> floors = floorService.pageOfFloor(current, size, number);
        return ResponsePojo.success(floors);
    }
}
