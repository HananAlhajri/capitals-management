package com.demo.capmgnmt.controller;

import com.demo.capmgnmt.common.response.APIResponse;
import com.demo.capmgnmt.service.implementation.LookupServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.capmgnmt.common.constants.APIsUrl.Lookup.*;

@RestController
@RequestMapping(LOOKUP_BASE_URL)
@RequiredArgsConstructor
public class LookupController {

    private final LookupServiceImpl lookupService;

    @GetMapping(CATEGORIES)
    public ResponseEntity<?> getCategories() {
        return APIResponse.success(lookupService.getCategories());
    }

    @GetMapping(ITEMS + "/{categoryId}")
    public ResponseEntity<?> getItemsInCategory(@PathVariable Long categoryId) {
        return APIResponse.success(lookupService.getItemsInCategory(categoryId));
    }
}