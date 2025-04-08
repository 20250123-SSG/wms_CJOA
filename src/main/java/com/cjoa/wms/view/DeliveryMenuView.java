package com.cjoa.wms.view;

import com.cjoa.wms.controller.DeliveryController;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;

import java.util.List;
import java.util.Scanner;

import static com.cjoa.wms.view.LoginView.userCode;

public class DeliveryMenuView {
    Scanner sc = new Scanner(System.in);
    private DeliveryController deliveryController = new DeliveryController();
    private DeliveryView deliveryView = new DeliveryView();

    public void deliveryMenu(){ // 창고관리자 메뉴화면

        while (true) {
            System.out.print("""
                    \n============================
                    1. 주문확인 및 출고
                    2. 출고내역조회
                    0. 뒤로가기
                    ============================
                    >> 입력:"""
            );
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    checkOrderList();
                    break;
                case "2":
                    deliveryView.mainView();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");
            }
        }
    }

    private void checkOrderList(){
        System.out.println("\n========= 주문확인 및 출고 =========");
        while (true) {
            // 미출고 주문 리스트 호출
            System.out.println("\n------- 미출고된 주문 목록 -------");
            deliveryController.checkOrderList();

            System.out.print(">> 출고처리할 주문번호 선택: ");
            String orderCode = sc.nextLine();

            // 주문 상세정보 확인
            System.out.println("\n---- 주문번호 " + orderCode + "번 주문 상세정보 ----");
            List<OrderProdOptionDeliveryDto> orderDetail = deliveryController.checkOrderDetail(orderCode);

            // 주문번호를 정확히 입력했을 경우 출고처리확인
            if (!orderDetail.isEmpty()) {
                System.out.println("상품 출고처리 하시겠습니까? (y/n)");
                System.out.print(">> 입력:");
                String out = sc.nextLine().toUpperCase();

                if ("Y".equals(out)) {
                    // 출고 테이블 삽입, 주문테이블 상태 변경, 재고 수량 감소 (트랜잭션)
                    deliveryController.productDeliveryProcess(orderDetail, userCode, orderCode);
                }
            }

            System.out.println("\n상품 출고를 추가로 진행하시겠습니까? (y/n)");
            System.out.print(">> 입력:");
            String menu = sc.nextLine().toUpperCase();
            switch (menu) {
                case "Y": break;
                case "N": return;
            }
        }

    }


}
