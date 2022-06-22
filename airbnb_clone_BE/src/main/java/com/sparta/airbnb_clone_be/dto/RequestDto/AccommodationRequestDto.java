package com.sparta.airbnb_clone_be.dto.RequestDto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@Data
public class AccommodationRequestDto {
    private String title;

    private String fee;

    private String content;

    private String address;

    private String people;

    private String wifi;

    private String parking;

    private String category;

    private String room;

    private List<MultipartFile> images;
}
