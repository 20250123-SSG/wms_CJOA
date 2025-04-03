package com.cjoa.wms.dao;

import com.cjoa.wms.dto.CategoryDto;

import java.util.List;

public interface CategoryMapper {

    int addCategory(CategoryDto category);

    int updateCategoryByCode(CategoryDto category);

    List<CategoryDto> getAllCategory();

    int deleteCategoryByCode(int code);
}
