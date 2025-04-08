package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserMainController;
import com.cjoa.wms.dto.ProductDto;

import java.util.Scanner;

public class ProductSearchView {

    private UserMainController userMainController = new UserMainController();
    private Scanner sc = new Scanner(System.in);

    public void productSearchMenu(){
        UserMainView userMainView = new UserMainView();


        System.out.print("""
                \n=============================
                1. 상품 목록 조회
                2. 카테고리 코드로 상품 조회
                3. 상품 키워드 검색
                0. 뒤로가기
                =============================
                >> 입력:"""
        );
        String menu = sc.nextLine();

        switch (menu){
            case "1": selectAllProduct(); break;
            case "2": selectProductByCategory(); break;
            case "3": selectProductByKeyword(); break;
            case "0": userMainView.userMainView();
            default:
                System.out.println("메뉴 번호를 잘못 입력하셨습니다😥");
        }

    }

    public String inputCode(String type){
        System.out.printf("\n>> %s 입력: ", type);
        return sc.nextLine();
    }

    // 상품 조회
    public void selectAllProduct(){
        userMainController.selectProductList();
        prodOptionView(1);
    }

    public void selectAllProductByAdmin(){
        userMainController.selectProductListByAdmin();

        prodOptionViewByAdmin();
    }

    // 카테고리 조회
    public void selectProductByCategory(){
        userMainController.selectProductListByCategoryCode(inputCode("카테고리코드"));
        prodOptionView(2);
    }

    // 키워드 조회
    public void selectProductByKeyword() {
        userMainController.selectProductListByKeyword(inputCode("키워드"));
        prodOptionView(3);
    }

    // 상품 상세 정보 조회
    public void prodOptionView(int flag) {
        System.out.print("""
                \n=========================================================================
                상세 정보를 보고 싶은 상품 번호를 입력하세요 (0을 입력하면 돌아갑니다)
                =========================================================================
                >> 입력:"""
        );
        String code = sc.nextLine();

        if (code.equals("0")) {
            productSearchMenu();// 0을 입력하면 돌아갑니다.
        }else {
            ProductDto product = userMainController.selectProductOptionByProdCode(code);
            new UserMainView().prodUpdateInCart(product, flag);
        }

    }

    public void prodOptionViewByAdmin() {
        System.out.print("""
                \n=========================================================================
                상세 정보를 보고 싶은 상품 번호를 입력하세요 (0을 입력하면 돌아갑니다)
                =========================================================================
                >> 입력:"""
        );
        String code = sc.nextLine();

        if (code.equals("0")) {
            return;
        } else {
            userMainController.selectProductOptionByProdCode(code);

        }

    }


}
