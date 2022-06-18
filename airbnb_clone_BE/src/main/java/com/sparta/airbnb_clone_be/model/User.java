package com.sparta.airbnb_clone_be.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username; //email 형식인 username

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;
}
