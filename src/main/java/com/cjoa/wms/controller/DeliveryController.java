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

    public int insertDeliveryByOrder(List<OrderProdOptionDeliveryDto> orderDetail, int userCode) {
        orderDetail.forEach(a -> a.setUserCode(userCode));
        return deliveryService.insertDeliveryByOrder(orderDetail);
    }

    public void productDeliveryProcess(List<OrderProdOptionDeliveryDto> orderDetail, int userCode, String orderCode) {
        orderDetail.forEach(a -> a.setUserCode(userCode));
        int result = deliveryService.productDeliveryProcess(orderDetail, Integer.parseInt(orderCode));
        DeliveryResultView.resultDeliveryProcess(result);
    }
}
