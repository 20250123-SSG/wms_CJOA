package com.cjoa.wms.controller;

import com.cjoa.wms.dto.ReceiveDeliveryDto;
import com.cjoa.wms.service.ReceiveDeliveryService;
import com.cjoa.wms.view.ResultView;

import java.util.List;

public class ReceiveDeliveryController {
    private ReceiveDeliveryService receiveDeliveryService = new ReceiveDeliveryService();

    public void receiveDeliverySearchAll() {
        List<ReceiveDeliveryDto> list = receiveDeliveryService.ReceiveDeliverySearchAll();
        ResultView.displayData(list);
    }
    public void receiveDeliverySearchByDate(String startDate, String endDate) {
        List<ReceiveDeliveryDto> list = receiveDeliveryService.receiveDeliverySearchByDate(startDate,endDate);
        ResultView.displayData(list);
    }
}
