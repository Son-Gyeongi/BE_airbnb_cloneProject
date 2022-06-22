package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.dto.response.CommentAvgResponseDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.CommentRequestDto;
import com.sparta.airbnb_clone_be.dto.response.CommentResponseDto;
import com.sparta.airbnb_clone_be.model.Comment;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import com.sparta.airbnb_clone_be.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글등록
    @PostMapping("/api/accommodations/{id}/comments")
    public void createComment(@RequestBody CommentRequestDto commentRequestdto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {
        Comment comment = commentService.createComment(commentRequestdto, id, userDetails);

//        Map<String, Object> result = new HashMap<>();
//        result.put("checkin", comment.getCheckin());
//        result.put("comment", comment.getComment());
//        result.put("clean", comment.getClean());
//        result.put("accuracy", comment.getAccuracy());
//        result.put("communication", comment.getCommunication());
//        result.put("location", comment.getLocation());
//        result.put("satisfaction", comment.getSatisfaction());
////        result.put("id", comment.getCommentId());

//        return result;
    }

    @GetMapping("/api/accommodations/{id}/comments")
    public List<CommentResponseDto> viewReview(@PathVariable Long id){
        return commentService.findComments(id);
    }

    @GetMapping("/api/accommodations/{id}/comments/avgs")
        public CommentAvgResponseDto starAvg(@PathVariable Long id) {
            return commentService.starAvg(id);
        }

}