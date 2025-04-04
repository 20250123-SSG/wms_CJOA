package com.cjoa.wms.service;

import com.cjoa.wms.dao.CartMapper;
import com.cjoa.wms.dao.ProductMapper;
import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.ProductDto;
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

}
