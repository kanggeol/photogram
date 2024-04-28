package com.dailystudy.dtmsapi.exception;

import com.dailystudy.dtmsapi.dto.CMResponse;
import com.dailystudy.dtmsapi.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(CustomValidationException.class) //Runtime오류 나는걸 전부 가로챈다
    //클라이언트에게 응답할 때는 자바스크립트 사용해서 alert 사용
    public String validationException(CustomValidationException e) {
        if (e.getErrorMap() == null) {
            return Script.back(e.getMessage());
        } else {
            return Script.back(e.getErrorMap().toString());
        }
    }

    @ExceptionHandler(CustomException.class) //CumstomException 걸리면 Exception 함수 실행
    //클라이언트에게 응답할 때는 자바스크립트 사용해서 alert 사용
    public String Exception(CustomException e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(CustomValidationApiException.class) //Runtime오류 나는걸 전부 가로챈다
//    public CMResponse<Map<String, String>> validationException(CustomValidationException e) {
    public ResponseEntity<CMResponse<?>> validationException(CustomValidationApiException e) { //?를 쓰면 추론함
        return new ResponseEntity<>(new CMResponse(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiException.class) //Runtime오류 나는걸 전부 가로챈다
    public ResponseEntity<CMResponse<?>> apiException(CustomApiException e) {
        return new ResponseEntity<>(new CMResponse(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
