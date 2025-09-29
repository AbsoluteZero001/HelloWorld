package com.springboot.springboot.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.springboot.pojo.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoomMapperTest {

 @Autowired
 private RoomMapper roomMapper;

 @Test
 void testFindAllRoom() {
  // 开启分页：查询第1页，每页10条
  PageHelper.startPage(1, 10);

  // 查询房间，传入关键字 "1"
  List<Room> rooms = roomMapper.findAllRoom("1");

  // 包装分页信息
  PageInfo<Room> pageInfo = new PageInfo<>(rooms);

  // 打印分页信息
  System.out.println("总记录数: " + pageInfo.getTotal());
  System.out.println("总页数: " + pageInfo.getPages());
  System.out.println("当前页记录数: " + pageInfo.getList().size());
  pageInfo.getList().forEach(System.out::println);
 }
}
