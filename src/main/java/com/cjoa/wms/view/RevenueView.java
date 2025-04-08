package com.cjoa.wms.view;

import com.cjoa.wms.controller.RevenueController;
import com.cjoa.wms.util.handleDateRangeInput;

import java.util.Scanner;

public class RevenueView {

    Scanner sc = new Scanner(System.in);
    RevenueController revenueController = new RevenueController();

    public void mainView(){
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 판매 금액 조회
                    2. 입고 금액 조회
                    3. 마진 금액 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    >> 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    salesDate();
                    break;
                case "2":
                    purchaseDate();
                    break;
                case "3" :
                    marginDate();
                    break;
                case "0" :
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");

            }
        }
    }
    private void salesDate() {
        handleDateRangeInput.handle((start, end) -> revenueController.calculateTotalSales(start, end));
    }

    private void purchaseDate() {
        handleDateRangeInput.handle((start, end) -> revenueController.calculateTotalPurchaseCost(start, end));
    }

    private void marginDate() {
        handleDateRangeInput.handle((start, end) -> revenueController.calculateTotalMarginCost(start, end));
    }
}
