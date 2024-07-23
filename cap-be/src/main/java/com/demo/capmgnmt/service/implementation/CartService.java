package com.demo.capmgnmt.service.implementation;

import com.demo.capmgnmt.dto.response.ItemResponse;
import com.demo.capmgnmt.service.ICartService;
import com.demo.capmgnmt.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class CartService implements ICartService {

    private final IItemService itemService;
    public HashMap<Long, ItemResponse> cart = new HashMap<>();

    @Override
    public void addItem(Long id) {
        cart.put(id, itemService.getItem(id));
    }

    @Override
    public void removeItem(Long id) {
        cart.remove(id);
    }

    public HashMap<Long, ItemResponse> viewCart() {
        return cart;
    }

}