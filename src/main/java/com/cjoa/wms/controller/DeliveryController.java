package com.cjoa.wms.controller;

import com.cjoa.wms.dto.DeliveryDto;
import com.cjoa.wms.dto.OrderDeliveryDto;
import com.cjoa.wms.dto.OrderProdOptionDeliveryDto;
import com.cjoa.wms.dto.ReceiveDto;
import com.cjoa.wms.service.DeliveryService;
import com.cjoa.wms.view.DeliveryResultView;
import com.cjoa.wms.view.ResultView;

import java.util.List;

public class DeliveryController {
    DeliveryService deliveryService = new DeliveryService();

    public void checkOrderList() {
        List<OrderDeliveryDto> list = deliveryService.checkOrderList();
        DeliveryResultView.resultOrderList(list);
    }

    public List<OrderProdOptionDeliveryDto> checkOrderDetail(String code) {
        List<OrderProdOptionDeliveryDto> orderDetail = deliveryService.checkOrderDetail(Integer.parseInt(code));
        DeliveryResultView.resultOrderDetail(orderDetail);
        return orderDetail;
    }

    public void productDeliveryProcess(List<OrderProdOptionDeliveryDto> orderDetail, int userCode, String orderCode) {
        orderDetail.forEach(a -> a.setUserCode(userCode));
        int result = deliveryService.productDeliveryProcess(orderDetail, Integer.parseInt(orderCode));
        DeliveryResultView.resultDeliveryProcess(result);
    }
    public void deliverySearchAll(){
       List<DeliveryDto> list  = deliveryService.deliverySearchAll();
        ResultView.displayData(list);

    }
    public void deliverySearchByCode(int deliveryCode){
        List<DeliveryDto> list =  deliveryService.deliverySearchByCode(deliveryCode);
        ResultView.displayData(list);

    }
    public void deliverySearchByDate(String startDate, String endDate){
        List<DeliveryDto> list = deliveryService.deliverySearchByDate(startDate, endDate);
        ResultView.displayData(list);
    }
}
