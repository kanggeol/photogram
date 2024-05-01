package com.dailystudy.dtmsapi.controller.api;

import com.dailystudy.dtmsapi.config.auth.PrincipalDetails;
import com.dailystudy.dtmsapi.domain.SubscribeResponse;
import com.dailystudy.dtmsapi.domain.User;
import com.dailystudy.dtmsapi.dto.CMResponse;
import com.dailystudy.dtmsapi.exception.CustomValidationApiException;
import com.dailystudy.dtmsapi.service.SubscribeService;
import com.dailystudy.dtmsapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final SubscribeService subscribeService;

    //ajax를 써서 리턴받게 할때 RestController 사용
    @PutMapping("/api/user/{id}")
    public CMResponse<?> update(@PathVariable int id, @Valid User user, BindingResult bindingResult, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.userUpdate(id, user);
        principalDetails.setUser(userEntity); //세션 정보 변경
        return new CMResponse<>(1, "회원수정완료", userEntity);
    }

    @GetMapping("/api/user/{pageUserId}/subscribe") //페이지 주인이 구독하는 모든 사람
    public ResponseEntity<?> subscribeList(@PathVariable int pageUserId, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        List<SubscribeResponse> subscribe = subscribeService.subscibeList(principalDetails.getUser().getId(), pageUserId);
        return new ResponseEntity<>(new CMResponse<>(1, "구독자 정보리스트 가져오기 성공", subscribe), HttpStatus.OK);
    }

    @PutMapping("/api/user/{principalId}/profileImageUrl")
    public ResponseEntity<?> profileImageUrlUpdate(@PathVariable int principalId, MultipartFile profileImageFile, @AuthenticationPrincipal PrincipalDetails principalDetails) { //프론트 input name값 profileImageFile 일치해야 값 매핑됨
        User userEntity = userService.profileUpdate(principalId, profileImageFile);
        principalDetails.setUser(userEntity); //사진변경 후 세션 변경
        return new ResponseEntity<>(new CMResponse<>(1, "프로필사진 변경 성공", null), HttpStatus.OK);
    }

}
