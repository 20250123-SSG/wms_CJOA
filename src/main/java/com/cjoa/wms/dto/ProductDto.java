package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ProductDto {

    private int prodCode;
    private String categoryName;
    private String prodName;
    private int prodPrice;
    private String soldOut;
    private String prodDesc;
}
