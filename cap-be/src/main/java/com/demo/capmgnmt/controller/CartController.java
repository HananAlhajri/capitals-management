package com.demo.capmgnmt.controller;

import com.demo.capmgnmt.common.response.APIResponse;
import com.demo.capmgnmt.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.demo.capmgnmt.common.constants.APIsUrl.Cart.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CART_BASE_URL)
public class CartController {

    private final ICartService cartService;

    @GetMapping(VIEW_CART)
    public ResponseEntity<?> view() {
        return APIResponse.success(cartService.viewCart());
    }

    @PostMapping(ADD_ITEM + "/{itemId}")
    public ResponseEntity<?> add(@PathVariable("itemId") Long id) {
        cartService.addItem(id);
        return APIResponse.success();
    }

    @DeleteMapping(REMOVE_ITEM + "/{itemId}")
    public ResponseEntity<?> remove(@PathVariable("itemId") Long id) {
        cartService.removeItem(id);
        return APIResponse.success();
    }

}