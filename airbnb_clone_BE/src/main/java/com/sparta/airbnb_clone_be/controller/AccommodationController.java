package com.sparta.airbnb_clone_be.controller;


import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import com.sparta.airbnb_clone_be.service.AccommodationService;
import com.sparta.airbnb_clone_be.service.S3Service;
import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.AccommodationRequestDto;
import com.sparta.airbnb_clone_be.dto.response.AccommodationResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;

    private final S3Service s3Service;


    @GetMapping("/api/accommodations/{id}")
    public AccommodationResponseDto readDetailAccommodation(@PathVariable Long id){
        return accommodationService.findByAccommodation(id);
    }

    @GetMapping("/api/accommodations")
    public List<AccommodationResponseDto> readMain(@RequestParam(required = false) String category) {
        if(category == null){
            return accommodationService.findMain();
        }
        else{
            return accommodationService.findByCategory(category);
        }
    }

    @PostMapping("/api/accommodation")
    public void hostAccommodation(AccommodationRequestDto requestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) throws Exception {
        List<PhotoDto> photoDtos = s3Service.uploadFile(requestDto.getImages());
        accommodationService.host(requestDto, photoDtos, userDetails);
    }
}
