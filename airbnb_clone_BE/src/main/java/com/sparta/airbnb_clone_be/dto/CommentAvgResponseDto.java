package com.sparta.airbnb_clone_be.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentAvgResponseDto {
    //CommentService에서 반환되서 들어올 때 스트링으로 소수점 잘라서 String으로 바꿈
    private String chechingAvg;
    private String cleanAvg;
    private String accuracyAvg;
    private String communicationAvg;
    private String locationAvg;
    private String satisfactionAvg;
    private String totalStar;
}
