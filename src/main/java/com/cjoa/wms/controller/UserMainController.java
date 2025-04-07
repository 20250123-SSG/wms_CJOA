package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.service.UserMainService;
import com.cjoa.wms.view.ResultMainView;
import com.cjoa.wms.view.ResultView;

import java.util.List;
import java.util.Map;

public class UserMainController {

    private UserMainService userMainService = new UserMainService();
    private ResultMainView resultMainView = new ResultMainView();



    public void selectProductList() {
        List<ProductDto> list =userMainService.selectProductList();
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