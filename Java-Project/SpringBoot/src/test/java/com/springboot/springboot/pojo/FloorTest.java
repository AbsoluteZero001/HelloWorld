package com.springboot.springboot.pojo;

import com.springboot.springboot.pojo.Floor;
import org.junit.jupiter.api.Test;

public class FloorTest {

    @Test
    public void testFloor() {
        Floor floor = new Floor();

        // 设置属性
        floor.setFloorId(1);
        floor.setBelongBuilding(101);
        floor.setFloorNumber(4);
        floor.setRoomNumber(20); // 改为 Integer

        // 打印对象（依赖 Lombok @Data 自动生成 toString）
        System.out.println(floor);

        // 简单断言（可选）
        assert floor.getFloorId() == 1;
        assert floor.getBelongBuilding() == 101;
        assert floor.getFloorNumber() == 4;
        assert floor.getRoomNumber() == 20;
    }
}
