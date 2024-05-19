package com.demo.capmgnmt.common.mapper;

import com.demo.capmgnmt.dto.response.ItemResponse;
import com.demo.capmgnmt.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Hanan Al-Hajri 2024/05/019
 */

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemResponse> mapItemsResponse(List<Item> Items);
}