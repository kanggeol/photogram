package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException {


    private static final long serialVersionUID = -807520916259076805L;

    private Map<String, String> errorMap;

    public CustomValidationApiException(String message) {
        super(message); // 부모클래스에 message를 보낸다
    }

    public CustomValidationApiException(String message, Map<String, String> errorMap) {
        super(message); // 부모클래스에 message를 보낸다
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}