package com.cjoa.wms.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class handleDateRangeInput {
    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void handle(DateRangeAction action) {
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
}
