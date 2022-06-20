package com.sparta.airbnb_clone_be.controller;

import com.sparta.airbnb_clone_be.Servcie.PhotoService;
import com.sparta.airbnb_clone_be.dto.PhotoDto;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
public class PhotoController {
    private final PhotoService photoService;

    @CrossOrigin
    @GetMapping(
            value = "/image/{id}",
            produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE}
    )
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        PhotoDto photoDto = photoService.findByFileId(id);
        String absolutePath
                = new File("").getAbsolutePath() + File.separator + File.separator;
        String path = photoDto.getPath();

        InputStream imageStream = new FileInputStream(absolutePath + path);
        byte[] imageByteArray = {};
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(imageStream))) {
            imageByteArray = buffer.lines().collect(Collectors.joining("\n")).getBytes();
        }

        imageStream.close();

        return new ResponseEntity<>(imageByteArray, HttpStatus.OK);
    }
}
