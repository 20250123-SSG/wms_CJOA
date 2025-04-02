package com.cjoa.wms.view;

import com.cjoa.wms.dto.ProductDto;

import java.util.List;

public class ResultMainView {

    public static void displayProductList(List<ProductDto> list) {
        if(list.isEmpty()){
            System.out.println("조회된 메뉴가 없습니다😥");
        }else {
            for (ProductDto product : list) {
                System.out.printf("%d\t%s\t%s\t%d원\t%s\t%s\n",
                        product.getProdCode(),
                        product.getCategoryName(),
                        product.getProdName(),
                        product.getProdPrice(),
                        product.getSoldOut(),
                        product.getProdDesc());
            }
        }
    }
}
