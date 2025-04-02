package com.cjoa.wms.dao;

import com.cjoa.wms.dto.ProductDto;

import java.util.List;

public interface ProductMapper {

    List<ProductDto> selectAllProduct();
}
