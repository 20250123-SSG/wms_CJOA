package com.cjoa.wms.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class CategoryDto {
    private Integer categoryCode;
    private String categoryName;
}
