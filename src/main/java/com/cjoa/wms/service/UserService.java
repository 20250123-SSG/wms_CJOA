package com.cjoa.wms.service;

import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class UserService {

    private UserMapper userMapper;

    public UserDto getUserByUserIdAndPassword(Map<String, String> userId) {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getUserByUserIdAndPassword(userId);
    }

    public List<UserDto> getAllUser() {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getAllUser();
    }

    public int addUser(UserDto user) {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        int result = userMapper.addUser(user);
        if (result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        return result;
    }
}
