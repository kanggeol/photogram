package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller

public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) {
//        log.info(signupDto.toString());
// 입력받아 post로 넘어온 정보

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성 검사 실패", errorMap);
        } else {
            User user = signupDto.toEntity();
//        log.info(user.toString());
//User(id=0, username=444, password=4444, name=4444, website=null, bio=null, email=xyritol@kakao.com, phone=null, gender=null, profileImageUrl=null, role=null, createDate=null)

            String rawPassword = user.getPassword();
            String encPassword = bCryptPasswordEncoder.encode(rawPassword);
            user.setPassword(encPassword);
            user.setRole("ROLE_USER");
            User userEntity = authService.회원가입(user);
            System.out.println(userEntity);

            return "auth/signin";
        }
    }
}