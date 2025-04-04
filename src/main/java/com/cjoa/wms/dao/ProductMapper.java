package com.cjoa.wms.dao;

import com.cjoa.wms.dto.ProductDto;
import com.cjoa.wms.dto.ProductOptionDto;

import java.util.List;

public interface ProductMapper {

    List<ProductDto> selectAllProduct();

    List<ProductDto> selectProductByCategory(int code);

    List<ProductDto> selectProductByProdKeyword(String key);

    List<ProductDto> selectProductOptionListByProdCode(int code);

    int addProduct(ProductDto productDto);

    int addProductOption(ProductDto productDto);
}
