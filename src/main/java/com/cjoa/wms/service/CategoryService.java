package com.cjoa.wms.service;

import com.cjoa.wms.dao.CategoryMapper;
import com.cjoa.wms.dto.CategoryDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.cjoa.wms.config.MyBatisConfig.getSqlSession;
import static com.cjoa.wms.view.ResultView.FailView;
import static com.cjoa.wms.view.ResultView.SuccessView;

public class CategoryService {
    private CategoryMapper categoryMapper;
    private SqlSession sqlSession;

    public int addCategory(CategoryDto categoryDto) {
        sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int result = categoryMapper.addCategory(categoryDto);
        if (result > 0) {
            sqlSession.commit();
            SuccessView("addCategory");
        } else {
            sqlSession.rollback();
            FailView("addCategory");
        }
        return result;
    }

    public int updateCategoryByCode(CategoryDto categoryDto) {
        sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int result = categoryMapper.updateCategoryByCode(categoryDto);

        if (result > 0) {
            sqlSession.commit();
            SuccessView("updateCategoryByCode");
        } else {
            sqlSession.rollback();
            FailView("updateCategoryByCode");
        }
        return result;
    }

    public List<CategoryDto> getAllCategory() {
        sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryDto> categoryDtoList = categoryMapper.getAllCategory();
        if (categoryDtoList != null && categoryDtoList.size() > 0) {
            SuccessView("getAllCategory");
        } else {
            FailView("getAllCategory");
        }
        return categoryDtoList;
    }

    public int deleteCategoryByCode(int categoryCode) {
        sqlSession = getSqlSession();
        categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        int result = categoryMapper.deleteCategoryByCode(categoryCode);
        if (result > 0) {
            sqlSession.commit();
            SuccessView("deleteCategoryByCode");
        } else {
            sqlSession.rollback();
            FailView("deleteCategoryByCode");
        }
        return result;
    }
}
