package com.sparta.airbnb_clone_be.model;
import com.sparta.airbnb_clone_be.model.Accommodation;
import com.sparta.airbnb_clone_be.dto.RequestDto.CommentRequestDto;
import com.sparta.miniproject.model.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;

    @Column(nullable = false)
    private String comment;//커멘트
    @Column(nullable = false)
    private Float checkin;//체크인

    @Column(nullable = false)
    private Float clean;//청결도

    @Column(nullable = false)
    private Float accuracy;//정확도

    @Column(nullable = false)
    private Float communication;//의사소통

    @Column(nullable = false)
    private Float location;//위치

    @Column(nullable = false)
    private Float satisfaction;//만족도

    @ManyToOne
    @JoinColumn(name = "Accomodation_ID", nullable = false)
    private Accommodation accomodation;

    public Comment(Float checkin, Float clean, Float accuracy, Float communication, Float location, Float satisfaction, Accommodation accomodation) {
        this.checkin = checkin;
        this.clean = clean;
        this.accuracy = accuracy;
        this.communication = communication;
        this.location = location;
        this.satisfaction = satisfaction;
        this.accomodation = accomodation;

    }
}
