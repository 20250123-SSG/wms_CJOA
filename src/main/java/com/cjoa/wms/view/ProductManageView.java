package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserMainController;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;
import com.cjoa.wms.service.UserMainService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                    productSearchView.productSearchMenu();
                    break;
                case "3":
//                    updateProductView();
                    break;
                case "4":
//                    deleteProductView();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("wrong menu, input again");
                    break;
            }
        }
    }

    public void addProductView() {
        System.out.print("categoryCode: ");
        String categoryCode = sc.nextLine();
        System.out.print("productName: ");
        String productName = sc.nextLine();
        System.out.print("price: ");
        String price = sc.nextLine();
        System.out.print("품절유무(Y/N): ");
        String yesOrNo = sc.nextLine().toUpperCase();
        if (!yesOrNo.equals("Y")) {
            yesOrNo = "N";
        }
        System.out.print("description: ");
        String description = sc.nextLine();
        ProductDto productDto = new ProductDto().builder()
                .categoryCode(Integer.parseInt(categoryCode))
                .prodName(productName)
                .prodPrice(Integer.parseInt(price))
                .soldOut(yesOrNo)
                .build();
        List<ProductOptionDto> productOptionDtoList = new ArrayList<>();
        while (true) {
            System.out.print("size: ");
            String size = sc.nextLine();
            System.out.print("color: ");
            String color = sc.nextLine();
            String optionyesOrNo = sc.nextLine().toUpperCase();
            if (!optionyesOrNo.equals("Y")) {
                optionyesOrNo = "N";
            }
            ProductOptionDto productOptionDto = new ProductOptionDto().builder()
                    .prodSize(size)
                    .prodColor(color)
                    .optionSoldOut(optionyesOrNo)
                    .build();
            productOptionDtoList.add(productOptionDto);
            System.out.print("더 입력하시겠습니까?: ");
            String input = sc.nextLine().toUpperCase();
            if (!input.equals("Y")) {
                break;
            }
        }
//        productDto.setProductOptionDto(productOptionDtoList);
    }
}
