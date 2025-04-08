package com.cjoa.wms.service;

import com.cjoa.wms.dao.CartMapper;
import com.cjoa.wms.dao.OrderMapper;
import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDto;
import com.cjoa.wms.dto.UserDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;
import static com.cjoa.wms.view.LoginView.userCode;

public class OrderService {

    private UserMapper userMapper;
    private OrderMapper orderMapper;
    private CartMapper cartMapper;

    public UserDto selectUserInfo(int userCode) {
        SqlSession sqlSession = getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        UserDto user = userMapper.selectUserInfoByUserCode(userCode);
        sqlSession.close();
        return user;
    }

    public int orderProcess(OrderDeliveryDto orderDelivery){
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        cartMapper = sqlSession.getMapper(CartMapper.class);

        int result = 0;
        try {
            int result1 = orderMapper.insertOrderTableByUser(orderDelivery);
            int result2 = orderMapper.insertOrderDeliveryTableByUser(orderDelivery);

            // orderDelivery 의 userCode를 넘겨서 해당 회원의 장바구니 목록(List)을 조회 해오기
            // orderDelivery에 orderProdOption 리스트에 조회해온 list 담기
            List<CartDto> list = cartMapper.selectCartProduct(userCode);
            for (CartDto cart : list) {
                cart.setOrderCode(orderDelivery.getOrderCode());
            }
            orderDelivery.setOrderProdOptionList(list);


            int result3 = orderMapper.insertOrderProdOption(orderDelivery);
            int result4 = cartMapper.dropCart(userCode);/*장바구니 지우기*/
            if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
                sqlSession.commit();
                result = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return result;
    }


    public List<OrderDeliveryDto> selectOrderList(int userCode) {
        SqlSession sqlSession = getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderDeliveryDto> list = orderMapper.selectOrderList(userCode);
        sqlSession.close();
        return list;

    }
}
