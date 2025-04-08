package com.cjoa.wms.dao;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.UserDto;

import java.util.List;

public interface OrderMapper {
    int insertOrderTableByUser(OrderDeliveryDto orderDelivery);

    int insertOrderDeliveryTableByUser(OrderDeliveryDto orderDelivery);


    int insertOrderProdOption(OrderDeliveryDto orderDelivery);

    List<OrderDeliveryDto> selectOrderList(int userCode);
}
