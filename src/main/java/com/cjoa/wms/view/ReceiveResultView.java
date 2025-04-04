package com.cjoa.wms.view;

import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

public class ReceiveResultView {
    public void productOptionDetail(OrderProdOptionDeliveryDto product) {
        if (product != null) {
            System.out.printf("[상품상세번호: %d, 상품명: %s, 사이즈: %s, 색상: %s [상품 현재고: %d]]\n",
                    product.getProdOptionCode(),
                    product.getProdName(),
                    product.getProdSize(),
                    product.getProdColor(),
                    product.getStockQuantity()
            );
        } else {
            System.out.println("없는 제품상세번호입니다.");
        }
    }

    public void receiveResult(int result) {
        if (result > 0) {
            System.out.println("입고가 성공적으로 완료되었습니다.");
        } else {
            System.out.println("문제가 발생하였습니다.");
        }
    }
}
