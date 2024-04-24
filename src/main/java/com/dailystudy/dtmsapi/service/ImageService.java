package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.ImageUpload;
import com.dailystudy.dtmsapi.mapper.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageMapper imageMapper;
    Logger log = LoggerFactory.getLogger(ImageService.class);

    @Value("${file.path}") //org.springframework.beans
    private String uploadFolder;

    public void imageUpload(ImageUpload imageUpload, PrincipalDetails principalDetails) throws IOException {
        UUID uuid = UUID.randomUUID(); //네트워트 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약
        String imageFileName = uuid + "_" + imageUpload.getFile().getOriginalFilename(); //1.jpg
        log.info("이미지 파일이름: {}", imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);
        //통신,I/O -> 예외가 발생할 수 있다
        try {
            Files.write(imageFilePath, imageUpload.getFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
