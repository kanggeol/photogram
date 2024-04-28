package com.dailystudy.dtmsapi.controller.api;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.Comment;
import com.dailystudy.dtmsapi.dto.CMResponse;
import com.dailystudy.dtmsapi.dto.CommentDto;
import com.dailystudy.dtmsapi.exception.CustomValidationApiException;
import com.dailystudy.dtmsapi.exception.CustomValidationException;
import com.dailystudy.dtmsapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
    Logger log = LoggerFactory.getLogger(CommentApiController.class);
    private final CommentService commentService;

    @PostMapping("/api/comment")
    public ResponseEntity<?> commentSave(@Valid @RequestBody CommentDto commentDto, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails) {//넘어 온 json을 받을때는 @RequestBody 사용
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }
            throw new CustomValidationApiException("유효성 검사 실패함", errorMap);
        }
        Comment comment = commentService.commentSave(commentDto.getContent(), commentDto.getImageId(), principalDetails.getUser().getId()); //contentId,imageId,userId 필요
        log.info("comment:{}", comment);

        return new ResponseEntity<>(new CMResponse<>(1, "댓글쓰기 성공", comment), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/comment/{id}")
    public ResponseEntity<?> commentDelete(@PathVariable int id) {
        commentService.commentDelete(id);

        return new ResponseEntity<>(new CMResponse<>(1, "댓글삭제 성공", null), HttpStatus.OK);
    }

}
