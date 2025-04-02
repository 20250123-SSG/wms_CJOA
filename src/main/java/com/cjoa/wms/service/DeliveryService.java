package com.cjoa.wms.service;

import com.cjoa.wms.dao.DeliveryMapper;
import com.cjoa.wms.dto.OrderDeliveryDto;
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
}
