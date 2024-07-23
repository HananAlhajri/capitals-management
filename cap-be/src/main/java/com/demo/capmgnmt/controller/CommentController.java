package com.demo.capmgnmt.controller;

import com.demo.capmgnmt.common.response.APIResponse;
import com.demo.capmgnmt.service.ICommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.demo.capmgnmt.common.constants.APIsUrl.Comment.COMMENT_BASE_URL;
import static com.demo.capmgnmt.common.constants.APIsUrl.Common.DISLIKE_URL;
import static com.demo.capmgnmt.common.constants.APIsUrl.Common.LIKE_URL;
import static com.demo.capmgnmt.common.constants.APIsUrl.Item.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ITEM_BASE_URL + COMMENT_BASE_URL)
public class CommentController {

    private final ICommentService commentService;

    @PostMapping("/{itemId}")
    public ResponseEntity<?> reviewItem(@PathVariable("itemId") Long id, @Valid @RequestBody String comment) {
        commentService.addCommentOnItem(id, comment); // TODO: add commenter from token in audit info [later with security feat]
        return APIResponse.success();
    }

    @PutMapping(LIKE_URL + "/{commentId}")
    public ResponseEntity<?> likeComment(@PathVariable("commentId") Long id) {
        commentService.like(id);
        return APIResponse.success();
    }

    @PutMapping(DISLIKE_URL + "/{commentId}")
    public ResponseEntity<?> dislikeComment(@PathVariable("commentId") Long id) {
        commentService.dislike(id);
        return APIResponse.success();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> removeComment(@PathVariable("commentId") Long id) {
        commentService.removeComment(id);
        return APIResponse.success();
    }

}