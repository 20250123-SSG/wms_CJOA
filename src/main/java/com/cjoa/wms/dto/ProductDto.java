package com.cjoa.wms.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class ProductDto {

    private int prodCode;
    private int categoryCode;
    private String categoryName;
    private String prodName;
    private int prodPrice;
    private String soldOut;
    private String prodDesc;


    private List<ProductOptionDto> productOptionList;

    @Override
    public String toString() {
        return "상품코드: " + prodCode +
                " | 카테고리코드: " + categoryCode +
                " | 카테고리명: " + categoryName +
                " | 상품명: " + prodName +
                " | 가격: " + prodPrice +
                " | 품절여부: " + soldOut +
                " | 상품설명: " + prodDesc + '\n';
    }

}
