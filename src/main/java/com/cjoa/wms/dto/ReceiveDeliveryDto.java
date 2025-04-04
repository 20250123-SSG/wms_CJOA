package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class ReceiveDeliveryDto {
    private String type;  //'입고', '출고'
    private String time;  //입출고 시간
    private int prodOptionCode;
    private int quantity;

    @Override
    public String toString() {
        return String.format(
                "입출고타입: %s | 입출고 시간: %s | 상품옵션코드: %d | 수량 %d",
                type, time, prodOptionCode, quantity
        );
    }
}
