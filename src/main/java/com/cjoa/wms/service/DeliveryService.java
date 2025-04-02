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

    public int insertDeliveryByOrder(List<OrderProdOptionDeliveryDto> orderDetail) {
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        int result = deliveryMapper.insertDeliveryByOrder(orderDetail);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
