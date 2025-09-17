package com.springboot.springboot.service;

import com.springboot.springboot.pojo.PageResult;
import com.springboot.springboot.pojo.Building;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuildingServiceImplTest {

    @Autowired
    private BuildingService buildingService;

    @Test
    void testPageOfBuilding() {
        // ===============================
        // 测试全部楼栋分页
        // ===============================
        PageResult<Building> allPage1 = buildingService.pageOfBuilding(1, 10, null);
        System.out.println("全部楼栋 - 第1页（每页10条）: " + allPage1);

        PageResult<Building> allPage2 = buildingService.pageOfBuilding(2, 5, null);
        System.out.println("全部楼栋 - 第2页（每页5条）: " + allPage2);

        // ===============================
        // 测试模糊查询分页
        // ===============================
        String filterNumber = "A"; // 查询楼栋编号包含 "A"
        PageResult<Building> filteredPage1 = buildingService.pageOfBuilding(1, 10, filterNumber);
        System.out.println("楼栋编号包含 '" + filterNumber + "' - 第1页（每页10条）: " + filteredPage1);

        PageResult<Building> filteredPage2 = buildingService.pageOfBuilding(1, 5, filterNumber);
        System.out.println("楼栋编号包含 '" + filterNumber + "' - 第1页（每页5条）: " + filteredPage2);
    }
}
