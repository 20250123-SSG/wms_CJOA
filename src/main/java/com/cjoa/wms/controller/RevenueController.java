package com.cjoa.wms.controller;

import com.cjoa.wms.service.RevenueService;
import com.cjoa.wms.view.ResultView;

public class RevenueController {
    RevenueService revenueService = new RevenueService();

    public void calculateTotalSales(String startDate,String endDate){
        int totalSales = revenueService.calculateTotalSales(startDate,endDate);
        ResultView.displayRevenue(startDate,endDate,totalSales);
    }
    public void calculateTotalPurchaseCost(String startDate,String endDate){
        int totalPurchaseCost = revenueService.calculateTotalPurchaseCost(startDate,endDate);
        ResultView.displayRevenue(startDate,endDate,totalPurchaseCost);
    }

    public void calculateTotalMarginCost(String startDate,String endDate){
        int totalMarginCost = revenueService.calculateTotalMarginCost(startDate,endDate);
        ResultView.displayRevenue(startDate,endDate,totalMarginCost);
    }


}
