package com.cjoa.wms.service;

import com.cjoa.wms.dao.CartMapper;
import com.cjoa.wms.dao.ProductMapper;
import com.cjoa.wms.dao.UserMapper;
import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;
import static com.cjoa.wms.view.ResultView.FailView;
import static com.cjoa.wms.view.ResultView.SuccessView;

public class UserMainService {

    private ProductMapper productMapper;
    private CartMapper cartMapper;


    public List<ProductDto> selectProductList() {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectAllProduct();
        sqlSession.close();
        return list;

    }

    public List<ProductDto> selectProductListByAdmin() {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<ProductDto> list = productMapper.selectAllProductForAdmin();
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

        // 조회 데이터가 있으면 업데이트 없으면 인서트
        int count = cartMapper.checkCartProduct(cart);
        int result = 0;
        try {
            if (count > 0) {
                // 수량 증가 update
                result = cartMapper.insertSameProductCart(cart);
            } else {
                // insert
                result = cartMapper.insertCart(cart);
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return result;
    }


    public int addProduct(ProductDto productDto) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.addProduct(productDto);
        if (result > 0) {
            SuccessView("addProduct");
            List<ProductOptionDto> list = productDto.getProductOptionList();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setProdCode(productDto.getProdCode());
                System.out.println(list.get(i).toString());

            }
            int optionResult = productMapper.addProductOption(Map.of("list", list));
            if (optionResult == productDto.getProductOptionList().size()) {
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

    public int updateProduct(ProductDto productDto) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.updateProduct(productDto);
        if (result > 0) {
            SuccessView("updateProduct");
            sqlSession.commit();
        } else {
            FailView("updateProduct");
            sqlSession.rollback();
        }
        return result;
    }

    public int updateProductOption(ProductOptionDto productOptionDto) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.updateProductOption(productOptionDto);
        if (result > 0) {
            SuccessView("updateProductOption");
            sqlSession.commit();
        } else {
            FailView("updateProductOption");
            sqlSession.rollback();
        }
        return result;
    }

    public int deleteProduct(int code) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        int result = productMapper.deleteProduct(code);
        if (result > 0) {
            SuccessView("deleteProduct");
            sqlSession.commit();
        } else {
            FailView("deleteProduct");
            sqlSession.rollback();
        }
        return result;
    }
}

