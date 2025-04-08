package com.cjoa.wms.view;

import com.cjoa.wms.controller.DeliveryController;
import com.cjoa.wms.util.handleDateRangeInput;

import java.util.Scanner;

public class DeliveryView {
    Scanner sc = new Scanner(System.in);
    DeliveryController deliveryController = new DeliveryController();

    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 전체 내역 조회
                    2. 출고 코드로 조회
                    3. 날짜로 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    >> 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    deliveryController.deliverySearchAll();
                    break;
                case "2":
                    deliveryController.deliverySearchByCode(deliveryCode());
                    break;
                case "3":
                    deliveryDate();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");

            }
        }
    }
    private int deliveryCode(){
        int code = -1;
        while (true) {
            try {
                System.out.print("조회하고자 하는 출고 내역의 코드를 입력해주세요 : ");
                String input = sc.nextLine();
                code = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return code;
    }

    private void deliveryDate() {
        handleDateRangeInput.handle((start, end) -> deliveryController.deliverySearchByDate(start, end));
    }

}
