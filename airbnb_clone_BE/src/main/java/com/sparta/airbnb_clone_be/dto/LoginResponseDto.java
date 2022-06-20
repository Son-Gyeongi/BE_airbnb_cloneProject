package com.sparta.airbnb_clone_be.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String nickname;

    private boolean is_login;

    private String token;

    public LoginResponseDto(String nickname, boolean is_login, String token) {
        this.nickname = nickname;
        this.is_login = is_login;
        this.token = token;
    }
}
