package com.demo.capmgnmt.service.implementation;

import com.demo.capmgnmt.entity.Comment;
import com.demo.capmgnmt.exception.custom.NotFoundException;
import com.demo.capmgnmt.repository.CommentsRepository;
import com.demo.capmgnmt.service.ICommentService;
import com.demo.capmgnmt.service.IItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService implements ICommentService {

    private final IItemService itemService;
    private final CommentsRepository commentsRepository;

    @Override
    public void addCommentOnItem(Long itemId, String comment) {
        commentsRepository.save(new Comment(
                comment,
                0,
                itemService.findById(itemId)
        ));
    }

    @Override
    public void like(Long commentId) {
        Comment comment = commentsRepository.findById(commentId).orElseThrow(NotFoundException::new);
        comment.like();
        commentsRepository.save(comment);
    }

    @Override
    public void dislike(Long commentId) {
        Comment comment = commentsRepository.findById(commentId).orElseThrow(NotFoundException::new);
        comment.dislike();
        commentsRepository.save(comment);
    }

    @Override
    public void removeComment(Long commentId) {
        commentsRepository.deleteById(commentId);
    }

}