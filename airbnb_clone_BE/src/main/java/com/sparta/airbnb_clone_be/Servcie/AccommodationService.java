package com.sparta.airbnb_clone_be.Servcie;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.dto.RequestDto.AccommodationRequestDto;
import com.sparta.airbnb_clone_be.dto.response.AccommodationResponseDto;
import com.sparta.airbnb_clone_be.handler.PhotoHandler;
import com.sparta.airbnb_clone_be.model.Accommodation;
import com.sparta.airbnb_clone_be.model.Photo;
import com.sparta.airbnb_clone_be.repository.AccommodationRepository;
import com.sparta.airbnb_clone_be.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final PhotoHandler photoHandler;
    private final PhotoRepository photoRepository;

    @Transactional
    public AccommodationResponseDto findByAccommodation(Long id, List<Long> photoId){
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 파일이 존재하지 않습니다."));


        return new AccommodationResponseDto(accommodation, photoId);
    }

    @Transactional
    public Accommodation host(AccommodationRequestDto requestDto, List<PhotoDto> photoDtos) throws Exception {

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
                .build();

        // 파일이 존재할 때에만 처리
        if(!photoDtos.isEmpty()) {
            for(PhotoDto photoDto : photoDtos) {
                // 파일을 DB에 저장
                Photo photo = new Photo(photoDto);
                photo.setAccommodation(accommodation);
                photoRepository.save(photo);
                System.out.println(1);
            }
        }


        accommodationRepository.save(accommodation);

//        AccommodationResponseDto accommodationResponseDto = new AccommodationResponseDto(
//                id,
//                accommodationRequestDto.getTitle(),
//                accommodationRequestDto.getFee(),
//                accommodationRequestDto.getContent(),
//                accommodationRequestDto.getAddress(),
//                accommodationRequestDto.getPeople(),
//                accommodationRequestDto.getWifi(),
//                accommodationRequestDto.getParking(),
//                accommodationRequestDto.getCategory(),
//                accommodationRequestDto.getRoom()
//        );

        return accommodation;
    }
}
