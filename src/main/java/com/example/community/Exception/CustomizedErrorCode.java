package com.example.community.Exception;

public enum CustomizedErrorCode implements ICustomizedErrorCode{
    QUESTION_NOT_FOUND(2001, "帖子不存在"),
    SYS_ERROR(2004, "服务端出错");

    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    CustomizedErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
