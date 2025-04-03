package com.cjoa.wms.controller;

import com.cjoa.wms.dto.ReceiveDto;
import com.cjoa.wms.service.ReceiveService;
import com.cjoa.wms.view.ResultView;

import java.util.List;

public class ReceiveController {
    private ReceiveService receiveService = new ReceiveService();

    public void receiveSearchAll(){
        List<ReceiveDto> list  = receiveService.receiveSearchAll();
        ResultView.displayData(list);
    }

    public void receiveSearchByCode(int receiveCode){
        List<ReceiveDto> list =  receiveService.receiveSearchByCode(receiveCode);
        ResultView.displayData(list);
    }

    public void receiveSearchByDate(String startDate,String endDate){
        List<ReceiveDto> list = receiveService.receiveSearchByDate(startDate,endDate);
        ResultView.displayData(list);
    }
}
