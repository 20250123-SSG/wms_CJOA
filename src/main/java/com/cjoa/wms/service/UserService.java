package com.cjoa.wms.service;

import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class UserService {

    public UserDto getUserByUserIdAndPassword(Map<String, String> userId) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getUserByUserIdAndPassword(userId);
    }
}
