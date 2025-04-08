package com.cjoa.wms.view;

import com.cjoa.wms.controller.OrderController;
import com.cjoa.wms.dto.OrderDeliveryDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class OrderListview {
    private Scanner sc = new Scanner(System.in);

    public void orderList(List<OrderDeliveryDto> list) {
        if(list.isEmpty()){
            System.out.println("주문내역이 없습니다.");
        }else {
            int i =0;
            for (OrderDeliveryDto order : list) {
                System.out.printf("%d. %s | %d원 | %s | %s\n",
                        ++i,
                        order.getOrderPayType(),
                        order.getOrderPrice(),
                        order.getOrderStatus(),
                        order.getOrderDate());
            }
        }
        OrderProdOptionView(list);

    }

    public void OrderProdOptionView(List<OrderDeliveryDto> list){
        UserMainView userMainView = new UserMainView();
        System.out.println("상세정보 확인할 주문번호 선택(0누를시 뒤로가기)");
        String num = sc.nextLine();
        int orderNum = list.get(Integer.parseInt(num)-1).getOrderCode();
        if(orderNum == 0){
            userMainView.userMainView();
        }else {
            OrderController orderController = new OrderController();
            orderController.selectOrderDetail(orderNum);
        }


    }


}
