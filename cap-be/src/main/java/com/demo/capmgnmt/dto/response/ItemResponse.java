package com.demo.capmgnmt.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponse {
    private Long id;
    private String name, description;
    private Double price;
    private int likes, numberOfComments;
    private List<CommentResponse> comments;
}