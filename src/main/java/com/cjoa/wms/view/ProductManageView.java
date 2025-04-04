package com.cjoa.wms.view;

import java.util.Scanner;

public class ProductManageView {
    Scanner sc = new Scanner(System.in);
    ProductSearchView productSearchView = new ProductSearchView();
    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 상품 생성
                    2. 상품 조회
                    3. 상품 수정
                    4. 상품 삭제
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    categoryController.addCategory(addCategoryForm());
                    break;
                case "2":
                    productSearchView.productSearchMenu();
                    break;
                case "3":
                    categoryController.updateCategoryByCode(inputCategoryCode());
                    break;
                case "4":
                    categoryController.deleteCategoryByCode(inputDeleteCategoryCode());
                    break;
                case "0":
                    return;
            }
        }
    }
}
