package com.cjoa.wms.dao;

import com.cjoa.wms.dto.ProductDto;

import java.util.List;

public interface ProductMapper {

    List<ProductDto> selectAllProduct();
    List<ProductDto> selectProductByCategory(int code);
    List<ProductDto> selectProductByProdKeyword(String key);
    ProductDto  selectProductOptionListByProdCode(int code);
}
