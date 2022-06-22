package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.dto.response.CommentAvgResponseDto;
import com.sparta.airbnb_clone_be.dto.response.CommentResponseDto;
import com.sparta.airbnb_clone_be.model.Accommodation;
import com.sparta.airbnb_clone_be.model.Comment;
import com.sparta.airbnb_clone_be.repository.AccommodationRepository;
import com.sparta.airbnb_clone_be.repository.CommentRepository;
import com.sparta.airbnb_clone_be.dto.RequestDto.CommentRequestDto;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final AccommodationRepository accommodationRepository;

    //등록
    public CommentResponseDto createComment(CommentRequestDto commentRequestdto, Long id, UserDetailsImpl userDetails) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("")
        );

        Comment comment = new Comment(commentRequestdto.getCheckin(),
                commentRequestdto.getClean(),
                commentRequestdto.getAccuracy(),
                commentRequestdto.getCommunication(),
                commentRequestdto.getLocation(),
                commentRequestdto.getSatisfaction(),
                accommodation,
                userDetails.getUser(),
                commentRequestdto.getComment());

        Comment saveComment = commentRepository.save(comment);

        CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                .id(comment.getId())
                .content(comment.getComment())
                .createdAt(comment.getCreatedAt())
                .user_nickname(comment.getUser().getNickname())
                .accommodation_id(comment.getAccommodation().getId())
                .build();

        System.out.println("코멘트 성공");
        return commentResponseDto;
    }

    public List<CommentResponseDto> findComments(Long id){
        List<Comment> comments = commentRepository.findAllByAccommodationId(id);
        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

        for(Comment comment : comments){
            CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                    .id(comment.getId())
                    .content(comment.getComment())
                    .createdAt(comment.getCreatedAt())
                    .user_nickname(comment.getUser().getNickname())
                    .accommodation_id(comment.getAccommodation().getId())
                    .build();

            commentResponseDtos.add(commentResponseDto);
        }

        System.out.println("코멘트 검색 성공");
        return commentResponseDtos;
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
        List<Comment> commentList = commentRepository.findAllByAccommodationId(id);

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


        System.out.println("avg 검색 성공");
        //소수점 아래 1자리, 2자리까지 나타내려고 아래와 같이 썼다.
        return CommentAvgResponseDto.builder()
                .cleanAvg((float) (Math.round(cleanAvg * 10) / 10.0))
                .chechingAvg((float) (Math.round(chechingAvg * 10) / 10.0))
                .accuracyAvg((float) (Math.round(accuracyAvg * 10) / 10.0))
                .communicationAvg((float) (Math.round(communicationAvg * 10) / 10.0))
                .locationAvg((float) (Math.round(locationAvg * 10) / 10.0))
                .satisfactionAvg((float) (Math.round(satisfactionAvg * 10) / 10.0))
                .totalStar((float) (Math.round(totalStar * 100) / 100.0))
                .build();
    }
}

