package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CategoryDto;
import com.cjoa.wms.dto.UserDto;
import com.cjoa.wms.service.CategoryService;

public class CategoryController {

    private CategoryService categoryService = new CategoryService();

    public void addCategory(CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }
}
