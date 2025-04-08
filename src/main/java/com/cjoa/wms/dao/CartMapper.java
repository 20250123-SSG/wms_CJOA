package com.cjoa.wms.dao;

import com.cjoa.wms.dto.CartDto;

import java.util.List;

public interface CartMapper {

    int insertCart(CartDto cart);
    List<CartDto> selectCartProduct(int code);
    int insertSameProductCart(CartDto cart);
    int checkCartProduct(CartDto cart);
    int modifyCart(CartDto cart);
    int deleteCart(CartDto cart);
    int dropCart(int code);
}
