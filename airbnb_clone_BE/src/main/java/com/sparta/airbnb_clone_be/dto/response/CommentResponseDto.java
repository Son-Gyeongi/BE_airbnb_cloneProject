package com.sparta.airbnb_clone_be.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;

    private String content;

    private String user_nickname;

    private Long accommodation_id;

    private LocalDateTime createdAt;

}
