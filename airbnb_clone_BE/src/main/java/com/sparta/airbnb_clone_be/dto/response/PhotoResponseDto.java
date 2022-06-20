package com.sparta.airbnb_clone_be.dto.response;

import com.sparta.airbnb_clone_be.model.Photo;
import lombok.Getter;

@Getter
public class PhotoResponseDto {
    private Long id;  // 파일 id

    public PhotoResponseDto(Photo entity){
        this.id = entity.getId();
    }

}
