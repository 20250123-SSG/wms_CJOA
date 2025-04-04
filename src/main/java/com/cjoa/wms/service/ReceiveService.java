package com.cjoa.wms.service;

import com.cjoa.wms.dao.ReceiveMapper;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import org.apache.ibatis.session.SqlSession;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class ReceiveService {
    ReceiveMapper receiveMapper;

    public OrderProdOptionDeliveryDto checkProductByOptionCode(int optionCode) {
        SqlSession sqlSession = getSqlSession();
        receiveMapper = sqlSession.getMapper(ReceiveMapper.class);
        OrderProdOptionDeliveryDto result = receiveMapper.checkProductByOptionCode(optionCode);
        sqlSession.close();
        return result;
    }

    public int receiveProcess(OrderProdOptionDeliveryDto prodInfo) {
        SqlSession sqlSession = getSqlSession();
        receiveMapper = sqlSession.getMapper(ReceiveMapper.class);
        int result1 = receiveMapper.insertReceive(prodInfo);
        int result2 = receiveMapper.updateStockPlus(prodInfo);
        int result = 0;
        if (result1 > 0 && result2 > 0) {
            sqlSession.commit();
            result = 1;
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
