package com.sparta.airbnb_clone_be.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Accommodation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String fee;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String people;

    @Column(nullable = false)
    private String wifi;

    @Column(nullable = false)
    private String parking;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String room;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<Photo> photos;

    public void addPhoto(Photo photo) {
        this.photos.add(photo);

        // 게시글에 파일이 저장되어있지 않은 경우
        if(photo.getAccommodation() != this)
            // 파일 저장
            photo.setAccommodation(this);
    }
}
