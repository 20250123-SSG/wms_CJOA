package com.cjoa.wms.view;

import com.cjoa.wms.controller.OrderController;
import com.cjoa.wms.dto.CartDto;
import com.cjoa.wms.dto.UserDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.cjoa.wms.view.LoginView.userCode;

public class OrderView {

    private Scanner sc = new Scanner(System.in);
    OrderController orderController = new OrderController();

    // 구매 뷰
    public void purchaseProduct(int total, List<CartDto> list){
        System.out.println("카드 / 현금: ");
        String payType = sc.nextLine();
        System.out.println("1. 집으로 배송\t 2. 배송지 입력");
        String menu = sc.nextLine();
        String phone="";
        String address="";
        String name="";
        switch (menu){
            case "1": UserDto user = orderController.selectUserInfo(userCode);
            phone = user.getUserPhone();
                System.out.println(phone);
            address = user.getUserAddress();
            name = user.getUserName();
            break;
            case "2":
                System.out.println("배송받을 분의 전화번호를 입력해 주세요: ");
                phone = sc.nextLine();
                System.out.println("배송받을 주소를 입력해주세요: ");
                address = sc.nextLine();
                System.out.println("배송받을 분의 이름을 입력해주세요: ");
                name = sc.nextLine();
                break;
            default:
                System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
        }
        System.out.println("요청사항을 입력: ");
        String request = sc.nextLine();

        Map<String, String> requestParam = Map.of(
                "orderPrice", String.valueOf(total),
                "orderPayType", payType,
                "orderDeliveryPhone", phone,
                "orderDeliveryAddress", address,
                "orderDeliveryName", name,
                "orderRequest", request,
                "userCode", String.valueOf(userCode)
        );
        orderController.insertOrderInfo(requestParam);

    }



}
