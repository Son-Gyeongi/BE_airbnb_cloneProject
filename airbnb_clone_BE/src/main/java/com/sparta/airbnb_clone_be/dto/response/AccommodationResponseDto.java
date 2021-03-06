package com.sparta.airbnb_clone_be.dto.response;

import com.sparta.airbnb_clone_be.model.Accommodation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationResponseDto {
    private Long id;

    private String title;

    private String fee;

    private String content;

    private String address;

    private String people;

    private String wifi;

    private String parking;

    private String category;

    private String room;

    private String user_nickname;

    private List<String> photoUrls;


    public AccommodationResponseDto(Accommodation accommodation){
        this.id = accommodation.getId();
        this.title = accommodation.getTitle();
        this.fee = accommodation.getFee();
        this.content = accommodation.getContent();
        this.address = accommodation.getAddress();
        this.people = accommodation.getPeople();
        this.wifi = accommodation.getWifi();
        this.parking = accommodation.getParking();
        this.category = accommodation.getCategory();
        this.room = accommodation.getRoom();
        this.user_nickname = accommodation.getUser().getNickname();
    }


    public void setPhotoId(List<String> photoUrls){
        this.photoUrls = photoUrls;
    }

}
