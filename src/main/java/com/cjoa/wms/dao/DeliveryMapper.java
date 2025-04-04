package com.cjoa.wms.dao;

import com.cjoa.wms.dto.DeliveryDto;
import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.dto.ReceiveDto;

import java.util.List;
import java.util.Map;

public interface DeliveryMapper {

    List<OrderDeliveryDto> checkOrderList();

    List<OrderProdOptionDeliveryDto> checkOrderDetail(int code);

    int insertDeliveryByOrder(List<OrderProdOptionDeliveryDto> orderDetail);

    int updateOrderStatus(int orderCode);

    int updateStockMinus(List<OrderProdOptionDeliveryDto> orderDetail);

    List<DeliveryDto> deliverySearchAll();

    List<DeliveryDto> deliverySearchByCode(int deliveryCode);

    List<DeliveryDto> deliverySearchByDate(Map<String, String> param);
}
