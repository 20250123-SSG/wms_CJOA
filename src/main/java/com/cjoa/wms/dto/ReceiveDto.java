package com.cjoa.wms.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class ReceiveDto {
    private int receiveCode;
    private int userCode;
    private String receiveTime;
    private int prodOptionCode;
    private int receiveQuantity;
    private int originPrice;
    @Override
    public String toString() {
        return String.format(
                "입고코드: %d | 유저코드: %d | 입고날짜: %s | 상품옵션코드: %d | 입고량: %d | 원가: %d",
                receiveCode, userCode, receiveTime, prodOptionCode, receiveQuantity, originPrice
        );
    }




}
