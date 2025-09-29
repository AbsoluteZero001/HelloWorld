package com.springboot.springboot.controller;

import com.springboot.springboot.pojo.Building;
import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.ResponsePojo;
import com.springboot.springboot.service.BuildingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "楼栋相关接口", description = "楼栋相关的增删改查接口")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/page/building")
    @Operation(
            summary = "查询楼栋分页信息",
            description = "根据页码、每页条数及可选楼栋编号分页查询楼栋列表",
            responses = {
                    @ApiResponse(
                            description = "返回楼栋分页信息",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ResponsePojo.class)
                            )
                    )
            }
    )
    public ResponsePojo<PageResult<Building>> pageOfBuilding(
            @Parameter(description = "当前页，默认1", example = "1")
            @RequestParam(defaultValue = "1") Integer current,

            @Parameter(description = "每页条数，默认10", example = "10")
            @RequestParam(defaultValue = "10") Integer size,

            @Parameter(description = "楼栋编号，可选", example = "B101")
            @RequestParam(required = false) String number
    ) {
        // 调用 Service 并传入三个参数（支持 number 可选）
        PageResult<Building> pageResult = buildingService.pageOfBuilding(current, size, number);
        return ResponsePojo.success(pageResult);
    }
}
