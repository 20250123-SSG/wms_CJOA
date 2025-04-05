package com.cjoa.wms.view;

import com.cjoa.wms.controller.ReceiveController;
import com.cjoa.wms.controller.RevenueController;
import com.cjoa.wms.util.handleDateRangeInput;

import java.util.Scanner;

public class ReceiveView {

    Scanner sc = new Scanner(System.in);
    ReceiveController receiveController = new ReceiveController();


    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 전체 내역 조회
                    2. 입고 코드로 조회
                    3. 날짜로 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    receiveController.receiveSearchAll();
                    break;
                case "2":
                    receiveController.receiveSearchByCode(receiveCode());
                    break;
                case "3":
                    receiveDate();
                    break;
                case "0":
                    return;
            }
        }
    }
    private int receiveCode(){
        int code = -1;
        while (true) {
            try {
                System.out.println("조회하고자 하는 입고 내역의 코드를 입력해주세요 : ");
                String input = sc.nextLine();
                code = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return code;
    }

    private void receiveDate() {
        handleDateRangeInput.handle((start, end) -> receiveController.receiveSearchByDate(start, end));
    }

}
