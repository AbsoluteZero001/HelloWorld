package com.springboot.springboot.mapper;

import com.springboot.springboot.pojo.Floor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FloorMapperTest {

    @Autowired
    private FloorMapper floorMapper;

    @Test
    public void testFindAllFloor() {
        System.out.println("=== 查询所有楼层 ===");
        List<Floor> allFloors = floorMapper.findAllFloor(null);
        allFloors.forEach(System.out::println);

        System.out.println("=== 查询楼层号包含 '4' 的楼层 ===");
        List<Floor> floors4 = floorMapper.findAllFloor("4");
        floors4.forEach(System.out::println);
    }
}
