package com.cjoa.wms.view;


import com.cjoa.wms.dto.*;

import java.util.List;

public class ResultView {
    public static <T> void displayData(T data) {
        if (data != null) {
            System.out.println(data);
        }else{
            System.out.println("data is null");
        }
    }

    public static <T> void displayData(List<T> data) {
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        }else{
            System.out.println("data is null");
        }
    }

    public static void SuccessView(String type) {
        System.out.println(type + " is Success");
    }

    public static void FailView(String type) {
        System.out.println(type + " is Fail");
    }

    public static void stockListView(List<OrderProdOptionDeliveryDto> list) {
        for (OrderProdOptionDeliveryDto stock : list) {
            System.out.printf("[제품상세코드: %d, 제품이름: %s, 상세정보: %s/%s [재고수량: %s 재고금액: %d]]\n",
                    stock.getProdOptionCode(),
                    stock.getProdName(),
                    stock.getProdSize(),
                    stock.getProdColor(),
                    stock.getStockQuantity(),
                    stock.getProdPrice()
            );
        }
    }

    public static void productStockListView(ProductDto list) {
        if (list == null) {
            System.out.println("없는 상품번호 입니다.");
        } else {
            int price = list.getProdPrice();
            System.out.printf("[제품번호: %d, 제품명: %s]\n",
                    list.getProdCode(),
                    list.getProdName()
            );
            for (ProductOptionDto product : list.getProductOptionList()) {
                System.out.printf("\t└[제품상세번호: %d, 사이즈: %s, 색상: %s][재고수량: %d 재고금액: %d]\n",
                        product.getProdOptionCode(),
                        product.getProdSize(),
                        product.getProdColor(),
                        product.getQuantity(),
                        price * product.getQuantity()
                );
            }
        }
    }

    public static void userInfoView(UserDto user) {
        if(user == null){
            System.out.println("😂조회된 메뉴가 없습니다😂");
        }else{
            System.out.println("~~~~~~ 메뉴 정보 ~~~~~~");
            System.out.println("Name: " + user.getUserName());
            System.out.println("ID: " + user.getUserId());
            System.out.println("Password: " + user.getUserPassword());
            System.out.println("Email: " + user.getUserEmail());
            System.out.println("Phone: " + user.getUserPhone());
            System.out.println("Address: " + user.getUserAddress());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

}
