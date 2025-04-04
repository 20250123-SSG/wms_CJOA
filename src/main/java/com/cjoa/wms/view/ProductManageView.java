package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserMainController;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;
import com.cjoa.wms.service.UserMainService;

import java.util.*;

public class ProductManageView {
    Scanner sc = new Scanner(System.in);
    ProductSearchView productSearchView = new ProductSearchView();
    UserMainController userMainController = new UserMainController();

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
                    addProductView();
                    break;
                case "2":
                    productSearchView.selectAllProductByAdmin();
                    break;
                case "3":
                    updateProductMenuView();
                    break;
                case "4":
                    deleteProductView();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("wrong menu, input again");
                    break;
            }
        }
    }

    private void deleteProductView() {
        System.out.print("삭제 상품 코드 입력: ");
        String productId = sc.nextLine();
        userMainController.deleteProduct(Integer.parseInt(productId));
    }

    private void updateProductMenuView() {
        while(true) {
            System.out.print("""
                    \n===============================
                    1. 상품 수정
                    2. 상품 옵션 수정
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    updateProductView();
                    break;
                case "2":
                    updateProductOptionView();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴를 잘못 입력하셨습니다, 다시 입력해주세요");
                    break;
            }
        }
    }

    private void updateProductOptionView() {
        System.out.print("수정할 제품 코드: ");
        String code = sc.nextLine();
        System.out.print("사이즈: ");
        String size = sc.nextLine();
        System.out.print("색상: ");
        String color = sc.nextLine();
        System.out.print("품절 여부 (Y/N): ");
        String optionyesOrNo = sc.nextLine().toUpperCase();

        if (!optionyesOrNo.equals("Y")) {
            optionyesOrNo = "N";
        }

        Map<String, Object> productOptionMap = new HashMap<>();
        productOptionMap.put("prodCode", Integer.parseInt(code));
        productOptionMap.put("prodSize", size);
        productOptionMap.put("prodColor", color);
        productOptionMap.put("optionSoldOut", optionyesOrNo);

        userMainController.updateProductOption(productOptionMap);
    }

    private void updateProductView() {
        System.out.print("수정할 제품 코드: ");
        String prodCode = sc.nextLine();
        System.out.print("카테고리 코드: ");
        String categoryCode = sc.nextLine();
        System.out.print("제품 이름: ");
        String productName = sc.nextLine();
        System.out.print("가격: ");
        String price = sc.nextLine();
        System.out.print("품절 여부 (Y/N): ");
        String yesOrNo = sc.nextLine().toUpperCase();
        System.out.print("설명: ");
        String description = sc.nextLine();

        Map<String, Object> productMap = new HashMap<>();
        productMap.put("prodCode", Integer.parseInt(prodCode));
        productMap.put("categoryCode", Integer.parseInt(categoryCode));
        productMap.put("prodName", productName);
        productMap.put("prodPrice", Integer.parseInt(price));
        productMap.put("soldOut", yesOrNo.equals("Y") ? "Y" : "N");
        productMap.put("description", description);

        userMainController.updateProduct(productMap);
    }

    public void addProductView() {
        System.out.print("카테고리 코드: ");
        String categoryCode = sc.nextLine();
        System.out.print("제품 이름: ");
        String productName = sc.nextLine();
        System.out.print("가격: ");
        String price = sc.nextLine();
        System.out.print("품절 여부 (Y/N): ");
        String yesOrNo = sc.nextLine().toUpperCase();
        System.out.print("설명: ");
        String description = sc.nextLine();

        Map<String, Object> productMap = new HashMap<>();
        productMap.put("categoryCode", Integer.parseInt(categoryCode));
        productMap.put("prodName", productName);
        productMap.put("prodPrice", Integer.parseInt(price));
        productMap.put("soldOut", yesOrNo.equals("Y") ? "Y" : "N");
        productMap.put("prodDesc", description);

        List<Map<String, Object>> productOptionList = new ArrayList<>();
        while (true) {
            System.out.println("======================");
            System.out.println("옵션 입력");
            System.out.print("사이즈: ");
            String size = sc.nextLine();
            System.out.print("색상: ");
            String color = sc.nextLine();
            System.out.print("옵션 품절 여부 (Y/N): ");
            String optionYesOrNo = sc.nextLine().toUpperCase();

            Map<String, Object> productOptionMap = new HashMap<>();
            productOptionMap.put("prodCode", productMap.get("prodCode"));
            productOptionMap.put("prodSize", size);
            productOptionMap.put("prodColor", color);
            productOptionMap.put("optionSoldOut", optionYesOrNo.equals("Y") ? "Y" : "N");

            productOptionList.add(productOptionMap);

            System.out.print("더 입력하시겠습니까? (Y/N): ");
            String input = sc.nextLine().toUpperCase();
            if (!input.equals("Y")) {
                System.out.println("======================");
                break;
            }
        }

        productMap.put("productOptionList", productOptionList);
        userMainController.addProduct(productMap);
    }
}
