package com.cjoa.wms.service;

import com.cjoa.wms.dao.ProductMapper;
import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class UserMainService {

    private UserMapper userMapper;
    private ProductMapper productMapper;

    public List<ProductDto> selectProductList() {
        SqlSession sqlSession= getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectAllProduct();
        sqlSession.close();
        return list;

    }
}
