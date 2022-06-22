package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.AccommodationRequestDto;
import com.sparta.airbnb_clone_be.dto.response.AccommodationResponseDto;
import com.sparta.airbnb_clone_be.model.Accommodation;
import com.sparta.airbnb_clone_be.model.Photo;
import com.sparta.airbnb_clone_be.repository.AccommodationRepository;
import com.sparta.airbnb_clone_be.repository.PhotoRepository;
import com.sparta.airbnb_clone_be.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final PhotoRepository photoRepository;


    public List<AccommodationResponseDto> findMain() {

        List<AccommodationResponseDto> accommodationResponseDtoList = new ArrayList<>();
        List<Accommodation> accommoList = accommodationRepository.findAll();

        for(Accommodation accommodation : accommoList) {
            AccommodationResponseDto accommodationResponseDto = new AccommodationResponseDto(accommodation);

            List<String> photoUrl = new ArrayList<>();
            for(Photo photo : accommodation.getPhotos())
                photoUrl.add(photo.getUrl());
            accommodationResponseDto.setPhotoId(photoUrl);

            accommodationResponseDtoList.add(accommodationResponseDto);
        }

        System.out.println("메인 검색 성공");
        return accommodationResponseDtoList;
    }

    //카테고리별 검색
    public List<AccommodationResponseDto> findByCategory(String category) {

        List<AccommodationResponseDto> accommodationResponseDtoList = new ArrayList<>();

        List<Accommodation> accommoList = accommodationRepository.findByCategory(category);

        for (Accommodation accommodation : accommoList) {
            AccommodationResponseDto accommodationResponseDto = new AccommodationResponseDto(accommodation);

            List<String> photoUrl = new ArrayList<>();
            for (Photo photo : accommodation.getPhotos())
                photoUrl.add(photo.getUrl());
            accommodationResponseDto.setPhotoId(photoUrl);

            accommodationResponseDtoList.add(accommodationResponseDto);
        }

        System.out.println("카테고리 검색 성공");
        return accommodationResponseDtoList;
    }

    @Transactional
    public AccommodationResponseDto findByAccommodation(Long id){

        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 파일이 존재하지 않습니다."));

        AccommodationResponseDto accommodationResponseDto = new AccommodationResponseDto(accommodation);

        List<String> photoUrls = new ArrayList<>();
        for(Photo photo : accommodation.getPhotos())
            photoUrls.add(photo.getUrl());
        accommodationResponseDto.setPhotoId(photoUrls);

        System.out.println("디테일 검색 성공");
        return accommodationResponseDto;
    }

    @Transactional
    public Accommodation host(AccommodationRequestDto requestDto, List<PhotoDto> photoDtos, UserDetailsImpl userDetails) throws Exception {

        Accommodation accommodation = Accommodation.builder()
                .title(requestDto.getTitle())
                .fee(requestDto.getFee())
                .content(requestDto.getContent())
                .address(requestDto.getAddress())
                .people(requestDto.getPeople())
                .wifi(requestDto.getWifi())
                .parking(requestDto.getParking())
                .category(requestDto.getCategory())
                .room(requestDto.getRoom())
                .user(userDetails.getUser())
                .build();

        // 파일이 존재할 때에만 처리
        if(!photoDtos.isEmpty()) {
            for(PhotoDto photoDto : photoDtos) {
                // 파일을 DB에 저장
                Photo photo = new Photo(photoDto);
                photo.setAccommodation(accommodation);
                photoRepository.save(photo);
            }
        }


        accommodationRepository.save(accommodation);
        System.out.println("호스트 성공");
        return accommodation;
    }


}
