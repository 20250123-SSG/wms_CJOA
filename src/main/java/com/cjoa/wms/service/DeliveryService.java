package com.cjoa.wms.service;

import com.cjoa.wms.dao.DeliveryMapper;
import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class DeliveryService {
    DeliveryMapper deliveryMapper;

    public List<OrderDeliveryDto> checkOrderList() {
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<OrderDeliveryDto> list = deliveryMapper.checkOrderList();
        sqlSession.close();
        return list;
    }

    public List<OrderProdOptionDeliveryDto> checkOrderDetail(int code) {
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<OrderProdOptionDeliveryDto> list = deliveryMapper.checkOrderDetail(code);
        sqlSession.close();
        return list;
    }

    public int productDeliveryProcess(List<OrderProdOptionDeliveryDto> orderDetail, int orderCode) {
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        int result1 = deliveryMapper.insertDeliveryByOrder(orderDetail);
        int result2 = deliveryMapper.updateOrderStatus(orderCode);
        int result3 = deliveryMapper.updateStockMinus(orderDetail);

        int result = 0;
        if (result1 > 0 && result2 > 0 && result3 > 0) {
            sqlSession.commit();
            result = 1;
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
