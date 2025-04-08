package com.cjoa.wms.view;

import com.cjoa.wms.controller.*;
import com.cjoa.wms.dto.CategoryDto;
import com.cjoa.wms.dto.UserDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AdminView {

    private Scanner sc = new Scanner(System.in);

    private ProductManageView productManageView = new ProductManageView();
    private CategoryManageView categoryManageView = new CategoryManageView();
    private UserManageView userManageView = new UserManageView();
    private StockView stockview = new StockView();
    private RevenueView revenueView = new RevenueView();

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
                    >> 입력: """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    userManageView.mainView();
                    break;
                case "2":
                    categoryManageView.mainView();
                    break;
                case "3":
                    productManageView.mainView();
                    break;
                case "4":
                    stockview.mainView();
                    break;
                case "5":
                    revenueView.mainView();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");

            }
        }
    }


}
