package com.cjoa.wms.service;

import com.cjoa.wms.dao.CartMapper;
import com.cjoa.wms.dto.CartDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class CartService {

    private CartMapper cartMapper;

    public List<CartDto> selectCartProductList(int code) {
        SqlSession sqlSession = getSqlSession();
        cartMapper = sqlSession.getMapper(CartMapper.class);
        List<CartDto> list = cartMapper.selectCartProduct(code);
        sqlSession.close();
        return list;
    }

    public int modifyOptionInCart(CartDto cart) {
        SqlSession sqlSession = getSqlSession();
        cartMapper = sqlSession.getMapper(CartMapper.class);

        int result = 0;
        try {
            result = cartMapper.modifyCart(cart);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        System.out.println(result);
        return result;
    }


    public int deleteCart(CartDto cart) {
        SqlSession sqlSession = getSqlSession();
        cartMapper = sqlSession.getMapper(CartMapper.class);


        int result = 0;
        try {
            result = cartMapper.deleteCart(cart);
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
