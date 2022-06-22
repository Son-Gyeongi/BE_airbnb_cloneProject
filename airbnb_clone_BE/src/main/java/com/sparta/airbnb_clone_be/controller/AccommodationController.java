package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.AccommodationRequestDto;
import com.sparta.airbnb_clone_be.dto.response.AccommodationResponseDto;
import com.sparta.airbnb_clone_be.dto.response.PhotoResponseDto;
import com.sparta.airbnb_clone_be.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;

    private final S3Service s3Service;


    //메인페이지 포스팅 모두 가져오기
    @GetMapping("/api/accommodations")
    public List<AccommodationResponseDto> findByAccommodation(Long id) {

        return accommodationService.findByAccommodation(id);
    }

    //카테고리 검색하기
    @GetMapping("/api/accommodations")
    public List<AccommodationResponseDto> findByCategory(@RequestParam String category) {
        return accommodationService.findByCategory(category);
    }

    @GetMapping("/api/accommodations/{id}")
    public AccommodationResponseDto readDetailAccommodation(@PathVariable Long id) {
        List<PhotoResponseDto> photoResponseDtoList = photoService.findAllByBoard(id);
        List<Long> photoId = new ArrayList<>();
        // 각 첨부파일 id 추가
        for (PhotoResponseDto photoResponseDto : photoResponseDtoList)
            photoId.add(photoResponseDto.getId());
        System.out.println("get accommodation");

        return accommodationService.findByAccommodation(id, photoId);
    }

    @PostMapping("/api/accommodation")
    public void hostAccommodation(AccommodationRequestDto requestDto) throws Exception {
        List<PhotoDto> photoDtos = s3Service.uploadFile(requestDto.getImages());
        accommodationService.host(requestDto, photoDtos);
    }
}
