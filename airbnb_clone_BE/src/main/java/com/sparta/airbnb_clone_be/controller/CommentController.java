package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.dto.response.CommentAvgResponseDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.CommentRequestDto;
import com.sparta.airbnb_clone_be.dto.response.CommentResponseDto;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import com.sparta.airbnb_clone_be.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    //댓글등록
    @PostMapping("/api/accommodations/{id}/comments")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestdto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id) {
        return commentService.createComment(commentRequestdto, id, userDetails);


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