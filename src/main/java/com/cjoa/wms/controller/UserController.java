package com.cjoa.wms.controller;

import com.cjoa.wms.dto.UserDto;
import com.cjoa.wms.service.UserService;
import com.cjoa.wms.view.AdminView;
import com.cjoa.wms.view.ResultView;

import java.util.List;
import java.util.Map;

public class UserController {

    private UserService userService = new UserService();
    private AdminView adminView = new AdminView();

    public void getUserByUserIdAndPassword(String id, String password) {
        login(userService.getUserByUserIdAndPassword(Map.of("userId", id, "password", password)));
        return;
    }

    public void login(UserDto user) {
        if (user != null) {
            System.out.println("Login Successful");
            switch (user.getUserType()) {
                case "관리자":
                    System.out.println("Admin Login");
                    adminView.mainView();
                    break;
                case "회원":
                    System.out.println("User Login");
                    break;
                case "창고관리자":
                    System.out.println("WareHouse Admin Login");
                default:
                    System.out.println("Invalid User");
                    break;
            }
        } else {
            System.out.println("Login Failed");
        }
    }

    public void getAllUser() {
        ResultView.displayData(userService.getAllUser());
        return;
    }

    public int addUser(UserDto user) {
        return userService.addUser(user);
    }
}
