package com.demo.capmgnmt.service.implementation;

import com.demo.capmgnmt.common.mapper.CategoryMapper;
import com.demo.capmgnmt.common.mapper.ItemMapper;
import com.demo.capmgnmt.dto.response.CategoryResponse;
import com.demo.capmgnmt.dto.response.ItemResponse;
import com.demo.capmgnmt.exception.custom.CategoryNotFoundException;
import com.demo.capmgnmt.repository.CategoryRepository;
import com.demo.capmgnmt.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookupServiceImpl {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getCategories() {
        return categoryMapper.mapCategoriesResponse(categoryRepository.findAll());
    }

    public List<ItemResponse> getItemsInCategory(Long categoryId) {
        return itemMapper.mapItemsResponse(
                itemRepository.findAllByCategory(
                        categoryRepository.findById(categoryId)
                                .orElseThrow(CategoryNotFoundException::new)
                )
        );
    }
}