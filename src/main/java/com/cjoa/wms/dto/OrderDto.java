package com.cjoa.wms.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderDto {

    private int orderCode;
    private int userCode;
    private String orderPayType;
    private int orderPrice;
    private String orderStatus;
    private String orderDate;

    // 제거해도 될듯?


}
