package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.dto.SignupRequestDto;
import com.sparta.airbnb_clone_be.model.User;
import com.sparta.airbnb_clone_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public String signupUser(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();
        System.out.println("email : "+email);
        String nickname = requestDto.getNickname();
        System.out.println("nickname : "+nickname);
//        System.out.println("password : "+requestDto.getPassword());

        //패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
//        System.out.println("password : "+password);

        User user = new User(email,nickname, password);
        userRepository.save(user);
        return "회원가입을 축하합니다!!";
    }

    public String checkEmail(SignupRequestDto requestDto) {
        String email = requestDto.getEmail();
        if(userRepository.findByEmail(email).isPresent()){
//            throw new IllegalArgumentException("중복된 이메일입니다.");
            //1.ResponseEntity 로 상태를 같이 넘겨줄지 (ok, bad 등등)
            //2. 아니면 true, false
            //3. 문자열로
            return "존재하는 이메일입니다.";
        } else {
            return "사용가능한 이메일입니다.";
        }
    }

    public String checkNickname(SignupRequestDto requestDto) {
        String nickname = requestDto.getNickname();
        if(userRepository.findByNickname(nickname).isPresent()){
            return "중복된 닉네임입니다.";
        } else {
            return "사용가능한 닉네임입니다.";
        }
    }
}
