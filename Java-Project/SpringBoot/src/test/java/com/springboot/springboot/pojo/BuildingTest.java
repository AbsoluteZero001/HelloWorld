package com.springboot.springboot.pojo;
import org.junit.jupiter.api.Test;

class BuildingTest {
    @Test
    public void testBuilding() {
        Building building = new Building();
        building.setBuildingId(4);
        building.setBuildingName("tjj");
        System.out.println(building.toString());
    }
}
