package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
