package com.sparta.airbnb_clone_be.handler;

import com.sparta.airbnb_clone_be.dto.PhotoDto;
import com.sparta.airbnb_clone_be.model.Photo;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class PhotoHandler {


    public List<Photo> parseFileInfo(List<MultipartFile> multipartFiles) throws Exception {
        List<Photo> photoList = new ArrayList<>();
        if(CollectionUtils.isEmpty(multipartFiles))
            return photoList;

        String absolutePath = new File("").getAbsolutePath() + File.separator;
        String path = "images" + File.separator;
        File file = new File(path);

        if(!file.exists()) {
            boolean wasSuccessful = file.mkdirs();

            // 디렉터리 생성에 실패했을 경우
            if(!wasSuccessful)
                System.out.println("file: was not successful");
        }

        for(MultipartFile multipartFile : multipartFiles){
            PhotoDto photoDto = PhotoDto.builder()
                    .name(multipartFile.getOriginalFilename())
                    .path(path + File.separator + multipartFile.getOriginalFilename())
                    .build();

            Photo photo = new Photo(photoDto);
            photoList.add(photo);

            file = new File(absolutePath + path + File.separator + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);

            file.setWritable(true);
            file.setReadable(true);

        }


        return photoList;
    }
}
