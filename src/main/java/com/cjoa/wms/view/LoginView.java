package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserController;
import com.cjoa.wms.dto.UserDto;

import java.util.Scanner;

public class LoginView {

    private UserController userController = new UserController();
    private Scanner sc = new Scanner(System.in);

    public void loginView() {
        while (true) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            userController.getUserByUserIdAndPassword(id, password);
        }
    }
}
