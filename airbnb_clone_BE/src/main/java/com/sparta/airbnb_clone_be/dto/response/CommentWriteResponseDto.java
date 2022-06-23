package com.sparta.airbnb_clone_be.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentWriteResponseDto {
    private Long id;

    private String content;

    private String user_nickname;

    private Long accommodation_id;

    @DateTimeFormat(pattern = "yyyy년 MM월")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy년 MM월", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    private Float cleanAvg;
    private Float chechingAvg;
    private Float accuracyAvg;
    private Float communicationAvg;
    private Float locationAvg;
    private Float satisfactionAvg;
    private Float totalStar;

}
