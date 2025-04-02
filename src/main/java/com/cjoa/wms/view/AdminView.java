package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserController;

import java.util.Scanner;

public class AdminView {

    private UserController userController = new UserController();
    private Scanner sc = new Scanner(System.in);

    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 회원 관리
                    2. 카테고리 관리
                    3. 상품 관리
                    4. 입출고 조회
                    5. 수익 조회
                    0. 로그아웃
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    UserManagerView();
                    break;
                case "2":
//                    CategoryManageView();
                    break;
                case "3":
//                    ProductManageView();
                    break;
                case "4":
//                    StockView();
                    break;
                case "5":
//                    RevenueView();
                    break;
                case "0":
                    return;
            }
        }
    }

    private void UserManagerView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 회원 생성
                    2. 회원 조회
                    3. 회원 수정
                    4. 회원 삭제
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    break;
                case "2":
                    userController.getAllUser();
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    return;
            }
        }
    }
}
