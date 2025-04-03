package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class DeliveryDto {

    private int deliveryCode;
    private int orderCode;
    private int userCode;
    private String deliveryTime;
    private int prodOptionCode;
    private int deliveryQuantity;

}
