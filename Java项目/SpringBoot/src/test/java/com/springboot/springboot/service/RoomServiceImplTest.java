package com.springboot.springboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * RoomServiceImpl 测试类
 */
@SpringBootTest
public class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;

    @Test
    void pageOfRoom() {
        System.out.println(roomService.pageOfRoom(1, 5, "3"));
    }
}
