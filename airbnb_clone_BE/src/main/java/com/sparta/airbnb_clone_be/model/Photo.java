package com.sparta.airbnb_clone_be.model;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    public Photo(PhotoDto photoDto){
        this.key = photoDto.getKey();
        this.url = photoDto.getPath();
    }

    public void setAccommodation(Accommodation accommodation){
        this.accommodation = accommodation;
//
//        // 게시글에 현재 파일이 존재하지 않는다면
//        if(!accommodation.getPhotos().contains(this))
//            // 파일 추가
//            accommodation.getPhotos().add(this);
    }
}

