package com.cjoa.wms.dao;

import com.cjoa.wms.dto.ReceiveDeliveryDto;

import java.util.List;
import java.util.Map;

public interface ReceiveDeliveryMapper {
    List<ReceiveDeliveryDto> receiveDeliverySearchAll();

    List<ReceiveDeliveryDto> receiveDeliverySearchByDate(Map<String, String> param);

}
