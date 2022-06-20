package com.sparta.airbnb_clone_be.Servcie;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.dto.response.PhotoResponseDto;
import com.sparta.airbnb_clone_be.model.Photo;
import com.sparta.airbnb_clone_be.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    @Transactional
    public PhotoDto findByFileId(Long id){

        Photo entity = photoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 파일이 존재하지 않습니다."));

        PhotoDto photoDto = PhotoDto.builder()
                .name(entity.getName())
                .path(entity.getPath())
                .build();

        return photoDto;
    }


    @Transactional
    public List<PhotoResponseDto> findAllByBoard(Long accommodationId){

        List<Photo> photoList = photoRepository.findAllByAccommodationId(accommodationId);

        return photoList.stream()
                .map(PhotoResponseDto::new)
                .collect(Collectors.toList());
    }
}
