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
        if (id == null || password == null) {
            throw new IllegalArgumentException("유저 아이디와 비밀번호를 입력해야 합니다.");
        }

        return userService.getUserByUserIdAndPassword(Map.of("userId", id, "userPassword", password));
    }

    public void getAllUser() {
        ResultView.displayData(userService.getAllUser());
    }

    public void addUser(Map<String, Object> userMap) {
        if (userMap.get("userId") == null || userMap.get("userPassword") == null) {
            throw new IllegalArgumentException("유저 아이디와 비밀번호를 입력해야 합니다.");
        }

        UserDto userDto = UserDto.builder()
                .userId((String) userMap.get("userId"))
                .userPassword((String) userMap.get("userPassword"))
                .userEmail((String) userMap.get("userEmail"))
                .userPhone((String) userMap.get("userPhone"))
                .userAddress((String) userMap.get("userAddress"))
                .userType((String) userMap.get("userType"))
                .userName((String) userMap.get("userName"))
                .build();

        userService.addUser(userDto);
    }

    public void updateUserByCode(Map<String, Object> userMap) {
        if (userMap.get("userCode") == null || userMap.get("userId") == null) {
            throw new IllegalArgumentException("유저 코드와 유저 아이디를 모두 입력해야 합니다.");
        }

        UserDto userDto = UserDto.builder()
                .userCode((Integer) userMap.get("userCode"))
                .userId((String) userMap.get("userId"))
                .userPassword((String) userMap.get("userPassword"))
                .userEmail((String) userMap.get("userEmail"))
                .userPhone((String) userMap.get("userPhone"))
                .userAddress((String) userMap.get("userAddress"))
                .userType((String) userMap.get("userType"))
                .userName((String) userMap.get("userName"))
                .build();

        userService.updateUserByCode(userDto);
    }

    public void deleteUserByCode(int code) {
        if (code <= 0) {
            throw new IllegalArgumentException("삭제할 유저 코드를 입력해야 합니다.");
        }

        userService.deleteUserByCode(code);
    }

    public void getUserByUserCode(int userCode) {
        UserDto user = userService.getUserByUserCode(userCode);
        ResultView.userInfoView(user);
    }


}
