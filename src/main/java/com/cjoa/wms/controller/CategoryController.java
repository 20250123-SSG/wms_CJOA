package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CategoryDto;
import com.cjoa.wms.service.CategoryService;
import com.cjoa.wms.view.ResultView;

import java.util.List;

public class CategoryController {

    private CategoryService categoryService = new CategoryService();

    public void addCategory(CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
    }

    public void updateCategoryByCode(CategoryDto categoryDto) {
        categoryService.updateCategoryByCode(categoryDto);
    }

    public void getAllCategory() {
        List<CategoryDto> list = categoryService.getAllCategory();

        ResultView.displayData(list);
    }

    public void deleteCategoryByCode(String categoryCode) {
        int result = categoryService.deleteCategoryByCode(Integer.parseInt(categoryCode));
    }
}
