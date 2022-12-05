package com.cos.photogramstart.handler.ex;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -807520916259076805L;

    public CustomException(String message) {
        super(message); // 부모클래스에 message를 보낸다
    }

}