package com.cjoa.wms.controller;

import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.service.UserMainService;
import com.cjoa.wms.view.ResultMainView;

import java.util.List;

public class UserMainController {

    private UserMainService userMainService = new UserMainService();

    public void selectProductList() {
        List<ProductDto> list =userMainService.selectProductList();
        ResultMainView.displayProductList(list);
    }
}
