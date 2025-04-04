package com.cjoa.wms.view;

import com.cjoa.wms.controller.ReceiveController;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

import java.util.Scanner;

public class ReceiveMenuView {
    Scanner sc = new Scanner(System.in);
    ReceiveController receiveController = new ReceiveController();

    public void receiveMenu(){

        System.out.print("""
                
                ======= 입고관리 =======
                1. 입고
                2. 입고내역 조회
                0. 뒤로가기
                ========================
                >> 메뉴번호 선택:"""
        );
        String menu = sc.nextLine();

        switch (menu) {
            case "1": insertReceive(); break;
            case "2":  break;
            case "0": return;
            default:
                System.out.println("메뉴 번호를 다시 입력해주세요.");
        }
    }

    private void insertReceive() {
        System.out.println("\n======= 입고 =======");

        while (true) {
            System.out.print("입고를 진행할 제품상세번호 입력\n>> ");
            String prodOptionCode = sc.nextLine();

            // 해당상품 조회 후 yes or no
            OrderProdOptionDeliveryDto prodInfo = receiveController.checkProductByOptionCode(prodOptionCode);
            if (prodInfo != null) {
                System.out.print("해당 상품을 입고 하시겠습니까? (y/n)\n>> ");
                String receive = sc.nextLine().toUpperCase();

                if ("Y".equals(receive)) {
                    // 입고수량 입력 후 입고처리 및 재고수량증가 (트랜잭션)
                    System.out.print("입고 수량 입력 >>");
                    String receiveNum = sc.nextLine();
                    System.out.print("상품 원가 입력 >>");
                    String originPrice = sc.nextLine();
                    receiveController.receiveProcess(receiveNum, prodInfo, originPrice);
                }
            }
            System.out.print("\n입고를 계속 진행하시겠습니까? (y/n)\n>> ");
            String menu = sc.nextLine().toUpperCase();
            if (!"Y".equals(menu)) {
                return;
            }
        }

    }
}
