package com.cjoa.wms.dao;

import com.cjoa.wms.dto.UserDto;

import java.util.Map;

public interface UserDao {
    UserDto getUserByUserIdAndPassword(Map<String, String> paramMap);
}
