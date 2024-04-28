package com.dailystudy.dtmsapi.service;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.Comment;
import com.dailystudy.dtmsapi.domain.Image;
import com.dailystudy.dtmsapi.domain.Likes;
import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.dto.ImageDto;
import com.dailystudy.dtmsapi.exception.CustomException;
import com.dailystudy.dtmsapi.mapper.ImageMapper;
import com.dailystudy.dtmsapi.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class ImageService {
    private final ImageMapper imageMapper;
    private final UserMapper userMapper;

    Logger log = LoggerFactory.getLogger(ImageService.class);

    public List<Image> popular() {
        return imageMapper.popular();
    }

    public List<Image> imageStory(int principalId, int page) {
        int pageSize = 3;
        int offset = (page <= 1) ? 0 : (page - 1) * pageSize;

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("principalId", principalId);
        parameters.put("pageSize", pageSize);
        parameters.put("offset", offset);

        List<Image> images = imageMapper.imageStory(parameters);
        log.info("============{}", images);
        //        images에 좋아요 상태담기
        images.forEach((image -> {

            List<Likes> imageLikes = imageMapper.imageLikes(image.getId());
            image.setLikes(imageLikes);

            List<Comment> imageComments = imageMapper.imageComments(image.getId());
            image.setComments(imageComments);

            image.setLikeCount(image.getLikes().size());
            image.getLikes().forEach(like -> {
                if (like.getUserId() == principalId) {
                    image.setLikeState(true);
                }
            });
        }));

        return images;
    }

    @Value("${file.path}") //org.springframework.beans
    private String uploadFolder;

    public void imageUpload(ImageDto imageDto, PrincipalDetails principalDetails) throws IOException {
        UUID uuid = UUID.randomUUID(); //네트워트 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약
        String imageFileName = uuid + "_" + imageDto.getFile().getOriginalFilename(); //1.jpg
        log.info("이미지 파일이름: {}", imageFileName);

        Path imageFilePath = Paths.get(uploadFolder + imageFileName);
        //통신,I/O -> 예외가 발생할 수 있다
        try {
            Files.write(imageFilePath, imageDto.getFile().getBytes()); //이미지 업로드
        } catch (IOException e) {
            e.printStackTrace();
        }

        //insert,update 할 때 Entity 작성해서 처리
        Image imageEntity = new Image();
        imageEntity.setUser(principalDetails.getUser());
        imageEntity.setPostImageUrl(imageFileName);
        imageEntity.setCaption(imageDto.getCaption());

//        log.info("imageEntity: {}", imageEntity);
        imageMapper.saveImage(imageEntity); //User로 넘기고, xml에서는 user.id 로 value 입력
        //저장한 내용 확인하려면 controller 에서 리턴값 받아서 처리하면 된다. Image imageEnttity = imageService.imageUpload()...

    }

    public List<Image> imageLikesCount(int imageId) {
        return imageMapper.imageLikesCount(imageId);
    }
}
