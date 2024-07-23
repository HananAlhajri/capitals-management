package com.demo.capmgnmt.controller;

import com.demo.capmgnmt.common.response.APIResponse;
import com.demo.capmgnmt.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.demo.capmgnmt.common.constants.APIsUrl.Common.DISLIKE_URL;
import static com.demo.capmgnmt.common.constants.APIsUrl.Common.LIKE_URL;
import static com.demo.capmgnmt.common.constants.APIsUrl.Item.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ITEM_BASE_URL)
public class ItemController {

    private final IItemService itemService;

    @GetMapping(VIEW_ITEM_URL + "/{itemId}")
    public ResponseEntity<?> viewItem(@PathVariable("itemId") Long id) {
        return APIResponse.success(itemService.getItem(id));
    }

    @PutMapping(LIKE_URL + "/{itemId}")
    public ResponseEntity<?> likeItem(@PathVariable("itemId") Long id) {
        itemService.like(id);
        return APIResponse.success();
    }

    @PutMapping(DISLIKE_URL + "/{itemId}")
    public ResponseEntity<?> dislikeItem(@PathVariable("itemId") Long id) {
        itemService.dislike(id);
        return APIResponse.success();
    }

}