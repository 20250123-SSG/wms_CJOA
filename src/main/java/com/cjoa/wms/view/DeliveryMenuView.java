package com.cjoa.wms.view;

import com.cjoa.wms.controller.DeliveryController;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

import java.util.List;
import java.util.Scanner;

public class DeliveryMenuView {
    Scanner sc = new Scanner(System.in);
    DeliveryController deliveryController = new DeliveryController();

    public void deliveryMenu(){ // 창고관리자 메뉴화면
        while (true) {
            System.out.print("""
                    \n========= 출고관리 =========
                    1. 주문확인 및 출고
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
        System.out.println("\n========= 주문확인 및 출고 =========");
        while (true) {
            // 미출고 주문 리스트 호출
            System.out.println("\n------- 미출고된 주문 목록 -------");
            deliveryController.checkOrderList();

            System.out.print(">> 출고처리할 주문번호 선택: ");
            String code = sc.nextLine();

            // 주문 상세정보 확인
            System.out.println("\n---- 주문번호 " + code + "번 주문 상세정보 ----");
            List<OrderProdOptionDeliveryDto> orderDetail = deliveryController.checkOrderDetail(code);

            // 출고처리
            System.out.println("상품 출고처리 하시겠습니까? (y/n)");
            System.out.print(">> ");
            String out = sc.nextLine().toUpperCase();
            if ("Y".equals(out)) {
                // 출고 테이블 삽입 (삽입시 정보 입력)
                int result = deliveryController.insertDeliveryByOrder(orderDetail);
                if (result > 0) {
                    System.out.println("성공적으로 출고되었습니다.");
                    // 주문테이블 상태 변경 (주문확인 -> 출고완료)

                } else {
                    System.out.println("출고에 실패하였습니다.");
                }
            }
                // 뒤로가기
            System.out.println("상품 출고를 추가로 진행하시겠습니까? (y/n)");
            System.out.print(">> ");
            String menu = sc.nextLine().toUpperCase();
            switch (menu) {
                case "Y": break;
                case "N": return;
            }
        }

    }


}
