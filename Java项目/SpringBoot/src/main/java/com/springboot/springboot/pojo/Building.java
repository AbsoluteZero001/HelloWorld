package com.springboot.springboot.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

/**
 * 楼栋实体类
 */
@Data
@Schema(description = "楼栋实体类，包含楼栋基本信息")
public class Building {

    @Schema(description = "楼栋ID")
    private Integer buildingId; //驼峰命名法 符合 JavaBean 规范
    //@Column(name = "building_id")  //如果不做配置，MyBatis 默认不会自动识别，需要手动写@Column(name = "building_id")

    @Schema(description = "楼栋编号")
    private String buildingCode;

    @Schema(description = "楼栋名称")
    private String buildingName;

    @Schema(description = "楼栋状态")
    private Short buildingStatus;

    @Schema(description = "楼层数")
    private Short buildingFloors;

    @Schema(description = "建成时间")
    private LocalDate completedDate;

    @Schema(description = "设计寿命（年）")
    private Short designLife;

    @Schema(description = "产权年限")
    private Short ownership;
}
