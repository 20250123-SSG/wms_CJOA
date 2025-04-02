package com.cjoa.wms.controller;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.service.DeliveryService;
import com.cjoa.wms.view.DeliveryResultView;

import java.util.List;

public class DeliveryController {
    DeliveryService deliveryService = new DeliveryService();

    public void checkOrderList() {
        List<OrderDeliveryDto> list = deliveryService.checkOrderList();
        DeliveryResultView.resultOrderList(list);
    }
}
