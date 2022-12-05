package com.cos.photogramstart.handler.ex;

public class CustomApiException extends RuntimeException {
    private static final long serialVersionUID = -807520916259076805L;

    public CustomApiException(String message) {
        super(message); // 부모클래스에 message를 보낸다
    }
}