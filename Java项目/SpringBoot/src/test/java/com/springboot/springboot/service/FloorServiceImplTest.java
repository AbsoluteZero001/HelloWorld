package com.springboot.springboot.service;

import com.springboot.springboot.Application; // 导入你的主启动类
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class) // 指定启动类
class FloorServiceImplTest {

    @Autowired
    private FloorService floorService;

    @Test
    void pageOfFloor() {
        System.out.println(floorService.pageOfFloor(1, 5, ""));
    }
}
