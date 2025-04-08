package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderProdOptionDto {

    private int orderProdOptionCode;
    private int orderCode;
    private int prodOptionCode;
    private int orderProdOptionQuantity;

}
