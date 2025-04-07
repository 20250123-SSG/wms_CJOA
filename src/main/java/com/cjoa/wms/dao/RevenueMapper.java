package com.cjoa.wms.dao;

import java.util.Map;

public interface RevenueMapper {
    int calculateTotalSales(Map<String, String> param);

    int calculateTotalPurchaseCost(Map<String, String> param);


}
