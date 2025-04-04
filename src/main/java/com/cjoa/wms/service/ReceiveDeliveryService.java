package com.cjoa.wms.service;

import com.cjoa.wms.dao.ReceiveDeliveryMapper;
import com.cjoa.wms.dto.DeliveryDto;
import com.cjoa.wms.dto.ReceiveDeliveryDto;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.*;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class ReceiveDeliveryService {
    private ReceiveDeliveryMapper receiveDeliveryMapper;

    public List<ReceiveDeliveryDto> ReceiveDeliverySearchAll() {
        SqlSession sqlSession = getSqlSession();
        receiveDeliveryMapper = sqlSession.getMapper(ReceiveDeliveryMapper.class);
        List<ReceiveDeliveryDto> list = receiveDeliveryMapper.receiveDeliverySearchAll();
        sqlSession.close();
        return list;
    }
    public List<ReceiveDeliveryDto> receiveDeliverySearchByDate(String startDate, String endDate){
        SqlSession sqlSession = getSqlSession();
        receiveDeliveryMapper = sqlSession.getMapper(ReceiveDeliveryMapper.class);
        LocalDate end = LocalDate.parse(endDate);
        LocalDate nextDay = end.plusDays(1);
        String nextDayEndTime = nextDay.toString(); // "2025-04-04" 형태

        Map<String, String> param = Map.of(
                "startTime", startDate,
                "nextDayEndTime", nextDayEndTime
        );
        List<ReceiveDeliveryDto> list = receiveDeliveryMapper.receiveDeliverySearchByDate(param);
        sqlSession.close();
        return list;
    }
}
