package com.cjoa.wms.service;

import com.cjoa.wms.dao.CartMapper;
import com.cjoa.wms.dao.ProductMapper;
import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class UserMainService {

    private UserMapper userMapper;
    private ProductMapper productMapper;
    private CartMapper cartMapper;



    public List<ProductDto> selectProductList() {
        SqlSession sqlSession= getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectAllProduct();
        sqlSession.close();
        return list;

    }

    public List<ProductDto> selectProductListByCategoryCode(int code) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectProductByCategory(code);
        sqlSession.close();
        return list;
    }

    public List<ProductDto> selectProductListByKeyword(String key) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectProductByProdKeyword(key);
        sqlSession.close();
        return list;
    }

    public ProductDto selectProductOptionListByProdCode(int code) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        ProductDto prod = productMapper.selectProductOptionListByProdCode(code);
        sqlSession.close();
        return prod;
    }

    public int insertCart(CartDto cart) {
        SqlSession sqlSession = getSqlSession();
        cartMapper = sqlSession.getMapper(CartMapper.class);

        int result = 0;
        try {
            result = cartMapper.insertCart(cart);
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
