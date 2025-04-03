package com.cjoa.wms.view;

import com.cjoa.wms.controller.CategoryController;
import com.cjoa.wms.controller.UserController;
import com.cjoa.wms.dto.CategoryDto;
import com.cjoa.wms.dto.UserDto;

import java.util.Scanner;

public class AdminView {

    private UserController userController = new UserController();
    private Scanner sc = new Scanner(System.in);
    private CategoryController categoryController = new CategoryController();

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
                    CategoryManageView();
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

    private void CategoryManageView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 카테고리 생성
                    2. 카테고리 조회
                    3. 카테고리 수정
                    4. 카테고리 삭제
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
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
                    userController.addUser(addUserForm());
                    break;
                case "2":
                    userController.getAllUser();
                    break;
                case "3":
                    userController.updateUserByCode(inputCode());
                    break;
                case "4":
                    userController.deleteUserByCode(inputDeleteCode());
                    break;
                case "0":
                    return;
            }
        }
    }

    private UserDto inputCode() {
        System.out.print("수정을 원하는 유저의 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        UserDto userDto = addUserForm();
        userDto.setUserCode(Integer.parseInt(code));
        return userDto;
    }


    private int inputDeleteCode() {
        System.out.print("삭제를 원하는 유저의 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        return Integer.parseInt(code);
    }

    private UserDto addUserForm() {
        System.out.print("유저 아이디 입력: ");
        String userId = sc.nextLine();
        System.out.print("유저 비밀번호 입력: ");
        String password = sc.nextLine();
        System.out.print("유저 이메일 입력: ");
        String email = sc.nextLine();
        System.out.print("유저 전화번호 입력: ");
        String phone = sc.nextLine();
        System.out.print("유저 주소 입력: ");
        String address = sc.nextLine();
        System.out.print("유저 타입 입력(회원, 관리자, 창고관리자): ");
        String userType = sc.nextLine();
        System.out.print("유저 이름 입력: ");
        String userName = sc.nextLine();

        UserDto userDto = new UserDto()
                .builder()
                .userId(userId)
                .userPassword(password)
                .userEmail(email)
                .userPhone(phone)
                .userAddress(address)
                .userType(userType)
                .userName(userName)
                .build();

        return userDto;
    }

    private CategoryDto addCategoryForm() {
        System.out.print("카테고리명 입력: ");
        String categoryName = sc.nextLine();

        CategoryDto categoryDto = new CategoryDto()
                .builder()
                .categoryName(categoryName)
                .build();

        return categoryDto;
    }

    private CategoryDto inputCategoryCode() {
        System.out.print("수정을 원하는 카테고리의 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        CategoryDto categoryDto = addCategoryForm();
        categoryDto.setCategoryCode(Integer.parseInt(code));
        return categoryDto;
    }

    private String inputDeleteCategoryCode() {
        System.out.print("삭제를 원하는 카테고리의 코드를 입력해주세요 : ");
        String code = sc.nextLine();
        return code;
    }
}
