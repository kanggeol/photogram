package com.dailystudy.dtmsapi.controller.api;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.Image;
import com.dailystudy.dtmsapi.dto.CMResponse;
import com.dailystudy.dtmsapi.service.ImageService;
import com.dailystudy.dtmsapi.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ImageApiController {
    private final ImageService imageService;
    private final LikesService likesService;
    Logger log = LoggerFactory.getLogger(ImageApiController.class);

    @GetMapping("/api/image")
    private ResponseEntity<?> imageStory(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestParam(defaultValue = "1") int page) {
        List<Image> images = imageService.imageStory(principalDetails.getUser().getId(), page);
        return new ResponseEntity<>(new CMResponse<>(1, "스토리 가져오기 성공", images), HttpStatus.OK);
    }

    @PostMapping("/api/image/{imageId}/likes")
    public ResponseEntity<?> likes(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        likesService.like(imageId, principalDetails.getUser().getId());
        return new ResponseEntity<>(new CMResponse<>(1, "좋아요 성공", null), HttpStatus.CREATED); //새로운 추가 상태코드 201
    }

    @DeleteMapping("/api/image/{imageId}/likes")
    public ResponseEntity<?> unLikes(@PathVariable int imageId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        likesService.unlike(imageId, principalDetails.getUser().getId());
        return new ResponseEntity<>(new CMResponse<>(1, "좋아요취소 성공", null), HttpStatus.OK);
    }
}
