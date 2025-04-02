package com.cjoa.wms.controller;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.service.DeliveryService;
import com.cjoa.wms.view.DeliveryResultView;

import java.util.List;

public class DeliveryController {
    DeliveryService deliveryService = new DeliveryService();

    public void checkOrderList() {
        List<OrderDeliveryDto> list = deliveryService.checkOrderList();
        DeliveryResultView.resultOrderList(list);
    }

    public List<OrderProdOptionDeliveryDto> checkOrderDetail(String code) {
        List<OrderProdOptionDeliveryDto> orderDetail = deliveryService.checkOrderDetail(Integer.parseInt(code));
        DeliveryResultView.resultOrderDetail(orderDetail);
        return orderDetail;
    }

    public int insertDeliveryByOrder(List<OrderProdOptionDeliveryDto> orderDetail) {
        int result = 0;
        result = deliveryService.insertDeliveryByOrder(orderDetail);
        return result;
    }
}
