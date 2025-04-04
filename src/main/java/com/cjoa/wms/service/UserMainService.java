package com.cjoa.wms.service;

import com.cjoa.wms.dao.ProductMapper;
import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;
import static com.cjoa.wms.view.ResultView.FailView;
import static com.cjoa.wms.view.ResultView.SuccessView;

public class UserMainService {

    private UserMapper userMapper;
    private ProductMapper productMapper;

    public List<ProductDto> selectProductList() {
        SqlSession sqlSession = getSqlSession();
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

    public List<ProductDto> selectProductOptionListByProdCode(int code) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectProductOptionListByProdCode(code);
        sqlSession.close();
        return list;
    }


    public int addProduct(ProductDto productDto) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.addProduct(productDto);
        List<ProductOptionDto> productOptionDtoList = new ArrayList<>();
        if (result > 0) {
            SuccessView("addProduct");
            int optionResult = productMapper.addProductOption(productOptionDtoList);
            if (optionResult == productOptionDtoList.size()) {
                SuccessView("addProductOptions");
                sqlSession.commit();
            } else {
                FailView("addProductOptions");
                sqlSession.rollback();
            }
        } else {
            sqlSession.rollback();
            FailView("addProduct");
        }
        sqlSession.close();
        return result;
    }
}
