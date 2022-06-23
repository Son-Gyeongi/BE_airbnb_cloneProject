package com.sparta.airbnb_clone_be.dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public  class CommentRequestDto {
    
    private String comment;

    private Float checkin;

    private Float clean;

    private Float accuracy;

    private Float communication;

    private Float location;

    private Float satisfaction;
}
