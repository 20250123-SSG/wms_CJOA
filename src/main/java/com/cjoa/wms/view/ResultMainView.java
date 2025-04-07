package com.cjoa.wms.view;

import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;

import java.util.List;

public class ResultMainView {

    // 상품 리스트 뷰
    public void displayProductList(List<ProductDto> list) {
        if(list.isEmpty()){
            System.out.println("조회된 메뉴가 없습니다😥");
        }else {
            for (ProductDto product : list) {
                System.out.printf("%d\t%d.%s\t%s\t%d원\t%s\n",
                        product.getProdCode(),
                        product.getCategoryCode(),
                        product.getCategoryName(),
                        product.getProdName(),
                        product.getProdPrice(),
                        product.getProdDesc());
            }
        }
    }

    // 상품 상세 정보 뷰
    public void displayProductOptionList(ProductDto product){
        if(product == null){
            System.out.println("없는 메뉴 번호입니다☹");
        }else {
            System.out.print(product.getProdName() + "\t");
            System.out.print(product.getProdPrice());
            System.out.println();

            List<ProductOptionDto> list = product.getProductOptionList();
            int i = 0;
            for (ProductOptionDto option : list) {
                System.out.print(++i +": " + option.getProdColor() + "\t");
                System.out.print(option.getProdSize() + "\t");
                System.out.println();
            }
        }
    }


}
