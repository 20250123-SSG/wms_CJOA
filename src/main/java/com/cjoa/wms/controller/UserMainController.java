package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;
import com.cjoa.wms.service.UserMainService;
import com.cjoa.wms.view.ResultMainView;
import com.cjoa.wms.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map;

import static com.cjoa.wms.view.ResultView.FailView;
import static com.cjoa.wms.view.ResultView.SuccessView;


public class UserMainController {

    private UserMainService userMainService = new UserMainService();
    private ResultMainView resultMainView = new ResultMainView();



    public void selectProductList() {
        List<ProductDto> list =userMainService.selectProductList();
        resultMainView.displayProductList(list);
    }

    public void selectProductListByAdmin() {
        List<ProductDto> list =userMainService.selectProductListByAdmin();
        resultMainView.displayProductList(list);
    }

    public void selectProductListByCategoryCode(String code) {
        List<ProductDto> list = userMainService.selectProductListByCategoryCode(Integer.parseInt(code));
        resultMainView.displayProductList(list);
    }

    public void selectProductListByKeyword(String key) {
        List<ProductDto> list = userMainService.selectProductListByKeyword(key);
        resultMainView.displayProductList(list);
    }

    public ProductDto selectProductOptionByProdCode(String code) {
        ProductDto prod = userMainService.selectProductOptionListByProdCode(Integer.parseInt(code));
        resultMainView.displayProductOptionList(prod);
        return prod;
    }

    public void addProduct(Map<String, Object> productMap) {
        if (productMap.get("categoryCode") == null ||
                productMap.get("prodName") == null ||
                productMap.get("prodPrice") == null ||
                productMap.get("soldOut") == null ||
                productMap.get("prodDesc") == null) {
            throw new IllegalArgumentException("모든 필드를 올바르게 입력해야 합니다.");
        }

        ProductDto productDto = ProductDto.builder()
                .categoryCode((Integer) productMap.get("categoryCode"))
                .prodName((String) productMap.get("prodName"))
                .prodPrice((Integer) productMap.get("prodPrice"))
                .soldOut((String) productMap.get("soldOut"))
                .prodDesc((String) productMap.get("prodDesc"))
                .build();

        List<Map<String, Object>> optionList = (List<Map<String, Object>>) productMap.get("productOptionList");
        List<ProductOptionDto> productOptionDtoList = new ArrayList<>();

        for (Map<String, Object> optionMap : optionList) {
            ProductOptionDto productOptionDto = ProductOptionDto.builder()
                    .prodCode(productDto.getProdCode()) // prodCode는 나중에 설정해야 함
                    .prodSize((String) optionMap.get("prodSize"))
                    .prodColor((String) optionMap.get("prodColor"))
                    .optionSoldOut((String) optionMap.get("optionSoldOut"))
                    .build();
            productOptionDtoList.add(productOptionDto);
        }

        productDto.setProductOptionList(productOptionDtoList);

        if (!productDto.getSoldOut().equals("Y")) {
            productDto.setSoldOut("N");
        }

        for (ProductOptionDto option : productOptionDtoList) {
            if (!option.getOptionSoldOut().equals("Y")) {
                option.setOptionSoldOut("N");
            }
        }

        userMainService.addProduct(productDto);
    }


    public void updateProduct(Map<String, Object> productMap) {
        if (productMap.get("prodCode") == null ||
                productMap.get("categoryCode") == null ||
                productMap.get("prodName") == null ||
                productMap.get("prodPrice") == null ||
                productMap.get("soldOut") == null ||
                productMap.get("description") == null) {
            throw new IllegalArgumentException("모든 필드를 올바르게 입력해야 합니다.");
        }

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

    public void insertCart(Map<String, Integer> requestParam) {
        CartDto cart = CartDto.builder()
                .prodOptionCode( (requestParam.get("optionCode")) )
                .userCode( requestParam.get("userCode") )
                .cartQuantity( requestParam.get("quantity") )
                .build();

        int result = userMainService.insertCart(cart);
        if(result > 0) {
            ResultView.SuccessView("장바구니등록");
        } else {
            ResultView.FailView("장바구니등록");
        }
    }
  
}

