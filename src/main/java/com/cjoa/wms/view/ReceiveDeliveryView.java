package com.cjoa.wms.view;

import com.cjoa.wms.controller.ReceiveDeliveryController;
import com.cjoa.wms.util.handleDateRangeInput;

import java.util.Scanner;

public class ReceiveDeliveryView {

    Scanner sc = new Scanner(System.in);
    ReceiveDeliveryController receiveDeliveryController = new ReceiveDeliveryController();

    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 전체 내역 조회
                    2. 날짜로 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    >> 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    receiveDeliveryController.receiveDeliverySearchAll();
                    break;
                case "2":
                    receiveDeliveryDate();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");

            }
        }
    }

    private void receiveDeliveryDate() {
        handleDateRangeInput.handle((start, end) -> receiveDeliveryController.receiveDeliverySearchByDate(start, end));
    }


}
