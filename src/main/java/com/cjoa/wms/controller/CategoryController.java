package com.cjoa.wms.controller;

import com.cjoa.wms.dto.CategoryDto;
import com.cjoa.wms.service.CategoryService;
import com.cjoa.wms.view.ResultView;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private CategoryService categoryService = new CategoryService();

    public void addCategory(Map<String, Object> categoryMap) {

        if (categoryMap.get("categoryName") == null) {
            throw new IllegalArgumentException("카테고리명을 입력해야 합니다.");
        }

        CategoryDto categoryDto = CategoryDto.builder()
                .categoryName((String) categoryMap.get("categoryName"))
                .build();

        categoryService.addCategory(categoryDto);
    }

    public void updateCategoryByCode(Map<String, Object> categoryMap) {

        if (categoryMap.get("categoryCode") == null || categoryMap.get("categoryName") == null) {
            throw new IllegalArgumentException("카테고리 코드와 이름을 모두 입력해야 합니다.");
        }

        CategoryDto categoryDto = CategoryDto.builder()
                .categoryCode((Integer) categoryMap.get("categoryCode"))
                .categoryName((String) categoryMap.get("categoryName"))
                .build();

        categoryService.updateCategoryByCode(categoryDto);
    }

    public void deleteCategoryByCode(String categoryCode) {

        if (categoryCode == null || categoryCode.isEmpty()) {
            throw new IllegalArgumentException("삭제할 카테고리 코드를 입력해야 합니다.");
        }

        int result = categoryService.deleteCategoryByCode(Integer.parseInt(categoryCode));
    }


    public void getAllCategory() {
        
        List<CategoryDto> list = categoryService.getAllCategory();

        ResultView.displayData(list);
    }
}
