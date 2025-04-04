package com.cjoa.wms.dao;

import com.cjoa.wms.dto.ReceiveDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;


import java.util.List;
import java.util.Map;

public interface ReceiveMapper {
  
    List<ReceiveDto> receiveSearchAll();
  
    List<ReceiveDto> receiveSearchByCode(int receiveCode);
  
    List<ReceiveDto> receiveSearchByDate(Map<String, String> param);

    OrderProdOptionDeliveryDto checkProductByOptionCode(int optionCode);

    int insertReceive(OrderProdOptionDeliveryDto prodInfo);

    int updateStockPlus(OrderProdOptionDeliveryDto prodInfo);

    String checkProdOptionSoldout(int code);

    int updateProdOptionSoldout(int code);
}
