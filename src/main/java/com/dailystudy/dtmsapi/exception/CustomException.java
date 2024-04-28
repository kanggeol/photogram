package com.dailystudy.dtmsapi.exception;

public class CustomException extends RuntimeException { //html 파일 리턴하는 클래스
    //serialVersionUID 객체를 구분할 때 사용함
    private static final long serialVersionUID = 4506639546795172400L;

    public CustomException(String message) {
        super(message);
    }

}
