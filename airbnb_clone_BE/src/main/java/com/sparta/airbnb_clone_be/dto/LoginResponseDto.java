package com.sparta.airbnb_clone_be.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String nickname;

    private boolean result;

    private String token;

    public LoginResponseDto(String nickname, boolean result, String token) {
        this.nickname = nickname;
        this.result = result;
        this.token = token;
    }
}
