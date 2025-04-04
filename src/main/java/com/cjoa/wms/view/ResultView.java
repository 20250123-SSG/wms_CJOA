package com.cjoa.wms.view;

import com.cjoa.wms.dto.CartDto;

import java.util.List;

public class ResultView {
    public static <T> void displayData(T data) {
        if (data != null) {
            System.out.println(data);
        }else{
            System.out.println("data is null");
        }
    }

    public static <T> void displayData(List<T> data) {
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        }else{
            System.out.println("data is null");
        }
    }

    public static void SuccessView(String type) {
        System.out.println(type + " is Success");
    }

    public static void FailView(String type) {
        System.out.println(type + " is Fail");
    }

    // 장바구니 리스트
    public static void cartProductList(List<CartDto> list){
        if(list.isEmpty()) {
            System.out.println("장바구니가 비어있습니다");
        }else {
            System.out.println("======================================================");
            System.out.println("                        장바구니                      ");
            System.out.println("======================================================");
            int total=0;
            for (CartDto cart : list) {
                System.out.printf("상품명: %s\t색상: %s\t사이즈: %s\t가격: %s원\t수량: %d개\n",
                        cart.getProdName(),
                        cart.getProdColor(),
                        cart.getProdSize(),
                        cart.getProdPrice(),
                        cart.getCartQuantity()
                );
                total += cart.getProdPrice() * cart.getCartQuantity();
            }
            System.out.println("총가격: " + total);
        }
    }
}
