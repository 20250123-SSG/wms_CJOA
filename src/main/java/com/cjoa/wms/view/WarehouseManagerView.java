package com.cjoa.wms.view;

import java.util.Scanner;

public class WarehouseManagerView {
    Scanner sc = new Scanner(System.in);
    DeliveryMenuView deliveryMenuView = new DeliveryMenuView();
    ReceiveMenuView receiveMenuView = new ReceiveMenuView();
    StockMenuView stockMenuView = new StockMenuView();

    public void warehouseMangerMenu(){ // 창고관리자 메뉴화면

        while (true) {
            System.out.print("""
                    \n======= 창고관리자 메뉴 =======
                    1. 입고관리
                    2. 출고관리
                    3. 재고조회
                    0. 로그아웃
                    ===============================
                    >> 메뉴번호 선택:"""
            );
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    receiveMenuView.receiveMenu();
                    break;
                case "2":
                    deliveryMenuView.deliveryMenu();
                    break;
                case "3":
                    stockMenuView.stockMenu();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");
            }
        }
    }
}
