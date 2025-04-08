package com.cjoa.wms.controller;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.UserDto;
import com.cjoa.wms.service.OrderService;
import com.cjoa.wms.view.OrderListview;
import com.cjoa.wms.view.ResultView;

import java.util.List;
import java.util.Map;

public class OrderController {

    private OrderService orderService = new OrderService();
    OrderListview orderListview = new OrderListview();

    public UserDto selectUserInfo(int userCode) {
        UserDto user = orderService.selectUserInfo(userCode);
        return user;
    }

    public void insertOrderInfo(Map<String, String> requestParam) {
        OrderDeliveryDto orderDelivery = OrderDeliveryDto.builder()
                .orderPrice( Integer.parseInt(requestParam.get("orderPrice")) )
                .orderPayType(requestParam.get("orderPayType"))
                .orderDeliveryPhone(requestParam.get("orderDeliveryPhone"))
                .orderDeliveryAddress(requestParam.get("orderDeliveryAddress"))
                .orderDeliveryName(requestParam.get("orderDeliveryName"))
                .orderRequest(requestParam.get("orderRequest"))
                .userCode(Integer.parseInt(requestParam.get("userCode")))
                .build();

                orderService.orderProcess(orderDelivery);

    }


    public void selectOrderList(int userCode) {
        List<OrderDeliveryDto> list = orderService.selectOrderList(userCode);
        orderListview.orderList(list);
    }

    public void selectOrderDetail(int orderNum) {

    }
}
