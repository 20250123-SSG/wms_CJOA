package com.cjoa.wms.controller;

import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.service.ReceiveService;
import com.cjoa.wms.view.LoginView;
import com.cjoa.wms.view.ReceiveResultView;

public class ReceiveController {
    ReceiveService receiveService = new ReceiveService();
    ReceiveResultView receiveResultView = new ReceiveResultView();

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
