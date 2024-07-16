package com.demo.capmgnmt.service;

import com.demo.capmgnmt.dto.ItemDTO;

public interface IItemService {
    ItemDTO getItem(Long id);
}