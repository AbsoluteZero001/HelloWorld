package com.springboot.springboot.pojo;

import lombok.Data;

@Data
public class Floor {
    private Integer floorId;
    private Integer belongBuilding;  // 对应 building_id
    private Integer floorNumber;
    private Integer roomNumber;
    private String buildingName;    // 用于显示楼栋名称
}
