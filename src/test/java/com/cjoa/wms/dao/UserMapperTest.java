package com.cjoa.wms.dao;

import com.cjoa.wms.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
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

//    @Test
//    void getUserByUserIdAndPassword() {
//        UserDto user = new UserDto()
//                .builder()
//                .userId("user1")
//                .userPassword("password123")
//                .build();
//        UserDto userDto = userMapper.getUserByUserIdAndPassword(Map.of("userId", user.getUserId(), "password", user.getUserPassword()));
//        assertThat(userDto).isNotNull();
//        assertThat(userDto.getUserId()).isEqualTo(user.getUserId()).isNotNull();
//    }

    @Test
    void testGetAllUser() {
        List<UserDto> list = userMapper.getAllUser();
        assertThat(list)
                .isNotNull()
                .isEqualTo(userMapper.getAllUser())
                .allSatisfy(userDto -> {
                    assertThat(userDto.getUserId()).isNotNull();
                    assertThat(userDto.getUserPassword()).isNotNull();
                    assertThat(userDto.getUserId()).isNotNull();
                    assertThat(userDto.getUserPassword()).isNotNull();
                    assertThat(userDto.getUserName()).isNotNull();
                });
    }

    @Test
    void testAddUser() {
        UserDto user = new UserDto()
                .builder()
                .userId("admin2")
                .userPassword("admin2")
                .userEmail("email123")
                .userPhone("phone123")
                .userAddress("address123")
                .userType("관리자")
                .userName("admin")
                .build();

        UserDto user2 = new UserDto()
                .builder()
                .userId("admin")
                .userPassword("admin")
                .userEmail("email123")
                .userPhone("phone123")
                .userAddress("address123")
                .userType("관리자")
                .userName("admin")
                .build();
        sqlSession.commit();
        assertThat(userMapper.addUser(user)).isEqualTo(userMapper.addUser(user2));
    }
}