package com.cjoa.wms.controller;

import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.service.StockService;
import com.cjoa.wms.view.ResultView;

import java.util.List;

public class StockController {
    private StockService stockService = new StockService();

    public void checkAllStock() {
        List<OrderProdOptionDeliveryDto> list = stockService.checkAllStockList();
        ResultView.stockListView(list);
    }

    public void checkStockByProdCode(String menu) {
        ProductDto list = stockService.checkStockByProdCode(Integer.parseInt(menu));
        ResultView.productStockListView(list);
    }
}
