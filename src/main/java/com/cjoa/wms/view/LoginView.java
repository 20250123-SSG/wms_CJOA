package com.cjoa.wms.view;

import com.cjoa.wms.controller.UserController;
import com.cjoa.wms.dto.UserDto;

import java.util.Scanner;

public class LoginView {

    private UserController userController = new UserController();
    private Scanner sc = new Scanner(System.in);
    private AdminView adminView = new AdminView();
    private WarehouseManagerView warehouseManagerView = new WarehouseManagerView();

    public void loginView() {
        while (true) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Password: ");
            String password = sc.nextLine();
            UserDto user = userController.getUserByUserIdAndPassword(id, password);

            if (user != null) {
                System.out.println("Login Successful");
                switch (user.getUserType()) {
                    case "관리자":
                        System.out.println("Admin Login");
                        adminView.mainView();
                        break;
                    case "회원":
                        System.out.println("User Login");
                        break;
                    case "창고관리자":
                        System.out.println("Warehouse Manager Login");
                        warehouseManagerView.warehouseMangerMenu(user.getUserCode());
                        break;
                    default:
                        System.out.println("Invalid User");
                        break;
                }
            } else {
                System.out.println("Login Failed");
            }
        }
    }
}
