package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProductOptionDto {

    private int prodOptionCode;
    private String prodSize;
    private String prodColor;
    private String optionSoldOut;
    private int quantity;

}
