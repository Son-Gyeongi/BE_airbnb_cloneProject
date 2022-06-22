package com.sparta.airbnb_clone_be.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Accomodations {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long accomodationsId;

}
