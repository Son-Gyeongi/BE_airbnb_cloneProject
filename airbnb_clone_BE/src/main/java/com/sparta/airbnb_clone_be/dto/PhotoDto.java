package com.sparta.airbnb_clone_be.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PhotoDto {
    private String name;

    private String path;
}
