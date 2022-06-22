package com.sparta.airbnb_clone_be.dto.response;

import com.sparta.airbnb_clone_be.model.Photo;
import lombok.Getter;

@Getter
public class PhotoResponseDto {
    private Long id;  // 파일 id
    private String url;

    public PhotoResponseDto(Photo photo){
        this.id = photo.getId();
        this.url = photo.getUrl();
    }
}
