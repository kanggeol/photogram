package com.dailystudy.dtmsapi.controller;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.Image;
import com.dailystudy.dtmsapi.dto.ImageDto;
import com.dailystudy.dtmsapi.exception.CustomValidationException;
import com.dailystudy.dtmsapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ImageController {
    private final ImageService imageService;

    @GetMapping({"/", "/image/story"})
    public String story() {
        return "image/story";
    }

    @GetMapping("/image/popular")
    public String popular(Model model) {
        List<Image> images = imageService.popular(); //ajax를 써서 리턴받게 할게 아니기 때문에 ApiController X
        model.addAttribute("images", images);
        return "image/popular";
    }

    @GetMapping("/image/upload")
    public String upload() {
        return "image/upload";
    }

    @PostMapping("/image")
    public String imageUpload(ImageDto imageDto, @AuthenticationPrincipal PrincipalDetails principalDetails) throws IOException {
        if (imageDto.getFile().isEmpty()) {
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }
        imageService.imageUpload(imageDto, principalDetails);
        return "redirect:/user/" + principalDetails.getUser().getId(); //이미지를 올리고 나면 이동할 페이지
    }
}
