package com.demo.capmgnmt.dto.response;

import lombok.Data;

@Data
public class ItemResponse {
    private Long id;
    private String name, description;
    private Double price;
}