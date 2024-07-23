package com.demo.capmgnmt.service;

public interface ICommentService {

    void addCommentOnItem(Long itemId, String comment);

    void like(Long commentId);

    void dislike(Long commentId);

    void removeComment(Long commentId);

}