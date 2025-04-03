package com.cjoa.wms.view;

import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

import java.util.List;

public class DeliveryResultView {
    public static void resultOrderList(List<OrderDeliveryDto> list) {
        if (list.isEmpty()) {
            System.out.println("주문이 없습니다.");
        } else {
            for (OrderDeliveryDto order : list) {
                System.out.printf("[주문번호: %d, 사용자번호: %d, 주문시간: %s, [배송정보] 이름: %s, 전화번호: %s, 주소: %s, 요청사항: %s]\n",
                        order.getOrderCode(),
                        order.getUserCode(),
                        order.getOrderDate(),
                        order.getOrderDeliveryName(),
                        order.getOrderDeliveryPhone(),
                        order.getOrderDeliveryAddress(),
                        order.getOrderRequest()
                );
            }
        }
    }

    public static void resultOrderDetail(List<OrderProdOptionDeliveryDto> orderDetail) {
        if (orderDetail.isEmpty()) {
            System.out.println("없는 주문번호 입니다.");
        } else {
            for (OrderProdOptionDeliveryDto order : orderDetail) {
                System.out.printf("[상품상세번호: %d, 상품명: %s, 사이즈: %s, 색상: %s, 수량: %d [상품 현재고: %d]]\n",
                        order.getProdOptionCode(),
                        order.getProdName(),
                        order.getProdSize(),
                        order.getProdColor(),
                        order.getOrderProdOptionQuantity(),
                        order.getStockQuantity()
                );
            }
        }
    }

    public static void resultDeliveryProcess(int result) {
        if (result > 0) {
            System.out.println("출고가 완료되었습니다.");
        } else {
            System.out.println("문제가 발생하였습니다.");
        }
    }
}
