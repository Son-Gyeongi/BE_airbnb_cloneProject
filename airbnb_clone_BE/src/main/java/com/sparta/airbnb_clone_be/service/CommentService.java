package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.dto.CommentAvgResponseDto;
import com.sparta.airbnb_clone_be.dto.CommentRequestdto;
import com.sparta.airbnb_clone_be.model.Accomodations;
import com.sparta.airbnb_clone_be.model.Comment;
import com.sparta.airbnb_clone_be.repository.AccomodationsRepository;
import com.sparta.airbnb_clone_be.repository.CommentRepository;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public CommentAvgResponseDto starAvg() {
        /**
         * {
         *   “checkinAvg” : 5,//체크인
         *   “cleanAvg” : 5,//청결도
         *   “accuracyAvg” : 5, //정확도
         *   “communicationAvg” : 5의사,소통
         *   “locationAvg” : 5,//위치
         *   “satisfactionAvg” : 5//만족도,
         *   “totalStar” : 5
         * //위 6개를 전부 더해서 평균 낸 값( 소수점 2자리까지)
         * }
         */

        float chechingAvg = 0F;
        float cleanAvg = 0F;
        float accuracyAvg = 0F;
        float communicationAvg = 0F;
        float locationAvg = 0F;
        float satisfactionAvg = 0F;
        float totalStar = 0F;

        //commentRespository에서 각 필드의 값들을 더해야한다.
        /**
         * this.checkin = checkin;
         *         this.clean = clean;
         *         this.accuracy = accuracy;
         *         this.communication = communication;
         *         this.location = location;
         *         this.satisfaction = satisfaction;
         */
        List<Comment> checkInList = commentRepository.findAllByCheckin();
        List<Comment> cleanList = commentRepository.findAllByClean();
        List<Comment> accuracyList = commentRepository.findAllByAccuracy();
        List<Comment> communicationList = commentRepository.findAllByCommunication();
        List<Comment> locationList = commentRepository.findAllByLocation();
        List<Comment> satisfactionList = commentRepository.findAllBySatisfaction();

        for(int i = 0 ; i<checkInList.size();i++){
            float checkIngSum = 0F;
            checkIngSum +=  (float) checkInList.get(i);

        }
    }
}

