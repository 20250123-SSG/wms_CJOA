package com.cjoa.wms.dao;

import com.cjoa.wms.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    @Test
    void getUserByUserIdAndPassword() {
        UserDto user = new UserDto()
                .builder()
                .userId("user1")
                .password("password123")
                .build();
        UserDto userDto = userMapper.getUserByUserIdAndPassword(Map.of("userId", user.getUserId(), "password", user.getPassword()));
        assertThat(userDto).isNotNull();
    }
}