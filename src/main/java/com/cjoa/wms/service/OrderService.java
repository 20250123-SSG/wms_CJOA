package com.cjoa.wms.service;

import com.cjoa.wms.dao.OrderMapper;
import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class OrderService {

    private UserMapper userMapper;
    private OrderMapper orderMapper;

    public UserDto selectUserInfo(int userCode) {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto user = userMapper.selectUserInfoByUserCode(userCode);
        sqlSession.close();
        return user;
    }

    public int insertOrderInfo(OrderDeliveryDto orderDelivery) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = 0;
        try {
            result = orderMapper.insertOrderTableByUser(orderDelivery);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return result;
    }


    public int insertOrderDeliveryInfo(OrderDeliveryDto orderDelivery) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = 0;
        try {
            result = orderMapper.insertOrderDeliveryTableByUser(orderDelivery);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public int insertOrderProdOption(OrderDeliveryDto orderDelivery){
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        int result = 0;

        try {
            result = orderMapper.insertOrderProdOptionByUser(orderDelivery);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return result;

    }



}
