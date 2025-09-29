package com.springboot.springboot.pojo.user;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResUserTest {

    @Test
    public void testUsers() {
        List<Object> list = Arrays.asList(
                new ResUser(),
                new LoginUser(),
                new User()
        );

        ((ResUser) list.get(0)).setUsername("resUser");
        ((LoginUser) list.get(1)).setUsername("loginUser");
        ((User) list.get(2)).setUsername("user");

        System.out.println(list);
    }
}
