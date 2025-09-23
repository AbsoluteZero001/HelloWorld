package com.springboot.springboot.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "房屋信息。与楼层相关")
public class Room {

    @Schema(description = "房屋的唯一标识")
    private Integer roomId;

    @Schema(description = "房屋所属楼层的标识 id")
    private Integer roomFloorId;

    @Schema(description = "建筑面积")
    private Integer builtUpArea; // 建议改成 Integer（一般数据库是 int/double，不常用 short）

    @Schema(description = "房屋状态,1、自住;2、出租;3、未居住;4、未售出;5、公共空间")
    private Integer roomStatus; // 同理，推荐 Integer

    @Schema(description = "房屋编号,1-3-2表示1号楼3层2号房")
    private String roomCode;

    @Schema(description = "该楼层所属楼栋")
    private String buildingName;

    @Schema(description = "该房间所属楼层")
    private Integer floorNumber; // ✅ Short → Integer
}

