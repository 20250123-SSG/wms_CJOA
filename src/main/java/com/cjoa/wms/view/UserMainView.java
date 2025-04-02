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
                1. 상품 목록 조회
                2. 카테고리 상품 조회
                3. 상품 검색
                4. 장바구니
                5. 구매 내역 조회
                6. 개인 정보 조회
                7. EXIT
                =====================
                > 입력:""");

        String menu = sc.nextLine();
        switch (menu){
            case "1": break;
            case "2": break;
            case "3": break;
            case "4": break;
            case "5": break;
            case "6": break;
            case "7": break;
            default:
                System.out.println("메뉴 번호를 잘못 입력하셨습니다😥");
        }


    }
}


}
