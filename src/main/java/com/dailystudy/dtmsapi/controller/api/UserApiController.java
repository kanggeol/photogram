package com.dailystudy.dtmsapi.controller.api;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.domain.response.CMResponse;
import com.dailystudy.dtmsapi.exception.CustomValidationApiException;
import com.dailystudy.dtmsapi.exception.CustomValidationException;
import com.dailystudy.dtmsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMResponse<?> update(@PathVariable int id, @Valid User user, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println(error.getDefaultMessage());
            }
            throw new CustomValidationApiException("유효성 검사 실패함", errorMap);
        } else {
            User userEntity = userService.updateUser(id, user);
            principalDetails.setUser(userEntity); //세션 정보 변경
            return new CMResponse<>(1, "회원수정완료", userEntity);
        }
    }
}
