package com.sparta.airbnb_clone_be.dto.RequestDto;

import com.sparta.airbnb_clone_be.model.Photo;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;


@Data
public class AccommodationRequestDto {
    private String title;

    private String house_name;

    private Long fee;

    private String content;

    private String address;

    private Long people;

    private String wifi;

    private String parking;

    private String category;

    private Long room;

    private List<MultipartFile> images;
}
