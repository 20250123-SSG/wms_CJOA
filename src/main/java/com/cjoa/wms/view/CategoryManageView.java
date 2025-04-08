package com.cjoa.wms.view;

import com.cjoa.wms.controller.CategoryController;
import com.cjoa.wms.dto.CategoryDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CategoryManageView {

    private Scanner sc = new Scanner(System.in);
    private CategoryController categoryController = new CategoryController();

    public void mainView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 카테고리 생성
                    2. 카테고리 조회
                    3. 카테고리 수정
                    4. 카테고리 삭제
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    >> 입력:""");
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    categoryController.addCategory(addCategoryForm());
                    break;
                case "2":
                    categoryController.getAllCategory();
                    break;
                case "3":
                    categoryController.updateCategoryByCode(inputCategoryCode());
                    break;
                case "4":
                    categoryController.deleteCategoryByCode(inputDeleteCategoryCode());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("메뉴 번호를 다시 입력해주세요.");

            }
        }
    }

    private Map<String, Object> addCategoryForm() {
        System.out.print("카테고리명 입력: ");
        String categoryName = sc.nextLine();

        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("categoryName", categoryName);

        return categoryMap;
    }

    private Map<String, Object> inputCategoryCode() {
        System.out.print("수정을 원하는 카테고리의 코드를 입력해주세요: ");
        String code = sc.nextLine();

        Map<String, Object> categoryMap = addCategoryForm();
        categoryMap.put("categoryCode", Integer.parseInt(code));

        return categoryMap;
    }

    private String inputDeleteCategoryCode() {
        System.out.print("삭제를 원하는 카테고리의 코드를 입력해주세요: ");
        return sc.nextLine();
    }
}
