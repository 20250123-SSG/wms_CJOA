package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserMainController;

import java.util.Scanner;

public class UserMainView {

    private UserMainController userMainController = new UserMainController();
    private Scanner sc = new Scanner(System.in);

    public void userMainView() {
        while(true){
            System.out.print("""
                    \n=====================
                    1. 검색
                    2. 장바구니
                    3. 구매 내역 조회
                    4. 개인 정보 조회
                    0. EXIT
                    =====================
                    > 입력:""");

            String menu = sc.nextLine();
            switch (menu){
                case "1": new ProductSearchView().productSearchMenu();  break;
                case "2": break;
                case "3": break;
                case "4": break;
                case "0": return;
                default:
                    System.out.println("메뉴 번호를 잘못 입력하셨습니다😥");
            }

        }
    }

    // 상품 상세 옵션 => 장바구니 선택
    public void prodUpdateInCart() {
        while (true){

            System.out.print("1.장바구니\t");
            System.out.print("0.뒤로가기\n");
            System.out.print(">> 메뉴번호입력:");
            String num = sc.nextLine();
            switch (num) {
                case "1": break;
                case "0": return;
            }
        }
    }






}
