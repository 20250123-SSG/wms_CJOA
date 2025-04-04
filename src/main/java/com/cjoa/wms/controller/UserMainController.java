package com.cjoa.wms.controller;

import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;
import com.cjoa.wms.service.UserMainService;
import com.cjoa.wms.view.ResultMainView;

import java.util.List;
import java.util.Map;

import static com.cjoa.wms.view.ResultView.FailView;
import static com.cjoa.wms.view.ResultView.SuccessView;

public class UserMainController {

    private UserMainService userMainService = new UserMainService();

    public void selectProductList() {
        List<ProductDto> list =userMainService.selectProductList();
        ResultMainView.displayProductList(list);
    }

    public void selectProductListByAdmin() {
        List<ProductDto> list =userMainService.selectProductListByAdmin();
        ResultMainView.displayProductList(list);
    }

    public void selectProductListByCategoryCode(String code) {
        List<ProductDto> list = userMainService.selectProductListByCategoryCode(Integer.parseInt(code));
        ResultMainView.displayProductList(list);
    }

    public void selectProductListByKeyword(String key) {
        List<ProductDto> list = userMainService.selectProductListByKeyword(key);
        ResultMainView.displayProductList(list);
    }

    public void selectProductOptionByProdCode(String code) {
        ProductDto prod = userMainService.selectProductOptionListByProdCode(Integer.parseInt(code));
        ResultMainView.displayProductOptionList(prod);
    }

    public void addProduct(ProductDto productDto) {
        if (!productDto.getSoldOut().equals("Y")) {
            productDto.setSoldOut("N");
        }
        List<ProductOptionDto> list = productDto.getProductOptionList();
        for (int i = 0; i < list.size(); i++) {
            ProductOptionDto productOptionDto = list.get(i);
            if(!productOptionDto.getOptionSoldOut().equals("Y")) {
                productOptionDto.setOptionSoldOut("N");
            }
            list.set(i, productOptionDto);
        }
        productDto.setProductOptionList(list);
        int result = userMainService.addProduct(productDto);
    }

    public void updateProduct(Map<String, Object> productMap) {
        // 입력값 검증
        if (productMap.get("prodCode") == null ||
                productMap.get("categoryCode") == null ||
                productMap.get("prodName") == null ||
                productMap.get("prodPrice") == null ||
                productMap.get("soldOut") == null ||
                productMap.get("description") == null) {
            throw new IllegalArgumentException("모든 필드를 올바르게 입력해야 합니다.");
        }

        // 모델에 담기
        ProductDto productDto = ProductDto.builder()
                .prodCode((Integer) productMap.get("prodCode"))
                .categoryCode((Integer) productMap.get("categoryCode"))
                .prodName((String) productMap.get("prodName"))
                .prodPrice((Integer) productMap.get("prodPrice"))
                .soldOut((String) productMap.get("soldOut"))
                .prodDesc((String) productMap.get("description")) // 설명 추가
                .build();

        userMainService.updateProduct(productDto);
    }


    public void updateProductOption(Map<String, Object> productOptionMap) {
        if (productOptionMap.get("prodCode") == null ||
                productOptionMap.get("prodSize") == null ||
                productOptionMap.get("prodColor") == null ||
                productOptionMap.get("optionSoldOut") == null) {
            throw new IllegalArgumentException("모든 필드를 올바르게 입력해야 합니다.");
        }

        ProductOptionDto productOptionDto = ProductOptionDto.builder()
                .prodCode((Integer) productOptionMap.get("prodCode"))
                .prodSize((String) productOptionMap.get("prodSize"))
                .prodColor((String) productOptionMap.get("prodColor"))
                .optionSoldOut((String) productOptionMap.get("optionSoldOut"))
                .build();

        userMainService.updateProductOption(productOptionDto);
    }


    public void deleteProduct(int code) {
        int result = userMainService.deleteProduct(code);
    }
}
