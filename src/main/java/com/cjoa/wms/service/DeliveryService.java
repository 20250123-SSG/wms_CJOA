package com.cjoa.wms.service;

import com.cjoa.wms.dao.DeliveryMapper;
import com.cjoa.wms.dao.ReceiveMapper;
import com.cjoa.wms.dto.DeliveryDto;
import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.dto.ReceiveDto;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class DeliveryService {
    private DeliveryMapper deliveryMapper;

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


    public List<DeliveryDto> deliverySearchAll(){
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<DeliveryDto> list = deliveryMapper.deliverySearchAll();
        sqlSession.close();
        return list;
    }

    public  List<DeliveryDto> deliverySearchByCode(int deliveryCode){
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        List<DeliveryDto> list = deliveryMapper.deliverySearchByCode(deliveryCode);
        sqlSession.close();
        return list;
    }
    public List<DeliveryDto> deliverySearchByDate(String startTime, String endTime){
        SqlSession sqlSession = getSqlSession();
        deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
        LocalDate end = LocalDate.parse(endTime);
        LocalDate nextDay = end.plusDays(1);
        String nextDayEndTime = nextDay.toString(); // "2025-04-04" 형태

        Map<String, String> param = Map.of(
                "startTime", startTime,
                "nextDayEndTime", nextDayEndTime
        );
        List<DeliveryDto> list = deliveryMapper.deliverySearchByDate(param);
        sqlSession.close();
        return list;


}

}