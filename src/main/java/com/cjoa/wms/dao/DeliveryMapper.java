package com.cjoa.wms.dao;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

import java.util.List;

public interface DeliveryMapper {

    List<OrderDeliveryDto> checkOrderList();

    List<OrderProdOptionDeliveryDto> checkOrderDetail(int code);

    int insertDeliveryByOrder(List<OrderProdOptionDeliveryDto> orderDetail);

    int updateOrderStatus(int orderCode);

    int updateStockMinus(List<OrderProdOptionDeliveryDto> orderDetail);
}
