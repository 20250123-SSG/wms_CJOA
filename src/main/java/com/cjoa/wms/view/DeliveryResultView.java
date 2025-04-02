package com.cjoa.wms.view;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderDto;

import java.util.List;

public class DeliveryResultView {
    public static void resultOrderList(List<OrderDeliveryDto> list) {
        if (list.isEmpty()) {
            System.out.println("주문이 없습니다.");
        } else {
            for (OrderDeliveryDto order : list) {
                System.out.printf("[주문번호: %d, 사용자번호: %d, 주문시간: %s]\n",
                        order.getOrderCode(),
                        order.getUserCode(),
                        order.getOrderDate()
                        // 배송정보 추가해야함.
                );
            }
        }
    }
}
