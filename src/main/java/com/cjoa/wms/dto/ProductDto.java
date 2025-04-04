package com.cjoa.wms.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class ProductDto {

    private int prodCode;
    private int categoryCode;
    private String categoryName;
    private String prodName;
    private int prodPrice;
    private String soldOut;
    private String prodDesc;


    private List<ProductOptionDto> productOptionDto;

}
