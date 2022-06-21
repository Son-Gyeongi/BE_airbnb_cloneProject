package com.sparta.airbnb_clone_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestdto {

    private Long accomodationid;
    private String comment;
    @Min(0)
    @Max(5)
    private Float checkin;
    @Min(0)
    @Max(5)
    private Float clean;
    @Min(0)
    @Max(5)
    private Float accuracy;
    @Min(0)
    @Max(5)
    private Float communication;
    @Min(0)
    @Max(5)
    private Float location;
    @Min(0)
    @Max(5)
    private Float satisfaction;
}
