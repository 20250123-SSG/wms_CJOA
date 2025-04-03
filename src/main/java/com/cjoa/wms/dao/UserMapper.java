package com.cjoa.wms.dao;

import com.cjoa.wms.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    UserDto getUserByUserIdAndPassword(Map<String, String> paramMap);

    List<UserDto> getAllUser();

    int addUser(UserDto user);

    int updateUserByCode(UserDto user);

    int deleteUserByCode(int code);
}
