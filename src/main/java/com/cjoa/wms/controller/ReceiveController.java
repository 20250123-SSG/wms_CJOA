package com.cjoa.wms.controller;

import com.cjoa.wms.dto.ReceiveDto;
import com.cjoa.wms.service.ReceiveService;
import com.cjoa.wms.view.ResultView;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.view.LoginView;
import com.cjoa.wms.view.ReceiveResultView;

import java.util.List;

public class ReceiveController {
    private ReceiveService receiveService = new ReceiveService();
    private ReceiveResultView receiveResultView = new ReceiveResultView();


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

    public OrderProdOptionDeliveryDto checkProductByOptionCode(String prodOptionCode) {
        OrderProdOptionDeliveryDto product = receiveService.checkProductByOptionCode(Integer.parseInt(prodOptionCode));
        receiveResultView.productOptionDetail(product);
        return product;
    }

    public void receiveProcess(String receiveNum, OrderProdOptionDeliveryDto prodInfo, String originPrice) {
        prodInfo.setUserCode(LoginView.userCode);
        prodInfo.setOrderProdOptionQuantity(Integer.parseInt(receiveNum));
        prodInfo.setProdPrice(Integer.parseInt(originPrice));
        int result = receiveService.receiveProcess(prodInfo);
        receiveResultView.receiveResult(result);
    }
}
