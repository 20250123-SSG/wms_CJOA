package com.cjoa.wms.view;

import java.util.Scanner;

public class StockView {
    Scanner sc = new Scanner(System.in);
    private ReceiveView receiveView = new ReceiveView();
    private DeliveryView deliveryView = new DeliveryView();
    private ReceiveDeliveryView receiveDeliveryView = new ReceiveDeliveryView();


    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 입고 조회
                    2. 출고 조회
                    3. 입출고 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    >> 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    receiveView.mainView();
                    break;
                case "2":
                    deliveryView.mainView();
                    break;
                case "3":
                    receiveDeliveryView.mainView();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");


            }

        }

    }
    }