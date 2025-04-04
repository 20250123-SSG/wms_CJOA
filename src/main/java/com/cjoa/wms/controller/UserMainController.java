package com.cjoa.wms.controller;

import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.service.UserMainService;
import com.cjoa.wms.view.ResultMainView;

import java.util.List;

import static com.cjoa.wms.view.ResultView.FailView;
import static com.cjoa.wms.view.ResultView.SuccessView;

public class UserMainController {

    private UserMainService userMainService = new UserMainService();

    public void selectProductList() {
        List<ProductDto> list =userMainService.selectProductList();
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
        List<ProductDto> list = userMainService.selectProductOptionListByProdCode(Integer.parseInt(code));
        ResultMainView.displayProductOptionList(list);
    }

    public void addProduct(ProductDto productDto) {
        int result = userMainService.addProduct(productDto);
    }
}
