package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.dto.SignupRequestDto;
import com.sparta.airbnb_clone_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public String signupUser(@Valid @RequestBody SignupRequestDto requestDto) {

        try { // 회원가입 진행 성공시 true
            return userService.signupUser(requestDto);
        }catch (Exception e){ // 에러나면 false
            return "회원가입 실패";
        }

    }

    //email(username) 중복체크
    @PostMapping("/signup/email")
    public String checkEmail(@RequestBody SignupRequestDto requestDto) {
        return userService.checkEmail(requestDto);
    }

    //nickname 중복체크
    @PostMapping("/signup/nickname")
    public String checkNickname(@RequestBody SignupRequestDto requestDto) {
        return userService.checkNickname(requestDto);
    }
}
