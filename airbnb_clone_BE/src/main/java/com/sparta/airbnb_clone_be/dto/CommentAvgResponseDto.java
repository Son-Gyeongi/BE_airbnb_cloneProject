package com.sparta.airbnb_clone_be.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentAvgResponseDto {
    private Float chechingAvg;
    private Float cleanAvg;
    private Float accuracyAvg;
    private Float communicationAvg;
    private Float locationAvg;
    private Float satisfactionAvg;
    private Float totalStar;
}
