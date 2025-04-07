package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.service.CartService;
import com.cjoa.wms.view.CartView;
import com.cjoa.wms.view.ResultView;

import java.util.List;
import java.util.Map;

public class CartController {

    private CartService cartService = new CartService();
    private CartView cartView = new CartView();

    public void selectCartProductList(int code) {
        List<CartDto> list = cartService.selectCartProductList(code);
        cartView.cartProductList(list);
    }

    public void modifyOptionInCart(Map<String, Integer> requestParam) {
        CartDto cart =CartDto.builder()
                .userCode(requestParam.get("userCode"))
                .prodOptionCode(requestParam.get("optionCode"))
                .cartQuantity(requestParam.get("quantity"))
                .build();

        int result = cartService.modifyOptionInCart(cart);
        if(result > 0) {
            ResultView.SuccessView("수량변경");
        } else {
            ResultView.FailView("수량변경");
        }
    }

    public void deleteCart(Map<String, Integer> requestParam) {
        CartDto cart = CartDto.builder()
                .userCode(requestParam.get("userCode"))
                .prodOptionCode(requestParam.get("optionCode"))
                .build();

        int result = cartService.deleteCart(cart);
        if(result >  0){
            System.out.println("항목 삭제됨");
        }else {
            System.out.println("삭제 실패");
        }
    }
}
