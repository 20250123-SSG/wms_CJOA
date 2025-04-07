package com.cjoa.wms.view;

import com.cjoa.wms.controller.CartController;
import com.cjoa.wms.controller.UserController;
import com.cjoa.wms.controller.UserMainController;
import com.cjoa.wms.dto.ProductDto;

import java.util.Map;
import java.util.Scanner;

import static com.cjoa.wms.view.LoginView.userCode;

public class UserMainView {

    private UserMainController userMainController = new UserMainController();
    private CartController cartController = new CartController();
    private Scanner sc = new Scanner(System.in);
    private UserController userController = new UserController();

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
                case "2": cartController.selectCartProductList(userCode); break;
                case "3": break;
                case "4": userController.getUserByUserCode(userCode); break;
                case "0": return;
                default:
                    System.out.println("메뉴 번호를 잘못 입력하셨습니다😥");
            }

        }
    }




    // 상품 상세 옵션 => 장바구니 선택
    public void prodUpdateInCart(ProductDto product, int flag) {
        ProductSearchView productSearchView = new ProductSearchView();
        System.out.print("""
                \n=========================================================================
                장바구니에 담을 옵션 선택(0을 입력하면 돌아갑니다)
                =========================================================================
                """
        );
        String answer = sc.nextLine();

        if (answer.equals("0")) {
            switch (flag){
                case 1: productSearchView.selectAllProduct(); break;
                case 2: productSearchView.selectProductByCategory(); break;
                case 3: productSearchView.selectProductByKeyword(); break;
            }

        } else {


            int optionCode = product.getProductOptionList().get(Integer.parseInt(answer)-1).getProdOptionCode();

            System.out.println("수량 입력:");
            String quantity = sc.nextLine();
            Map<String, Integer> requestParam = Map.of(
                    "optionCode", optionCode,
                    "userCode", userCode,
                    "quantity", Integer.parseInt(quantity)
            );
            userMainController.insertCart(requestParam);

        }
    }






}
