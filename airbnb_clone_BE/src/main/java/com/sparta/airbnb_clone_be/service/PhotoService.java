package com.sparta.airbnb_clone_be.service;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.dto.response.PhotoResponseDto;
import com.sparta.airbnb_clone_be.model.Photo;
import com.sparta.airbnb_clone_be.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;


    @Transactional(readOnly = true)
    public List<PhotoResponseDto> findAllByBoard(Long accommodationId){

        List<Photo> photoList = photoRepository.findAllByAccommodationId(accommodationId);

        return photoList.stream()
                .map(PhotoResponseDto::new)
                .collect(Collectors.toList());
    }
}
