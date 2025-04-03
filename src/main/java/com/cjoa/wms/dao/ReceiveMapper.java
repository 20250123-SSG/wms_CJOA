package com.cjoa.wms.dao;

import com.cjoa.wms.dto.ReceiveDto;

import java.util.List;
import java.util.Map;

public interface ReceiveMapper {
    List<ReceiveDto> receiveSearchAll();
    List<ReceiveDto> receiveSearchByCode(int receiveCode);
    List<ReceiveDto> receiveSearchByDate(Map<String, String> param);
}
