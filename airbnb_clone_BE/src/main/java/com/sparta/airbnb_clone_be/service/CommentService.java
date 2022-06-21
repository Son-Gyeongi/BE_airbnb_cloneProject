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

    public CommentAvgResponseDto starAvg(Long id) {
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

        Float chechingAvg = 0F;
        Float cleanAvg = 0F;
        Float accuracyAvg = 0F;
        Float communicationAvg = 0F;
        Float locationAvg = 0F;
        Float satisfactionAvg = 0F;
        Float totalStar = 0F;

        //commentRespository에서 각 필드의 값들을 더해야한다.
        /**
         * this.checkin = checkin;
         *         this.clean = clean;
         *         this.accuracy = accuracy;
         *         this.communication = communication;
         *         this.location = location;
         *         this.satisfaction = satisfaction;
         */
        List<Comment> commentList = commentRepository.findAllByAccommodationsId(id);

        for(int i = 0 ; i<commentList.size();i++){
            cleanAvg += commentList.get(i).getClean();
            chechingAvg += commentList.get(i).getCheckin();
            accuracyAvg += commentList.get(i).getAccuracy();
            communicationAvg += commentList.get(i).getCommunication();
            locationAvg += commentList.get(i).getLocation();
            satisfactionAvg += commentList.get(i).getSatisfaction();
        }
        cleanAvg /= commentList.size();
        chechingAvg /= commentList.size();
        accuracyAvg /= commentList.size();
        communicationAvg /= commentList.size();
        locationAvg /= commentList.size();
        satisfactionAvg /= commentList.size();

        totalStar = (cleanAvg + chechingAvg + accuracyAvg + communicationAvg + locationAvg +satisfactionAvg)/6;

        //소수점 아래 1자리, 2자리까지 나타내려고 아래와 같이 썼다.
        return CommentAvgResponseDto.builder()
                .cleanAvg(String.format("%1.f",cleanAvg))
                .chechingAvg(String.format("%1.f",chechingAvg))
                .accuracyAvg(String.format("%1.f",accuracyAvg))
                .communicationAvg(String.format("%1.f",communicationAvg))
                .locationAvg(String.format("%1.f",locationAvg))
                .satisfactionAvg(String.format("%1.f",satisfactionAvg))
                .totalStar(String.format("%2.f",totalStar))
                .build();
    }
}

