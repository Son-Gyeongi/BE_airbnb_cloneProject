package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.model.Accommodation;
import com.sparta.airbnb_clone_be.model.Comment;
import com.sparta.airbnb_clone_be.repository.AccommodationRepository;
import com.sparta.airbnb_clone_be.repository.CommentRepository;
import com.sparta.airbnb_clone_be.dto.RequestDto.CommentRequestDto;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final AccommodationRepository accommodationRepository;

    //등록
    public Comment createComment(CommentRequestDto commentRequestdto, UserDetailsImpl userDetails) {
        Accommodation accomodation = accommodationRepository.findById(commentRequestdto.getAccomodationid()).orElseThrow(
                () -> new IllegalArgumentException("")
        );

        String email = "test 확인";
        if (userDetails != null) {
            email = userDetails.getUser().getEmail();
        }
        Comment comment = new Comment(commentRequestdto.getCheckin(), commentRequestdto.getClean(), commentRequestdto.getAccuracy(),  commentRequestdto.getCommunication(),  commentRequestdto.getLocation(),  commentRequestdto.getSatisfaction(), accomodation);
        Comment saveComment = commentRepository.save(comment);
        return saveComment;
    }
}

