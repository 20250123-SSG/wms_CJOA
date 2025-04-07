package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CartDto {

    private int prodOptionCode;
    private int userCode;
    private int cartQuantity;
    private String cartDatetime;
    private String prodName;
    private String prodColor;
    private String prodSize;
    private int prodPrice;
    private int prodCode;


}
