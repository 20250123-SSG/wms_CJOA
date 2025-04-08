package com.cjoa.wms.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductOptionDto {

    private int prodOptionCode;
    private int prodCode;
    private String prodSize;
    private String prodColor;
    private String optionSoldOut;
    private int quantity;

    @Override
    public String toString() {
        return "옵션코드: " + prodOptionCode +
                " | 상품코드: " + prodCode +
                " | 사이즈: " + prodSize +
                " | 색상: " + prodColor +
                " | 품절여부: " + optionSoldOut +
                " | 수량: " + quantity + '\n';
    }

}
