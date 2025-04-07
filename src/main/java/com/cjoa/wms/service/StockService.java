package com.cjoa.wms.service;

import com.cjoa.wms.dao.ProductMapper;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.dto.ProductDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;


public class StockService {
    ProductMapper productMapper;

    public List<OrderProdOptionDeliveryDto> checkAllStockList() {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        List<OrderProdOptionDeliveryDto> list = productMapper.selectAllStockList();
        sqlSession.close();
        return list;
    }

    public ProductDto checkStockByProdCode(int menu) {
        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        ProductDto list = productMapper.checkStockByProdCode(menu);
        sqlSession.close();
        return list;
    }
}
