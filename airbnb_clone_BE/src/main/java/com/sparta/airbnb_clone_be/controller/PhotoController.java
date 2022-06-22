package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.service.PhotoService;
import com.sparta.airbnb_clone_be.dto.response.PhotoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.List;



@RequiredArgsConstructor
@RestController
@CrossOrigin
public class PhotoController {
    private final PhotoService photoService;


    @GetMapping("/api/accommodations/{id}/imgs")
    public ResponseEntity<List<PhotoResponseDto>> getImage(@PathVariable Long id) throws IOException {
        System.out.println("get photo");
        return ResponseEntity.ok().body(photoService.findAllByBoard(id));
    }
}
