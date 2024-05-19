package com.demo.capmgnmt.common.mapper;

import com.demo.capmgnmt.dto.response.CategoryResponse;
import com.demo.capmgnmt.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/05/019
 */

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryResponse> mapCategoriesResponse(List<Category> category);
}