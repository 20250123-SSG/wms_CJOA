package com.cjoa.wms.service;

import com.cjoa.wms.dao.ReceiveMapper;
import com.cjoa.wms.dao.RevenueMapper;
import com.cjoa.wms.dto.ReceiveDto;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;

public class RevenueService {
    private RevenueMapper revenueMapper;

    public int calculateTotalSales(String startTime,String endTime){
        SqlSession sqlSession = getSqlSession();
        revenueMapper = sqlSession.getMapper(RevenueMapper.class);
        LocalDate end = LocalDate.parse(endTime);
        LocalDate nextDay = end.plusDays(1);
        String nextDayEndTime = nextDay.toString(); // "2025-04-04" 형태

        Map<String, String> param = Map.of(
                "startTime", startTime,
                "nextDayEndTime", nextDayEndTime
        );
        int totalSales = revenueMapper.calculateTotalSales(param);
        sqlSession.close();
        return totalSales;
    }

    public int calculateTotalPurchaseCost(String startTime,String endTime){
        SqlSession sqlSession = getSqlSession();
        revenueMapper = sqlSession.getMapper(RevenueMapper.class);
        LocalDate end = LocalDate.parse(endTime);
        LocalDate nextDay = end.plusDays(1);
        String nextDayEndTime = nextDay.toString(); // "2025-04-04" 형태

        Map<String, String> param = Map.of(
                "startTime", startTime,
                "nextDayEndTime", nextDayEndTime
        );
        int totalSales = revenueMapper.calculateTotalPurchaseCost(param);
        sqlSession.close();
        return totalSales;
    }

    public int calculateTotalMarginCost(String startTime,String endTime){
        SqlSession sqlSession = getSqlSession();
        revenueMapper = sqlSession.getMapper(RevenueMapper.class);
        LocalDate end = LocalDate.parse(endTime);
        LocalDate nextDay = end.plusDays(1);
        String nextDayEndTime = nextDay.toString(); // "2025-04-04" 형태

        Map<String, String> param = Map.of(
                "startTime", startTime,
                "nextDayEndTime", nextDayEndTime
        );
        int totalSales = revenueMapper.calculateTotalSales(param);
        int totalPurchaseCost = revenueMapper.calculateTotalPurchaseCost(param);
        int totalMarginCost = totalSales - totalPurchaseCost;
        sqlSession.close();
        return totalMarginCost;
    }


}
