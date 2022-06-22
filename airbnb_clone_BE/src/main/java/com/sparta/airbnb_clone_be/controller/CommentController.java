package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.dto.CommentAvgResponseDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.CommentRequestDto;
import com.sparta.airbnb_clone_be.model.Comment;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import com.sparta.airbnb_clone_be.service.CommentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;

    }

    //댓글등록
    @PostMapping("/api/accomodations/{accomodations_id}")
    public Map<String, Object> createComment(@RequestBody CommentRequestDto commentRequestdto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        Comment comment = commentService.createComment(commentRequestdto, userDetails);

        Map<String, Object> result = new HashMap<>();
        result.put("checkin", comment.getCheckin());
        result.put("comment", comment.getComment());
        result.put("clean", comment.getClean());
        result.put("accuracy", comment.getAccuracy());
        result.put("communication", comment.getCommunication());
        result.put("location", comment.getLocation());
        result.put("satisfaction", comment.getSatisfaction());
        result.put("id", comment.getCommentId());

            return result;
        }

        @GetMapping("/api/accommodation/{id}/avgs")
        public CommentAvgResponseDto starAvg(@PathVariable Long id) {
            return commentService.starAvg(id);
        }

}