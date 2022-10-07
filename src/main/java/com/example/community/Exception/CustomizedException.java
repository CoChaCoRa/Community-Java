package com.example.community.Exception;

public class CustomizedException extends RuntimeException{
    private String message;
    private Integer code;

    public CustomizedException(ICustomizedErrorCode errorCode) {
        message = errorCode.getMessage();
        code = errorCode.getCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
