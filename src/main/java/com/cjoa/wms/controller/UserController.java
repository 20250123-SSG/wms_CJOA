package com.cjoa.wms.controller;

import com.cjoa.wms.dto.UserDto;
import com.cjoa.wms.service.UserService;
import com.cjoa.wms.view.AdminView;
import com.cjoa.wms.view.ResultView;

import java.util.List;
import java.util.Map;

public class UserController {

    private UserService userService = new UserService();

    public UserDto getUserByUserIdAndPassword(String id, String password) {
        return userService.getUserByUserIdAndPassword(Map.of("userId", id, "userPassword", password));
    }

    public void getAllUser() {
        ResultView.displayData(userService.getAllUser());
        return;
    }

    public void addUser(UserDto user) {
        userService.addUser(user);
    }


    public void updateUserByCode(UserDto user) {
        userService.updateUserByCode(user);
    }

    public void deleteUserByCode(int code) {
        userService.deleteUserByCode(code);
        return;
    }
}
