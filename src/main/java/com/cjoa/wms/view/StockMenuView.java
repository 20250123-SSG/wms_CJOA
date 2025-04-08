package com.cjoa.wms.view;

import com.cjoa.wms.controller.StockController;

import java.util.Scanner;

public class StockMenuView {
    Scanner sc = new Scanner(System.in);
    private StockController stockController = new StockController();

    public void stockMenu() {

        while (true) {
            System.out.print("""
                    \n=============================
                    1. 전체 재고 조회
                    2. 상품별 재고 조회
                    0. 뒤로가기
                    =============================
                    >> 입력:"""
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
                    System.out.println("메뉴 번호를 다시 입력해주세요.");
            }

        }
    }

    private void checkStockByProdCode() {
        System.out.print("\n======= 상품별 재고 조회 =======\n>> 입력:");
        String menu = sc.nextLine();
        stockController.checkStockByProdCode(menu);
    }

}
