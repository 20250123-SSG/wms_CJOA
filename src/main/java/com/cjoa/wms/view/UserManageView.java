package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserController;
import com.cjoa.wms.dto.UserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManageView {

    private Scanner sc = new Scanner(System.in);

    private UserController userController = new UserController();

    public void mainView() {
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

    private Map<String, Object> inputCode() {
        System.out.print("수정을 원하는 유저의 코드를 입력해주세요: ");
        String code = sc.nextLine();

        Map<String, Object> userMap = addUserForm();
        userMap.put("userCode", Integer.parseInt(code));

        return userMap;
    }

    private int inputDeleteCode() {
        System.out.print("삭제를 원하는 유저의 코드를 입력해주세요: ");
        String code = sc.nextLine();
        return Integer.parseInt(code);
    }

    private Map<String, Object> addUserForm() {
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

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userId", userId);
        userMap.put("userPassword", password);
        userMap.put("userEmail", email);
        userMap.put("userPhone", phone);
        userMap.put("userAddress", address);
        userMap.put("userType", userType);
        userMap.put("userName", userName);

        return userMap;
    }
}
