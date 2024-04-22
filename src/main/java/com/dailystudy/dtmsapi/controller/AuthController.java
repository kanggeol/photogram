package com.dailystudy.dtmsapi.controller;

import com.dailystudy.dtmsapi.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor // final 필드를 DI 할때 사용
@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
@RequestMapping("/auth")
public class AuthController {
    Logger log = LoggerFactory.getLogger(AuthController.class);
    @GetMapping("/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(SignupDto signupDto) {
        log.info(signupDto.toString());
        return "auth/signup";
    }

}