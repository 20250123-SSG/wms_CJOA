package com.cjoa.wms.view;

import com.cjoa.wms.controller.StockController;

import java.util.Scanner;

public class StockMenuView {
    Scanner sc = new Scanner(System.in);
    private StockController stockController = new StockController();

    public void stockMenu() {

        while (true) {
            System.out.print("""
                    \n========= 재고조회 ==========
                    1. 전체 재고 조회
                    2. 상품별 재고 조회
                    0. 뒤로가기
                    =============================
                    >> 메뉴번호 선택:"""
            );
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    stockController.checkAllStock();
                    break;
                case "2":
                    checkStockByProdCode();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다.");
            }

        }
    }

    private void checkStockByProdCode() {
        // 상품리스트 조회가 있으면 좋을까?
        System.out.print("\n======= 상품별 재고 조회 =======\n>> 상품번호입력:");
        String menu = sc.nextLine();
        stockController.checkStockByProdCode(menu);
    }

}
