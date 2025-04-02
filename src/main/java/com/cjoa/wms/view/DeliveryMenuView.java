package com.cjoa.wms.view;

import com.cjoa.wms.controller.DeliveryController;

import java.util.Scanner;

public class DeliveryMenuView {
    Scanner sc = new Scanner(System.in);
    DeliveryController deliveryController = new DeliveryController();

    public void deliveryMenu(){ // 창고관리자 메뉴화면
        while (true) {
            System.out.print("""
                    \n========= 출고관리 =========
                    1. 출고처리
                    2. 출고내역조회
                    0. 뒤로가기
                    ============================
                    >> 메뉴번호 선택:"""
            );
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    checkOrderList();
                    break;
                case "2": /*승주님이 만드시는 내역조회 호출?*/
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");
            }
        }
    }

    public void checkOrderList(){
        System.out.println("\n========= 출고처리 =========");
        System.out.println("---- 미출고된 주문 목록 ----");
        deliveryController.checkOrderList();
        System.out.print(">> 출고처리할 주문번호 선택: ");
        String code = sc.nextLine();

    }


}
