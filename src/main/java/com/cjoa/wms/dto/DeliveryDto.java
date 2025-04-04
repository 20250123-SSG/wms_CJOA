package com.cjoa.wms.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DeliveryDto{

    private int deliveryCode;
    private int orderCode;
    private int userCode;
    private String deliveryTime;
    private int prodOptionCode;
    private int deliveryQuantity;
    @Override
    public String toString() {
        return String.format(
                "출고코드: %d | 주문코드: %d | 유저코드: %d | 출고날짜: %s | 상품옵션코드: %d | 출고량: %d",
                deliveryCode, orderCode, userCode, deliveryTime, prodOptionCode, deliveryQuantity
        );
    }







}
