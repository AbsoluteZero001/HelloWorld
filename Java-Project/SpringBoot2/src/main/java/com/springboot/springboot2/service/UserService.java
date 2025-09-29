package com.springboot.springboot2
        .service;

import com.springboot.springboot2.pojo.User;
import org.springframework.dao.DuplicateKeyException;

public interface UserService {
    int insertUser(User user) throws DuplicateKeyException, Exception;
}
