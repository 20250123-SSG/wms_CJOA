package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.service.CartService;
import com.cjoa.wms.view.CartView;

import java.util.List;

public class CartController {

    private CartService cartService = new CartService();

    public void selectCartProductList(int code) {
        List<CartDto> list = cartService.selectCartProductList(code);
        CartView.cartProductList(list);
    }
}
