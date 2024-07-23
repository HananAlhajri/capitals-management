package com.demo.capmgnmt.dto.response;

import lombok.Data;

@Data
public class CommentResponse {
    private String name, comment;
    private int likes;
}