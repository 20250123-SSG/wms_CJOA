package com.cjoa.wms.view;

import com.cjoa.wms.controller.CartController;
import com.cjoa.wms.dto.CartDto;

import java.util.*;

import static com.cjoa.wms.view.LoginView.userCode;

public class CartView {


    // 장바구니 리스트
    public void cartProductList(List<CartDto> list){

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
            System.out.println("\n1. 항목수정,삭제 \t2. 구매하기 \t0. 뒤로가기");
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

    public void modifyOptionInCart(List<CartDto> list){
        Scanner sc = new Scanner(System.in);
        CartController cartController = new CartController();

        System.out.println("변경할 옵션 번호 입력: ");
        String code = sc.nextLine();
        int optionCode = list.get(Integer.parseInt(code)-1).getProdOptionCode();
        System.out.println("변경할 수량 입력(수량을 0으로 변경시 삭제됩니다.): ");
        String quantity = sc.nextLine();

        Map<String, Integer> requestParam = new HashMap<>();
        requestParam.put("userCode", userCode);
        requestParam.put("optionCode", optionCode);

        if(quantity.equals("0")){
            cartController.deleteCart(requestParam);
        } else {
            requestParam.put("quantity", Integer.parseInt(quantity));
            cartController.modifyOptionInCart(requestParam);
        }

    }



}
