package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.dto.CommentRequestdto;
import com.sparta.airbnb_clone_be.model.Accomodations;
import com.sparta.airbnb_clone_be.model.Comment;
import com.sparta.airbnb_clone_be.repository.AccomodationsRepository;
import com.sparta.airbnb_clone_be.repository.CommentRepository;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    //등록
    public Comment createComment(CommentRequestdto commentRequestdto, UserDetailsImpl userDetails) {
        Accomodations accomodations = AccomodationsRepository.findById(commentRequestdto.getAccomodationid()).orElseThrow(
                () -> new IllegalArgumentException("")
        );

        String email = "test 확인";
        if (userDetails != null) {
            email = userDetails.getUser().getEmail();
        }
        Comment comment = new Comment(commentRequestdto.getCheckin(), commentRequestdto.getClean(), commentRequestdto.getAccuracy(),  commentRequestdto.getCommunication(),  commentRequestdto.getLocation(),  commentRequestdto.getSatisfaction(), accomodations);
        Comment saveComment = commentRepository.save(comment);
        return saveComment;
    }
}

