package com.dailystudy.dtmsapi.exception;

import java.util.Map;

public class CustomApiException extends RuntimeException { // 데이터를 리턴하는 클래스

    // 객체를 구분할 때!!
    private static final long serialVersionUID = 1L;

    public CustomApiException(String message) {
        super(message);
    }

}
