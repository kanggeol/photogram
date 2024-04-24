package com.dailystudy.dtmsapi.controller.api;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.response.CMResponse;
import com.dailystudy.dtmsapi.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SubscribeApiController {
    private final SubscribeService subscribeService;

    @PostMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> subscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId) {
        subscribeService.subscibe(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(new CMResponse<>(1, "구독하기 성공", null), HttpStatus.OK); //CMResponse 첫번째 인자 1인데 result를 썼고, 세번째 인자는 따로 없어서 null
    }

    @DeleteMapping("/api/subscribe/{toUserId}")
    public ResponseEntity<?> unSubscribe(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int toUserId) {
        subscribeService.unSubscibe(principalDetails.getUser().getId(), toUserId);
        return new ResponseEntity<>(new CMResponse<>(1, "구독취소 성공", null), HttpStatus.OK);
    }
}
