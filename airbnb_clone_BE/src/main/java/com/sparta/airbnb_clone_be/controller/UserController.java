package com.sparta.airbnb_clone_be.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.airbnb_clone_be.dto.SignupRequestDto;
import com.sparta.airbnb_clone_be.service.KakaoUserService;
import com.sparta.airbnb_clone_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final KakaoUserService kakaoUserService;

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


    //카카오톡 로그인
    @GetMapping("/oauth/kakao/callback")
    public boolean kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {

        try { // 회원가입 진행 성공시 true
            kakaoUserService.kakaoLogin(code, response);
            return true;
        }catch (Exception e){ // 에러나면 false
            System.out.println("카톡 로그인 실패!");
            return false;
        }

    }
}
