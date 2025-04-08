package com.cjoa.wms.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CategoryDto {
    private Integer categoryCode;
    private String categoryName;

    @Override
    public String toString() {
        return "카테고리코드: " + categoryCode +
                "| 카테고리명: " + categoryName + '\n';
    }
}
