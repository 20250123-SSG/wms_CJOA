package com.cjoa.wms.view;

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
}
