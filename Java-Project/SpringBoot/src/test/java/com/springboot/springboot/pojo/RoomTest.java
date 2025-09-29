package com.springboot.springboot.pojo;

import org.junit.jupiter.api.Test;

public class RoomTest {

    @Test
    public void testRoom() {
        Room room = new Room();
        room.setRoomId(2);
        room.setRoomCode("4-23-5");

        System.out.println(room);
    }
}
