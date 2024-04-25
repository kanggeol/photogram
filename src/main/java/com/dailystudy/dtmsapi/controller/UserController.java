package com.dailystudy.dtmsapi.controller;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.Profile;
import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/{pageUserId}")
    public String profile(@PathVariable int pageUserId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        Profile dto = userService.profile(pageUserId, principalDetails.getUser().getId());
        model.addAttribute("dto", dto);
        return "/user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String updateForm(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        log.info("세션정보: {}", principalDetails.getUser());
        return "user/update";
    }
}
