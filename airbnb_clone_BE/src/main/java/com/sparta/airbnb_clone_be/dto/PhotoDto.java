package com.sparta.airbnb_clone_be.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PhotoDto {
    private String key;

    private String path;
}
