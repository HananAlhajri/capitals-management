package com.demo.capmgnmt.service;

import com.demo.capmgnmt.dto.ItemDTO;

import java.util.HashMap;

public interface ICartService {
    void addItem(Long id);

    void removeItem(Long id);

    HashMap<Long, ItemDTO> viewCart();
}