package com.cjoa.wms.dao;

import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

public interface ReceiveMapper {

    OrderProdOptionDeliveryDto checkProductByOptionCode(int optionCode);

    int insertReceive(OrderProdOptionDeliveryDto prodInfo);

    int updateStockPlus(OrderProdOptionDeliveryDto prodInfo);
}
