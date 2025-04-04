package com.cjoa.wms.view;

import com.cjoa.wms.controller.CartController;
import com.cjoa.wms.dto.CartDto;

import java.util.List;
import java.util.Scanner;

public class CartView {

    private CartController cartController  = new CartController();

    // 장바구니 리스트
    public static void cartProductList(List<CartDto> list){

        Scanner sc = new Scanner(System.in);
        if(list.isEmpty()) {
            System.out.println("장바구니가 비어있습니다");
        }else {
            System.out.println("======================================================");
            System.out.println("                        장바구니                      ");
            System.out.println("======================================================");
            int total=0;
            int i = 0;
            for (CartDto cart : list) {
                System.out.printf("%d. 상품명: %s\t색상: %s\t사이즈: %s\t가격: %s원\t수량: %d개\n",
                        ++i,
                        cart.getProdName(),
                        cart.getProdColor(),
                        cart.getProdSize(),
                        cart.getProdPrice(),
                        cart.getCartQuantity()
                );
                total += cart.getProdPrice() * cart.getCartQuantity();
            }
            System.out.println("\n총가격: " + total);
            System.out.println("\n1. 옵션수정 \t2. 구매하기 \t0. 뒤로가기");
            String menu = sc.nextLine();
            switch (menu){
                case "1" : modifyOptionInCart(list); break;
                case "2" : /* 구매하기 기능 추가*/break;
                case "0" : new UserMainView().userMainView();
                default:
                    System.out.println("메뉴 번호를 잘못누르셨습니다.");
            }

        }
    }

    public static void modifyOptionInCart(List<CartDto> list ){
        Scanner sc = new Scanner(System.in);

        System.out.println("수정할 상품번호 선택: ");
        String num = sc.nextLine();
        // num -1 번째 리스트 상품의 색상,사이즈, 수량 수정
    }



}
