package com.dailystudy.dtmsapi.exception;

import java.util.Map;

public class CustomValidationException extends RuntimeException{
    //serialVersionUID 객체를 구분할 때 사용함
    private static final long serialVersionUID = 4506639546795172400L;

    private Map<String, String> errorMap;

    //생성자 만드는 단축키 command + N
    public CustomValidationException(String message, Map<String, String> errorMap) {
        super(message); //부모인 RuntimeException 에 전달
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
