package com.demo.capmgnmt.service.implementation;

import com.demo.capmgnmt.dto.ItemDTO;
import com.demo.capmgnmt.entity.Item;
import com.demo.capmgnmt.exception.custom.ItemNotFoundException;
import com.demo.capmgnmt.repository.ItemRepository;
import com.demo.capmgnmt.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService implements IItemService {

    private final ItemRepository itemRepository;

    @Override
    public ItemDTO getItem(Long id) {
        return map(itemRepository.findById(id).orElseThrow(ItemNotFoundException::new));
    }

    private ItemDTO map(Item item) {
        return new ItemDTO(item.getName(), item.getDescription(), item.getPrice());
    }
}