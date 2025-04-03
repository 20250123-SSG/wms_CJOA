package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class OrderProdOptionDeliveryDto {

    private int orderProdOptionCode;
    private int orderCode;
    private int prodCode;
    private int prodOptionCode;
    private String prodName;
    private String prodSize;
    private String prodColor;
    private int orderProdOptionQuantity; // 구매수량
    private int stockQuantity; // 재고수량

    private int userCode;

}
