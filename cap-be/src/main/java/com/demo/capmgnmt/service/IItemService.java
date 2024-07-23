package com.demo.capmgnmt.service;

import com.demo.capmgnmt.dto.response.ItemResponse;
import com.demo.capmgnmt.entity.Item;

public interface IItemService {
    ItemResponse getItem(Long itemId);

    Item findById(Long itemId);

    void like(Long itemId);

    void dislike(Long itemId);
}