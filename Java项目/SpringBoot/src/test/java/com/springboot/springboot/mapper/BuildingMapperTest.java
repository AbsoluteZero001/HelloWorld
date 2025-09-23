package com.springboot.springboot.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.springboot.springboot.mapper.BuildingMapper;
import com.springboot.springboot.pojo.Building;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@SpringBootTest(classes = com.springboot.springboot.Application.class)
@ExtendWith(SpringExtension.class)
class BuildingMapperTest {

    @Autowired
    BuildingMapper buildingMapper;

    @Test
    void findAllBuilding() {
        // 查询全部楼栋
        Page<Building> allBuildings = buildingMapper.findAllBuilding(null);
        System.out.println("=== 查询全部楼栋 ===");
        allBuildings.forEach(System.out::println);

        // 查询编号包含 "A" 的楼栋（模糊查询）
        /*List<Building> filteredBuildings = buildingMapper.findAllBuilding("A");
        System.out.println("=== 查询编号包含 'A' 的楼栋 ===");
        filteredBuildings.forEach(System.out::println);*/
    }
}
