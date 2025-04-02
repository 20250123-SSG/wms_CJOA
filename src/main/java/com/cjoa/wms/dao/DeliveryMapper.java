package com.cjoa.wms.dao;

import com.cjoa.wms.dto.OrderDeliveryDto;

import java.util.List;

public interface DeliveryMapper {

    List<OrderDeliveryDto> checkOrderList();
}
