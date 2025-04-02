package com.cjoa.wms.controller;

import com.cjoa.wms.dto.UserDto;
import com.cjoa.wms.service.UserService;

import java.util.Map;

public class UserController {

    private UserService userService = new UserService();
    public UserDto getUserByUserIdAndPassword(String id, String password) {
        return userService.getUserByUserIdAndPassword(Map.of("userId", id, "password", password));
    }
}
