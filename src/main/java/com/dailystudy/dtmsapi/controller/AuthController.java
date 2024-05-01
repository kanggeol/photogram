package com.dailystudy.dtmsapi.controller;

import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.exception.CustomValidationException;
import com.dailystudy.dtmsapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor // final 필드를 DI 할때 사용
@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
@RequestMapping("/auth")
public class AuthController {

    Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    @GetMapping("/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid User user, BindingResult bindingResult) {


        //        log.info(signup.toString());
//        log.info(user.getUsername());
//        authService.selectUser(user.getUsername());
        authService.insertUser(user);
        return "auth/signup";
    }
}
