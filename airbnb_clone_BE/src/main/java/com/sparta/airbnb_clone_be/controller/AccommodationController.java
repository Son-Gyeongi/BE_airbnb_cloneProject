package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.Servcie.AccommodationService;
import com.sparta.airbnb_clone_be.Servcie.PhotoService;
import com.sparta.airbnb_clone_be.dto.RequestDto.AccommodationRequestDto;
import com.sparta.airbnb_clone_be.dto.response.AccommodationResponseDto;
import com.sparta.airbnb_clone_be.dto.response.PhotoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;
    private final PhotoService photoService;

    @GetMapping("/api/accommodations/{id}")
    public AccommodationResponseDto readDetailAccommodation(@PathVariable Long id){
        List<PhotoResponseDto> photoResponseDtoList = photoService.findAllByBoard(id);
        List<Long> photoId = new ArrayList<>();
        // 각 첨부파일 id 추가
        for(PhotoResponseDto photoResponseDto : photoResponseDtoList)
            photoId.add(photoResponseDto.getId());
        return accommodationService.findByAccommodation(id, photoId);
    }

    @PostMapping("/api/accommodation")
    public void hostAccommodation(AccommodationRequestDto requestDto) throws Exception {
        accommodationService.host(requestDto);
    }
}
