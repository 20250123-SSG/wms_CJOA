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

    private UserController userController = new UserController();
    private ReceiveController receiveController = new ReceiveController();
    private DeliveryController deliveryController = new DeliveryController();
    private ReceiveDeliveryController receiveDeliveryController = new ReceiveDeliveryController();

    private ProductManageView productManageView = new ProductManageView();
    private CategoryManageView categoryManageView = new CategoryManageView();

    private RevenueController revenueController = new RevenueController();
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
                    categoryManageView.categoryMainView();
                    break;
                case "3":
                    productManageView.mainView();
                    break;
                case "4":
                    StockView();
                    break;
                case "5":
                    RevenueView();
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

    private void StockView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 입고 조회
                    2. 출고 조회
                    3. 재고 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    ReceiveView();
                    break;
                case "2":
                    DeliveryView();
                     break;
                case "3":
                    ReceiveDeliveryView();
                    break;
                case "0":
                    return;

            }
        }
    }

    private void ReceiveView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 전체 내역 조회
                    2. 입고 코드로 조회
                    3. 날짜로 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    receiveController.receiveSearchAll();
                    break;
                case "2":
                    receiveController.receiveSearchByCode(receiveCode());
                    break;
                case "3":
                    receiveDate();
                    break;
                case "0":
                    return;
            }
        }
    }


    private void DeliveryView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 전체 내역 조회
                    2. 출고 코드로 조회
                    3. 날짜로 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    deliveryController.deliverySearchAll();
                    break;
                case "2":
                    deliveryController.deliverySearchByCode(deliveryCode());
                    break;
                case "3":
                    deliveryDate();
                    break;
                case "0":
                    return;

            }
        }
    }

    private void ReceiveDeliveryView() {
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 전체 내역 조회
                    2. 날짜로 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    receiveDeliveryController.receiveDeliverySearchAll();
                    break;
                case "2":
                    receiveDeliveryDate();
                    break;
                case "0":
                    return;
            }
        }
    }

    private void RevenueView(){
        while (true) {
            System.out.print("""
                    \n===============================
                    1. 판매 금액 조회
                    2. 입고 금액 조회
                    3. 마진 금액 조회
                    0. 이전 메뉴로 돌아가기
                    ===============================
                    """);
            String menu = sc.nextLine();
            switch (menu) {
                case "1":
                    salesDate();
                    break;
                case "2":
                    purchaseDate();
                    break;
                case "3" :
                    marginDate();
                    break;
                case "0" :
                    return;
        }
    }
}

    private int deliveryCode(){
        int code = -1;
        while (true) {
            try {
                System.out.println("조회하고자 하는 출고 내역의 코드를 입력해주세요 : ");
                String input = sc.nextLine();
                code = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return code;
    }


    private int receiveCode(){
        int code = -1;
        while (true) {
            try {
                System.out.println("조회하고자 하는 입고 내역의 코드를 입력해주세요 : ");
                String input = sc.nextLine();
                code = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
            }
        }
        return code;
    }

    @FunctionalInterface
    private interface DateRangeAction {
        void execute(String startDate, String endDate);
    }

    private void handleDateRangeInput(DateRangeAction action) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            try {
                System.out.print("조회 시작 날짜 입력(0000-00-00): ");
                String start = sc.nextLine();
                LocalDate startDate = LocalDate.parse(start, formatter);

                System.out.print("조회 종료 날짜 입력(0000-00-00): ");
                String end = sc.nextLine();
                LocalDate endDate = LocalDate.parse(end, formatter);

                if (startDate.isAfter(endDate)) {
                    System.out.println("조회 시작일은 종료일보다 이전이어야 합니다.");
                    continue;
                }

                action.execute(start, end);
                break;

            } catch (DateTimeParseException e) {
                System.out.println("날짜 형식이 잘못되었습니다. '0000-00-00' 형식으로 입력해주세요.");
            }
        }
    }

    private void receiveDate() {
        handleDateRangeInput((start, end) -> receiveController.receiveSearchByDate(start, end));
    }

    private void deliveryDate() {
        handleDateRangeInput((start, end) -> deliveryController.deliverySearchByDate(start, end));
    }

    private void receiveDeliveryDate() {
        handleDateRangeInput((start, end) -> receiveDeliveryController.receiveDeliverySearchByDate(start, end));
    }

    private void salesDate() {
        handleDateRangeInput((start, end) -> revenueController.calculateTotalSales(start, end));
    }

    private void purchaseDate() {
        handleDateRangeInput((start, end) -> revenueController.calculateTotalPurchaseCost(start, end));
    }

    private void marginDate() {
        handleDateRangeInput((start, end) -> revenueController.calculateTotalMarginCost(start, end));
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
}
