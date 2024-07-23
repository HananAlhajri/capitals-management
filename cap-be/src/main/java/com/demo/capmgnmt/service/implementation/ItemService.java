package com.demo.capmgnmt.service.implementation;

import com.demo.capmgnmt.common.mapper.ItemMapper;
import com.demo.capmgnmt.dto.response.ItemResponse;
import com.demo.capmgnmt.entity.Item;
import com.demo.capmgnmt.exception.custom.NotFoundException;
import com.demo.capmgnmt.repository.ItemRepository;
import com.demo.capmgnmt.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService implements IItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Override
    public ItemResponse getItem(Long id) {
        ItemResponse item = itemMapper.mapItemResponse(itemRepository.findById(id).orElseThrow(NotFoundException::new));
        item.setNumberOfComments(item.getComments().size());
        return item;
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void like(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(NotFoundException::new);
        item.like();
        itemRepository.save(item);
    }

    @Override
    public void dislike(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(NotFoundException::new);
        item.dislike();
        itemRepository.save(item);
    }

}